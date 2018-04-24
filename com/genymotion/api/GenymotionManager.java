package com.genymotion.api;

import android.content.*;
import com.genymotion.genyd.*;
import android.os.*;
import android.util.*;
import java.lang.reflect.*;

public final class GenymotionManager
{
    static final String TAG = "GenymotionApi";
    static final int TIMEOUT = 10000;
    static GenymotionManager genymotionManager;
    Context context;
    private static Battery battery;
    private static Gps gps;
    private static Id id;
    private static Orientation orientation;
    private static Radio radio;
    private static Network network;
    private static DiskIO diskIO;
    private String version;
    private IGenydService genyd;
    
    private GenymotionManager(final Context pContext) {
        this.context = null;
        this.genyd = null;
        if (!isGenymotionDevice()) {
            throw new NotGenymotionDeviceException();
        }
        if (pContext == null) {
            throw new GenymotionException("You must provide a valid Android Context.");
        }
        this.context = pContext;
        this.genyd = (IGenydService)this.context.getSystemService("Genyd");
        if (this.genyd == null) {
            throw new GenymotionException("This version of Genymotion is not compatible with the Genymotion API. Please upgrade your Genymotion Device.");
        }
        //checkToken(this.genyd);
    }
    
    public static GenymotionManager getGenymotionManager(final Context context) throws GenymotionException {
        checkApi("2.2", "com.genymotion.api.GenymotionManager.getGenymotionManager(android.content.Context)");
        if (GenymotionManager.genymotionManager == null) {
            if (context.getApplicationContext() != null) {
                GenymotionManager.genymotionManager = new GenymotionManager(context.getApplicationContext());
            }
            else {
                GenymotionManager.genymotionManager = new GenymotionManager(context);
            }
            GenymotionManager.genymotionManager.version = getGenymotionVersion();
        }
        return GenymotionManager.genymotionManager;
    }
    
    public Battery getBattery() {
        checkApi("2.2", "com.genymotion.api.GenymotionManager.getBattery()");
        if (GenymotionManager.battery == null) {
            GenymotionManager.battery = new Battery(this.genyd);
        }
        return GenymotionManager.battery;
    }
    
    public Gps getGps() {
        checkApi("2.2", "com.genymotion.api.GenymotionManager.getGps()");
        if (GenymotionManager.gps == null) {
            GenymotionManager.gps = new Gps(this.genyd);
        }
        return GenymotionManager.gps;
    }
    
    public Id getId() {
        checkApi("2.2", "com.genymotion.api.GenymotionManager.getId()");
        if (GenymotionManager.id == null) {
            GenymotionManager.id = new Id(this.genyd);
        }
        return GenymotionManager.id;
    }
    
    public Orientation getOrientation() {
        checkApi("2.2", "com.genymotion.api.GenymotionManager.getOrientation()");
        if (GenymotionManager.orientation == null) {
            GenymotionManager.orientation = new Orientation(this.genyd);
        }
        return GenymotionManager.orientation;
    }
    
    public Radio getRadio() {
        checkApi("2.2", "com.genymotion.api.GenymotionManager.getRadio()");
        if (GenymotionManager.radio == null) {
            GenymotionManager.radio = new Radio(this.genyd);
        }
        return GenymotionManager.radio;
    }
    
    static void checkApi(final String apk, final String methodSign) {
        if (GenymotionManager.genymotionManager == null) {
            return;
        }
        if (compareVersion(apk, GenymotionManager.genymotionManager.version) > 0) {
            throw new MethodUnavailableException(methodSign + " doesn't exists on this version of Genymotion: " + GenymotionManager.genymotionManager.version + ". You need at least the version: " + apk);
        }
    }
    
    public Network getNetwork() {
        checkApi("2.3", "com.genymotion.api.GenymotionManager.getNetwork()");
        if (GenymotionManager.network == null) {
            GenymotionManager.network = new Network(this.genyd);
        }
        return GenymotionManager.network;
    }
    
