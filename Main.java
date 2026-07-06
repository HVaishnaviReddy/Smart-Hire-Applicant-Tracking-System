package com.smarthire;

import com.smarthire.db.DatabaseConfig;
import com.smarthire.handler.*;
import com.sun.net.httpserver.HttpServer;
import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class Main {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        System.out.println("----------------------------------------------");
        System.out.println("     SmartHire Recruitment & ATS Starting     ");
        System.out.println("----------------------------------------------");

        // 1. Initialize and verify Database Schema
        try {
            DatabaseConfig.initializeDatabase();
        } catch (Exception e) {
            System.err.println("Fatal: Could not initialize database schema. Please check if your MySQL server is running on port 3306. Error: " + e.getMessage());
            System.exit(1);
        }

        // 2. Ensure "uploads" folder for resume documents exists
        File uploadDir = new File("uploads");
        if (!uploadDir.exists()) {
            boolean created = uploadDir.mkdirs();
            if (created) {
                System.out.println("Created 'uploads/' directory for candidate resumes.");
            }
        }

        // 3. Start Embedded HTTPServer
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);
            
            // Register Authentication Handlers
            AuthHandler authHandler = new AuthHandler();
            server.createContext("/api/hr/login", authHandler);

            // Register Job Handlers
            JobHandler jobHandler = new JobHandler();
            server.createContext("/api/jobs", jobHandler);
            server.createContext("/api/hr/jobs", jobHandler);
            server.createContext("/api/hr/jobs/status", jobHandler);

            // Register Candidate & Resume Handlers
            CandidateHandler candidateHandler = new CandidateHandler();
            server.createContext("/api/candidate/register", candidateHandler);
            server.createContext("/api/hr/candidates", candidateHandler);
            server.createContext("/api/hr/candidates/status", candidateHandler);
            server.createContext("/api/hr/resumes/", candidateHandler);

            // Register Interview Handlers
            InterviewHandler interviewHandler = new InterviewHandler();
            server.createContext("/api/hr/interviews", interviewHandler);
            server.createContext("/api/hr/interviews/status", interviewHandler);

            // Register Dashboard Stats Handler
            DashboardHandler dashboardHandler = new DashboardHandler();
            server.createContext("/api/hr/stats", dashboardHandler);

            // Register Static Files Handler (catches all static asset files: HTML, CSS, JS)
            StaticFileHandler staticHandler = new StaticFileHandler();
            server.createContext("/", staticHandler);

            // Use multi-threaded executor for handling concurrent requests
            server.setExecutor(Executors.newFixedThreadPool(10));
            server.start();

            System.out.println("\nSmartHire Application is running!");
            System.out.println(" -> Candidate Portal URL : http://localhost:" + PORT + "/");
            System.out.println(" -> HR Dashboard URL      : http://localhost:" + PORT + "/admin");
            System.out.println("\nPress Ctrl+C in terminal to stop the server.");
            System.out.println("----------------------------------------------");

        } catch (IOException e) {
            System.err.println("Fatal: Could not start HTTP server on port " + PORT + ". Error: " + e.getMessage());
            System.exit(1);
        }
    }
}
