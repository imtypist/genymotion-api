package com.genymotion.genyd;

import android.os.*;

public interface IGenydService extends IInterface
{
    int getError() throws RemoteException;
    
    int getTokenValidity() throws RemoteException;
    
    int getBatteryLevel() throws RemoteException;
    
    void setBatteryLevel(final int p0) throws RemoteException;
    
    int getBatteryMode() throws RemoteException;
    
    void setBatteryMode(final int p0) throws RemoteException;
    
    int getBatteryStatus() throws RemoteException;
    
    void setBatteryStatus(final int p0) throws RemoteException;
    
    double getGpsAccuracy() throws RemoteException;
    
    void setGpsAccuracy(final double p0) throws RemoteException;
    
    double getGpsAltitude() throws RemoteException;
    
    void setGpsAltitude(final double p0) throws RemoteException;
    
    double getGpsBearing() throws RemoteException;
    
    void setGpsBearing(final double p0) throws RemoteException;
    
    double getGpsLatitude() throws RemoteException;
    
    void setGpsLatitude(final double p0) throws RemoteException;
    
    double getGpsLongitude() throws RemoteException;
    
    void setGpsLongitude(final double p0) throws RemoteException;
    
    boolean getGpsStatus() throws RemoteException;
    
    void setGpsStatus(final boolean p0) throws RemoteException;
    
    String getAndroidId() throws RemoteException;
    
    void setAndroidId(final String p0) throws RemoteException;
    
    void setRandomAndroidId() throws RemoteException;
    
    String getDeviceId() throws RemoteException;
    
    void setDeviceId(final String p0) throws RemoteException;
    
    void setRandomDeviceId() throws RemoteException;
    
    double getOrientationAngle() throws RemoteException;
    
    void setOrientationAngle(final double p0) throws RemoteException;
    
    void basebandCall(final String p0) throws RemoteException;
    
    void basebandEndCall(final String p0) throws RemoteException;
    
    void basebandSms(final String p0, final String p1) throws RemoteException;
    
    void basebandCommand(final String p0) throws RemoteException;
    
    int getNetworkProfile() throws RemoteException;
    
    void setNetworkProfile(final int p0) throws RemoteException;
    
    int getDiskIOMaxReadByteRate() throws RemoteException;
    
    void setDiskIOMaxReadByteRate(final int p0) throws RemoteException;
    
    void diskIOClearCache() throws RemoteException;
    
    public abstract static class Stub extends Binder implements IGenydService
    {
        private static final String DESCRIPTOR = "com.genymotion.genyd.IGenydService";
        static final int TRANSACTION_getError = 1;
        static final int TRANSACTION_getTokenValidity = 2;
        static final int TRANSACTION_getBatteryLevel = 3;
        static final int TRANSACTION_setBatteryLevel = 4;
        static final int TRANSACTION_getBatteryMode = 5;
        static final int TRANSACTION_setBatteryMode = 6;
        static final int TRANSACTION_getBatteryStatus = 7;
        static final int TRANSACTION_setBatteryStatus = 8;
        static final int TRANSACTION_getGpsAccuracy = 9;
        static final int TRANSACTION_setGpsAccuracy = 10;
        static final int TRANSACTION_getGpsAltitude = 11;
        static final int TRANSACTION_setGpsAltitude = 12;
        static final int TRANSACTION_getGpsBearing = 13;
        static final int TRANSACTION_setGpsBearing = 14;
        static final int TRANSACTION_getGpsLatitude = 15;
        static final int TRANSACTION_setGpsLatitude = 16;
        static final int TRANSACTION_getGpsLongitude = 17;
        static final int TRANSACTION_setGpsLongitude = 18;
        static final int TRANSACTION_getGpsStatus = 19;
        static final int TRANSACTION_setGpsStatus = 20;
        static final int TRANSACTION_getAndroidId = 21;
        static final int TRANSACTION_setAndroidId = 22;
        static final int TRANSACTION_setRandomAndroidId = 23;
        static final int TRANSACTION_getDeviceId = 24;
        static final int TRANSACTION_setDeviceId = 25;
        static final int TRANSACTION_setRandomDeviceId = 26;
        static final int TRANSACTION_getOrientationAngle = 27;
        static final int TRANSACTION_setOrientationAngle = 28;
        static final int TRANSACTION_basebandCall = 29;
        static final int TRANSACTION_basebandEndCall = 30;
        static final int TRANSACTION_basebandSms = 31;
        static final int TRANSACTION_basebandCommand = 32;
        static final int TRANSACTION_getNetworkProfile = 33;
        static final int TRANSACTION_setNetworkProfile = 34;
        static final int TRANSACTION_getDiskIOMaxReadByteRate = 35;
        static final int TRANSACTION_setDiskIOMaxReadByteRate = 36;
        static final int TRANSACTION_diskIOClearCache = 37;
        
