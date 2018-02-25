package com.gym.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import javax.validation.MessageInterpolator;
import java.util.Locale;

/**
 * Created by Alejandro on 25/2/2018.
 */
public class MyMessageInterpolator implements MessageInterpolator {
    @Autowired
    private MessageSource messageSource;
    @Override
    public String interpolate(String s, Context context) {
        return messageSource.getMessage(s, null, null);
    }

    @Override
    public String interpolate(String s, Context context, Locale locale) {
        return messageSource.getMessage(s, null, locale);
    }
}
