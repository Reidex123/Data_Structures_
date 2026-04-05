package com.dag;

public class CycleFoundException extends Exception {

    public CycleFoundException(String message) {
        super(message);
    }

}
