package com.itheima.ssm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Yangbin
 * @create 2020-05-09 22:07
 * @Description 时间处理的工具类
 */
public class DateUtils {

    /**
     * 日期转字符串
     * @param date
     * @param ptt   指定的字符串格式
     * @return
     */
    public static String date2String(Date date ,String ptt){
        //指定格式
        SimpleDateFormat sdf = new SimpleDateFormat(ptt);
        //将日期转换为字符串
        String format = sdf.format(date);
        //返回转换的字符串
        return format;
    }

    /**
     * 字符串转换为日期
     * @param str   需要转换的字符串
     * @param ptt   转换的格式
     * @return
     */
    public static Date string2Date(String str, String ptt) throws ParseException {
        //指定格式
        SimpleDateFormat sdf = new SimpleDateFormat(ptt);
        //将字符串转换为日期
        Date parse = sdf.parse(str);
        //返回转换的日期
        return parse;
    }


}
