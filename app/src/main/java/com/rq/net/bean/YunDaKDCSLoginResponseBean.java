package com.rq.net.bean;

public class YunDaKDCSLoginResponseBean
{
    private int code;
    private DataBean data;
    private String message;
    private String openid;
    private String publicKey;
    private boolean result;
    private String token;
    
    public int getCode() {
        return this.code;
    }
    
    public DataBean getData() {
        return this.data;
    }
    
    public String getMessage() {
        return this.message;
    }
    
    public String getOpenid() {
        return this.openid;
    }
    
    public String getPublicKey() {
        return this.publicKey;
    }
    
    public String getToken() {
        return this.token;
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
    
    public void setOpenid(final String openid) {
        this.openid = openid;
    }
    
    public void setPublicKey(final String publicKey) {
        this.publicKey = publicKey;
    }
    
    public void setResult(final boolean result) {
        this.result = result;
    }
    
    public void setToken(final String token) {
        this.token = token;
    }
    
    public static class DataBean
    {
        private String accType;
        private String address;
        private String agentId;
        private String agentName;
        private String agentPerson;
        private String agentPhone;
        private int agentType;
        private String applyAuditFailDesc;
        private String applyAuditState;
        private String assignId;
        private String auditState;
        private int bindBranch;
        private int bindStore;
        private int bindUser;
        private String branchId;
        private String branchName;
        private String checkAuditFailDesc;
        private String checkAuditState;
        private String city;
        private String cityName;
        private String contactPhone;
        private String county;
        private String countyName;
        private String createTime;
        private int distributeSetting;
        private int doorReminderMode;
        private int doorReminderSetting;
        private int firstReminderMode;
        private int firstReminderSetting;
        private String headIcon;
        private boolean isNewUser;
        private int movePackMode;
        private String phone;
        private String pickMode;
        private String pickTime;
        private String pickTimeEnd;
        private String pickTimeStart;
        private String province;
        private String provinceName;
        private int signMode;
        private String smsMode;
        private int specialSetting;
        private String staffCode;
        private int standardTips;
        private String userId;
        private String username;
        private String wxSwitch;
        private String ztSpecialSwitch;
        
        public String getAccType() {
            return this.accType;
        }
        
        public String getAddress() {
            return this.address;
        }
        
        public String getAgentId() {
            return this.agentId;
        }
        
        public String getAgentName() {
            return this.agentName;
        }
        
        public String getAgentPerson() {
            return this.agentPerson;
        }
        
        public String getAgentPhone() {
            return this.agentPhone;
        }
        
        public int getAgentType() {
            return this.agentType;
        }
        
        public String getApplyAuditFailDesc() {
            return this.applyAuditFailDesc;
        }
        
        public String getApplyAuditState() {
            return this.applyAuditState;
        }
        
        public String getAssignId() {
            return this.assignId;
        }
        
        public String getAuditState() {
            return this.auditState;
        }
        
        public int getBindBranch() {
            return this.bindBranch;
        }
        
        public int getBindStore() {
            return this.bindStore;
        }
        
        public int getBindUser() {
            return this.bindUser;
        }
        
        public String getBranchId() {
            return this.branchId;
        }
        
        public String getBranchName() {
            return this.branchName;
        }
        
        public String getCheckAuditFailDesc() {
            return this.checkAuditFailDesc;
        }
        
        public String getCheckAuditState() {
            return this.checkAuditState;
        }
        
        public String getCity() {
            return this.city;
        }
        
        public String getCityName() {
            return this.cityName;
        }
        
        public String getContactPhone() {
            return this.contactPhone;
        }
        
        public String getCounty() {
            return this.county;
        }
        
        public String getCountyName() {
            return this.countyName;
        }
        
        public String getCreateTime() {
            return this.createTime;
        }
        
        public int getDistributeSetting() {
            return this.distributeSetting;
        }
        
        public int getDoorReminderMode() {
            return this.doorReminderMode;
        }
        
        public int getDoorReminderSetting() {
            return this.doorReminderSetting;
        }
        
        public int getFirstReminderMode() {
            return this.firstReminderMode;
        }
        
        public int getFirstReminderSetting() {
            return this.firstReminderSetting;
        }
        
        public String getHeadIcon() {
            return this.headIcon;
        }
        
        public int getMovePackMode() {
            return this.movePackMode;
        }
        
        public String getPhone() {
            return this.phone;
        }
        
        public String getPickMode() {
            return this.pickMode;
        }
        
        public String getPickTime() {
            return this.pickTime;
        }
        
        public String getPickTimeEnd() {
            return this.pickTimeEnd;
        }
        
        public String getPickTimeStart() {
            return this.pickTimeStart;
        }
        
        public String getProvince() {
            return this.province;
        }
        
        public String getProvinceName() {
            return this.provinceName;
        }
        
        public int getSignMode() {
            return this.signMode;
        }
        
        public String getSmsMode() {
            return this.smsMode;
        }
        
        public int getSpecialSetting() {
            return this.specialSetting;
        }
        
        public String getStaffCode() {
            return this.staffCode;
        }
        
        public int getStandardTips() {
            return this.standardTips;
        }
        
        public String getUserId() {
            return this.userId;
        }
        
        public String getUsername() {
            return this.username;
        }
        
        public String getWxSwitch() {
            return this.wxSwitch;
        }
        
        public String getZtSpecialSwitch() {
            return this.ztSpecialSwitch;
        }
        
        public boolean isIsNewUser() {
            return this.isNewUser;
        }
        
        public void setAccType(final String accType) {
            this.accType = accType;
        }
        
        public void setAddress(final String address) {
            this.address = address;
        }
        
        public void setAgentId(final String agentId) {
            this.agentId = agentId;
        }
        
        public void setAgentName(final String agentName) {
            this.agentName = agentName;
        }
        
        public void setAgentPerson(final String agentPerson) {
            this.agentPerson = agentPerson;
        }
        
        public void setAgentPhone(final String agentPhone) {
            this.agentPhone = agentPhone;
        }
        
        public void setAgentType(final int agentType) {
            this.agentType = agentType;
        }
        
        public void setApplyAuditFailDesc(final String applyAuditFailDesc) {
            this.applyAuditFailDesc = applyAuditFailDesc;
        }
        
        public void setApplyAuditState(final String applyAuditState) {
            this.applyAuditState = applyAuditState;
        }
        
        public void setAssignId(final String assignId) {
            this.assignId = assignId;
        }
        
        public void setAuditState(final String auditState) {
            this.auditState = auditState;
        }
        
        public void setBindBranch(final int bindBranch) {
            this.bindBranch = bindBranch;
        }
        
        public void setBindStore(final int bindStore) {
            this.bindStore = bindStore;
        }
        
        public void setBindUser(final int bindUser) {
            this.bindUser = bindUser;
        }
        
        public void setBranchId(final String branchId) {
            this.branchId = branchId;
        }
        
        public void setBranchName(final String branchName) {
            this.branchName = branchName;
        }
        
        public void setCheckAuditFailDesc(final String checkAuditFailDesc) {
            this.checkAuditFailDesc = checkAuditFailDesc;
        }
        
        public void setCheckAuditState(final String checkAuditState) {
            this.checkAuditState = checkAuditState;
        }
        
        public void setCity(final String city) {
            this.city = city;
        }
        
        public void setCityName(final String cityName) {
            this.cityName = cityName;
        }
        
        public void setContactPhone(final String contactPhone) {
            this.contactPhone = contactPhone;
        }
        
        public void setCounty(final String county) {
            this.county = county;
        }
        
        public void setCountyName(final String countyName) {
            this.countyName = countyName;
        }
        
        public void setCreateTime(final String createTime) {
            this.createTime = createTime;
        }
        
        public void setDistributeSetting(final int distributeSetting) {
            this.distributeSetting = distributeSetting;
        }
        
        public void setDoorReminderMode(final int doorReminderMode) {
            this.doorReminderMode = doorReminderMode;
        }
        
        public void setDoorReminderSetting(final int doorReminderSetting) {
            this.doorReminderSetting = doorReminderSetting;
        }
        
        public void setFirstReminderMode(final int firstReminderMode) {
            this.firstReminderMode = firstReminderMode;
        }
        
        public void setFirstReminderSetting(final int firstReminderSetting) {
            this.firstReminderSetting = firstReminderSetting;
        }
        
        public void setHeadIcon(final String headIcon) {
            this.headIcon = headIcon;
        }
        
        public void setIsNewUser(final boolean isNewUser) {
            this.isNewUser = isNewUser;
        }
        
        public void setMovePackMode(final int movePackMode) {
            this.movePackMode = movePackMode;
        }
        
        public void setPhone(final String phone) {
            this.phone = phone;
        }
        
        public void setPickMode(final String pickMode) {
            this.pickMode = pickMode;
        }
        
        public void setPickTime(final String pickTime) {
            this.pickTime = pickTime;
        }
        
        public void setPickTimeEnd(final String pickTimeEnd) {
            this.pickTimeEnd = pickTimeEnd;
        }
        
        public void setPickTimeStart(final String pickTimeStart) {
            this.pickTimeStart = pickTimeStart;
        }
        
        public void setProvince(final String province) {
            this.province = province;
        }
        
        public void setProvinceName(final String provinceName) {
            this.provinceName = provinceName;
        }
        
        public void setSignMode(final int signMode) {
            this.signMode = signMode;
        }
        
        public void setSmsMode(final String smsMode) {
            this.smsMode = smsMode;
        }
        
        public void setSpecialSetting(final int specialSetting) {
            this.specialSetting = specialSetting;
        }
        
        public void setStaffCode(final String staffCode) {
            this.staffCode = staffCode;
        }
        
        public void setStandardTips(final int standardTips) {
            this.standardTips = standardTips;
        }
        
        public void setUserId(final String userId) {
            this.userId = userId;
        }
        
        public void setUsername(final String username) {
            this.username = username;
        }
        
        public void setWxSwitch(final String wxSwitch) {
            this.wxSwitch = wxSwitch;
        }
        
        public void setZtSpecialSwitch(final String ztSpecialSwitch) {
            this.ztSpecialSwitch = ztSpecialSwitch;
        }
    }
}
