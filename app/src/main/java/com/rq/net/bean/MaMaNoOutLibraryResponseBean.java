package com.rq.net.bean;

import java.util.*;

public class MaMaNoOutLibraryResponseBean
{
    private String code;
    private List<DataBean> data;
    private String message;
    
    public String getCode() {
        return this.code;
    }
    
    public List<DataBean> getData() {
        return this.data;
    }
    
    public String getMessage() {
        return this.message;
    }
    
    public void setCode(final String code) {
        this.code = code;
    }
    
    public void setData(final List<DataBean> data) {
        this.data = data;
    }
    
    public void setMessage(final String message) {
        this.message = message;
    }
    
    public static class DataBean
    {
        private String customerCode;
        private String dataFlag;
        private String destName;
        private String destPhone;
        private String empCode;
        private String endTime;
        private String fullPhoneNo;
        private String id;
        private String idleDays;
        private String imgeUrl;
        private String incomeImageId;
        private String incomeTime;
        private boolean isnewClient;
        private String issign;
        private String key;
        private String lastIssueDesc;
        private String lastIssueTime;
        private String logisticsCode;
        private String logisticsName;
        private String matOrgCode;
        private String modelNo;
        private String modifyTime;
        private String moveRackTime;
        private String opCode;
        private String opTime;
        private String opUserId;
        private String orgCode;
        private String putNo;
        private String rackNo;
        private String recieverSignoff;
        private String reserve1;
        private String reserve2;
        private String reserve3;
        private String returnSignImageId;
        private String returnTime;
        private String returnUserId;
        private String signatureFailCode;
        private String signatureFailReason;
        private String signatureTime;
        private String smsErrorMsg;
        private String smsStatus;
        private int smsUpCount;
        private String sourceType;
        private String specialFlag;
        private String startTime;
        private String stationCode;
        private String status;
        private String statusName;
        private String takeCode;
        private String upRackTime;
        private String uploadTime;
        private String waybillNo;
        
        public String getCustomerCode() {
            return this.customerCode;
        }
        
        public String getDataFlag() {
            return this.dataFlag;
        }
        
        public String getDestName() {
            return this.destName;
        }
        
        public String getDestPhone() {
            return this.destPhone;
        }
        
        public String getEmpCode() {
            return this.empCode;
        }
        
        public String getEndTime() {
            return this.endTime;
        }
        
        public String getFullPhoneNo() {
            return this.fullPhoneNo;
        }
        
        public String getId() {
            return this.id;
        }
        
        public String getIdleDays() {
            return this.idleDays;
        }
        
        public String getImgeUrl() {
            return this.imgeUrl;
        }
        
        public String getIncomeImageId() {
            return this.incomeImageId;
        }
        
        public String getIncomeTime() {
            return this.incomeTime;
        }
        
        public String getIssign() {
            return this.issign;
        }
        
        public String getKey() {
            return this.key;
        }
        
        public String getLastIssueDesc() {
            return this.lastIssueDesc;
        }
        
        public String getLastIssueTime() {
            return this.lastIssueTime;
        }
        
        public String getLogisticsCode() {
            return this.logisticsCode;
        }
        
        public String getLogisticsName() {
            return this.logisticsName;
        }
        
        public String getMatOrgCode() {
            return this.matOrgCode;
        }
        
        public String getModelNo() {
            return this.modelNo;
        }
        
        public String getModifyTime() {
            return this.modifyTime;
        }
        
        public String getMoveRackTime() {
            return this.moveRackTime;
        }
        
        public String getOpCode() {
            return this.opCode;
        }
        
        public String getOpTime() {
            return this.opTime;
        }
        
        public String getOpUserId() {
            return this.opUserId;
        }
        
        public String getOrgCode() {
            return this.orgCode;
        }
        
        public String getPutNo() {
            return this.putNo;
        }
        
        public String getRackNo() {
            return this.rackNo;
        }
        
        public String getRecieverSignoff() {
            return this.recieverSignoff;
        }
        
        public String getReserve1() {
            return this.reserve1;
        }
        
        public String getReserve2() {
            return this.reserve2;
        }
        
        public String getReserve3() {
            return this.reserve3;
        }
        
        public String getReturnSignImageId() {
            return this.returnSignImageId;
        }
        
        public String getReturnTime() {
            return this.returnTime;
        }
        
        public String getReturnUserId() {
            return this.returnUserId;
        }
        
        public String getSignatureFailCode() {
            return this.signatureFailCode;
        }
        
        public String getSignatureFailReason() {
            return this.signatureFailReason;
        }
        
        public String getSignatureTime() {
            return this.signatureTime;
        }
        
        public String getSmsErrorMsg() {
            return this.smsErrorMsg;
        }
        
        public String getSmsStatus() {
            return this.smsStatus;
        }
        
        public int getSmsUpCount() {
            return this.smsUpCount;
        }
        
        public String getSourceType() {
            return this.sourceType;
        }
        
        public String getSpecialFlag() {
            return this.specialFlag;
        }
        
        public String getStartTime() {
            return this.startTime;
        }
        
        public String getStationCode() {
            return this.stationCode;
        }
        
        public String getStatus() {
            return this.status;
        }
        
        public String getStatusName() {
            return this.statusName;
        }
        
        public String getTakeCode() {
            return this.takeCode;
        }
        
        public String getUpRackTime() {
            return this.upRackTime;
        }
        
        public String getUploadTime() {
            return this.uploadTime;
        }
        
