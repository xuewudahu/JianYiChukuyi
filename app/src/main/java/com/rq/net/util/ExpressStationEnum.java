package com.rq.net.util;

public enum ExpressStationEnum {
    DUODUOYIZHAN(0, "多多驿站", 68719476736L, "DUODUOYIZHAN"),
    KUAIBAO(1, "快宝驿站", 2L, "KUAIBAO"),
    STAGESMALLPOLE(2, "驿站小扁担", 8192L, "STAGESMALLPOLE"),
    STATIONHELPER(3, "驿站助手", 2048L, "STATIONHELPER"),
    LAIQU(4, "百世邻里", 32L, "LAIQU"),
    KUAIDICAOSHI(5, "兔喜快递超市", 4L, "KUAIDICAOSHI"),
    COURIERSMALLPOLE(6, "快递员小扁担", 4096L, "COURIERSMALLPOLE"),
    JITU(7, "极兔", 262144L, "JITU"),
    MOXIGUANJIA(8, "摩西管家", 8589934792L, "MOXIGUANJIA"),
    FENGCHAOSERVICE(9, "丰巢服务站", 256L, "FENGCHAOSERVICE"),
    MAMASTATION(10, "妈妈驿站", 16L, "MAMASTATION"),

    YSHOUFA(11, "驿收发", 134217728L, "YSHOUFA"),
    ZYZT(12, "中邮自提", 8589934592L, "ZYZT"),
    ZHONGYOUSTATION(13, "中邮驿站", 1073741824L, "ZHONGYOUSTATION"),
    PANDAHARVEST(14, "熊猫快收", 1024L, "PANDAKUAISHOU"),
    BLUESHOP(15, "蓝店", 16384L, "BLUESHOP"),
    YUNDAKDCS(16, "韵达快递", 128L, "YUNDAKDCS"),
    FENSHISHENGHUO(17, "粉丝生活", 1048576L, "FSSH"),
    GUOGUOYIZHAN(18, "果果驿站", 268435456L, "GUOGUOYIZHAN"),
    JINLINBAOGAOPAIYI(19, "近邻宝高拍仪", 16777216L, "JINLINBAOGAOPAIYI"),
    JINLINBAOKUAIDIQUJIAN(20, "近邻宝快递取件", 8388608L, "JINLINBAOKUAIDIQUJIAN"),
    JINLINBAOOCRJIEBO(21, "近邻宝OCR接驳", 2097152L, "JINLINBAOOCRJIEBO"),
    JINLINBAOQIANSHOU(22, "近邻宝取件签收", 4194304L, "JINLINBAOQIANSHOU"),
    SUDIYIGONGPEI(23, "速递易共配", 536870912L, "SUDIYIGONGPEI"),
    JUSHUITAN(24, "聚水潭", 32768L, "JUSHUITAN"),
    XINGHUO(25, "星火", 524288L, "XINGHUO"),
    XINIAOGAOPAIYI(26, "溪鸟高拍仪", 65536L, "XINIAOGAOPAIYI"),
    XIAOBINGSTATION(27, "小兵驿站", 512L, "XIAOBINGSTATION"),
    NETMANAGER(28, "吉客云", 131072L, "NETMANAGER"),
    MIAOZHAN(29, "喵站", 2147483648L, "MIAOZHAN"),
    ZHONGYOUCHENGZHONG(30, "众邮称重", 33554432L, "ZHONGYOUCHENGZHONG"),


    CAINIAO(31, "菜鸟驿站", 1L, "CAINIAO"),
    DIYIBOX(32, "递易", 4294967296L, "DIYIBOX"),
    HAOYUNLAI(33, "蔚路循环", 67108864L, "HAOYUNLAI"),
    MSWMS(34, "弥森WMS", 17179869184L, "SMVMS"),
    OTHER(35, "其他", 8L, "OTHER"),
    XINIAO(36, "溪鸟", 64L, "XINIAO"),
    YIXIAODIAN(37, "驿小店", 34359738368L, "YIXIAODIAN");




    private int code;
    private long item;
    private String name;
    private String title;

    private ExpressStationEnum(int var3, String var4, long var5, String var7) {
        this.code = var3;
        this.name = var4;
        this.item = var5;
        this.title = var7;
    }

    public static String getName(int var0) {
        ExpressStationEnum[] var4 = values();
        int var2 = var4.length;
        String var3 = "";
        for (int var1 = 0; var1 < var2; ++var1) {
            ExpressStationEnum var5 = var4[var1];
            if (var5.code == var0) {
                var3 = var5.name;
            }
        }
        return var3;
    }

    public static String getTitle(int var0) {
        ExpressStationEnum[] var4 = values();
        int var2 = var4.length;
        String var3 = "";
        for (int var1 = 0; var1 < var2; ++var1) {
            ExpressStationEnum var5 = var4[var1];
            if (var5.code == var0) {
                var3 = var5.title;
            }
        }
        return var3;
    }

    public int getCode() {
        return this.code;
    }

    public long getItem() {
        return this.item;
    }

    public String getName() {
        return this.name;
    }

    public String getTitle() {
        return this.title;
    }

    public void setCode(int var1) {
        this.code = var1;
    }

    public void setItem(int var1) {
        this.item = (long) var1;
    }

    public void setName(String var1) {
        this.name = var1;
    }

    public void setTitle(String var1) {
        this.title = var1;
    }
}