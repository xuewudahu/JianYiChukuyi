package com.rq.net.bean;

public class BizBean
{
    private String logisticNo;
    private String operator;
    private int weight;
    
    public BizBean(final String logisticNo, final int weight, final String operator) {
        this.logisticNo = logisticNo;
        this.weight = weight;
        this.operator = operator;
    }
    
    public String getLogisticNo() {
        return this.logisticNo;
    }
    
    public String getOperator() {
        return this.operator;
    }
    
    public int getWeight() {
        return this.weight;
    }
    
    public void setLogisticNo(final String logisticNo) {
        this.logisticNo = logisticNo;
    }
    
    public void setOperator(final String operator) {
        this.operator = operator;
    }
    
    public void setWeight(final int weight) {
        this.weight = weight;
    }
}
