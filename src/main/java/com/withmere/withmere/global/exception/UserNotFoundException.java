package com.withmere.withmere.global.exception;


import com.withmere.withmere.global.exception.error.BusinessException;
import com.withmere.withmere.global.exception.error.ErrorCode;

public class UserNotFoundException extends BusinessException {
    public static final BusinessException EXCEPTION = new UserNotFoundException();
    private UserNotFoundException() { super(ErrorCode.USER_NOT_FOUND); }
}