package com.carbon.ecommerce.exception;

public class BusinessException extends Exception {

	private static final long serialVersionUID = -2565240123632337990L;

	public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
	
	public BusinessException(String message) {
        super(message);
    }
}
