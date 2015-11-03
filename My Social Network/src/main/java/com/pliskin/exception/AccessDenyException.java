package com.pliskin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by aleksandrpliskin on 29.10.15.
 */
@ResponseStatus(HttpStatus.FORBIDDEN)
public class AccessDenyException extends RuntimeException {
}
