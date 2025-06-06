# Student Record Manager (Java + SQLite)

## 📌 Overview
This is a simple desktop application built using **Java Swing** and **SQLite** to manage student records (Name, Roll No, Marks).

## 🚀 Features
- Add student records
- View all student entries
- Validates user input
- Stores data using SQLite database
- Clean and modular code structure

## 📂 Project Structure
```
java project/
├── Databasemanager.java
├── Student.java
├── StudentForm.java
└── students.db (auto-created on first run)
```

## 🛠️ Requirements
- JDK 8 or later
- SQLite JDBC driver (`sqlite-jdbc.jar`)

## ▶️ How to Run
1. Compile the files:
   ```bash
   javac -cp ".;sqlite-jdbc.jar" *.java
   ```

2. Run the application:
   ```bash
   java -cp ".;sqlite-jdbc.jar" StudentForm
   ```

> 💡 Ensure `sqlite-jdbc.jar` is in the same folder or included in your classpath.

## 📑 Author
Developed as part of a Hackathon project submission.

