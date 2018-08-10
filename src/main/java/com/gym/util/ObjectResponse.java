package com.gym.util;

/**
 * Created by Alejandro on 1/5/2018.
 */
public class ObjectResponse {
    private Object objectResponse;
    private String messageResponse;

    public ObjectResponse(Object o, String message) {
        super();
        objectResponse = o;
        messageResponse = message;
    }


    public Object getObjectResponse() {
        return objectResponse;
    }

    public void setObjectResponse(Object objectResponse) {
        this.objectResponse = objectResponse;
    }

    public String getMessageResponse() {
        return messageResponse;
    }

    public void setMessageResponse(String messageResponse) {
        this.messageResponse = messageResponse;
    }
}
