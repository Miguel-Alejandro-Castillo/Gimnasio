package com.gym.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alejandro on 1/5/2018.
 */
public class Response {
    private Object data;
    private Map<String, String> errores;

    public Response() {
        super();
       this.errores = new HashMap<>();
    }

    public Response(Object data) {
        this();
        this.data = data;

    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Map<String, String> getErrores() {
        return errores;
    }

    public void setErrores(Map<String, String> errores) {
        this.errores = errores;
    }
}
