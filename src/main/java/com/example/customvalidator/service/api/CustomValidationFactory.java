package com.example.customvalidator.service.api;

public interface CustomValidationFactory {
    <T>CustomValidationService<T> get(Class<T> validationObjectClass);
}
