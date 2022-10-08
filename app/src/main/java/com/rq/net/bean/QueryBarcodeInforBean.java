package com.rq.net.bean;

import java.util.*;

public class QueryBarcodeInforBean
{
    private String express_no;
    private List<String> info;
    
    public String getExpress_no() {
        return this.express_no;
    }
    
    public List<String> getInfo() {
        return this.info;
    }
    
    public void setExpress_no(final String express_no) {
        this.express_no = express_no;
    }
    
    public void setInfo(final List<String> info) {
        this.info = info;
    }
}
