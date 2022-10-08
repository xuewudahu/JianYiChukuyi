package com.rq.net.bean;

public class DeviceCloudResponseBean
{
    private long cloud_current;
    private String cloud_deadline;
    private long cloud_limit;
    private boolean is_trial;
    private RenewConfig renew_config;
    private String trial_date;
    private int trial_days;
    
    public long getCloud_current() {
        return this.cloud_current;
    }
    
    public String getCloud_deadline() {
        return this.cloud_deadline;
    }
    
    public long getCloud_limit() {
        return this.cloud_limit;
    }
    
    public RenewConfig getRenew_config() {
        return this.renew_config;
    }
    
    public String getTrial_date() {
        return this.trial_date;
    }
    
    public int getTrial_days() {
        return this.trial_days;
    }
    
    public boolean isIs_trial() {
        return this.is_trial;
    }
    
    public void setCloud_current(final long cloud_current) {
        this.cloud_current = cloud_current;
    }
    
    public void setCloud_deadline(final String cloud_deadline) {
        this.cloud_deadline = cloud_deadline;
    }
    
    public void setCloud_limit(final long cloud_limit) {
        this.cloud_limit = cloud_limit;
    }
    
    public void setIs_trial(final boolean is_trial) {
        this.is_trial = is_trial;
    }
    
    public void setRenew_config(final RenewConfig renew_config) {
        this.renew_config = renew_config;
    }
    
    public void setTrial_date(final String trial_date) {
        this.trial_date = trial_date;
    }
    
    public void setTrial_days(final int trial_days) {
        this.trial_days = trial_days;
    }
}
