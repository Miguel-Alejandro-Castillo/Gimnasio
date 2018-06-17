package com.gym.validator;

import com.gym.model.Cliente;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by Alejandro on 27/5/2018.
 */
@Component
public class ClienteValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Cliente.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

    }
}
