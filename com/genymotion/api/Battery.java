package com.genymotion.api;

import com.genymotion.genyd.*;
import android.content.*;
import android.os.*;

public class Battery
{
    private final Object mLock;
    private final IGenydService genyd;
    
    private int getStatusToBatteryManagerValue(final Status status) {
        switch (status) {
            case CHARGING: {
                return 2;
            }
            case DISCHARGING: {
                return 3;
            }
            case NOTCHARGING: {
                return 4;
            }
            case FULL: {
                return 5;
            }
            default: {
                return 4;
            }
        }
    }
    
    private Status getStatusFromBatteryManagerValue(final int status) {
        switch (status) {
            case 2: {
                return Status.CHARGING;
            }
            case 3: {
                return Status.DISCHARGING;
            }
            case 4: {
                return Status.NOTCHARGING;
            }
            case 5: {
                return Status.FULL;
            }
            default: {
                return Status.NOTCHARGING;
            }
        }
    }
    
    Battery(final IGenydService genyd) {
        this.mLock = new Object();
        this.genyd = genyd;
    }
    
    public Battery setLevel(final int level) {
        GenymotionManager.checkApi("2.2", "com.genymotion.api.Battery.setLevel(int)");
        try {
            this.genyd.setBatteryLevel(level);
        }
        catch (RemoteException e) {
            throw new GenymotionException("Unable to communicate with Genymotion", (Throwable)e);
        }
        final Intent targetBatteryStatus = new Intent();
        targetBatteryStatus.putExtra("level", level);
        targetBatteryStatus.putExtra("scale", 100);
        this.waitForTargetPowerState(targetBatteryStatus);
        return this;
    }
    
    public Mode getMode() {
        GenymotionManager.checkApi("2.2", "com.genymotion.api.Battery.getMode()");
        Mode mode;
        try {
            mode = Mode.values()[this.genyd.getBatteryMode()];
        }
        catch (RemoteException e) {
            throw new GenymotionException("Unable to communicate with Genymotion", (Throwable)e);
        }
        return mode;
    }
    
    public Battery setMode(final Mode mode) {
        GenymotionManager.checkApi("2.2", "com.genymotion.api.Battery.setMode(com.genymotion.api.Battery$Mode)");
        try {
            this.genyd.setBatteryMode(mode.getValue());
        }
        catch (RemoteException e) {
            throw new GenymotionException("Unable to communicate with Genymotion", (Throwable)e);
        }
        return this;
    }
    
    public Battery setStatus(final Status status) {
        GenymotionManager.checkApi("2.2", "com.genymotion.api.Battery.setStatus(com.genymotion.api.Battery$Status)");
        try {
            this.genyd.setBatteryStatus(status.getValue());
        }
        catch (RemoteException e) {
            throw new GenymotionException("Unable to communicate with Genymotion", (Throwable)e);
        }
        final Intent targetBatteryStatus = new Intent();
        targetBatteryStatus.putExtra("status", this.getStatusToBatteryManagerValue(status));
        this.waitForTargetPowerState(targetBatteryStatus);
        return this;
    }
    
    private void waitForTargetPowerState(final Intent target) {
        final BroadcastReceiver listener = new BroadcastReceiver() {
            public void onReceive(final Context context, final Intent intent) {
                final int status = intent.getIntExtra("status", -1);
                final int targetStatus = target.getIntExtra("status", -1);
                if (target.hasExtra("status") && status != targetStatus) {
                    return;
                }
                if (target.hasExtra("level") && target.hasExtra("scale")) {
                    final int level = intent.getIntExtra("level", -1);
                    final int scale = intent.getIntExtra("scale", -1);
                    final double batteryPct = level / scale;
                    final int targetLevel = target.getIntExtra("level", -1);
                    final int targetScale = target.getIntExtra("scale", -1);
                    final double targetBatteryPct = targetLevel / targetScale;
                    if (Math.abs(batteryPct - targetBatteryPct) >= 0.001) {
                        return;
                    }
                }
                synchronized (Battery.this.mLock) {
                    Battery.this.mLock.notify();
                }
            }
        };
        final HandlerThread handlerThread = new HandlerThread("waitForTargetLocation");
        handlerThread.start();
        final Looper looper = handlerThread.getLooper();
        final Handler handler = new Handler(looper);
        final Context ctx = GenymotionManager.genymotionManager.context;
        final IntentFilter filter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        ctx.registerReceiver(listener, filter, (String)null, handler);
        try {
            synchronized (this.mLock) {
                this.mLock.wait(10000L);
            }
        }
        catch (InterruptedException ex) {}
        ctx.unregisterReceiver(listener);
        if (Build.VERSION.SDK_INT >= 18) {
            handlerThread.quitSafely();
        }
        else {
            handlerThread.quit();
        }
    }
    
    public enum Mode
    {
        HOST(0), 
        MANUAL(1);
        
        private final int value;
        
        private Mode(final int newValue) {
            this.value = newValue;
        }
        
        public int getValue() {
            return this.value;
        }
    }
    
    public enum Status
    {
        CHARGING(0), 
        DISCHARGING(1), 
        NOTCHARGING(2), 
        FULL(3);
        
        private final int value;
        
        private Status(final int newValue) {
            this.value = newValue;
        }
        
        public int getValue() {
            return this.value;
        }
    }
}
