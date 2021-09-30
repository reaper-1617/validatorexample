package com.example.customvalidator.service.impl.validators;

import com.example.customvalidator.model.DomainModelClass1;
import com.example.customvalidator.service.impl.AbstractValidationService;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.util.Set;

@Service
public class DomainModelClass1ValidatorImpl extends AbstractValidationService<DomainModelClass1> {

    @Override
    public Class<DomainModelClass1> getClassFor() {
        return DomainModelClass1.class;
    }


    @Override
    protected void setDefaults(DomainModelClass1 toValidate,
                               DomainModelClass1 defaultValue,
                               Set<ConstraintViolation<DomainModelClass1>> constraintViolations) {
        toValidate.setBooleanValue(false);
        toValidate.setStringValue(defaultValue.getStringValue());
    }
}
