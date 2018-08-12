package com.gym.formatter;

import com.gym.dao.ProfesorRepository;
import com.gym.model.Profesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.beans.PropertyEditorSupport;

/**
 * Created by Alejandro on 11/8/2018.
 */
@Component
public class ProfesorEditor extends PropertyEditorSupport {

    @Autowired
    private ProfesorRepository profesorRepository;

    @Override
    public void setAsText(String text) {
        Profesor profesor = profesorRepository.findOne(Long.valueOf(text));
        this.setValue(profesor);
    }
}
