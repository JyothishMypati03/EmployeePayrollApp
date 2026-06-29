# 📄  Payslip Print / Download

## 📖 Overview

**Use Case 4 (UC4)** implements the **Payslip Print / Download** module of the Employee Payroll Management System.

This module allows an authenticated employee to generate a downloadable copy of a monthly payslip while preserving the original payslip object. The application creates a separate payslip copy, generates a unique filename, and saves it using Java File I/O.

---

## 🎯 Goal

Generate a downloadable copy of an employee's monthly payslip without modifying the original payslip.

---

## 👥 Actors

- Authenticated Employee (Primary)
- FileService (Secondary)

---

## 🔄 Flow

```
Generate Payslip
        │
        ▼
Clone Payslip Object
        │
        ▼
Validate Payslip
        │
        ▼
Generate Unique File Name
        │
        ▼
Save Payslip (Text/PDF)
        │
        ▼
Print Confirmation
```

---

## 🛠 Features

- Generate Downloadable Payslip
- Create Independent Payslip Copy
- Clone Payslip Object
- Compare Payslip Objects
- Generate Unique File Names
- Save Payslip as Text File
- Support PDF Download (Future Enhancement)
- Print Download Confirmation

---

# 📚 OOP Concepts Covered

## ✅ equals()

Compares two payslip objects based on their business data instead of memory addresses.

---

## ✅ hashCode()

Generates a hash value consistent with `equals()` to support proper object comparison and collections.

---

## ✅ Cloning

Creates an independent copy of the payslip object.

- Shallow Copy
- Deep Copy (concept)

---

## ✅ Immutable Objects

Downloaded payslip copy should not modify the original object.

---

## ✅ File I/O

Uses Java File I/O classes to save the generated payslip into a file.

---

## ✅ Method Overriding

Override:

- `toString()`
- `equals()`
- `hashCode()`
- `clone()`

---

# 📂 Project Structure

```
EmployeePayrollApp
│
├── model
│     ├── Employee.java
│     ├── Payslip.java
│     └── FinalPayslip.java
│
├── service
│     ├── PayrollService.java
│     └── FileService.java
│
├── utility
│     └── FileUtility.java
│
└── main
      UseCase4Application.java
```

---

# 🖥 Sample Output

```
===============================
        MONTHLY PAYSLIP
===============================

Employee ID : EMP101
Employee    : Jyothish Mypati
Department  : IT

Month       : June 2026

--------------------------------

Basic Salary : ₹50,000.00
HRA          : ₹10,000.00
DA           : ₹5,000.00

Gross Salary : ₹65,000.00

PF           : ₹3,000.00
Tax          : ₹2,000.00

--------------------------------

Net Salary   : ₹60,000.00

===============================

Save Payslip? (y/n): y

Generating Download Copy...

Clone Created Successfully.

Payslip Saved Successfully.

File Name:
Payslip_EMP101_1751276543210.txt

Download Completed.
```

---

# 🔑 Class Responsibilities

## Employee

- Stores employee information.

---

## Payslip

- Stores salary details.
- Calculates gross and net salary.
- Generates formatted payslip.

---

## FinalPayslip

- Represents the downloadable payslip.
- Overrides `equals()`
- Overrides `hashCode()`
- Supports cloning.

---

## PayrollService

- Generates employee payslip.
- Sends payslip to FileService.

---

## FileService

- Generates unique filenames.
- Saves payslip as a text file.
- Handles file operations.

---

## UseCase4Application

- Displays payslip.
- Accepts user choice.
- Creates downloadable copy.
- Saves the payslip.

---

# 📖 Key Benefits

- Data safety (original object remains unchanged)
- Independent downloadable payslip copy
- Proper object comparison using `equals()` and `hashCode()`
- Professional unique file naming
- Easy file storage using Java File I/O
- Extendable to PDF generation
- Version-control friendly design

---