        public String getWaybillNo() {
            return this.waybillNo;
        }
        
        public boolean isIsnewClient() {
            return this.isnewClient;
        }
        
        public void setCustomerCode(final String customerCode) {
            this.customerCode = customerCode;
        }
        
        public void setDataFlag(final String dataFlag) {
            this.dataFlag = dataFlag;
        }
        
        public void setDestName(final String destName) {
            this.destName = destName;
        }
        
        public void setDestPhone(final String destPhone) {
            this.destPhone = destPhone;
        }
        
        public void setEmpCode(final String empCode) {
            this.empCode = empCode;
        }
        
        public void setEndTime(final String endTime) {
            this.endTime = endTime;
        }
        
        public void setFullPhoneNo(final String fullPhoneNo) {
            this.fullPhoneNo = fullPhoneNo;
        }
        
        public void setId(final String id) {
            this.id = id;
        }
        
        public void setIdleDays(final String idleDays) {
            this.idleDays = idleDays;
        }
        
        public void setImgeUrl(final String imgeUrl) {
            this.imgeUrl = imgeUrl;
        }
        
        public void setIncomeImageId(final String incomeImageId) {
            this.incomeImageId = incomeImageId;
        }
        
        public void setIncomeTime(final String incomeTime) {
            this.incomeTime = incomeTime;
        }
        
        public void setIsnewClient(final boolean isnewClient) {
            this.isnewClient = isnewClient;
        }
        
        public void setIssign(final String issign) {
            this.issign = issign;
        }
        
        public void setKey(final String key) {
            this.key = key;
        }
        
        public void setLastIssueDesc(final String lastIssueDesc) {
            this.lastIssueDesc = lastIssueDesc;
        }
        
        public void setLastIssueTime(final String lastIssueTime) {
            this.lastIssueTime = lastIssueTime;
        }
        
        public void setLogisticsCode(final String logisticsCode) {
            this.logisticsCode = logisticsCode;
        }
        
        public void setLogisticsName(final String logisticsName) {
            this.logisticsName = logisticsName;
        }
        
        public void setMatOrgCode(final String matOrgCode) {
            this.matOrgCode = matOrgCode;
        }
        
        public void setModelNo(final String modelNo) {
            this.modelNo = modelNo;
        }
        
        public void setModifyTime(final String modifyTime) {
            this.modifyTime = modifyTime;
        }
        
        public void setMoveRackTime(final String moveRackTime) {
            this.moveRackTime = moveRackTime;
        }
        
        public void setOpCode(final String opCode) {
            this.opCode = opCode;
        }
        
        public void setOpTime(final String opTime) {
            this.opTime = opTime;
        }
        
        public void setOpUserId(final String opUserId) {
            this.opUserId = opUserId;
        }
        
        public void setOrgCode(final String orgCode) {
            this.orgCode = orgCode;
        }
        
        public void setPutNo(final String putNo) {
            this.putNo = putNo;
        }
        
        public void setRackNo(final String rackNo) {
            this.rackNo = rackNo;
        }
        
        public void setRecieverSignoff(final String recieverSignoff) {
            this.recieverSignoff = recieverSignoff;
        }
        
        public void setReserve1(final String reserve1) {
            this.reserve1 = reserve1;
        }
        
        public void setReserve2(final String reserve2) {
            this.reserve2 = reserve2;
        }
        
        public void setReserve3(final String reserve3) {
            this.reserve3 = reserve3;
        }
        
        public void setReturnSignImageId(final String returnSignImageId) {
            this.returnSignImageId = returnSignImageId;
        }
        
        public void setReturnTime(final String returnTime) {
            this.returnTime = returnTime;
        }
        
        public void setReturnUserId(final String returnUserId) {
            this.returnUserId = returnUserId;
        }
        
        public void setSignatureFailCode(final String signatureFailCode) {
            this.signatureFailCode = signatureFailCode;
        }
        
        public void setSignatureFailReason(final String signatureFailReason) {
            this.signatureFailReason = signatureFailReason;
        }
        
        public void setSignatureTime(final String signatureTime) {
            this.signatureTime = signatureTime;
        }
        
        public void setSmsErrorMsg(final String smsErrorMsg) {
            this.smsErrorMsg = smsErrorMsg;
        }
        
        public void setSmsStatus(final String smsStatus) {
            this.smsStatus = smsStatus;
        }
        
        public void setSmsUpCount(final int smsUpCount) {
            this.smsUpCount = smsUpCount;
        }
        
        public void setSourceType(final String sourceType) {
            this.sourceType = sourceType;
        }
        
        public void setSpecialFlag(final String specialFlag) {
            this.specialFlag = specialFlag;
        }
        
        public void setStartTime(final String startTime) {
            this.startTime = startTime;
        }
        
        public void setStationCode(final String stationCode) {
            this.stationCode = stationCode;
        }
        
        public void setStatus(final String status) {
            this.status = status;
        }
        
        public void setStatusName(final String statusName) {
            this.statusName = statusName;
        }
        
        public void setTakeCode(final String takeCode) {
            this.takeCode = takeCode;
        }
        
        public void setUpRackTime(final String upRackTime) {
            this.upRackTime = upRackTime;
        }
        
        public void setUploadTime(final String uploadTime) {
            this.uploadTime = uploadTime;
        }
        
        public void setWaybillNo(final String waybillNo) {
            this.waybillNo = waybillNo;
        }
    }
}
