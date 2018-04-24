package com.genymotion.api;

public class GenymotionException extends RuntimeException
{
    public GenymotionException() {
    }
    
    public GenymotionException(final String message) {
        super(message);
    }
    
    public GenymotionException(final Throwable cause) {
        super(cause);
    }
    
    public GenymotionException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
