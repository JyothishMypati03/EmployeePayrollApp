package com.payroll.main;

import com.payroll.dao.EmployeeDAO;
import com.payroll.daoimpl.EmployeeDAOImpl;
import com.payroll.exception.ValidationException;
import com.payroll.model.Employee;
import com.payroll.model.UserAccount;
import com.payroll.validation.Validator;
import com.payroll.auth.PasswordUtil;
import com.payroll.auth.AuthenticationService;
import com.payroll.auth.Session;

import java.util.Scanner;

public class PayrollApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Validator validator = new Validator();
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        AuthenticationService authService = new AuthenticationService(employeeDAO);

        System.out.println("=== Payroll App (Register / Login) ===");

        boolean running = true;
        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1) Register Employee");
            System.out.println("2) Login");
            System.out.println("3) Exit");
            System.out.print("Enter choice: ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    // Registration flow (same as before)
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

                        String hashed = PasswordUtil.hash(password);
                        UserAccount account = new UserAccount(username, hashed, "EMPLOYEE");
                        Employee employee = new Employee(employeeId, name, email, phone, department, designation, salary, account);
                        employeeDAO.addEmployee(employee);

                        System.out.println("\nEmployee Registered Successfully\n");
                        System.out.println(employee);

                    } catch (ValidationException e) {
                        System.out.println("Validation error: " + e.getMessage());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid salary. Please enter a numeric value.");
                    }
                    break;

                case "2":
                    // Login flow via AuthenticationService
                    Session session = authService.login();
                    if (session != null) {
                        if (session.isExpired()) {
                            System.out.println("Session expired immediately after login.");
                        } else {
                            System.out.println("Session is active and usable.");
                        }
                    } else {
                        System.out.println("Login failed.");
                    }
                    break;

                case "3":
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Choose 1, 2, or 3.");
            }
        }

    }
}
