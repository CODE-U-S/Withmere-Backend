package com.withmere.withmere.global.exception;

import com.withmere.withmere.global.exception.error.BusinessException;
import com.withmere.withmere.global.exception.error.ErrorCode;

public class LikeDuplicateException extends BusinessException {
    public static final BusinessException EXCEPTION = new LikeDuplicateException();
    private LikeDuplicateException() { super(ErrorCode.LIKE_DUPLICATE); }
}