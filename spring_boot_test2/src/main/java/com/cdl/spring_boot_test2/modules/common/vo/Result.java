package com.cdl.spring_boot_test2.modules.common.vo;

public class Result<T> {
    private int status;
    private String message;
    private T object;

    public int getStatus() {
        return status;
    }

    public Result( ) {
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

    public T getObject() {
        return object;
    }

    public Result(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public Result(int status, String message, T object) {
        this.status = status;
        this.message = message;
        this.object = object;
    }

    public void setObject(T object) {
        this.object = object;
    }
    public enum ResultStatus{
        SUCCESS(200),FAILD(500);
        public int status;

        ResultStatus(int status) {
            this.status = status;
        }
    }
}
