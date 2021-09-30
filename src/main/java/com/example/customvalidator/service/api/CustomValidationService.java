package com.example.customvalidator.service.api;

public interface CustomValidationService<T> {
    /**
     * Validates and throws an exception
     * @param toValidate
     */
    void validate(T toValidate);

    /**
     *  Validates and sets default if not valid
     *  Attention! Default value not guaranteed to be checked on its validity
     * @param toValidate
     * @param defaultValue
     */
    void validate(T toValidate, T defaultValue);

    /**
     * Class of object this service intended to validate
     * @return instance of {@link Class<T>}
     */
    Class<T> getClassFor();
}
