-- Create SmartHire Database if not exists
CREATE DATABASE IF NOT EXISTS smarthire_db;
USE smarthire_db;

-- HR Users Table
CREATE TABLE IF NOT EXISTS hr_users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(256) NOT NULL, -- SHA-256 hash of password
    full_name VARCHAR(100) NOT NULL
);

-- Job Postings Table
CREATE TABLE IF NOT EXISTS jobs (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    department VARCHAR(100) NOT NULL,
    description TEXT NOT NULL,
    requirements TEXT NOT NULL,
    status VARCHAR(20) DEFAULT 'Active', -- 'Active', 'Inactive'
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Candidates Table
CREATE TABLE IF NOT EXISTS candidates (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    skills TEXT,
    experience_years INT,
    resume_path VARCHAR(256),
    status VARCHAR(20) DEFAULT 'Applied', -- 'Applied', 'Shortlisted', 'Selected', 'Rejected'
    applied_job_id INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (applied_job_id) REFERENCES jobs(id) ON DELETE SET NULL
);

-- Interview Scheduling Table
CREATE TABLE IF NOT EXISTS interviews (
    id INT AUTO_INCREMENT PRIMARY KEY,
    candidate_id INT NOT NULL,
    job_id INT NOT NULL,
    interview_date DATETIME NOT NULL,
    mode VARCHAR(50) NOT NULL, -- 'Online', 'In-Person', 'Telephone'
    details TEXT,
    status VARCHAR(20) DEFAULT 'Scheduled', -- 'Scheduled', 'Completed', 'Cancelled'
    FOREIGN KEY (candidate_id) REFERENCES candidates(id) ON DELETE CASCADE,
    FOREIGN KEY (job_id) REFERENCES jobs(id) ON DELETE CASCADE
);

-- Seed default HR manager account (username: admin, password: admin123)
-- SHA-256 of admin123 is 24078914ba1096c5f7a10f85291e4a3e1ae975200db8f5682d174b698e8bb335
INSERT INTO hr_users (username, password, full_name)
SELECT 'admin', '24078914ba1096c5f7a10f85291e4a3e1ae975200db8f5682d174b698e8bb335', 'HR Administrator'
WHERE NOT EXISTS (SELECT 1 FROM hr_users WHERE username = 'admin');

-- Seed a few sample active jobs
INSERT INTO jobs (title, department, description, requirements, status)
SELECT 'Software Engineer (Java)', 'Engineering', 'We are looking for a skilled Java Developer to join our core backend team. You will build high-performance APIs and maintain data pipelines.', '3+ years experience, Core Java, Spring Boot, MySQL, REST APIs, Git.', 'Active'
WHERE NOT EXISTS (SELECT 1 FROM jobs WHERE title = 'Software Engineer (Java)');

INSERT INTO jobs (title, department, description, requirements, status)
SELECT 'Frontend Developer (React)', 'Engineering', 'Join our frontend team to build beautiful, responsive user interfaces. You will collaborate with design teams and integrate backend endpoints.', '2+ years experience, JavaScript (ES6+), React.js, HTML5/CSS3, TailwindCSS.', 'Active'
WHERE NOT EXISTS (SELECT 1 FROM jobs WHERE title = 'Frontend Developer (React)');

INSERT INTO jobs (title, department, description, requirements, status)
SELECT 'Talent Acquisition Specialist', 'Human Resources', 'Help us source and hire the best talent across tech and non-tech roles. You will manage end-to-end recruitment pipelines.', '2+ years recruiting experience, strong communication, applicant tracking experience.', 'Active'
WHERE NOT EXISTS (SELECT 1 FROM jobs WHERE title = 'Talent Acquisition Specialist');
