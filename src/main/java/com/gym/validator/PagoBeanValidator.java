package com.gym.validator;

import com.gym.bean.PagoBean;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by Alejandro on 27/5/2018.
 */
@Component
public class PagoBeanValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return PagoBean.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        PagoBean pagoBean = (PagoBean) o;
        if(pagoBean.getFecha_desde() != null && pagoBean.getFecha_hasta() != null) {
            if (pagoBean.getFecha_desde().compareTo(pagoBean.getFecha_hasta()) > 0) {
                errors.rejectValue("fecha_desde", "campo.fecha_desde.menorIgualQueFecha_hasta");
                errors.rejectValue("fecha_hasta", "campo.fecha_hasta.mayorIgualQueFecha_desde");
            }
        }
    }
}
