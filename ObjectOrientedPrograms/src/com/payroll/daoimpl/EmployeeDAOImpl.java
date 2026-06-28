package com.payroll.daoimpl;

import com.payroll.dao.EmployeeDAO;
import com.payroll.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private final List<Employee> employees;

    public EmployeeDAOImpl() {
        this.employees = new ArrayList<>();
    }

    @Override
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    @Override
    public Employee getEmployee(String empId) {
        for (Employee employee : employees) {
            if (employee.getEmployeeId().equals(empId)) {
                return employee;
            }
        }
        return null;
    }
}
