package com.rq.net.bean;

import java.util.*;

public class KDCSQueryStaffAndStoreResponseBean
{
    private String account;
    private String address;
    private int approveStatus;
    private String city;
    private String commitTime;
    private String depotCode;
    private String depotName;
    private String district;
    private String failReason;
    private int id;
    private int ladingSwitch;
    private String mobile;
    private String name;
    private int orgId;
    private List<PostsData> posts;
    private String printerId;
    private String province;
    private String runtime;
    private String staffCode;
    private int staffId;
    private int storeId;
    private boolean storeManager;
    private String storeMobile;
    
    public String getAccount() {
        return this.account;
    }
    
    public String getAddress() {
        return this.address;
    }
    
    public int getApproveStatus() {
        return this.approveStatus;
    }
    
    public String getCity() {
        return this.city;
    }
    
    public String getCommitTime() {
        return this.commitTime;
    }
    
    public String getDepotCode() {
        return this.depotCode;
    }
    
    public String getDepotName() {
        return this.depotName;
    }
    
    public String getDistrict() {
        return this.district;
    }
    
    public String getFailReason() {
        return this.failReason;
    }
    
    public int getId() {
        return this.id;
    }
    
    public int getLadingSwitch() {
        return this.ladingSwitch;
    }
    
    public String getMobile() {
        return this.mobile;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getOrgId() {
        return this.orgId;
    }
    
    public List<PostsData> getPosts() {
        return this.posts;
    }
    
    public String getPrinterId() {
        return this.printerId;
    }
    
    public String getProvince() {
        return this.province;
    }
    
    public String getRuntime() {
        return this.runtime;
    }
    
    public String getStaffCode() {
        return this.staffCode;
    }
    
    public int getStaffId() {
        return this.staffId;
    }
    
    public int getStoreId() {
        return this.storeId;
    }
    
    public String getStoreMobile() {
        return this.storeMobile;
    }
    
    public boolean isStoreManager() {
        return this.storeManager;
    }
    
    public void setAccount(final String account) {
        this.account = account;
    }
    
    public void setAddress(final String address) {
        this.address = address;
    }
    
    public void setApproveStatus(final int approveStatus) {
        this.approveStatus = approveStatus;
    }
    
    public void setCity(final String city) {
        this.city = city;
    }
    
    public void setCommitTime(final String commitTime) {
        this.commitTime = commitTime;
    }
    
    public void setDepotCode(final String depotCode) {
        this.depotCode = depotCode;
    }
    
    public void setDepotName(final String depotName) {
        this.depotName = depotName;
    }
    
    public void setDistrict(final String district) {
        this.district = district;
    }
    
    public void setFailReason(final String failReason) {
        this.failReason = failReason;
    }
    
    public void setId(final int id) {
        this.id = id;
    }
    
    public void setLadingSwitch(final int ladingSwitch) {
        this.ladingSwitch = ladingSwitch;
    }
    
    public void setMobile(final String mobile) {
        this.mobile = mobile;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public void setOrgId(final int orgId) {
        this.orgId = orgId;
    }
    
    public void setPosts(final List<PostsData> posts) {
        this.posts = posts;
    }
    
    public void setPrinterId(final String printerId) {
        this.printerId = printerId;
    }
    
    public void setProvince(final String province) {
        this.province = province;
    }
    
    public void setRuntime(final String runtime) {
        this.runtime = runtime;
    }
    
    public void setStaffCode(final String staffCode) {
        this.staffCode = staffCode;
    }
    
    public void setStaffId(final int staffId) {
        this.staffId = staffId;
    }
    
    public void setStoreId(final int storeId) {
        this.storeId = storeId;
    }
    
    public void setStoreManager(final boolean storeManager) {
        this.storeManager = storeManager;
    }
    
    public void setStoreMobile(final String storeMobile) {
        this.storeMobile = storeMobile;
    }
    
    public static class PostsData
    {
        private int postId;
        private String postName;
        private String roleIds;
        
        public int getPostId() {
            return this.postId;
        }
        
        public String getPostName() {
            return this.postName;
        }
        
        public String getRoleIds() {
            return this.roleIds;
        }
        
        public void setPostId(final int postId) {
            this.postId = postId;
        }
        
        public void setPostName(final String postName) {
            this.postName = postName;
        }
        
        public void setRoleIds(final String roleIds) {
            this.roleIds = roleIds;
        }
    }
}
