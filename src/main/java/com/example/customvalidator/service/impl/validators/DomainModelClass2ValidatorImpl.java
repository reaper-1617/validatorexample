package com.example.customvalidator.service.impl.validators;

import com.example.customvalidator.model.DomainModelClass2;
import com.example.customvalidator.service.impl.AbstractValidationService;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.util.Set;

@Service
public class DomainModelClass2ValidatorImpl extends AbstractValidationService<DomainModelClass2> {
    @Override
    public Class<DomainModelClass2> getClassFor() {
        return DomainModelClass2.class;
    }

    @Override
    protected void setDefaults(DomainModelClass2 toValidate, DomainModelClass2 defaultValue, Set<ConstraintViolation<DomainModelClass2>> constraintViolations) {
        toValidate.setIntegerValue(10);
        toValidate.setStringValue("курлык");
    }
}
