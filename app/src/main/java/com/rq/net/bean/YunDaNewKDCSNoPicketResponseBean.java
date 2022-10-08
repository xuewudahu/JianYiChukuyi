package com.rq.net.bean;

import java.util.*;

public class YunDaNewKDCSNoPicketResponseBean
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
        private List<ContentBean> content;
        private int currentPage;
        private boolean first;
        private boolean hasNext;
        private boolean hasPrev;
        private boolean last;
        private int nextPage;
        private int pageCount;
        private int pageSize;
        private int prevPage;
        private int totalCount;
        
        public List<ContentBean> getContent() {
            return this.content;
        }
        
        public int getCurrentPage() {
            return this.currentPage;
        }
        
        public int getNextPage() {
            return this.nextPage;
        }
        
        public int getPageCount() {
            return this.pageCount;
        }
        
        public int getPageSize() {
            return this.pageSize;
        }
        
        public int getPrevPage() {
            return this.prevPage;
        }
        
        public int getTotalCount() {
            return this.totalCount;
        }
        
        public boolean isFirst() {
            return this.first;
        }
        
        public boolean isHasNext() {
            return this.hasNext;
        }
        
        public boolean isHasPrev() {
            return this.hasPrev;
        }
        
        public boolean isLast() {
            return this.last;
        }
        
        public void setContent(final List<ContentBean> content) {
            this.content = content;
        }
        
        public void setCurrentPage(final int currentPage) {
            this.currentPage = currentPage;
        }
        
        public void setFirst(final boolean first) {
            this.first = first;
        }
        
        public void setHasNext(final boolean hasNext) {
            this.hasNext = hasNext;
        }
        
        public void setHasPrev(final boolean hasPrev) {
            this.hasPrev = hasPrev;
        }
        
        public void setLast(final boolean last) {
            this.last = last;
        }
        
        public void setNextPage(final int nextPage) {
            this.nextPage = nextPage;
        }
        
        public void setPageCount(final int pageCount) {
            this.pageCount = pageCount;
        }
        
        public void setPageSize(final int pageSize) {
            this.pageSize = pageSize;
        }
        
        public void setPrevPage(final int prevPage) {
            this.prevPage = prevPage;
        }
        
        public void setTotalCount(final int totalCount) {
            this.totalCount = totalCount;
        }
        
        public static class ContentBean
        {
            private Object accountPhone;
            private int agentId;
            private String arriveTime;
            private Object badCode;
            private String badDesc;
            private String company;
            private long idx;
            private Object kdyId;
            private Object moveFlag;
            private String pickCode;
            private String receAddress;
            private String receName;
            private String recePhone;
            private String shipId;
            private Object signPhoto;
            private Object signTime;
            private String state;
            private int upLogistics;
            private String updateTime;
            private Object ydUserId;
            
            public Object getAccountPhone() {
                return this.accountPhone;
            }
            
            public int getAgentId() {
                return this.agentId;
            }
            
            public String getArriveTime() {
                return this.arriveTime;
            }
            
            public Object getBadCode() {
                return this.badCode;
            }
            
            public String getBadDesc() {
                return this.badDesc;
            }
            
            public String getCompany() {
                return this.company;
            }
            
            public long getIdx() {
                return this.idx;
            }
            
            public Object getKdyId() {
                return this.kdyId;
            }
            
            public Object getMoveFlag() {
                return this.moveFlag;
            }
            
            public String getPickCode() {
                return this.pickCode;
            }
            
            public String getReceAddress() {
                return this.receAddress;
            }
            
            public String getReceName() {
                return this.receName;
            }
            
            public String getRecePhone() {
                return this.recePhone;
            }
            
            public String getShipId() {
                return this.shipId;
            }
            
            public Object getSignPhoto() {
                return this.signPhoto;
            }
            
            public Object getSignTime() {
                return this.signTime;
            }
            
            public String getState() {
                return this.state;
            }
            
            public int getUpLogistics() {
                return this.upLogistics;
            }
            
            public String getUpdateTime() {
                return this.updateTime;
            }
            
            public Object getYdUserId() {
                return this.ydUserId;
            }
            
            public void setAccountPhone(final Object accountPhone) {
                this.accountPhone = accountPhone;
            }
            
            public void setAgentId(final int agentId) {
                this.agentId = agentId;
            }
            
            public void setArriveTime(final String arriveTime) {
                this.arriveTime = arriveTime;
            }
            
            public void setBadCode(final Object badCode) {
                this.badCode = badCode;
            }
            
            public void setBadDesc(final String badDesc) {
                this.badDesc = badDesc;
            }
            
            public void setCompany(final String company) {
                this.company = company;
            }
            
            public void setIdx(final long idx) {
                this.idx = idx;
            }
            
            public void setKdyId(final Object kdyId) {
                this.kdyId = kdyId;
            }
            
            public void setMoveFlag(final Object moveFlag) {
                this.moveFlag = moveFlag;
            }
            
            public void setPickCode(final String pickCode) {
                this.pickCode = pickCode;
            }
            
            public void setReceAddress(final String receAddress) {
                this.receAddress = receAddress;
            }
            
            public void setReceName(final String receName) {
                this.receName = receName;
            }
            
            public void setRecePhone(final String recePhone) {
                this.recePhone = recePhone;
            }
            
            public void setShipId(final String shipId) {
                this.shipId = shipId;
            }
            
            public void setSignPhoto(final Object signPhoto) {
                this.signPhoto = signPhoto;
            }
            
            public void setSignTime(final Object signTime) {
                this.signTime = signTime;
            }
            
            public void setState(final String state) {
                this.state = state;
            }
            
            public void setUpLogistics(final int upLogistics) {
                this.upLogistics = upLogistics;
            }
            
            public void setUpdateTime(final String updateTime) {
                this.updateTime = updateTime;
            }
            
            public void setYdUserId(final Object ydUserId) {
                this.ydUserId = ydUserId;
            }
        }
    }
}
