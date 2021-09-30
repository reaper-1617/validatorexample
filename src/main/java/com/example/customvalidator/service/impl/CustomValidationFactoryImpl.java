package com.example.customvalidator.service.impl;

import com.example.customvalidator.service.api.CustomValidationFactory;
import com.example.customvalidator.service.api.CustomValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class CustomValidationFactoryImpl implements CustomValidationFactory {


    private final List<CustomValidationService<?>> validationServices;

    private Map<Class<?>, CustomValidationService<?>> validationServiceMap;

    @Autowired
    public CustomValidationFactoryImpl(List<CustomValidationService<?>> validationServices) {
        this.validationServices = validationServices;
    }

    @PostConstruct
    void postConstruct() {
        validationServiceMap = validationServices.stream().collect(Collectors.toMap(
                CustomValidationService::getClassFor, Function.identity()
        ));
    }

    @Override
    public <T>CustomValidationService<T> get(Class<T> validationObjectClass) {
        return (CustomValidationService<T>) validationServiceMap.get(validationObjectClass);
    }
}
