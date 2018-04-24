package com.genymotion.api;

import com.genymotion.genyd.*;
import android.location.*;
import android.os.*;
import android.content.*;

public class Gps
{
    private final Object mLocationLock;
    private final IGenydService genyd;
    
    Gps(final IGenydService genyd) {
        this.mLocationLock = new Object();
        this.genyd = genyd;
    }
    
    public Gps setAccuracy(final float accuracy) {
        GenymotionManager.checkApi("2.2", "com.genymotion.api.Gps.setAccuracy(float)");
        if (accuracy < 0.0f || accuracy > 200.0f) {
            throw new GenymotionException("Invalid value. The expected range is 0 to 200");
        }
        try {
            this.genyd.setGpsAccuracy(accuracy);
        }
        catch (RemoteException e) {
            throw new GenymotionException("Unable to communicate with Genymotion", (Throwable)e);
        }
        final Location targetLocation = new Location("DummyProvider");
        targetLocation.setAccuracy(accuracy);
        this.waitForTargetLocation(targetLocation);
        return this;
    }
    
    public Gps setAltitude(final double altitude) {
        GenymotionManager.checkApi("2.2", "com.genymotion.api.Gps.setAltitude(double)");
        if (altitude < -10000.0 || altitude > 10000.0) {
            throw new GenymotionException("Invalid Value. The expected range is -1000 to 1000");
        }
        try {
            this.genyd.setGpsAltitude(altitude);
        }
        catch (RemoteException e) {
            throw new GenymotionException("Unable to communicate with Genymotion", (Throwable)e);
        }
        final Location targetLocation = new Location("DummyProvider");
        targetLocation.setAltitude(altitude);
        this.waitForTargetLocation(targetLocation);
        return this;
    }
    
    public Gps setBearing(final float bearing) {
        GenymotionManager.checkApi("2.2", "com.genymotion.api.Gps.setBearing(float)");
        if (bearing < 0.0f || bearing >= 360.0f) {
            throw new GenymotionException("Invalid value. The expected range is 0 to 360");
        }
        try {
            this.genyd.setGpsBearing(bearing);
        }
        catch (RemoteException e) {
            throw new GenymotionException("Unable to communicate with Genymotion", (Throwable)e);
        }
        final Location targetLocation = new Location("DummyProvider");
        targetLocation.setBearing(bearing);
        this.waitForTargetLocation(targetLocation);
        return this;
    }
    
    public Gps setLatitude(final double latitude) {
        GenymotionManager.checkApi("2.2", "com.genymotion.api.Gps.setLatitude(double)");
        if (latitude < -90.0 || latitude > 90.0) {
            throw new GenymotionException("Invalid value. The expected range is 0 to 90");
        }
        try {
            this.genyd.setGpsLatitude(latitude);
        }
        catch (RemoteException e) {
            throw new GenymotionException("Unable to communicate with Genymotion", (Throwable)e);
        }
        final Location targetLocation = new Location("DummyProvider");
        targetLocation.setLatitude(latitude);
        this.waitForTargetLocation(targetLocation);
        return this;
    }
    
    public Gps setLongitude(final double longitude) {
        GenymotionManager.checkApi("2.2", "com.genymotion.api.Gps.setLongitude(double)");
        if (longitude < -180.0 || longitude > 180.0) {
            throw new GenymotionException("Invalid value. The expected range is -180 to 180");
        }
        try {
            this.genyd.setGpsLongitude(longitude);
        }
        catch (RemoteException e) {
            throw new GenymotionException("Unable to communicate with Genymotion", (Throwable)e);
        }
        final Location targetLocation = new Location("DummyProvider");
        targetLocation.setLongitude(longitude);
        this.waitForTargetLocation(targetLocation);
        return this;
    }
    
    public Status getStatus() {
        GenymotionManager.checkApi("2.2", "com.genymotion.api.Gps.getStatus()");
        Status res;
        try {
            res = (this.genyd.getGpsStatus() ? Status.ENABLED : Status.DISABLED);
        }
        catch (RemoteException e) {
            throw new GenymotionException("Unable to communicate with Genymotion", (Throwable)e);
        }
        return res;
    }
    
    public Gps setStatus(final Status status) {
        GenymotionManager.checkApi("2.2", "com.genymotion.api.Gps.setStatus(com.genymotion.api.Gps$Status)");
        try {
            this.genyd.setGpsStatus(status == Status.ENABLED);
        }
        catch (RemoteException e) {
            throw new GenymotionException("Unable to communicate with Genymotion", (Throwable)e);
        }
        return this;
    }
    
    private static boolean nearlyEqual(final double a, final double b) {
        return Math.abs(a - b) < 0.001;
    }
    
    private void waitForTargetLocation(final Location targetLocation) {
        final Context ctx = GenymotionManager.genymotionManager.context;
        final LocationManager locMan = (LocationManager)ctx.getSystemService("location");
        final LocationListener locListener = (LocationListener)new LocationListener() {
            public void onLocationChanged(final Location lastLocation) {
                if (targetLocation.getLatitude() != 0.0 && !nearlyEqual(targetLocation.getLatitude(), lastLocation.getLatitude())) {
                    return;
                }
                if (targetLocation.getLongitude() != 0.0 && !nearlyEqual(targetLocation.getLongitude(), lastLocation.getLongitude())) {
                    return;
                }
                if (targetLocation.hasAccuracy() && (!lastLocation.hasAccuracy() || !nearlyEqual(targetLocation.getAccuracy(), lastLocation.getAccuracy()))) {
                    return;
                }
                if (targetLocation.hasBearing() && (!lastLocation.hasBearing() || !nearlyEqual(targetLocation.getBearing(), lastLocation.getBearing()))) {
                    return;
                }
                if (targetLocation.hasSpeed() && (!lastLocation.hasSpeed() || !nearlyEqual(targetLocation.getSpeed(), lastLocation.getSpeed()))) {
                    return;
                }
                if (targetLocation.hasAltitude() && (!lastLocation.hasAltitude() || !nearlyEqual(targetLocation.getAltitude(), lastLocation.getAltitude()))) {
                    return;
                }
                synchronized (Gps.this.mLocationLock) {
                    Gps.this.mLocationLock.notify();
                }
            }
            
            public void onStatusChanged(final String s, final int i, final Bundle bundle) {
            }
            
            public void onProviderEnabled(final String s) {
            }
            
            public void onProviderDisabled(final String s) {
            }
        };
        final HandlerThread handlerThread = new HandlerThread("waitForTargetLocation");
        handlerThread.start();
        locMan.requestLocationUpdates("gps", 0L, 0.0f, locListener, handlerThread.getLooper());
        try {
            synchronized (this.mLocationLock) {
                this.mLocationLock.wait(10000L);
            }
        }
        catch (InterruptedException ex) {}
        locMan.removeUpdates(locListener);
        if (Build.VERSION.SDK_INT >= 18) {
            handlerThread.quitSafely();
        }
        else {
            handlerThread.quit();
        }
    }
    
    public enum Status
    {
        ENABLED, 
        DISABLED;
    }
}
