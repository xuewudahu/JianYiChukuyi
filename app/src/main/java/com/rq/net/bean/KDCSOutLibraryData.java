package com.rq.net.bean;

import java.util.*;

public class KDCSOutLibraryData
{
    private List<OutLibraryData> data;
    
    public KDCSOutLibraryData() {
        this.data = new ArrayList<OutLibraryData>();
    }
    
    public List<OutLibraryData> getData() {
        return this.data;
    }
    
    public void setData(final List<OutLibraryData> data) {
        this.data = data;
    }
    
    public static class OutLibraryData
    {
        private String billCode;
        private String billCodeScanTime;
        private int channel;
        private String courierCode;
        private String courierExpCompanyCode;
        private String depotCode;
        private String ediUdf2;
        private String ediUdf3;
        private String expressComapnyCode;
        private int expressType;
        private String expressUserCode;
        private String expressUserMobile;
        private String extraInfo;
        private String fileImgPath;
        private int isNewUser;
        private String leaveRemark;
        private int mobileChannel;
        private int parcelCount;
        private String receiveMan;
        private String receiveManMobile;
        private String scanDate;
        private int scanType;
        private String staffCode;
        private String takeCode;
        private int takeType;
        private int taobao_type;
        
        public String getBillCode() {
            return this.billCode;
        }
        
        public String getBillCodeScanTime() {
            return this.billCodeScanTime;
        }
        
        public int getChannel() {
            return this.channel;
        }
        
        public String getCourierCode() {
            return this.courierCode;
        }
        
        public String getCourierExpCompanyCode() {
            return this.courierExpCompanyCode;
        }
        
        public String getDepotCode() {
            return this.depotCode;
        }
        
        public String getEdiUdf2() {
            return this.ediUdf2;
        }
        
        public String getEdiUdf3() {
            return this.ediUdf3;
        }
        
        public String getExpressComapnyCode() {
            return this.expressComapnyCode;
        }
        
        public int getExpressType() {
            return this.expressType;
        }
        
        public String getExpressUserCode() {
            return this.expressUserCode;
        }
        
        public String getExpressUserMobile() {
            return this.expressUserMobile;
        }
        
        public String getExtraInfo() {
            return this.extraInfo;
        }
        
        public String getFileImgPath() {
            return this.fileImgPath;
        }
        
        public int getIsNewUser() {
            return this.isNewUser;
        }
        
        public String getLeaveRemark() {
            return this.leaveRemark;
        }
        
        public int getMobileChannel() {
            return this.mobileChannel;
        }
        
        public int getParcelCount() {
            return this.parcelCount;
        }
        
        public String getReceiveMan() {
            return this.receiveMan;
        }
        
        public String getReceiveManMobile() {
            return this.receiveManMobile;
        }
        
        public String getScanDate() {
            return this.scanDate;
        }
        
        public int getScanType() {
            return this.scanType;
        }
        
        public String getStaffCode() {
            return this.staffCode;
        }
        
        public String getTakeCode() {
            return this.takeCode;
        }
        
        public int getTakeType() {
            return this.takeType;
        }
        
        public int getTaobao_type() {
            return this.taobao_type;
        }
        
        public void setBillCode(final String billCode) {
            this.billCode = billCode;
        }
        
        public void setBillCodeScanTime(final String billCodeScanTime) {
            this.billCodeScanTime = billCodeScanTime;
        }
        
        public void setChannel(final int channel) {
            this.channel = channel;
        }
        
        public void setCourierCode(final String courierCode) {
            this.courierCode = courierCode;
        }
        
        public void setCourierExpCompanyCode(final String courierExpCompanyCode) {
            this.courierExpCompanyCode = courierExpCompanyCode;
        }
        
        public void setDepotCode(final String depotCode) {
            this.depotCode = depotCode;
        }
        
        public void setEdiUdf2(final String ediUdf2) {
            this.ediUdf2 = ediUdf2;
        }
        
        public void setEdiUdf3(final String ediUdf3) {
            this.ediUdf3 = ediUdf3;
        }
        
        public void setExpressComapnyCode(final String expressComapnyCode) {
            this.expressComapnyCode = expressComapnyCode;
        }
        
        public void setExpressType(final int expressType) {
            this.expressType = expressType;
        }
        
        public void setExpressUserCode(final String expressUserCode) {
            this.expressUserCode = expressUserCode;
        }
        
        public void setExpressUserMobile(final String expressUserMobile) {
            this.expressUserMobile = expressUserMobile;
        }
        
        public void setExtraInfo(final String extraInfo) {
            this.extraInfo = extraInfo;
        }
        
        public void setFileImgPath(final String fileImgPath) {
            this.fileImgPath = fileImgPath;
        }
        
        public void setIsNewUser(final int isNewUser) {
            this.isNewUser = isNewUser;
        }
        
        public void setLeaveRemark(final String leaveRemark) {
            this.leaveRemark = leaveRemark;
        }
        
        public void setMobileChannel(final int mobileChannel) {
            this.mobileChannel = mobileChannel;
        }
        
        public void setParcelCount(final int parcelCount) {
            this.parcelCount = parcelCount;
        }
        
        public void setReceiveMan(final String receiveMan) {
            this.receiveMan = receiveMan;
        }
        
        public void setReceiveManMobile(final String receiveManMobile) {
            this.receiveManMobile = receiveManMobile;
        }
        
        public void setScanDate(final String scanDate) {
            this.scanDate = scanDate;
        }
        
        public void setScanType(final int scanType) {
            this.scanType = scanType;
        }
        
        public void setStaffCode(final String staffCode) {
            this.staffCode = staffCode;
        }
        
        public void setTakeCode(final String takeCode) {
            this.takeCode = takeCode;
        }
        
        public void setTakeType(final int takeType) {
            this.takeType = takeType;
        }
        
        public void setTaobao_type(final int taobao_type) {
            this.taobao_type = taobao_type;
        }
    }
}
