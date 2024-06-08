package com.withmere.withmere.global.exception;

import com.withmere.withmere.global.exception.error.BusinessException;
import com.withmere.withmere.global.exception.error.ErrorCode;

public class CommentNotFoundException extends BusinessException {
    public static final BusinessException EXCEPTION = new CommentNotFoundException();
    private CommentNotFoundException() { super(ErrorCode.COMMENT_NOT_FOUND); }
}