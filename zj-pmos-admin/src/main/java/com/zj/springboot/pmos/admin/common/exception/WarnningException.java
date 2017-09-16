package com.zj.springboot.pmos.admin.common.exception;

public class WarnningException extends LogicException{
	private static final long serialVersionUID = 7676754986940389833L;
	public WarnningException(String message) {
		super(1,message);
	}
}
