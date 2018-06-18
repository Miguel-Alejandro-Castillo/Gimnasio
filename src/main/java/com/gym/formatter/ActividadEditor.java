package com.gym.formatter;

import com.gym.dao.ActividadRepository;
import com.gym.model.Actividad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.beans.PropertyEditorSupport;
/**
 * Created by Alejandro on 17/6/2018.
 */
@Component
public class ActividadEditor extends PropertyEditorSupport {

    @Autowired
    private ActividadRepository actividadRepository;

    @Override
    public void setAsText(String text) {
        Actividad a = actividadRepository.findOne(Long.valueOf(text));
        this.setValue(a);
    }

}
