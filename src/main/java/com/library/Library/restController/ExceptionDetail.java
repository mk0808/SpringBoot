package com.library.Library.restController;

public class ExceptionDetail {
    private String exceptionName;
    private String message;


    public ExceptionDetail(String exeptionName, String message) {
        this.exceptionName = exeptionName;
        this.message = message;
    }

    public String getExceptionName() {
        return exceptionName;
    }

    public void setExceptionName(String exceptionName) {
        this.exceptionName = exceptionName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
