# 👨‍💼 Employee Payroll Management System – UC1: Employee Registration

## 📖 Overview

**Use Case 1 (UC1)** focuses on implementing the **Employee Registration** module of the Employee Payroll Management System. The objective is to register a new employee by validating the input data, creating the required objects, and storing the employee information.

This use case introduces the fundamental Object-Oriented Programming (OOP) concepts used throughout the project.

---

## 🎯 Goal

Register a new employee with validated personal and salary information.

---

## 📌 Learning Objectives

- Understand how multiple classes work together.
- Learn object creation and interaction.
- Apply core OOP principles in a real-world scenario.
- Separate validation logic from business logic.
- Build a modular and maintainable application.

---

## 🛠️ Features

- Register a new employee
- Validate Email Address
- Validate Phone Number
- Validate Employee ID
- Create User Account
- Generate Unique Employee Information
- Display Registration Confirmation

---

## 📚 OOP Concepts Covered

### ✅ Encapsulation
- Private data members
- Public getters and setters
- Controlled access to employee information

### ✅ Constructor Overloading
- Multiple constructors for flexible object creation

### ✅ Composition
- An Employee **HAS-A** UserAccount

### ✅ Method Overriding
- Override `toString()` for formatted employee details

### ✅ Regular Expressions (RegEx)
- Email validation
- Phone number validation
- Employee ID validation

### ✅ Exception Handling
- Custom `ValidationException`
- User-friendly error messages

---

## 📂 Project Structure

```text
src/
│
├── exception
│   └── ValidationException.java
│
├── validation
│   └── Validator.java
│
├── model
│   ├── Employee.java
│   └── UserAccount.java
│
├── dao
│   └── EmployeeDAO.java
│
├── daoimpl
│   └── EmployeeDAOImpl.java
│
└── main
    └── PayrollApplication.java
```

---

## 🔄 Registration Flow

```text
Start
   │
   ▼
Enter Employee Details
   │
   ▼
Validate Email
   │
   ▼
Validate Phone Number
   │
   ▼
Validate Employee ID
   │
   ▼
Create UserAccount Object
   │
   ▼
Create Employee Object
   │
   ▼
Save Employee
   │
   ▼
Registration Successful
```

---

## 🖥️ Sample Output

```text
========== Employee Registration ==========

Enter Employee ID : EMP-1001
Enter Name        : Jyothish Mypati
Enter Email       : jyothish@gmail.com
Enter Phone       : 9876543210
Enter Department  : IT
Enter Designation : Java Developer
Enter Salary      : 55000

Create Login

Username : jyothish
Password : ********

-----------------------------------------
Employee Registered Successfully
-----------------------------------------

Employee ID : EMP-1001
Name        : Jyothish Mypati
Department  : IT
Designation : Java Developer
Email       : jyothish@gmail.com
Phone       : 9876543210
Salary      : 55000.0
```

---

## ❌ Validation Rules

| Field | Rule |
|--------|------|
| Email | Must follow a valid email format |
| Phone | Must contain exactly 10 digits and start with 6, 7, 8, or 9 |
| Employee ID | Format: `EMP-XXXX` (e.g., EMP-1001) |
nagement System** to practice Java Object-Oriented Programming concepts through real-world use cases.