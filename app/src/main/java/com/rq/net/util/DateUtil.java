package com.rq.net.util;

import java.sql.*;
import java.sql.Date;
import java.util.*;
import java.text.*;
import java.util.concurrent.*;

public final class DateUtil
{
    public static final String DEFAULT_DATE = "yyyyMMdd";
    public static final String DEFAULT_DATE_HOUR = "yyyy/MM/dd HH";
    public static final String DEFAULT_DATE_HOUR_FORMAT = "yyyyMMddHH";
    public static final String DEFAULT_DATE_SECOND_FORMAT = "yyyyMMddHHmmss";
    public static final String DEFAULT_DATE_SLASH = "yyyy/MM/dd";
    public static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DEFAULT_FORMAT_DATE = "yyyy-MM-dd";
    public static final String DEFAULT_FORMAT_HOUR = "HH:mm";
    public static final String DEFAULT_FORMAT_TIME = "HH:mm:ss";
    public static final String DEFAULT_TIME = "yyyyMMdd HHmmss";
    public static SimpleDateFormat defaultDate;
    public static SimpleDateFormat defaultDateDay;
    public static SimpleDateFormat defaultDateFormat;
    public static SimpleDateFormat defaultDateHour;
    public static SimpleDateFormat defaultDateHourFormat;
    public static SimpleDateFormat defaultDateSecondFormat;
    public static SimpleDateFormat defaultDateTimeFormat;
    public static SimpleDateFormat defaultHourFormat;
    public static SimpleDateFormat defaultSlashDate;
    public static SimpleDateFormat defaultTime;
    public static SimpleDateFormat defaultTimeFormat;
    
    static {
        DateUtil.defaultDateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateUtil.defaultDateHour = new SimpleDateFormat("yyyy/MM/dd HH");
        DateUtil.defaultDateHourFormat = new SimpleDateFormat("yyyyMMddHH");
        DateUtil.defaultDateSecondFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        DateUtil.defaultDateDay = new SimpleDateFormat("yyyyMMdd");
        DateUtil.defaultTime = new SimpleDateFormat("yyyyMMdd HHmmss");
        DateUtil.defaultDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateUtil.defaultDate = new SimpleDateFormat("yyyyMMdd");
        DateUtil.defaultSlashDate = new SimpleDateFormat("yyyy/MM/dd");
        DateUtil.defaultTimeFormat = new SimpleDateFormat("HH:mm:ss");
        DateUtil.defaultHourFormat = new SimpleDateFormat("HH:mm");
    }
    
    private DateUtil() {
    }
    
    public static String dateFormat(final String s, final String s2) {
        return dateSimpleFormat(Date.valueOf(s), new SimpleDateFormat(s2));
    }
    
    public static String dateFormat(final java.util.Date date, final String s) {
        return dateSimpleFormat(date, new SimpleDateFormat(s));
    }
    
    public static String dateSimpleFormat(final java.util.Date date, final SimpleDateFormat simpleDateFormat) {
        SimpleDateFormat defaultDateTimeFormat = simpleDateFormat;
        if (simpleDateFormat == null) {
            defaultDateTimeFormat = DateUtil.defaultDateTimeFormat;
        }
        if (date == null) {
            return "";
        }
        return defaultDateTimeFormat.format(date.getTime());
    }
    
    public static long get12HourDayMillise(final int n) {
        return getDate(getCurrentYear(), getCurrentMonth(), getDayOfMonth() - n, 12, 0, 0).getTime();
    }
    
    public static String getBeforeYesterday() {
        final Calendar instance = Calendar.getInstance();
        instance.add(5, -2);
        return getDateFormat(instance.getTime());
    }
    
    public static java.util.Date getCalcDate(final java.util.Date time, final int n) {
        final Calendar instance = Calendar.getInstance();
        instance.setTime(time);
        instance.add(5, n);
        return instance.getTime();
    }
    
    public static String getCalcDateFormat(final String s, final int n) {
        return getDateFormat(getCalcDate(getDateByDateFormat(s), n));
    }
    
    public static String getCurrentDateSecond() {
        return getDateSecondFormat(Calendar.getInstance().getTime());
    }
    
    public static String getCurrentDateTime() {
        return getDateTimeFormat(Calendar.getInstance().getTime());
    }
    
    public static final int getCurrentDayOfMonth() {
        return Calendar.getInstance().get(5);
    }
    
    public static final int getCurrentDayOfWeek() {
        return Calendar.getInstance().get(7) - 1;
    }
    
    public static int getCurrentMonth() {
        return Calendar.getInstance().get(2);
    }
    
    public static int getCurrentYear() {
        return Calendar.getInstance().get(1);
    }
    
