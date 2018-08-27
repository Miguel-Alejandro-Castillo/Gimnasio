package com.gym.validator;

import com.gym.model.Pago;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by Alejandro on 27/5/2018.
 */
@Component
public class PagoValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Pago.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Pago pago = (Pago) o;
        if( pago != null && pago.getFechaDesde() != null && pago.getFechaHasta() != null) {
            if (pago.getFechaDesde().compareTo(pago.getFechaHasta()) > 0) {
                errors.rejectValue("fechaDesde", "campo.fechaDesde.menorIgualQueFechaHasta");
                errors.rejectValue("fechaHasta", "campo.fechaHasta.mayorIgualQueFechaDesde");
            }
        }

        if(pago.getMontoAPagar() != null && pago.getMontoPagado() != null){
          if(pago.getMontoPagado().compareTo(pago.getMontoAPagar()) > 0 ){
              errors.rejectValue("montoAPagar", "campo.montoAPagar.menorQueMontoPagado");
              errors.rejectValue("montoPagado", "campo.montoPagado.mayorQueMontoAPagar");
          }
        }
    }
}
