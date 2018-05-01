package com.gym.validator;


import com.gym.dao.HorarioRepository;
import com.gym.model.Horario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Alejandro on 14/4/2018.
 */
/*@Component
public class HorarioValidator implements Validator {

    @Autowired
    HorarioRepository horarioRepository;
    @Override
    public boolean supports(Class<?> aClass) {
        return Horario.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Horario horario = (Horario) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "hora_inicio", "campo.obligatorio" );
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "hora_fin", "campo.obligatorio" );

        if(!errors.hasErrors()){
            SimpleDateFormat parser = new SimpleDateFormat("HH:mm");
            try {
                Date horario_inicio = parser.parse(horario.getHora_inicio());
                Date horario_fin = parser.parse(horario.getHora_fin());
                int valueComparacion = horario_inicio.compareTo(horario_fin);
                if(valueComparacion >= 0){
                    errors.rejectValue("hora_inicio", "horario.campo.horario_inicio.menorQueFecha_fin");
                    errors.rejectValue("hora_fin", "horario.campo.horario_fin.mayorQueFecha_inicio");
                }
                else {
                    Horario entity = horarioRepository.findByHorario_inicioAndHorario_finAndIdNot(horario.getHora_inicio(), horario.getHora_fin(), horario.getId() == null ? Long.MIN_VALUE : horario.getId());
                    if(entity != null){
                        errors.rejectValue("validationError", "horario.validationError.horarioExistente");
                    }
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

    }
}
*/
