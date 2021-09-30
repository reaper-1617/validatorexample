package com.example.customvalidator.service.impl;

import com.example.customvalidator.model.DomainModelClass2;
import com.example.customvalidator.service.api.CustomValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;


public abstract class AbstractValidationService<T> implements CustomValidationService<T> {


    private Validator validator;


    @Autowired
    public void setValidator(Validator validator) {
        this.validator = validator;
    }

    @Override
    public void validate(T toValidate) {
        Set<ConstraintViolation<T>> violations = validator.validate(toValidate);
        if (!violations.isEmpty()){
            throw new RuntimeException();
        }
    }

    @Override
    public void validate(T toValidate, T defaultValue) {
        Set<ConstraintViolation<T>> violations = validator.validate(toValidate);
        if (!violations.isEmpty()){
            setDefaults(toValidate, defaultValue, violations);
        }
    }

    protected abstract void setDefaults(T toValidate, T defaultValue, Set<ConstraintViolation<T>> violations);

}
