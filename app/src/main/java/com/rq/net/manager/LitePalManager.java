package com.rq.net.manager;

import org.litepal.crud.*;
//import com.kuaidihelp.posthouse.sqlite.bean.*;
import java.util.*;
//import com.kuaidihelp.posthouse.bean.*;
import android.content.*;

import com.rq.net.bean.BaseDataSupport;
import com.rq.net.bean.SendInformationTableBean;

public class LitePalManager
{/*
    public static boolean delete(final DataSupport dataSupport) {
        return dataSupport.delete() > 0;
    }
    
    public static boolean deleteByConditions(final Class<?> clazz, final String... array) {
        return DataSupport.deleteAll((Class)clazz, array) > 0;
    }
    
    public static boolean deleteByConditions(final DataSupport dataSupport, final String... array) {
        return DataSupport.deleteAll((Class)dataSupport.getClass(), array) > 0;
    }
    
    public static int deleteData(final Class<?> clazz, final String... array) {
        return DataSupport.deleteAll((Class)clazz, array);
    }
    
    public static DataSupport find(final Class<DataSupport> clazz, final int n) {
        return (DataSupport)DataSupport.find((Class)clazz, (long)n, true);
    }
    
    public static List<BaseDataSupport> findByConditions(final BaseDataSupport baseDataSupport, final String... array) {
        return (List<BaseDataSupport>)DataSupport.where(array).find((Class)baseDataSupport.getClass());
    }
    
    public static <T> List<T> findByConditions(final Class<T> clazz, final String... array) throws Exception {
        return (List<T>)DataSupport.where(array).find((Class)clazz, true);
    }
    
    public static <T> List<T> findByLimitConditions(final String s, final int n, final Class<T> clazz, final String... array) {
        return (List<T>)DataSupport.order(s).limit(n).where(array).find((Class)clazz, true);
    }
    
    public static DataSupport findFirst(final Class<?> clazz) {
        return (DataSupport)DataSupport.findFirst((Class)clazz, true);
    }
    
    public static <T> T findFirstByConditions(final Class<T> clazz, final String... array) {
        return (T)DataSupport.where(array).findFirst((Class)clazz, false);
    }
    
    public static DataSupport findLast(final DataSupport dataSupport) {
        return (DataSupport)DataSupport.findLast((Class)dataSupport.getClass());
    }
    
    public static <T> T findLimitFirstByConditions(final String s, final int n, final Class<T> clazz, final String... array) {
        return (T)DataSupport.order(s).limit(n).where(array).findFirst((Class)clazz, false);
    }
    
    public static <T> int getCountByConditions(final Class<T> clazz, final String... array) {
        return DataSupport.where(array).count((Class)clazz);
    }
    
    public static boolean save(final DataSupport dataSupport) throws Exception {
        return dataSupport.save();
    }
    
    public static void saveAll(final List<DataSupport> list) {
        DataSupport.saveAll((Collection)list);
    }
    
    public static boolean saveOrUpdate(final DataSupport dataSupport, final String... array) {
        return dataSupport.saveOrUpdate(array);
    }
    
    public static void saveSendInformationList(final List<SendInformationTableBean> list) {
        DataSupport.saveAll((Collection)list);
    }
    
    public static <T> boolean updateByConditions(final Class<T> clazz, final ContentValues contentValues, final String... array) {
        return DataSupport.updateAll((Class)clazz, contentValues, array) >= 0;
    }*/
}
