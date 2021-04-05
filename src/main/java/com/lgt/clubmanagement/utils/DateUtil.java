package com.lgt.clubmanagement.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class DateUtil {

    public static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";// 时间格式
    public static final String DEFAULT_FORMAT1 = "yyyy/MM/dd HH:mm:ss";// 时间格式1
    public static final String DEFAULT_FORMATS = "yyyy-MM-dd";
    public static final String DATE_FOMATE_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static final String Message_TIME = "yyyy年MM月dd日HH点mm分";

    /**
     * 格式化时间(Date 转换成String)
     *
     * @param date   时间
     * @param format 时间格式 如： DEFAULT_FORMAT= "yyyy-MM-dd HH:mm:ss"
     * @return 字符串
     */
    public static String format(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * 字符串格式化为时间
     *
     * @param dateStr 时间字符串
     * @param format  时间格式 如：DEFAULT_FORMAT1 = "yyyy/MM/dd HH:mm:ss";// 时间格式1
     * @return
     */
    public static Date parseDate(String dateStr, String format) {
        Date date = null;
        if (!StringUtils.isEmpty(dateStr)) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            try {
                date = sdf.parse(dateStr);
            } catch (ParseException e) {
                log.error(e.getMessage(), e);
            }
        }
        return date;
    }

}