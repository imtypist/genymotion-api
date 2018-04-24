package com.genymotion.api;

import com.genymotion.genyd.*;
import android.os.*;

public class DiskIO
{
    private final IGenydService genyd;
    
    DiskIO(final IGenydService genyd) {
        this.genyd = genyd;
    }
    
    public int getReadRateLimit() {
        GenymotionManager.checkApi("2.11", "com.genymotion.api.DiskIO.getReadRateLimit()");
        try {
            final int byterate = this.genyd.getDiskIOMaxReadByteRate();
            return byterate / 1024;
        }
        catch (RemoteException e) {
            throw new GenymotionException("Unable to communicate with Genymotion", (Throwable)e);
        }
    }
    
    public DiskIO setReadRateLimit(final int byterate) {
        GenymotionManager.checkApi("2.11", "com.genymotion.api.DiskIO.setReadRateLimit(int)");
        if (byterate < 0) {
            throw new GenymotionException("Invalid value. Positive value expected");
        }
        try {
            this.genyd.diskIOClearCache();
            this.genyd.setDiskIOMaxReadByteRate(byterate * 1024);
        }
        catch (RemoteException e) {
            throw new GenymotionException("Unable to communicate with Genymotion", (Throwable)e);
        }
        return this;
    }
    
    public DiskIO clearCache() {
        GenymotionManager.checkApi("2.11", "com.genymotion.api.DiskIO.clearCache()");
        try {
            this.genyd.diskIOClearCache();
        }
        catch (RemoteException e) {
            throw new GenymotionException("Unable to communicate with Genymotion", (Throwable)e);
        }
        return this;
    }
}
