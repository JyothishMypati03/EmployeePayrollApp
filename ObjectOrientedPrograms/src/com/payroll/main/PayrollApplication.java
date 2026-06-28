package com.payroll.main;

import com.payroll.dao.EmployeeDAO;
import com.payroll.daoimpl.EmployeeDAOImpl;
import com.payroll.exception.ValidationException;
import com.payroll.model.Employee;
import com.payroll.model.UserAccount;
import com.payroll.validation.Validator;

import java.util.Scanner;

public class PayrollApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Validator validator = new Validator();
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

        System.out.println("========== Employee Registration ==========");

        try {
            System.out.print("\nEnter Employee ID : ");
            String employeeId = scanner.nextLine().trim();
            validator.validateEmpId(employeeId);

            System.out.print("Enter Name        : ");
            String name = scanner.nextLine().trim();

            System.out.print("Enter Email       : ");
            String email = scanner.nextLine().trim();
            validator.validateEmail(email);

            System.out.print("Enter Phone       : ");
            String phone = scanner.nextLine().trim();
            validator.validatePhone(phone);

            System.out.print("Enter Department  : ");
            String department = scanner.nextLine().trim();

            System.out.print("Enter Designation : ");
            String designation = scanner.nextLine().trim();

            System.out.print("Enter Salary      : ");
            double salary = Double.parseDouble(scanner.nextLine().trim());

            System.out.println("\nCreate Login\n");
            System.out.print("Username : ");
            String username = scanner.nextLine().trim();

            System.out.print("Password : ");
            String password = scanner.nextLine().trim();

            UserAccount account = new UserAccount(username, password, "EMPLOYEE");
            Employee employee = new Employee(employeeId, name, email, phone, department, designation, salary, account);
            employeeDAO.addEmployee(employee);

            System.out.println("\n---------------------------------------");
            System.out.println("Employee Registered Successfully");
            System.out.println("---------------------------------------\n");
            System.out.println(employee);

        } catch (ValidationException e) {
            System.out.println("Validation error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid salary. Please enter a numeric value.");
        } finally {
            scanner.close();
        }
    }
}
