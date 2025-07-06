package com.app.exceptions;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonProcessingException;

public class CustomJsonException extends JsonProcessingException {
    public CustomJsonException(String msg) {
        super(msg);
    }

    public CustomJsonException(String msg, JsonLocation loc) {
        super(msg, loc);
    }
}
