package com.genymotion.api;

public class MethodUnavailableException extends RuntimeException
{
    public MethodUnavailableException() {
    }
    
    public MethodUnavailableException(final String message) {
        super(message);
    }
    
    public MethodUnavailableException(final Throwable cause) {
        super(cause);
    }
    
    public MethodUnavailableException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
