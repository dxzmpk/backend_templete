package com.dxzmpk.edu_backend.dto;

public class HttpResponseSingle implements HttpResponse {

    private int status;
    private String message;
    private Object data;

    public HttpResponseSingle(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpResponseSingle(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
