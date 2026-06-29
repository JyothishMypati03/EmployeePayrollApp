package com.payroll.model;

public class Payslip {
    private final Employee employee;
    private final SalaryComponents components;
    private final String month;

    public Payslip(Employee employee, SalaryComponents components, String month) {
        this.employee = employee;
        this.components = components;
        this.month = month;
    }

    public Employee getEmployee() {
        return employee;
    }

    public SalaryComponents getComponents() {
        return components;
    }

    public String getMonth() {
        return month;
    }

    @Override
    public String toString() {
        return "\n========== PAYSLIP ==========\n" +
                "Month              : " + month + "\n" +
                "Salary Structure   : " + components.getStructureName() + "\n" +
                "Employee ID        : " + employee.getEmployeeId() + "\n" +
                "Employee Name      : " + employee.getName() + "\n\n" +

                "----- Earnings -----\n" +
                "Basic Salary       : " + components.getBasicSalary() + "\n" +
                "HRA                : " + components.getHra() + "\n" +
                "DA                 : " + components.getDa() + "\n" +
                "Allowances         : " + components.getAllowances() + "\n\n" +

                "----- Deductions -----\n" +
                "Provident Fund (PF): " + components.getPf() + "\n" +
                "Income Tax         : " + components.getTax() + "\n\n" +

                "Net Pay            : " + components.getNetPay() + "\n" +
                "==========================";
    }
}
