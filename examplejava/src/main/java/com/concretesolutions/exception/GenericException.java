package com.concretesolutions.exception;

import org.springframework.http.HttpStatus;

public class GenericException extends Exception {
	private static final long serialVersionUID = 6978356406969855607L;
    private HttpStatus httpStatus;

    public GenericException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public GenericException(String message, Throwable cause, HttpStatus httpStatus) {
        super(message, cause);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}
