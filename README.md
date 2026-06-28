# 🔐 Employee Payroll Management System – UC2: Employee Authentication & Login

## 📖 Overview

**Use Case 2 (UC2)** implements the Employee Authentication and Login module of the Employee Payroll Management System.

This module extends the Employee Registration use case by introducing user authentication, role-based access, password hashing, inheritance, polymorphism, abstract classes, and session management.

---

## 🎯 Goal

Securely authenticate registered users and provide role-based dashboard access.

---

## 📌 Learning Objectives

- Understand Inheritance and Polymorphism.
- Learn how Abstract Classes are used.
- Understand Method Overriding.
- Introduce Password Hashing.
- Learn Session Management.
- Understand Runtime Polymorphism.

---

## 🛠 Features

- Secure User Login
- Password Hashing
- Username & Password Authentication
- Role-Based Login
- Employee Dashboard
- Manager Dashboard
- Session Creation
- Session Validation
- Login Attempt Limiting

---

# 📚 OOP Concepts Covered

## ✅ Inheritance

```
            User (Abstract)
             /         \
            /           \
RegularEmployee      Manager
```

Both user types inherit common properties from the abstract `User` class.

---

## ✅ Abstraction

The `User` class defines the common structure while forcing subclasses to implement their own authentication logic.

---

## ✅ Polymorphism

Different objects (`RegularEmployee`, `Manager`) are stored using the parent `User` reference.

```java
User employee = new RegularEmployee(...);

User manager = new Manager(...);
```

At runtime, the correct `authenticate()` method is executed.

---

## ✅ Method Overriding

Each subclass provides its own implementation of:

```java
authenticate()
```

---

## ✅ Password Hashing

Passwords are converted into hashed values before comparison.

```
Password
    │
    ▼
Hash
    │
    ▼
Stored Securely
```

---

## ✅ Session Management

After successful login, a session object is created.

The session stores:

- Username
- Login Time
- Session Timeout

---

# 📂 Project Structure

```
src/

│
├── model
│      User.java
│      RegularEmployee.java
│      Manager.java
│      Session.java
│
├── service
│      AuthenticationService.java
│
├── utility
│      PasswordUtil.java
│
└── main
       UseCase2LoginApp.java
```

---

# 🔄 Authentication Flow

```
Start
   │
   ▼
Enter Username
   │
   ▼
Enter Password
   │
   ▼
Hash Password
   │
   ▼
Authenticate User
   │
   ▼
Identify User Role
   │
   ▼
Create Session
   │
   ▼
Display Dashboard
   │
   ▼
End
```

---

# 🖥 Sample Output

```
==== USE CASE 2: EMPLOYEE AUTHENTICATION & LOGIN ====

Enter Username : emp1

Enter Password : Emp@1234

Login Successful!

Role : EMPLOYEE

======== DASHBOARD ========

Employee Dashboard

View Payslip

Update Profile

Session active for user : emp1

Session active and valid.
```

---

# 🔑 Class Responsibilities

## PasswordUtil

- Hash passwords
- Compare password hashes

---

## User (Abstract)

- Stores common user information
- Defines abstract `authenticate()` method

---

## RegularEmployee

- Extends User
- Implements employee authentication

---

## Manager

- Extends User
- Implements manager authentication

---

## Session

- Represents logged-in user
- Maintains login state
- Validates session timeout

---

## AuthenticationService

- Handles login
- Validates credentials
- Creates sessions
- Displays role-based dashboard

---

## UseCase2LoginApp

- Entry point
- Coordinates login flow
- Calls AuthenticationService

---
