package com.rq.net.bean;

import android.util.Pair;

import java.util.*;
public final class YshouFaKt
{
    private static final Map expressMap = new HashMap<>();
    {
        expressMap.put("SF", "顺丰速运");
        expressMap.put("HTKY", "百世快递");
        expressMap.put("ZTO", "中通快递");
        expressMap.put("STO", "申通快递");
        expressMap.put("YTO", "圆通速递");
        expressMap.put("YZPY", "韵达速递");
        expressMap.put("YD", "EMS");
        expressMap.put("HHTT ", "天天快递");
        expressMap.put("JD ", "京东快递");
        expressMap.put("UC ", "优速快递");
        expressMap.put("DBL ", "德邦快递");
        expressMap.put("ZJS", "宅急送");
        expressMap.put("JTSD", "极兔速递");
        expressMap.put("SNWL", "苏宁物流");
        expressMap.put("ANE56", "安能物流");
        expressMap.put("FWSY", "丰网速运");
        expressMap.put("DNWL", "丹鸟");
        expressMap.put("DISU", "D速物流");
        expressMap.put("TMCS", "天猫超市");
        expressMap.put("OTHERS", "其他");
    }
    public static final Map getExpressMap() {
        return expressMap;
    }
}
