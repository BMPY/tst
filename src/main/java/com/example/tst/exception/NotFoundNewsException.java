package com.example.tst.exception;

public class NotFoundNewsException extends Exception {
    public NotFoundNewsException(String message) {
        super(message);
    }
}