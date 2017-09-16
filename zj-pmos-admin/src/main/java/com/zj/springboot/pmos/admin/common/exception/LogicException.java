package com.zj.springboot.pmos.admin.common.exception;

public class LogicException extends Exception{
	private static final long serialVersionUID = -2459296536746888047L;
	private int code;
	protected LogicException(int code,String message) {
		super(message);
		this.code = code;
	}
	public int getCode() {
		return code;
	}
}
