package com.genymotion.api;

import com.genymotion.genyd.*;
import android.os.*;

public class Network
{
    private final IGenydService genyd;
    
    Network(final IGenydService genyd) {
        this.genyd = genyd;
    }
    
    public Profile getProfile() {
        GenymotionManager.checkApi("2.3", "com.genymotion.api.Network.getProfile()");
        Profile res;
        try {
            res = Profile.values()[this.genyd.getNetworkProfile()];
        }
        catch (RemoteException e) {
            throw new GenymotionException("Unable to communicate with Genymotion", (Throwable)e);
        }
        return res;
    }
    
    public Network setProfile(final Profile profile) {
        GenymotionManager.checkApi("2.3", "com.genymotion.api.Network.setProfile(com.genymotion.api.Network$Profile)");
        try {
            this.genyd.setNetworkProfile(profile.getValue());
        }
        catch (RemoteException e) {
            throw new GenymotionException("Unable to communicate with Genymotion", (Throwable)e);
        }
        return this;
    }
    
    public enum Profile
    {
        NONE(0), 
        NO_DATA(1), 
        GPRS(2), 
        EDGE(3), 
        THREE_G(4), 
        FOUR_G(5), 
        FOUR_G_BAD_DNS(6), 
        FOUR_G_BAD_NETWORK(7), 
        WIFI(8);
        
        private final int value;
        
        private Profile(final int value) {
            this.value = value;
        }
        
        public int getValue() {
            return this.value;
        }
    }
}
