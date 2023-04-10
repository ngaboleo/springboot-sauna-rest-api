package com.springbootsauna.springbootsaunarestapi.util;

public class ResponseObject {

    private Boolean status;
    private Object result;
    private String message;
    private Long count;

    public ResponseObject(Object object){
        this.status = true;
        this.result = object;
        this.message = "Request processed successful";
    }

    public ResponseObject(Exception exception)
    {
        this.status=false;
        this.result=exception.getStackTrace();
        this.message= exception.getMessage();

    }


}
