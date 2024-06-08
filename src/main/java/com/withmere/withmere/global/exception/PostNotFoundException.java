package com.withmere.withmere.global.exception;

import com.withmere.withmere.global.exception.error.BusinessException;
import com.withmere.withmere.global.exception.error.ErrorCode;

public class PostNotFoundException extends BusinessException {
    public static final BusinessException EXCEPTION = new PostNotFoundException();
    private PostNotFoundException() { super(ErrorCode.POST_NOT_FOUND); }
}