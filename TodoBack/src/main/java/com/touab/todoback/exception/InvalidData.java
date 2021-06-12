package com.touab.todoback.exception;


public class InvalidData extends Exception {

    private String message;
    private String field;

    public InvalidData(String message, String field) {
        super();
        this.message = message;
        this.field = field;
    }

    public InvalidData(String message) {
        super(message);
        this.message = message;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }


}
