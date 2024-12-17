package com.system.recommendations.exceptions;

public class TaskException extends RuntimeException {

    public TaskException(String s) {
        super(s);
    }

    public TaskException(String s, Throwable throwable) {
        super(s, throwable);
    }
}