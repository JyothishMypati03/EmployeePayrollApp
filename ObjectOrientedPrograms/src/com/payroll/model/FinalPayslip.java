package com.payroll.model;

import java.util.Objects;

public final class FinalPayslip implements Cloneable {
    private final String empId;
    private final String empName;
    private final String month;
    private final double netPay;

    public FinalPayslip(String empId, String empName, String month, double netPay) {
        this.empId = empId;
        this.empName = empName;
        this.month = month;
        this.netPay = netPay;
    }

    public String getEmpId() { return empId; }
    public String getEmpName() { return empName; }
    public String getMonth() { return month; }
    public double getNetPay() { return netPay; }

    @Override
    public Object clone() {
        return new FinalPayslip(empId, empName, month, netPay);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FinalPayslip that = (FinalPayslip) o;
        return Objects.equals(empId, that.empId) && Objects.equals(month, that.month);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (empId == null ? 0 : empId.hashCode());
        result = 31 * result + (month == null ? 0 : month.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PAYSLIP\n" +
                "Employee ID : " + empId + "\n" +
                "Employee Name : " + empName + "\n" +
                "Month       : " + month + "\n" +
                "Net Pay     : " + netPay + "\n";
    }
}
