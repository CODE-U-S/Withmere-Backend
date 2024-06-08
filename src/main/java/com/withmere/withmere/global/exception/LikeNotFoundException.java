package com.withmere.withmere.global.exception;

import com.withmere.withmere.global.exception.error.BusinessException;
import com.withmere.withmere.global.exception.error.ErrorCode;

public class LikeNotFoundException extends BusinessException {
    public static final BusinessException EXCEPTION = new LikeNotFoundException();
    private LikeNotFoundException() { super(ErrorCode.POST_NOT_FOUND); }
}