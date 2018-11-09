package com.concretesolutions.exception;
import org.springframework.http.HttpStatus;


public class EmailAlreadyRegisteredException extends GenericException {
	private static final long serialVersionUID = 6902542402673108734L;

    public EmailAlreadyRegisteredException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }

}
