package com.dxzmpk.edu_backend.dto;

import java.util.List;

public class HttpResponseList implements HttpResponse {

    private int status;
    private String message;
    private long pageTotal;
    private List data;



    public HttpResponseList(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpResponseList(int status, String message, List data) {
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

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public long getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(long pageTotal) {
        this.pageTotal = pageTotal;
    }
}
