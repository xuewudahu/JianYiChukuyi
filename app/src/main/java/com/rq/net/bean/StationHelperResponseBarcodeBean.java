package com.rq.net.bean;

import java.util.*;

public class StationHelperResponseBarcodeBean
{
    private String errMsg;
    private List<Detail> expressPackLst;
    private int retCode;
    
    public String getErrMsg() {
        return this.errMsg;
    }
    
    public List<Detail> getExpressPackLst() {
        return this.expressPackLst;
    }
    
    public int getRetCode() {
        return this.retCode;
    }
    
    public void setErrMsg(final String errMsg) {
        this.errMsg = errMsg;
    }
    
    public void setExpressPackLst(final List<Detail> expressPackLst) {
        this.expressPackLst = expressPackLst;
    }
    
    public void setRetCode(final int retCode) {
        this.retCode = retCode;
    }
}
