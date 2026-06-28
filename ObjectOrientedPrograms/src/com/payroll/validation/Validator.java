package com.payroll.validation;

import com.payroll.exception.ValidationException;

public class Validator {
    private static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final String PHONE_PATTERN = "^[0-9]{10}$";
    private static final String EMP_ID_PATTERN = "^EMP-[0-9]{4}$";

    public void validateEmail(String email) throws ValidationException {
        if (email == null || !email.matches(EMAIL_PATTERN)) {
            throw new ValidationException("Invalid email format. Expected example: user@example.com");
        }
    }

    public void validatePhone(String phone) throws ValidationException {
        if (phone == null || !phone.matches(PHONE_PATTERN)) {
            throw new ValidationException("Invalid phone number. Enter 10 digits only.");
        }
    }

    public void validateEmpId(String empId) throws ValidationException {
        if (empId == null || !empId.matches(EMP_ID_PATTERN)) {
            throw new ValidationException("Invalid employee ID. Expected format: EMP-1001");
        }
    }
}
