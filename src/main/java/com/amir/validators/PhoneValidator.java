package com.amir.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, String> {
    @Override
    public void initialize(Phone constraint) {

    }

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
        if (phoneNumber == null)
            return false;
        if (phoneNumber.matches("09[1-5][1-9]\\d{7}$"))
            return true;
        return false;
    }
}