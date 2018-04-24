package com.genymotion.api;

import com.genymotion.genyd.*;
import android.content.*;
import android.os.*;
import android.telephony.*;

public class Radio
{
    private static final int TIMEOUT = 3000;
    private final IGenydService genyd;
    private final Object mLock;
    
    Radio(final IGenydService genyd) {
        this.mLock = new Object();
        this.genyd = genyd;
    }
    
    public Radio setDeviceId(final String id) {
        GenymotionManager.checkApi("2.2", "com.genymotion.api.Radio.setDeviceId(java.lang.String)");
        if (id.length() > 15 || !id.matches("^[a-zA-Z0-9_\\.\\-]*$")) {
            throw new GenymotionException("Device ID must be at most 15 characters and contains only alphanumeric characters, dots, dashes and underscores");
        }
        try {
            this.genyd.setDeviceId(id);
        }
        catch (RemoteException e) {
            throw new GenymotionException("Unable to communicate with Genymotion", (Throwable)e);
        }
        return this;
    }
    
    public Radio setRandomDeviceId() {
        GenymotionManager.checkApi("2.2", "com.genymotion.api.Radio.setRandomDeviceId()");
        try {
            this.genyd.setRandomDeviceId();
        }
        catch (RemoteException e) {
            throw new GenymotionException("Unable to communicate with Genymotion", (Throwable)e);
        }
        return this;
    }
    
    public Radio call(final String number) {
        GenymotionManager.checkApi("2.4", "com.genymotion.api.Radio.call(java.lang.String)");
        final BroadcastReceiver phoneCallReceivedReciever = new BroadcastReceiver() {
            public void onReceive(final Context context, final Intent intent) {
                final Bundle extras = intent.getExtras();
                if (extras == null) {
                    return;
                }
                if (extras.getString("state").equals(TelephonyManager.EXTRA_STATE_RINGING) && extras.getString("incoming_number").equals(number)) {
                    synchronized (Radio.this.mLock) {
                        Radio.this.mLock.notify();
                    }
                }
            }
        };
        final HandlerThread handlerThread = new HandlerThread("waitForCall");
        handlerThread.start();
        final Looper looper = handlerThread.getLooper();
        final Handler handler = new Handler(looper);
        final IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.PHONE_STATE");
        filter.setPriority(-1000);
        GenymotionManager.genymotionManager.context.registerReceiver(phoneCallReceivedReciever, filter, (String)null, handler);
        try {
            this.genyd.basebandCall(number);
            synchronized (this.mLock) {
                this.mLock.wait(3000L);
            }
        }
        catch (RemoteException e) {
            throw new GenymotionException("Unable to communicate with Genymotion", (Throwable)e);
        }
        catch (InterruptedException ex) {}
        finally {
            if (Build.VERSION.SDK_INT >= 18) {
                handlerThread.quitSafely();
            }
            else {
                handlerThread.quit();
            }
            GenymotionManager.genymotionManager.context.unregisterReceiver(phoneCallReceivedReciever);
        }
        return this;
    }
    
    public Radio endCall(final String number) {
        GenymotionManager.checkApi("2.4", "com.genymotion.api.Radio.endCall(java.lang.String)");
        final BroadcastReceiver phoneCallReceivedReciever = new BroadcastReceiver() {
            public void onReceive(final Context context, final Intent intent) {
                final Bundle extras = intent.getExtras();
                if (extras == null) {
                    return;
                }
                if (extras.getString("state").equals(TelephonyManager.EXTRA_STATE_IDLE)) {
                    synchronized (Radio.this.mLock) {
                        Radio.this.mLock.notify();
                    }
                }
            }
        };
        final HandlerThread handlerThread = new HandlerThread("waitForCall");
        handlerThread.start();
        final Looper looper = handlerThread.getLooper();
        final Handler handler = new Handler(looper);
        final IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.PHONE_STATE");
        filter.setPriority(-1000);
        GenymotionManager.genymotionManager.context.registerReceiver(phoneCallReceivedReciever, filter, (String)null, handler);
        try {
            this.genyd.basebandEndCall(number);
            synchronized (this.mLock) {
                this.mLock.wait(3000L);
            }
        }
        catch (RemoteException e) {
            throw new GenymotionException("Unable to communicate with Genymotion", (Throwable)e);
        }
        catch (InterruptedException ex) {}
        finally {
            if (Build.VERSION.SDK_INT >= 18) {
                handlerThread.quitSafely();
            }
            else {
                handlerThread.quit();
            }
            GenymotionManager.genymotionManager.context.unregisterReceiver(phoneCallReceivedReciever);
        }
        return this;
    }
    
    public Radio sendSms(final String number, final String message) {
        GenymotionManager.checkApi("2.4", "com.genymotion.api.Radio.sendSms(java.lang.String,java.lang.String)");
        final BroadcastReceiver smsReceivedReciever = new BroadcastReceiver() {
            public void onReceive(final Context context, final Intent intent) {
                final Bundle extras = intent.getExtras();
                if (extras == null) {
                    return;
                }
                final Object[] array;
                final Object[] rawMessages = array = (Object[])extras.get("pdus");
                for (final Object rawMessage : array) {
                    final SmsMessage sms = SmsMessage.createFromPdu((byte[])rawMessage);
                    if (sms.getMessageBody().equals(message)) {
                        synchronized (Radio.this.mLock) {
                            Radio.this.mLock.notify();
                        }
                    }
                }
            }
        };
        final HandlerThread handlerThread = new HandlerThread("waitForSms");
        handlerThread.start();
        final Looper looper = handlerThread.getLooper();
        final Handler handler = new Handler(looper);
        final IntentFilter filter = new IntentFilter();
        filter.addAction("android.provider.Telephony.SMS_RECEIVED");
        filter.setPriority(-1000);
        GenymotionManager.genymotionManager.context.registerReceiver(smsReceivedReciever, filter, (String)null, handler);
        try {
            this.genyd.basebandSms(number, message);
            synchronized (this.mLock) {
                this.mLock.wait(3000L);
            }
        }
        catch (RemoteException e) {
            throw new GenymotionException("Unable to communicate with Genymotion", (Throwable)e);
        }
        catch (InterruptedException ex) {}
        finally {
            if (Build.VERSION.SDK_INT >= 18) {
                handlerThread.quitSafely();
            }
            else {
                handlerThread.quit();
            }
            GenymotionManager.genymotionManager.context.unregisterReceiver(smsReceivedReciever);
        }
        return this;
    }
    
    public Radio command(final String command) {
        GenymotionManager.checkApi("2.4", "com.genymotion.api.Radio.command(java.lang.String)");
        try {
            this.genyd.basebandCommand(command);
        }
        catch (RemoteException e) {
            throw new GenymotionException("Unable to communicate with Genymotion", (Throwable)e);
        }
        return this;
    }
}
