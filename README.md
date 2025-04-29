# 📝 Task Manager Application

A full-stack task management system built using **Spring Boot**, **Thymeleaf**, **MySQL**, and **HTML/CSS**. This application allows users to create, view, update, and delete tasks with support for priorities, due dates, and status tracking — similar to tools like Trello or Asana.

---

## 🔧 Tech Stack

- **Backend**: Java 17, Spring Boot, Spring MVC, Spring Data JPA
- **Frontend**: HTML, CSS, Thymeleaf
- **Database**: MySQL
- **Build Tool**: Maven

---

## 🎯 Features

- 🔄 Full CRUD (Create, Read, Update, Delete) functionality
- 🏷️ Task prioritization and status tracking
- 📅 Due date assignment for tasks
- 💾 Persistent data storage using MySQL
- 🖥️ HTML/CSS interface styled with custom responsive design
- 🧪 Input validation and error handling
- 📄 RESTful API integration ready for frontend or mobile consumption

---

## 📸 Screenshots

![Task List Screenshot](assets/screenshot-tasklist.png)
*(Add your screenshots here)*

---

## 🛠️ Installation & Setup

### Prerequisites:
- Java 17 or higher
- Maven
- MySQL installed and running

### Steps:

1. **Clone the repository**
```bash
git clone https://github.com/mohd-zeeshan77/taskManager.git
cd taskManager




🔁 Data Flow (CRUD Operations)

Client (Frontend) ➝ REST API ➝ Controller ➝ Service ➝ Repository ➝ DB
                                  ↑
                            Response DTO





task-management-system/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.example.taskmanager/
│   │   │       ├── controller/
│   │   │       ├── service/
│   │   │       ├── repository/
│   │   │       ├── entity/
│   │   │       └── dto/
│   │   ├── resources/
│   │   │   ├── static/
│   │   │   │   ├── css/
│   │   │   │   │   └── style.css
│   │   │   │   └── html/
│   │   │   │       ├── create_task.html
│   │   │   │       └── list_tasks.html
│   │   │   └── application.properties
├── pom.xml






2. application.properties

# Server
server.port=8080

# Database
spring.datasource.url=jdbc:mysql://localhost:3306/task_db
spring.datasource.username=root
spring.datasource.password=your_password_here
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Thymeleaf settings
spring.thymeleaf.prefix=classpath:/static/html/
spring.thymeleaf.suffix=.html
spring.thymeleaf.mode=HTML
spring.thymeleaf.cache=false




Step 1: Create Database

-- Create the database
CREATE DATABASE IF NOT EXISTS task_management_db;

    ✅ This will create a database named task_management_db.

Step 2: Use the Database

-- Select the database
USE task_management_db;

Step 3: Create Tables
📄 User Table

-- Create the User table
CREATE TABLE IF NOT EXISTS user (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL
);

📄 Task Table

-- Create the Task table
CREATE TABLE IF NOT EXISTS task (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(500),
    due_date DATE,
    priority VARCHAR(50),
    status VARCHAR(50),
    user_id BIGINT,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES user(id)
);

    ✅ Notice that task table has a foreign key user_id linking to user.id.

Step 4: Insert Sample Data
👤 Insert Some Users

-- Insert demo users
INSERT INTO user (username, email) VALUES ('JohnDoe', 'john@example.com');
INSERT INTO user (username, email) VALUES ('JaneDoe', 'jane@example.com');

📝 Insert Some Tasks

-- Insert demo tasks
INSERT INTO task (title, description, due_date, priority, status, user_id)
VALUES 
('Complete Backend Project', 'Finish the full stack task management system.', '2025-05-10', 'HIGH', 'IN_PROGRESS', 1),
('Submit Assignment', 'Upload files on portal before deadline.', '2025-05-08', 'MEDIUM', 'PENDING', 2);
