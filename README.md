# 💰Payslip Generation

## 📖 Overview

**Use Case 3 (UC3)** implements the **Payslip Generation** module of the Employee Payroll Management System.

This use case calculates an employee's monthly salary by combining salary components, applying statutory deductions, and generating a professional payslip. It demonstrates how object-oriented design can simplify payroll processing through reusable components and clean class relationships.

---

## 🎯 Goal

Generate a detailed monthly payslip with salary components, deductions, and net payable salary.

---

## 📌 Learning Objectives

- Understand Composition and Aggregation.
- Learn how multiple objects collaborate.
- Apply Java Stream API for salary calculations.
- Use the Fluent Interface Design Pattern.
- Override `toString()` for formatted payslip output.

---

## 🛠 Features

- Generate Monthly Payslip
- Calculate Gross Salary
- Apply PF Deduction
- Apply Tax Deduction
- Calculate Net Salary
- Support Multiple Salary Structures
- Display Professional Payslip
- Maintain Historical Payslip Records

---

# 📚 OOP Concepts Covered

## ✅ Composition

A **Payslip HAS-A SalaryComponents**.

```
Payslip
   │
   ├── Basic Salary
   ├── HRA
   ├── DA
   ├── Bonus
   └── Allowances
```

---

## ✅ Aggregation

A **Payslip HAS-A Employee**.

```
Employee
      ▲
      │
  Payslip
```

The Employee exists independently of the Payslip.

---

## ✅ Stream API

Used for:

- Calculating Gross Salary
- Summing Salary Components
- Processing Collections

Example operations:

- map()
- filter()
- reduce()
- sum()

---

## ✅ Fluent Interface

Supports chained method calls.

Example:

```java
Payslip payslip = new Payslip()
        .setEmployee(employee)
        .setMonth("June")
        .calculateSalary();
```

---

## ✅ Method Overriding

Override `toString()` to generate a formatted payslip.

---

# 📂 Project Structure

```
src/

│
├── model
│      Employee.java
│      SalaryComponent.java
│      Payslip.java
│
├── service
│      PayrollService.java
│
└── main
       UseCase3PayslipApp.java
```

---

# 🔄 Payslip Generation Flow

```
Start
   │
   ▼
Select Employee
   │
   ▼
Select Month
   │
   ▼
Load Salary Components
   │
   ▼
Calculate Gross Salary
   │
   ▼
Apply PF & Tax
   │
   ▼
Calculate Net Salary
   │
   ▼
Generate Payslip
   │
   ▼
Display Payslip
```

---

# 🖥 Sample Output

```
=========== MONTHLY PAYSLIP ===========

Employee ID : EMP-1001
Employee    : Jyothish Mypati
Department  : IT
Month       : June 2026

---------------------------------------

Basic Salary     : ₹50,000.00
HRA              : ₹10,000.00
DA               : ₹5,000.00
Bonus            : ₹2,000.00

---------------------------------------

Gross Salary     : ₹67,000.00

PF Deduction     : ₹3,000.00
Tax Deduction    : ₹2,000.00

---------------------------------------

Net Salary       : ₹62,000.00

=======================================
```

---

# 🔑 Class Responsibilities

## Employee

- Stores employee information.

---

## SalaryComponent

- Represents individual salary components.
- Basic Salary
- HRA
- DA
- Bonus
- Allowances

---

## Payslip

- Holds employee details.
- Contains salary components.
- Calculates gross salary.
- Calculates deductions.
- Calculates net salary.
- Generates formatted payslip.

---

## PayrollService

- Generates payslip.
- Applies payroll rules.
- Calculates deductions.
- Returns completed Payslip object.