    public DiskIO getDiskIO() {
        checkApi("2.11", "com.genymotion.api.GenymotionManager.getDiskIO()");
        if (GenymotionManager.diskIO == null) {
            GenymotionManager.diskIO = new DiskIO(this.genyd);
        }
        return GenymotionManager.diskIO;
    }
    
    public static boolean isGenymotionDevice() {
        checkApi("2.2", "com.genymotion.api.GenymotionManager.isGenymotionDevice()");
        return !getGenymotionVersion().isEmpty();
    }
    
    static int compareVersion(final String v1, final String v2) {
        final String[] vals1 = v1.split("\\.");
        final String[] vals2 = v2.split("\\.");
        for (int i = 0, m = Math.max(vals1.length, vals2.length); i < m; ++i) {
            final int d1 = (i < vals1.length) ? Integer.valueOf(vals1[i]) : 0;
            final int d2 = (i < vals2.length) ? Integer.valueOf(vals2[i]) : 0;
            final int diff = Integer.signum(d1 - d2);
            if (diff != 0) {
                return diff;
            }
        }
        return 0;
    }
    
    static void checkToken(final IGenydService service) {
        int token;
        try {
            token = service.getTokenValidity();
        }
        catch (RemoteException e) {
            throw new GenymotionException(e.getMessage(), e.getCause());
        }
        final String pleaseRestart = " Please run Genymotion and connect to Genymotion Cloud to force a license check.";
        switch (TokenValidity.values()[token]) {
            case Valid: {}
            case TokenExpired: {
                throw new GenymotionException("License activation has expired." + pleaseRestart);
            }
            case LicenseExpired: {
                throw new GenymotionException("Last license check reported that license has expired." + pleaseRestart);
            }
            case EmptyToken: {
                throw new GenymotionException("License has not been verified using Genymotion Cloud." + pleaseRestart);
            }
            case Unknown: {
                throw new GenymotionException("Unable to connect to Genymotion via Genymotion API.");
            }
            case TokenNotSet: {
                throw new GenymotionException("This software requires a valid Genymotion license.");
            }
            default: {
                throw new GenymotionException("License cannot be verified because check data are invalid." + pleaseRestart);
            }
        }
    }
    
    static String getGenymotionVersion() {
        String version = "";
        try {
            final Class systemProperties = Class.forName("android.os.SystemProperties");
            if (systemProperties != null) {
                final Method getProperty = systemProperties.getDeclaredMethod("get", String.class);
                if (getProperty != null) {
                    version = (String)getProperty.invoke(null, "ro.genymotion.version");
                }
            }
        }
        catch (ClassNotFoundException e) {
            Log.e("GenymotionApi", e.getMessage(), (Throwable)e);
        }
        catch (NoSuchMethodException e2) {
            Log.e("GenymotionApi", e2.getMessage(), (Throwable)e2);
        }
        catch (IllegalAccessException e3) {
            Log.e("GenymotionApi", e3.getMessage(), (Throwable)e3);
        }
        catch (IllegalArgumentException e4) {
            Log.e("GenymotionApi", e4.getMessage(), (Throwable)e4);
        }
        catch (InvocationTargetException e5) {
            Log.e("GenymotionApi", e5.getMessage(), (Throwable)e5);
        }
        return version;
    }
    
    static {
        GenymotionManager.genymotionManager = null;
        GenymotionManager.battery = null;
        GenymotionManager.gps = null;
        GenymotionManager.id = null;
        GenymotionManager.orientation = null;
        GenymotionManager.radio = null;
        GenymotionManager.network = null;
        GenymotionManager.diskIO = null;
    }
    
    enum TokenValidity
    {
        Unknown, 
        Valid, 
        NoSignature, 
        InvalidSignature, 
        InvalidData, 
        InvalidUuid, 
        TokenExpired, 
        LicenseExpired, 
        EmptyToken, 
        TokenNotSet;
    }
}
