package com.gym.validator;

import com.gym.bean.LoginBean;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Alejandro on 11/2/2018.
 */
@Component
public class ValidatorLoginBean  implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return LoginBean.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "login.username.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "login.password.empty");
        /*LoginBean loginBean= (LoginBean) o;
        if(loginBean == null || loginBean.getUsername() == null || loginBean.getUsername().trim().isEmpty())
            errors.rejectValue("username", "login.username.empty");
        if(loginBean == null || loginBean.getPassword() == null || loginBean.getPassword().trim().isEmpty())
            errors.rejectValue("password", "login.password.empty");
        */
    }
}
