package com.rq.net.bean;

public class JuShuiTanRequest
{
    private String l_id;
    private int type;
    private float weight;
    
    public JuShuiTanRequest(final String l_id, final float weight, final int type) {
        this.l_id = l_id;
        this.weight = weight;
        this.type = type;
    }
    
    public String getL_id() {
        return this.l_id;
    }
    
    public int getType() {
        return this.type;
    }
    
    public float getWeight() {
        return this.weight;
    }
    
    public void setL_id(final String l_id) {
        this.l_id = l_id;
    }
    
    public void setType(final int type) {
        this.type = type;
    }
    
    public void setWeight(final float weight) {
        this.weight = weight;
    }
}
