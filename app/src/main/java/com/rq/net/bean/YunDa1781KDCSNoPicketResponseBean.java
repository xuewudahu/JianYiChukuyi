package com.rq.net.bean;

import java.util.*;

public class YunDa1781KDCSNoPicketResponseBean
{
    private int code;
    private DataBean data;
    private String message;
    private boolean result;
    
    public int getCode() {
        return this.code;
    }
    
    public DataBean getData() {
        return this.data;
    }
    
    public String getMessage() {
        return this.message;
    }
    
    public boolean isResult() {
        return this.result;
    }
    
    public void setCode(final int code) {
        this.code = code;
    }
    
    public void setData(final DataBean data) {
        this.data = data;
    }
    
    public void setMessage(final String message) {
        this.message = message;
    }
    
    public void setResult(final boolean result) {
        this.result = result;
    }
    
    public static class DataBean
    {
        private int noMoveCount;
        private String phone;
        private List<ShipsBean> ships;
        private int total;
        
        public int getNoMoveCount() {
            return this.noMoveCount;
        }
        
        public String getPhone() {
            return this.phone;
        }
        
        public List<ShipsBean> getShips() {
            return this.ships;
        }
        
        public int getTotal() {
            return this.total;
        }
        
        public void setNoMoveCount(final int noMoveCount) {
            this.noMoveCount = noMoveCount;
        }
        
        public void setPhone(final String phone) {
            this.phone = phone;
        }
        
        public void setShips(final List<ShipsBean> ships) {
            this.ships = ships;
        }
        
        public void setTotal(final int total) {
            this.total = total;
        }
        
        public static class ShipsBean
        {
            private String pickCode;
            private String recePhone;
            private String shipId;
            
            public String getPickCode() {
                return this.pickCode;
            }
            
            public String getRecePhone() {
                return this.recePhone;
            }
            
            public String getShipId() {
                return this.shipId;
            }
            
            public void setPickCode(final String pickCode) {
                this.pickCode = pickCode;
            }
            
            public void setRecePhone(final String recePhone) {
                this.recePhone = recePhone;
            }
            
            public void setShipId(final String shipId) {
                this.shipId = shipId;
            }
        }
    }
}
