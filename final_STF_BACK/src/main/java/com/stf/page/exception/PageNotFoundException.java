package com.stf.page.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PageNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public PageNotFoundException(String msg) {
		super(msg);
	}
}
