package com.example.customvalidator;

import com.example.customvalidator.model.DomainModelClass1;
import com.example.customvalidator.model.DomainModelClass2;
import com.example.customvalidator.service.api.CustomValidationFactory;
import com.example.customvalidator.service.api.CustomValidationService;
import com.example.customvalidator.service.impl.validators.DomainModelClass1ValidatorImpl;
import com.example.customvalidator.service.impl.validators.DomainModelClass2ValidatorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CustomValidatorApplication {



    public static CustomValidationFactory customValidationFactory;

    public static void main(String[] args) {
        SpringApplication.run(CustomValidatorApplication.class, args);

        CustomValidationService<DomainModelClass1> validator1 = customValidationFactory.get(DomainModelClass1.class);
        CustomValidationService<DomainModelClass2> validator2 = customValidationFactory.get(DomainModelClass2.class);

        DomainModelClass1 model1 = new DomainModelClass1();
        model1.setStringValue("mmmmm"); //should be a email
        model1.setBooleanValue(false); //should not be null
        DomainModelClass1 defaultModel1Value = new DomainModelClass1(true, "mail@mail.ru");

        DomainModelClass2 model2 = new DomainModelClass2();
        model2.setIntegerValue(null); //should not be null
        model2.setStringValue("dddddd"); //should be from 2 to 5 chars
        DomainModelClass2 defaultModel2Value = new DomainModelClass2(2, "333");

        validator1.validate(model1, defaultModel1Value); //validate with default value setting
        validator2.validate(model2, defaultModel2Value); //validate with default value setting

        System.out.println("Model 1 after default values set: " + model1);
        System.out.println("Model 2 after default values set: " + model2);


    }

    @Autowired
    public void setCustomValidationFactory(CustomValidationFactory customValidationFactory) {
        CustomValidatorApplication.customValidationFactory = customValidationFactory;
    }
}
