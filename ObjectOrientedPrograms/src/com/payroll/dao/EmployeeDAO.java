package com.payroll.dao;

import com.payroll.model.Employee;

public interface EmployeeDAO {
    void addEmployee(Employee employee);
    Employee getEmployee(String empId);
}
