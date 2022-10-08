package com.rq.net.bean;

public class AgeingTestBean
{
    public boolean isOkBarcode;
    public boolean isOkFaceCamera;
    public boolean isOkLed;
    public boolean isOkNetwork;
    public boolean isOkSound;
    public boolean isOkWeight;
    public int maxAppUsedCpu;
    public int maxAppUsedMemory;
    public int minAppUsedCpu;
    public int minAppUsedMemory;
    
    public AgeingTestBean() {
        this.isOkBarcode = false;
        this.isOkWeight = true;
        this.isOkFaceCamera = false;
        this.isOkLed = false;
        this.isOkNetwork = false;
        this.isOkSound = false;
    }
}
