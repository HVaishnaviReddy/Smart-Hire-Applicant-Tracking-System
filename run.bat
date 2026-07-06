@echo off
setlocal enabledelayedexpansion
title SmartHire Recruitment System - Bootstrapper

echo ==================================================
echo         SmartHire Startup and Bootstrapper        
echo ==================================================

:: 1. Verify Java Installation
where java >nul 2>&1
if %errorlevel% neq 0 (
    echo [ERROR] Java is not installed or not in the system PATH.
    echo Please install JDK 17 or higher and try again.
    pause
    exit /b 1
)

:: 2. Check/Download JDBC Driver
set DRIVER_URL=https://repo1.maven.org/maven2/com/mysql/mysql-connector-j/8.4.0/mysql-connector-j-8.4.0.jar
set LIB_DIR=lib
set DRIVER_JAR=%LIB_DIR%\mysql-connector-j-8.4.0.jar

if not exist %LIB_DIR% (
    mkdir %LIB_DIR%
)

if not exist "%DRIVER_JAR%" (
    echo [INFO] Downloading MySQL JDBC driver (Connector/J 8.4.0)...
    powershell -Command "Invoke-WebRequest -Uri '%DRIVER_URL%' -OutFile '%DRIVER_JAR%'"
    if !errorlevel! neq 0 (
        echo [ERROR] Failed to download JDBC driver automatically.
        echo Please download it manually and place it inside the 'lib' folder.
        pause
        exit /b 1
    )
    echo [SUCCESS] JDBC driver downloaded successfully.
) else (
    echo [INFO] JDBC driver found in lib folder.
)

:: 3. Create Compilation Outputs Directory
if not exist bin (
    mkdir bin
)

:: 4. Compile Java Source Files
echo [INFO] Compiling SmartHire Java sources...
javac -cp "%DRIVER_JAR%" -sourcepath src -d bin src\com\smarthire\Main.java
if %errorlevel% neq 0 (
    echo [ERROR] Compilation failed. Please review compiler messages above.
    pause
    exit /b 1
)
echo [SUCCESS] Compilation completed.

:: 5. Launch the application
echo [INFO] Starting SmartHire Server...
echo --------------------------------------------------
java -cp "bin;%DRIVER_JAR%" com.smarthire.Main
if %errorlevel% neq 0 (
    echo [ERROR] Application terminated unexpectedly.
    pause
)
pause