    public static java.util.Date getDate(final int n, final int n2, final int n3) {
        final Calendar instance = Calendar.getInstance();
        instance.set(n, n2 - 1, n3);
        return instance.getTime();
    }
    
    public static java.util.Date getDate(final int n, final int n2, final int n3, final int n4, final int n5, final int n6) {
        final Calendar instance = Calendar.getInstance();
        instance.set(n, n2, n3, n4, n5, n6);
        return instance.getTime();
    }
    
    public static java.util.Date getDateByDateFormat(final String s) {
        return getDateByFormat(s, DateUtil.defaultDateFormat);
    }
    
    public static java.util.Date getDateByDateTimeFormat(final String s) {
        return getDateByFormat(s, DateUtil.defaultDateTimeFormat);
    }
    
    public static java.util.Date getDateByFormat(final String s, final String s2) {
        return getDateByFormat(s, new SimpleDateFormat(s2));
    }
    
    private static java.util.Date getDateByFormat(final String s, final SimpleDateFormat simpleDateFormat) {
        SimpleDateFormat defaultDateTimeFormat = simpleDateFormat;
        if (simpleDateFormat == null) {
            defaultDateTimeFormat = DateUtil.defaultDateTimeFormat;
        }
        try {
            return defaultDateTimeFormat.parse(s);
        }
        catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static String getDateFormat(final int n, final int n2, final int n3) {
        return getDateFormat(getDate(n, n2, n3));
    }
    
    public static String getDateFormat(final java.util.Date date) {
        return dateSimpleFormat(date, DateUtil.defaultDateFormat);
    }
    
    public static String getDateFromMillis(final long n) {
        return getDateFormat(new java.util.Date(n));
    }
    
    public static String getDateHourFromMillis(final long n) {
        return getHourFormat(new java.util.Date(n));
    }
    
    public static String getDateHourFromMillisSS(final long n) {
        return getTimeFormat(new java.util.Date(n));
    }
    
    public static String getDateSecondFormat(final java.util.Date date) {
        return dateSimpleFormat(date, DateUtil.defaultDateSecondFormat);
    }
    
    public static String getDateTimeFormat(final java.util.Date date) {
        return dateSimpleFormat(date, DateUtil.defaultDateTimeFormat);
    }
    
    public static String getDateTimeFromMillis(final long n) {
        return getDateTimeFormat(new java.util.Date(n));
    }
    
    public static long getDayMillise(final int n) {
        return TimeUnit.DAYS.toMillis(n);
    }
    
    public static int getDayOfMonth() {
        return Calendar.getInstance().get(5);
    }
    
    public static String getDetaultDateFromMillis(final long n) {
        return dateSimpleFormat(new java.util.Date(n), DateUtil.defaultDate);
    }
    
    public static String getDetaultFormatDateFromMillis(final long n) {
        return dateSimpleFormat(new java.util.Date(n), DateUtil.defaultSlashDate);
    }
    
    public static long getDistDates(final java.util.Date time, final java.util.Date time2) {
        final Calendar instance = Calendar.getInstance();
        instance.setTime(time);
        final long timeInMillis = instance.getTimeInMillis();
        instance.setTime(time2);
        return Math.abs(instance.getTimeInMillis() - timeInMillis) / 86400000L;
    }
    
    public static String getHourFormat(final java.util.Date date) {
        return dateSimpleFormat(date, DateUtil.defaultHourFormat);
    }
    
    public static String getHourFromMillis(final long n) {
        return dateSimpleFormat(new java.util.Date(n), DateUtil.defaultDateHour);
    }
    
    public static long getHourMillise(final int n, final int n2, final int n3, final int n4) {
        return getDate(getCurrentYear(), getCurrentMonth(), getDayOfMonth() + n, n2, n3, n4).getTime();
    }
    
    public static String getHourMinuteByMillise(final long n) {
        synchronized (DateUtil.class) {
            final StringBuffer sb = new StringBuffer();
            final int n2 = (int)(n / 1000L);
            final int n3 = n2 / 60;
            final int n4 = n2 / 3600;
            if (n4 > 0 && n4 < 60) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append(n4);
                sb2.append(" \u5c0f\u65f6");
                sb.append(sb2.toString());
                final int n5 = n2 % 3600 / 60;
                if (n5 > 0) {
                    final StringBuilder sb3 = new StringBuilder();
                    sb3.append(n5);
                    sb3.append(" \u5206\u949f");
                    sb.append(sb3.toString());
                }
            }
            else if (n3 > 0 && n3 < 60) {
                final StringBuilder sb4 = new StringBuilder();
                sb4.append(n3);
                sb4.append(" \u5206\u949f");
                sb.append(sb4.toString());
            }
            return sb.toString();
        }
    }
    
