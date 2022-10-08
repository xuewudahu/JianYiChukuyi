package com.rq.net.bean;

import java.util.*;

public class LaiquOutLibraryPictureBean
{
    private List<PickupListBean> pickupList;
    
    public LaiquOutLibraryPictureBean() {
        this.pickupList = new ArrayList<PickupListBean>();
    }
    
    public List<PickupListBean> getPickupList() {
        return this.pickupList;
    }
    
    public void setPickupList(final List<PickupListBean> pickupList) {
        this.pickupList = pickupList;
    }
    
    public static class PickupListBean
    {
        private String billCode;
        private String photoStr;
        
        public String getBillCode() {
            return this.billCode;
        }
        
        public String getPhotoStr() {
            return this.photoStr;
        }
        
        public void setBillCode(final String billCode) {
            this.billCode = billCode;
        }
        
        public void setPhotoStr(final String photoStr) {
            this.photoStr = photoStr;
        }
    }
}
