package com.rq.net.bean;

import org.litepal.crud.*;
import org.litepal.annotation.*;

public class DeliveryCodeTableBean /*extends DataSupport*/{
    @Column(defaultValue = "unknown", unique = true)
    private String goodsShelvesCode;
    private int latticeCode;
    private String num;
    
    public String getGoodsShelvesCode() {
        return this.goodsShelvesCode;
    }
    
    public int getLatticeCode() {
        return this.latticeCode;
    }
    
    public String getNum() {
        return this.num;
    }
    
    public void setGoodsShelvesCode(final String goodsShelvesCode) {
        this.goodsShelvesCode = goodsShelvesCode;
    }
    
    public void setLatticeCode(final int latticeCode) {
        this.latticeCode = latticeCode;
    }
    
    public void setNum(final String num) {
        this.num = num;
    }
}