        public Stub() {
            this.attachInterface((IInterface)this, "com.genymotion.genyd.IGenydService");
        }
        
        public static IGenydService asInterface(final IBinder obj) {
            if (obj == null) {
                return null;
            }
            final IInterface iin = obj.queryLocalInterface("com.genymotion.genyd.IGenydService");
            if (iin != null && iin instanceof IGenydService) {
                return (IGenydService)iin;
            }
            return new Proxy(obj);
        }
        
        public IBinder asBinder() {
            return (IBinder)this;
        }
        
        public boolean onTransact(final int code, final Parcel data, final Parcel reply, final int flags) throws RemoteException {
            switch (code) {
                case 1598968902: {
                    reply.writeString("com.genymotion.genyd.IGenydService");
                    return true;
                }
                case 1: {
                    data.enforceInterface("com.genymotion.genyd.IGenydService");
                    final int _result = this.getError();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case 2: {
                    data.enforceInterface("com.genymotion.genyd.IGenydService");
                    final int _result = this.getTokenValidity();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case 3: {
                    data.enforceInterface("com.genymotion.genyd.IGenydService");
                    final int _result = this.getBatteryLevel();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case 4: {
                    data.enforceInterface("com.genymotion.genyd.IGenydService");
                    final int _arg0 = data.readInt();
                    this.setBatteryLevel(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case 5: {
                    data.enforceInterface("com.genymotion.genyd.IGenydService");
                    final int _result = this.getBatteryMode();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case 6: {
                    data.enforceInterface("com.genymotion.genyd.IGenydService");
                    final int _arg0 = data.readInt();
                    this.setBatteryMode(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case 7: {
                    data.enforceInterface("com.genymotion.genyd.IGenydService");
                    final int _result = this.getBatteryStatus();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case 8: {
                    data.enforceInterface("com.genymotion.genyd.IGenydService");
                    final int _arg0 = data.readInt();
                    this.setBatteryStatus(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case 9: {
                    data.enforceInterface("com.genymotion.genyd.IGenydService");
                    final double _result2 = this.getGpsAccuracy();
                    reply.writeNoException();
                    reply.writeDouble(_result2);
                    return true;
                }
                case 10: {
                    data.enforceInterface("com.genymotion.genyd.IGenydService");
                    final double _arg2 = data.readDouble();
                    this.setGpsAccuracy(_arg2);
                    reply.writeNoException();
                    return true;
                }
                case 11: {
                    data.enforceInterface("com.genymotion.genyd.IGenydService");
                    final double _result2 = this.getGpsAltitude();
                    reply.writeNoException();
                    reply.writeDouble(_result2);
                    return true;
                }
                case 12: {
                    data.enforceInterface("com.genymotion.genyd.IGenydService");
                    final double _arg2 = data.readDouble();
                    this.setGpsAltitude(_arg2);
                    reply.writeNoException();
                    return true;
                }
                case 13: {
                    data.enforceInterface("com.genymotion.genyd.IGenydService");
                    final double _result2 = this.getGpsBearing();
                    reply.writeNoException();
                    reply.writeDouble(_result2);
                    return true;
                }
                case 14: {
                    data.enforceInterface("com.genymotion.genyd.IGenydService");
                    final double _arg2 = data.readDouble();
                    this.setGpsBearing(_arg2);
                    reply.writeNoException();
                    return true;
                }
                case 15: {
                    data.enforceInterface("com.genymotion.genyd.IGenydService");
                    final double _result2 = this.getGpsLatitude();
                    reply.writeNoException();
                    reply.writeDouble(_result2);
                    return true;
                }
                case 16: {
                    data.enforceInterface("com.genymotion.genyd.IGenydService");
                    final double _arg2 = data.readDouble();
                    this.setGpsLatitude(_arg2);
                    reply.writeNoException();
                    return true;
                }
                case 17: {
                    data.enforceInterface("com.genymotion.genyd.IGenydService");
                    final double _result2 = this.getGpsLongitude();
                    reply.writeNoException();
                    reply.writeDouble(_result2);
                    return true;
                }
                case 18: {
                    data.enforceInterface("com.genymotion.genyd.IGenydService");
                    final double _arg2 = data.readDouble();
                    this.setGpsLongitude(_arg2);
                    reply.writeNoException();
                    return true;
                }
                case 19: {
                    data.enforceInterface("com.genymotion.genyd.IGenydService");
                    final boolean _result3 = this.getGpsStatus();
                    reply.writeNoException();
                    reply.writeInt((int)(_result3 ? 1 : 0));
                    return true;
                }
                case 20: {
                    data.enforceInterface("com.genymotion.genyd.IGenydService");
                    final boolean _arg3 = 0 != data.readInt();
                    this.setGpsStatus(_arg3);
                    reply.writeNoException();
                    return true;
                }
                case 21: {
                    data.enforceInterface("com.genymotion.genyd.IGenydService");
                    final String _result4 = this.getAndroidId();
                    reply.writeNoException();
                    reply.writeString(_result4);
                    return true;
                }
                case 22: {
                    data.enforceInterface("com.genymotion.genyd.IGenydService");
                    final String _arg4 = data.readString();
                    this.setAndroidId(_arg4);
                    reply.writeNoException();
                    return true;
                }
                case 23: {
                    data.enforceInterface("com.genymotion.genyd.IGenydService");
                    this.setRandomAndroidId();
                    reply.writeNoException();
                    return true;
                }
                case 24: {
                    data.enforceInterface("com.genymotion.genyd.IGenydService");
                    final String _result4 = this.getDeviceId();
                    reply.writeNoException();
                    reply.writeString(_result4);
                    return true;
                }
                case 25: {
                    data.enforceInterface("com.genymotion.genyd.IGenydService");
                    final String _arg4 = data.readString();
                    this.setDeviceId(_arg4);
                    reply.writeNoException();
                    return true;
                }
                case 26: {
                    data.enforceInterface("com.genymotion.genyd.IGenydService");
                    this.setRandomDeviceId();
                    reply.writeNoException();
                    return true;
                }
                case 27: {
                    data.enforceInterface("com.genymotion.genyd.IGenydService");
                    final double _result2 = this.getOrientationAngle();
                    reply.writeNoException();
                    reply.writeDouble(_result2);
                    return true;
                }
                case 28: {
                    data.enforceInterface("com.genymotion.genyd.IGenydService");
                    final double _arg2 = data.readDouble();
                    this.setOrientationAngle(_arg2);
                    reply.writeNoException();
                    return true;
                }
                case 29: {
                    data.enforceInterface("com.genymotion.genyd.IGenydService");
                    final String _arg4 = data.readString();
                    this.basebandCall(_arg4);
                    reply.writeNoException();
                    return true;
                }
                case 30: {
                    data.enforceInterface("com.genymotion.genyd.IGenydService");
                    final String _arg4 = data.readString();
                    this.basebandEndCall(_arg4);
                    reply.writeNoException();
                    return true;
                }
                case 31: {
                    data.enforceInterface("com.genymotion.genyd.IGenydService");
                    final String _arg4 = data.readString();
                    final String _arg5 = data.readString();
                    this.basebandSms(_arg4, _arg5);
                    reply.writeNoException();
                    return true;
                }
                case 32: {
                    data.enforceInterface("com.genymotion.genyd.IGenydService");
                    final String _arg4 = data.readString();
                    this.basebandCommand(_arg4);
                    reply.writeNoException();
                    return true;
                }
                case 33: {
                    data.enforceInterface("com.genymotion.genyd.IGenydService");
                    final int _result = this.getNetworkProfile();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case 34: {
                    data.enforceInterface("com.genymotion.genyd.IGenydService");
                    final int _arg0 = data.readInt();
                    this.setNetworkProfile(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case 35: {
                    data.enforceInterface("com.genymotion.genyd.IGenydService");
                    final int _result = this.getDiskIOMaxReadByteRate();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case 36: {
                    data.enforceInterface("com.genymotion.genyd.IGenydService");
                    final int _arg0 = data.readInt();
                    this.setDiskIOMaxReadByteRate(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case 37: {
                    data.enforceInterface("com.genymotion.genyd.IGenydService");
                    this.diskIOClearCache();
                    reply.writeNoException();
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }
        
        private static class Proxy implements IGenydService
        {
            private IBinder mRemote;
            
            Proxy(final IBinder remote) {
                this.mRemote = remote;
            }
            
            public IBinder asBinder() {
                return this.mRemote;
            }
            
            public String getInterfaceDescriptor() {
                return "com.genymotion.genyd.IGenydService";
            }
            
            @Override
            public int getError() throws RemoteException {
                final Parcel _data = Parcel.obtain();
                final Parcel _reply = Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken("com.genymotion.genyd.IGenydService");
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
            
            @Override
            public int getTokenValidity() throws RemoteException {
                final Parcel _data = Parcel.obtain();
                final Parcel _reply = Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken("com.genymotion.genyd.IGenydService");
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
            
            @Override
            public int getBatteryLevel() throws RemoteException {
                final Parcel _data = Parcel.obtain();
                final Parcel _reply = Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken("com.genymotion.genyd.IGenydService");
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
            
            @Override
            public void setBatteryLevel(final int level) throws RemoteException {
                final Parcel _data = Parcel.obtain();
                final Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken("com.genymotion.genyd.IGenydService");
                    _data.writeInt(level);
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
            
            @Override
            public int getBatteryMode() throws RemoteException {
                final Parcel _data = Parcel.obtain();
                final Parcel _reply = Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken("com.genymotion.genyd.IGenydService");
                    this.mRemote.transact(5, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
            
            @Override
            public void setBatteryMode(final int mode) throws RemoteException {
                final Parcel _data = Parcel.obtain();
                final Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken("com.genymotion.genyd.IGenydService");
                    _data.writeInt(mode);
                    this.mRemote.transact(6, _data, _reply, 0);
                    _reply.readException();
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
            
            @Override
            public int getBatteryStatus() throws RemoteException {
                final Parcel _data = Parcel.obtain();
                final Parcel _reply = Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken("com.genymotion.genyd.IGenydService");
                    this.mRemote.transact(7, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
            
            @Override
            public void setBatteryStatus(final int status) throws RemoteException {
                final Parcel _data = Parcel.obtain();
                final Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken("com.genymotion.genyd.IGenydService");
                    _data.writeInt(status);
                    this.mRemote.transact(8, _data, _reply, 0);
                    _reply.readException();
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
            
            @Override
            public double getGpsAccuracy() throws RemoteException {
                final Parcel _data = Parcel.obtain();
                final Parcel _reply = Parcel.obtain();
                double _result;
                try {
                    _data.writeInterfaceToken("com.genymotion.genyd.IGenydService");
                    this.mRemote.transact(9, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readDouble();
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
            
            @Override
            public void setGpsAccuracy(final double value) throws RemoteException {
                final Parcel _data = Parcel.obtain();
                final Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken("com.genymotion.genyd.IGenydService");
                    _data.writeDouble(value);
                    this.mRemote.transact(10, _data, _reply, 0);
                    _reply.readException();
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
            
            @Override
            public double getGpsAltitude() throws RemoteException {
                final Parcel _data = Parcel.obtain();
                final Parcel _reply = Parcel.obtain();
                double _result;
                try {
                    _data.writeInterfaceToken("com.genymotion.genyd.IGenydService");
                    this.mRemote.transact(11, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readDouble();
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
            
            @Override
            public void setGpsAltitude(final double value) throws RemoteException {
                final Parcel _data = Parcel.obtain();
                final Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken("com.genymotion.genyd.IGenydService");
                    _data.writeDouble(value);
                    this.mRemote.transact(12, _data, _reply, 0);
                    _reply.readException();
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
            
            @Override
            public double getGpsBearing() throws RemoteException {
                final Parcel _data = Parcel.obtain();
                final Parcel _reply = Parcel.obtain();
                double _result;
                try {
                    _data.writeInterfaceToken("com.genymotion.genyd.IGenydService");
                    this.mRemote.transact(13, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readDouble();
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
            
            @Override
            public void setGpsBearing(final double value) throws RemoteException {
                final Parcel _data = Parcel.obtain();
                final Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken("com.genymotion.genyd.IGenydService");
                    _data.writeDouble(value);
                    this.mRemote.transact(14, _data, _reply, 0);
                    _reply.readException();
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
            
            @Override
            public double getGpsLatitude() throws RemoteException {
                final Parcel _data = Parcel.obtain();
                final Parcel _reply = Parcel.obtain();
                double _result;
                try {
                    _data.writeInterfaceToken("com.genymotion.genyd.IGenydService");
                    this.mRemote.transact(15, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readDouble();
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
            
            @Override
            public void setGpsLatitude(final double value) throws RemoteException {
                final Parcel _data = Parcel.obtain();
                final Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken("com.genymotion.genyd.IGenydService");
                    _data.writeDouble(value);
                    this.mRemote.transact(16, _data, _reply, 0);
                    _reply.readException();
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
            
            @Override
            public double getGpsLongitude() throws RemoteException {
                final Parcel _data = Parcel.obtain();
                final Parcel _reply = Parcel.obtain();
                double _result;
                try {
                    _data.writeInterfaceToken("com.genymotion.genyd.IGenydService");
                    this.mRemote.transact(17, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readDouble();
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
            
            @Override
            public void setGpsLongitude(final double value) throws RemoteException {
                final Parcel _data = Parcel.obtain();
                final Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken("com.genymotion.genyd.IGenydService");
                    _data.writeDouble(value);
                    this.mRemote.transact(18, _data, _reply, 0);
                    _reply.readException();
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
            
            @Override
            public boolean getGpsStatus() throws RemoteException {
                final Parcel _data = Parcel.obtain();
                final Parcel _reply = Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken("com.genymotion.genyd.IGenydService");
                    this.mRemote.transact(19, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
            
            @Override
            public void setGpsStatus(final boolean value) throws RemoteException {
                final Parcel _data = Parcel.obtain();
                final Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken("com.genymotion.genyd.IGenydService");
                    _data.writeInt((int)(value ? 1 : 0));
                    this.mRemote.transact(20, _data, _reply, 0);
                    _reply.readException();
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
            
            @Override
            public String getAndroidId() throws RemoteException {
                final Parcel _data = Parcel.obtain();
                final Parcel _reply = Parcel.obtain();
                String _result;
                try {
                    _data.writeInterfaceToken("com.genymotion.genyd.IGenydService");
                    this.mRemote.transact(21, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readString();
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
            
            @Override
            public void setAndroidId(final String value) throws RemoteException {
                final Parcel _data = Parcel.obtain();
                final Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken("com.genymotion.genyd.IGenydService");
                    _data.writeString(value);
                    this.mRemote.transact(22, _data, _reply, 0);
                    _reply.readException();
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
            
            @Override
            public void setRandomAndroidId() throws RemoteException {
                final Parcel _data = Parcel.obtain();
                final Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken("com.genymotion.genyd.IGenydService");
                    this.mRemote.transact(23, _data, _reply, 0);
                    _reply.readException();
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
            
            @Override
            public String getDeviceId() throws RemoteException {
                final Parcel _data = Parcel.obtain();
                final Parcel _reply = Parcel.obtain();
                String _result;
                try {
                    _data.writeInterfaceToken("com.genymotion.genyd.IGenydService");
                    this.mRemote.transact(24, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readString();
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
            
            @Override
            public void setDeviceId(final String value) throws RemoteException {
                final Parcel _data = Parcel.obtain();
                final Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken("com.genymotion.genyd.IGenydService");
                    _data.writeString(value);
                    this.mRemote.transact(25, _data, _reply, 0);
                    _reply.readException();
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
            
            @Override
            public void setRandomDeviceId() throws RemoteException {
                final Parcel _data = Parcel.obtain();
                final Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken("com.genymotion.genyd.IGenydService");
                    this.mRemote.transact(26, _data, _reply, 0);
                    _reply.readException();
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
            
            @Override
            public double getOrientationAngle() throws RemoteException {
                final Parcel _data = Parcel.obtain();
                final Parcel _reply = Parcel.obtain();
                double _result;
                try {
                    _data.writeInterfaceToken("com.genymotion.genyd.IGenydService");
                    this.mRemote.transact(27, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readDouble();
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
            
            @Override
            public void setOrientationAngle(final double angle) throws RemoteException {
                final Parcel _data = Parcel.obtain();
                final Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken("com.genymotion.genyd.IGenydService");
                    _data.writeDouble(angle);
                    this.mRemote.transact(28, _data, _reply, 0);
                    _reply.readException();
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
            
            @Override
            public void basebandCall(final String number) throws RemoteException {
                final Parcel _data = Parcel.obtain();
                final Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken("com.genymotion.genyd.IGenydService");
                    _data.writeString(number);
                    this.mRemote.transact(29, _data, _reply, 0);
                    _reply.readException();
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
            
            @Override
            public void basebandEndCall(final String number) throws RemoteException {
                final Parcel _data = Parcel.obtain();
                final Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken("com.genymotion.genyd.IGenydService");
                    _data.writeString(number);
                    this.mRemote.transact(30, _data, _reply, 0);
                    _reply.readException();
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
            
            @Override
            public void basebandSms(final String number, final String message) throws RemoteException {
                final Parcel _data = Parcel.obtain();
                final Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken("com.genymotion.genyd.IGenydService");
                    _data.writeString(number);
                    _data.writeString(message);
                    this.mRemote.transact(31, _data, _reply, 0);
                    _reply.readException();
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
            
            @Override
            public void basebandCommand(final String command) throws RemoteException {
                final Parcel _data = Parcel.obtain();
                final Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken("com.genymotion.genyd.IGenydService");
                    _data.writeString(command);
                    this.mRemote.transact(32, _data, _reply, 0);
                    _reply.readException();
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
            
            @Override
            public int getNetworkProfile() throws RemoteException {
                final Parcel _data = Parcel.obtain();
                final Parcel _reply = Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken("com.genymotion.genyd.IGenydService");
                    this.mRemote.transact(33, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
            
            @Override
            public void setNetworkProfile(final int profile) throws RemoteException {
                final Parcel _data = Parcel.obtain();
                final Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken("com.genymotion.genyd.IGenydService");
                    _data.writeInt(profile);
                    this.mRemote.transact(34, _data, _reply, 0);
                    _reply.readException();
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
            
            @Override
            public int getDiskIOMaxReadByteRate() throws RemoteException {
                final Parcel _data = Parcel.obtain();
                final Parcel _reply = Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken("com.genymotion.genyd.IGenydService");
                    this.mRemote.transact(35, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
            
            @Override
            public void setDiskIOMaxReadByteRate(final int byteRate) throws RemoteException {
                final Parcel _data = Parcel.obtain();
                final Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken("com.genymotion.genyd.IGenydService");
                    _data.writeInt(byteRate);
                    this.mRemote.transact(36, _data, _reply, 0);
                    _reply.readException();
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
            
            @Override
            public void diskIOClearCache() throws RemoteException {
                final Parcel _data = Parcel.obtain();
                final Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken("com.genymotion.genyd.IGenydService");
                    this.mRemote.transact(37, _data, _reply, 0);
                    _reply.readException();
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }
    }
}
