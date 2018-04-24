package com.genymotion.api;

import com.genymotion.genyd.*;
import android.provider.*;
import android.os.*;

public class Id
{
    private final IGenydService genyd;
    private final Object mLock;
    
    Id(final IGenydService genyd) {
        this.mLock = new Object();
        this.genyd = genyd;
    }
    
    public Id setAndroidId(final String id) {
        GenymotionManager.checkApi("2.2", "com.genymotion.api.Id.setAndroidId(java.lang.String)");
        if (id.length() > 16 || !id.matches("^[\\da-fA-F]+$")) {
            throw new IllegalArgumentException("Android ID should be less than 16 hex chars long");
        }
        try {
            this.genyd.setAndroidId(id);
        }
        catch (RemoteException e) {
            throw new GenymotionException("Unable to communicate with Genymotion", (Throwable)e);
        }
        this.waitForTargetId(id);
        return this;
    }
    
    public Id setRandomAndroidId() {
        GenymotionManager.checkApi("2.2", "com.genymotion.api.Id.setRandomAndroidId()");
        String id;
        try {
            this.genyd.setRandomAndroidId();
            id = this.genyd.getAndroidId();
        }
        catch (RemoteException e) {
            throw new GenymotionException("Unable to communicate with Genymotion", (Throwable)e);
        }
        this.waitForTargetId(id);
        return this;
    }
    
    private void waitForTargetId(final String targetId) {
        final HandlerThread handlerThread = new HandlerThread("waitForTargetId");
        handlerThread.start();
        final Looper looper = handlerThread.getLooper();
        final Handler handler = new Handler(looper);
        final Runnable runCheckId = new Runnable() {
            @Override
            public void run() {
                final String currentAndroidId = Settings.Secure.getString(GenymotionManager.genymotionManager.context.getContentResolver(), "android_id");
                if (!currentAndroidId.equals(targetId)) {
                    handler.postDelayed((Runnable)this, 100L);
                    return;
                }
                synchronized (Id.this.mLock) {
                    Id.this.mLock.notify();
                }
            }
        };
        handler.postDelayed(runCheckId, 100L);
        try {
            synchronized (this.mLock) {
                this.mLock.wait(10000L);
            }
        }
        catch (InterruptedException ex) {}
        if (Build.VERSION.SDK_INT >= 18) {
            handlerThread.quitSafely();
        }
        else {
            handlerThread.quit();
        }
    }
}
