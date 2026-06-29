package com.payroll.auth;

import com.payroll.dao.EmployeeDAO;
import com.payroll.model.Employee;
import com.payroll.model.UserAccount;

import java.util.Scanner;


public class AuthenticationService {
    private final EmployeeDAO employeeDAO;
    private final int maxAttempts = 3;

    public AuthenticationService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    // Very small and readable login flow for learning
    public Session login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== USE CASE 2: EMPLOYEE AUTHENTICATION & LOGIN ===");

        System.out.print("Enter Username: ");
        String username = scanner.nextLine().trim();

        // Find the employee record from DAO
        Employee employee = employeeDAO.findByUsername(username);
        if (employee == null || employee.getAccount() == null) {
            System.out.println("User not found.");
            return null;
        }

        UserAccount account = employee.getAccount();

        int attempts = 0;
        while (attempts < maxAttempts) {
            System.out.print("Enter Password: ");
            String password = scanner.nextLine().trim();

            // Verify hashed password
            boolean ok = PasswordUtil.verify(password, account.getPassword());
            if (ok) {
                System.out.println("\nLogin Successful!\nRole: " + account.getRole() + "\n");
                Session session = new Session(username);
                showDashboard(account.getRole());
                System.out.println(session.toString());
                System.out.println(session.isExpired() ? "Session active but expired." : "Session active and valid.");
                return session;
            } else {
                attempts++;
                System.out.println("Invalid credentials. Attempts left: " + (maxAttempts - attempts));
            }
        }

        System.out.println("Maximum login attempts exceeded. Notification sent to admin.");
        return null;
    }

    private void showDashboard(String role) {
        System.out.println("======= DASHBOARD =======");
        if ("EMPLOYEE".equals(role)) {
            System.out.println("Employee Dashboard");
            System.out.println("View Payslip | Update Profile");
        } else if ("MANAGER".equals(role)) {
            System.out.println("Manager Dashboard");
            System.out.println("Team Overview | Approve Leaves | Payroll Reports");
        } else {
            System.out.println("Generic Dashboard");
        }
        System.out.println();
    }
}
