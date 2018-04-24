package com.genymotion.api;

import com.genymotion.genyd.*;
import android.os.*;

class Orientation
{
    private final IGenydService genyd;
    private static final int ACCELEROMETER_WRITE_MIN_PERIOD = 200;
    
    Orientation(final IGenydService genyd) {
        this.genyd = genyd;
    }
    
    public Orientation setAngle(final double angle) {
        GenymotionManager.checkApi("2.2", "com.genymotion.api.Orientation.setAngle(double)");
        try {
            this.genyd.setOrientationAngle(angle);
            Thread.sleep(200L);
        }
        catch (RemoteException e) {
            throw new GenymotionException("Unable to communicate with Genymotion", (Throwable)e);
        }
        catch (InterruptedException ex) {}
        return this;
    }
}
