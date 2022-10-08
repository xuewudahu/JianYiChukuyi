package com.rq.net.util;

import androidx.annotation.Nullable;

import java.util.List;

public class Intrinsics {
    public final static boolean areEqual(String s1,String s2){
        if(s1 == null){
            return s2 == null;
        }
        return s1.equals(s2);
    }

    public final static boolean areEqual(List s1, List s2){
        if(s1 == null){
            return s2 == null;
        }
        return s1.equals(s2);
    }

    public final static boolean areEqual(Object s1, Object s2){
        if(s1 == null){
            return s2 == null;
        }
        return s1.equals(s2);
    }
}
