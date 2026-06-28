package com.payroll.model;

public class Employee {
    private String employeeId;
    private String name;
    private String email;
    private String phone;
    private String department;
    private String designation;
    private double basicSalary;
    private UserAccount account;

    public Employee() {
    }

    public Employee(String employeeId, String name, String email, String phone,
                    String department, String designation, double basicSalary, UserAccount account) {
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.department = department;
        this.designation = designation;
        this.basicSalary = basicSalary;
        this.account = account;
    }

    public Employee(String employeeId, String name, String email, String phone,
                    String department, String designation, double basicSalary) {
        this(employeeId, name, email, phone, department, designation, basicSalary, null);
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public UserAccount getAccount() {
        return account;
    }

    public void setAccount(UserAccount account) {
        this.account = account;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Employee ID : ").append(employeeId).append("\n");
        builder.append("Name        : ").append(name).append("\n");
        builder.append("Email       : ").append(email).append("\n");
        builder.append("Phone       : ").append(phone).append("\n");
        builder.append("Department  : ").append(department).append("\n");
        builder.append("Designation : ").append(designation).append("\n");
        builder.append("Salary      : ").append(basicSalary).append("\n");
        if (account != null) {
            builder.append(account.toString());
        }
        return builder.toString();
    }
}
