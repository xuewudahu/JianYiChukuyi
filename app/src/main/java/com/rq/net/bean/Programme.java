package com.rq.net.bean;

//import kotlin.*;

//@Metadata(bv = { 1, 0, 3 }, d1 = { "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t" }, d2 = { "Lcom/yunpan/cobaaidlservice/bean/Programme;", "", "size", "", "price", "(II)V", "getPrice", "()I", "getSize", "app_CoBaAIRelease" }, k = 1, mv = { 1, 1, 16 })
public final class Programme
{
    private final int price;
    private final int size;
    
    public Programme(final int size, final int price) {
        this.size = size;
        this.price = price;
    }
    
    public final int getPrice() {
        return this.price;
    }
    
    public final int getSize() {
        return this.size;
    }
}
