package com.genymotion.api;

public class NotGenymotionDeviceException extends GenymotionException
{
    public NotGenymotionDeviceException() {
        super("This device is not a Genymotion Virtual Device, you cannot use Genymotion API.");
    }
    
    public NotGenymotionDeviceException(final String message) {
        super(message);
    }
    
    public NotGenymotionDeviceException(final Throwable cause) {
        super(cause);
    }
    
    public NotGenymotionDeviceException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
