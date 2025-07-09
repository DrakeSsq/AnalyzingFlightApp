package com.app.util;

import lombok.experimental.UtilityClass;

import java.io.FileNotFoundException;
import java.io.IOException;

@UtilityClass
public class ExceptionMessages {
    private static final String FILE_NOT_FOUND = "File %s not found";
    private static final String JSON_EXCEPTION_MESSAGE = "The incoming file contains an unsupported data format: %s";
    private static final String ZERO_ARGS = "0 arguments passed, 1 must be passed";

    public static FileNotFoundException createFileNotFoundException(String fileName) throws FileNotFoundException {
        throw new FileNotFoundException(String.format(FILE_NOT_FOUND, fileName));
    }

    public static IOException createJsonException(String msg) throws IOException{
        throw new IOException(String.format(JSON_EXCEPTION_MESSAGE, msg));
    }

    public static IllegalArgumentException createIllegalArgumentException() throws IllegalArgumentException{
        throw new IllegalArgumentException(ZERO_ARGS);
    }


}