    public static String getHourMinuteByMinute(int n) {
        synchronized (DateUtil.class) {
            final StringBuffer sb = new StringBuffer();
            final int n2 = n / 60;
            n %= 60;
            if (n2 > 0 && n2 < 60) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append(n2);
                sb2.append(" \u5c0f\u65f6");
                sb.append(sb2.toString());
                if (n > 0) {
                    final StringBuilder sb3 = new StringBuilder();
                    sb3.append(n);
                    sb3.append(" \u5206\u949f");
                    sb.append(sb3.toString());
                }
            }
            else if (n > 0) {
                final StringBuilder sb4 = new StringBuilder();
                sb4.append(n);
                sb4.append(" \u5206\u949f");
                sb.append(sb4.toString());
            }
            return sb.toString();
        }
    }
    
    public static long getIntervalDays(final String s, final String s2) {
        return (Date.valueOf(s2).getTime() - Date.valueOf(s).getTime()) / 86400000L;
    }
    
    public static long getMilliseByDateDayFormat(final String s) {
        return getDateByFormat(s, DateUtil.defaultDateDay).getTime();
    }
    
    public static long getMilliseByDateFormat(final String s) {
        return getDateByFormat(s, DateUtil.defaultDateFormat).getTime();
    }
    
    public static long getMilliseByDateHourFormat(final String s) {
        return getDateByFormat(s, DateUtil.defaultDateHourFormat).getTime();
    }
    
    public static long getMilliseByDateSecondFormat(final String s) {
        return getDateByFormat(s, DateUtil.defaultDateSecondFormat).getTime();
    }
    
    public static long getMilliseByDateTimeFormat(final String s) {
        return getDateByFormat(s, DateUtil.defaultDateTimeFormat).getTime();
    }
    
    public static long getMilliseByTimeFormat(final String s) {
        return getDateByFormat(s, DateUtil.defaultTime).getTime();
    }
    
    public static String getMonday(final int n) {
        final Calendar instance = Calendar.getInstance();
        instance.setFirstDayOfWeek(2);
        instance.add(5, n * -7);
        instance.set(7, 2);
        return new SimpleDateFormat("yyyy-MM-dd").format(instance.getTime());
    }
    
    public static int getMonthManyDay(final String s) {
        final Calendar instance = Calendar.getInstance();
        instance.setTime(getDateByFormat(s, DateUtil.defaultDateFormat));
        return instance.getActualMaximum(5);
    }
    
    public static String getOtherDay(final int n) {
        final Calendar instance = Calendar.getInstance();
        instance.add(5, n);
        return getDateFormat(instance.getTime());
    }
    
    public static String getSunday(final int n) {
        final Calendar instance = Calendar.getInstance();
        instance.setFirstDayOfWeek(2);
        instance.add(5, n * -7);
        instance.set(7, 1);
        return new SimpleDateFormat("yyyy-MM-dd").format(instance.getTime());
    }
    
    public static String getTimeFormat(final java.util.Date date) {
        return dateSimpleFormat(date, DateUtil.defaultTimeFormat);
    }
    
    public static String getToday() {
        return getDateFormat(Calendar.getInstance().getTime());
    }
    
    public static int[] getYearMonthAndDayFrom(final String s) {
        return getYearMonthAndDayFromDate(getDateByDateFormat(s));
    }
    
    public static int[] getYearMonthAndDayFromDate(final java.util.Date time) {
        final Calendar instance = Calendar.getInstance();
        instance.setTime(time);
        return new int[] { instance.get(1), instance.get(2), instance.get(5) };
    }
    
    public static String getYesterday() {
        final Calendar instance = Calendar.getInstance();
        instance.add(5, -1);
        return getDateFormat(instance.getTime());
    }
    
    public static long getZeroDayMillise() {
        return getDate(getCurrentYear(), getCurrentMonth(), getDayOfMonth(), 0, 0, 0).getTime();
    }
    
    public static long getZeroOtherDayMillise(final int n) {
        final StringBuilder sb = new StringBuilder();
        sb.append(getOtherDay(n));
        sb.append(" 00:00:00");
        return getMilliseByDateTimeFormat(sb.toString());
    }
    
    public static String getfirstDayofMonth(final int n) {
        final Calendar instance = Calendar.getInstance();
        instance.add(2, n * -30);
        instance.set(5, 1);
        return new SimpleDateFormat("yyyy-MM-dd").format(instance.getTime());
    }
    
    public static String getlastDayofMonth(final int n) {
        final Calendar instance = Calendar.getInstance();
        instance.add(5, n * -30);
        instance.set(5, 1);
        return new SimpleDateFormat("yyyy-MM-dd").format(instance.getTime());
    }
}
