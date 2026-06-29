package com.payroll.model;

import java.util.Objects;
import java.util.stream.Stream;

public class SalaryComponents {
    private static final double PF_RATE = 0.12;
    private static final double TAX_RATE = 0.10;

    private final String structureName;
    private final double basicSalary;
    private final double hra;
    private final double da;
    private final double allowances;
    private final double grossSalary;
    private final double pf;
    private final double tax;
    private final double netPay;


    public SalaryComponents(String structureName, double basicSalary, double hra, double da, double allowances) {
        this.structureName = structureName;
        this.basicSalary = basicSalary;
        this.hra = hra;
        this.da = da;
        this.allowances = allowances;
        this.grossSalary = basicSalary + hra + da + allowances;
        this.pf = basicSalary * PF_RATE;
        this.tax = grossSalary * TAX_RATE;
        this.netPay = grossSalary - (pf + tax);
    }

    public String getStructureName() {
        return structureName;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public double getHra() {
        return hra;
    }

    public double getDa() {
        return da;
    }

    public double getAllowances() {
        return allowances;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public double getPf() {
        return pf;
    }

    public double getTax() {
        return tax;
    }

    public double getNetPay() {
        return netPay;
    }


}
