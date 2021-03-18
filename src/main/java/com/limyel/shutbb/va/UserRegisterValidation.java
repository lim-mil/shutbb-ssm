package com.limyel.shutbb.va;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserRegisterValidation implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object o, Errors errors) {

    }
}
