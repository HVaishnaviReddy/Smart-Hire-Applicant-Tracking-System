# SmartHire – Applicant Tracking & Recruitment System

SmartHire is a lightweight, high-performance standalone web application designed for recruitment management and applicant tracking. Built with a zero-dependency Java backend, JDBC, MySQL, and a modern glassmorphic web UI, it serves as a complete platform for recruiters and candidates.

## Features

- **HR Dashboard & Login**: Secure credential-based sign-in for Human Resources.
- **Candidate Job Portal**: Open board where candidates can search active jobs, submit personal info, and apply.
- **Resume Upload**: Fast client-side Base64 encoding that saves files onto the server and links them in the database.
- **Candidate Tracking**: Dynamic status workflow changes (Applied → Shortlisted → Selected → Rejected).
- **Interview Scheduler**: HR can book interviews (Online, In-Person, Telephone) with calendar updates.
- **Search & Filter Pipeline**: Advanced sorting of candidates by keywords (name/skills), job roles, and application statuses.
- **Overview Analytics**: Dynamic dashboard metrics displaying active jobs, application counts, and candidate pipeline progress bars.

---

## Technical Architecture

- **Backend**: Core Java, JDBC, and standard built-in `com.sun.net.httpserver.HttpServer`.
- **Database**: MySQL.
- **Frontend**: Single Page Application (SPA) design with Vanilla HTML5, CSS3 (Glassmorphic theme), and ES6 JavaScript.
- **Zero-Dependency**: No Spring Boot, Tomcat, or third-party JSON/parsing frameworks. Only requires the MySQL JDBC driver.

---

## Directory Structure

```
SmartHire/
├── db/
│   └── schema.sql        # Database initialization DDL & Seed Data
├── lib/
│   └── mysql-connector-j-8.4.0.jar (auto-downloaded)
├── src/
│   └── com/
│       └── smarthire/
│           ├── Main.java              # Bootstraps HTTP Server (Port 8080)
│           ├── db/
│           │   └── DatabaseConfig.java # Database connection manager
│           ├── model/
│           │   ├── User.java
│           │   ├── Job.java
│           │   ├── Candidate.java
│           │   └── Interview.java
│           ├── dao/
│           │   ├── UserDAO.java
│           │   ├── JobDAO.java
│           │   ├── CandidateDAO.java
│           │   └── InterviewDAO.java
│           ├── handler/
│           │   ├── StaticFileHandler.java
│           │   ├── AuthHandler.java
│           │   ├── JobHandler.java
│           │   ├── CandidateHandler.java
│           │   ├── InterviewHandler.java
│           │   └── DashboardHandler.java
│           └── util/
│               ├── JsonUtil.java       # Custom JSON parsing utility
│               └── SessionManager.java  # Session/Token manager
├── web/
│   ├── index.html        # Candidate Portal
│   ├── admin.html        # HR Dashboard & Login
│   ├── css/
│   │   └── style.css     # Dark Glassmorphism Styling
│   └── js/
│       ├── app.js        # Candidate portal logic
│       └── admin.js      # HR dashboard logic
├── db.properties         # Database Connection Configuration
├── run.bat               # Compiles and starts the system
└── README.md             # Setup guide
```

---

## Setup & Running Instructions

### 1. Database Configuration
Make sure your MySQL database server is running (default port `3306`).
- Open `db.properties` in the project root.
- Edit the database connection details to match your database server configuration:
  ```properties
  db.url=jdbc:mysql://localhost:3306/smarthire_db?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
  db.user=root
  db.password=YOUR_MYSQL_PASSWORD_HERE
  ```
  *(If your root user doesn't have a password, you can leave `db.password=` empty).*

- **Note**: The application will **automatically create** the database (`smarthire_db`) and initialize the tables and seed data using `db/schema.sql` on startup! You do not need to run DDL scripts manually.

### 2. Run the Application
Simply double-click on `run.bat` (or open a terminal in the folder and execute `run.bat`).
The script will:
- Check for Java JDK and check/download the JDBC driver jar.
- Compile all java sources into a `bin/` folder.
- Boot the embedded web server on port `8080`.

### 3. Access Portals
- **Candidate Portal**: Open [http://localhost:8080/](http://localhost:8080/)
- **HR Dashboard**: Open [http://localhost:8080/admin](http://localhost:8080/admin)
  - *Default Seed HR Credentials*:
    - **Username**: `admin`
    - **Password**: `admin123`
