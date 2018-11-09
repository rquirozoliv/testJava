package com.concretesolutions.exception;

import org.springframework.http.HttpStatus;

public class InvalidDataException extends GenericException {
	private static final long serialVersionUID = 4093480342519179523L;

    public InvalidDataException(String dataError, HttpStatus httpStatus) {
        super(dataError, httpStatus);
    }

}
