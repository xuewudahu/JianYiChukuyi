package com.rq.net.bean;

import java.util.*;

public class StationHelperResponseChuKuBean
{
    private String errMsg;
    private InfoData expressPackInfo;
    private List<InfoListData> mergeOutExpressInfoLst;
    private int retCode;
    
    public String getErrMsg() {
        return this.errMsg;
    }
    
    public InfoData getExpressPackInfo() {
        return this.expressPackInfo;
    }
    
    public List<InfoListData> getMergeOutExpressInfoLst() {
        return this.mergeOutExpressInfoLst;
    }
    
    public int getRetCode() {
        return this.retCode;
    }
    
    public void setErrMsg(final String errMsg) {
        this.errMsg = errMsg;
    }
    
    public void setExpressPackInfo(final InfoData expressPackInfo) {
        this.expressPackInfo = expressPackInfo;
    }
    
    public void setMergeOutExpressInfoLst(final List<InfoListData> mergeOutExpressInfoLst) {
        this.mergeOutExpressInfoLst = mergeOutExpressInfoLst;
    }
    
    public void setRetCode(final int retCode) {
        this.retCode = retCode;
    }
}
