package com.example.customvalidator.service.impl.validators;

import com.example.customvalidator.model.БольшойСложныйОбъект;
import com.example.customvalidator.service.impl.AbstractValidationService;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.util.Collections;
import java.util.Set;

@Service
public class ВалидаторБольшогоСложногоОбъектаImpl extends AbstractValidationService<БольшойСложныйОбъект> {

    @Override
    public void validate(БольшойСложныйОбъект toValidate, БольшойСложныйОбъект defaultValue) {
        // instead of hibernate (or spring) validator of standard @NonNull, @Email etc:

        if (toValidate.getЗависимоеПоле1().equals("лалала")) {
            if (toValidate.getЗависимоеПоле2().equals("бебебе")) {
                // do some logic corresponding to the validation rules
                // e.g. set defaults
                setDefaults(toValidate, defaultValue, Collections.emptySet());
            }
        }
    }

    @Override
    public Class<БольшойСложныйОбъект> getClassFor() {
        return БольшойСложныйОбъект.class;
    }

    @Override
    protected void setDefaults(БольшойСложныйОбъект toValidate, БольшойСложныйОбъект defaultValue, Set<ConstraintViolation<БольшойСложныйОбъект>> constraintViolations) {
        toValidate.setЗависимоеПоле1("никита соберись");
    }
}
