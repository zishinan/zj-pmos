package com.common.jz.oa.common.exception;


public class ErrorException extends LogicException{
	private static final long serialVersionUID = 7676754986940389833L;
	public ErrorException(String message) {
		super(-1,message);
	}
}
