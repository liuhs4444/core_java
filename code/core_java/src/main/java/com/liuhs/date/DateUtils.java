package com.liuhs.date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static java.util.Calendar.*;


/**
 * <B>功能简述</B><br>
 * 日期处理工具
 *
 * @author liuhongshen
 * @date 2018/6/24 上午9:53
 */
public class DateUtils {

    private static final Logger log = LoggerFactory.getLogger(DateUtils.class);

    private static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * <B>功能简述</B><br>
     * 字符串日期转date
     *
     * @param dateStr
     * @return
     * @date 2018/6/24 上午9:54
     * @author liuhongshen
     */
    public static Date strToDate(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE_PATTERN);
        Date date = null;

        try {
            date = sdf.parse(dateStr);
        } catch (Exception e) {
            log.error("[日期]dateStr_{}转date异常：", dateStr, e);
        }

        return date;
    }

    /**
     * <B>功能简述</B><br>
     * date日期转字符串日期
     *
     * @param date
     * @return
     * @date 2018/6/24 上午9:56
     * @author liuhongshen
     */
    public static String dateToStr(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE_PATTERN);
        String strDate = null;

        try {
            strDate = sdf.format(date);
        } catch (Exception e) {
            log.error("[日期]date_{}转字符串日期异常：", date, e);
        }

        return strDate;
    }

    /**
     * <B>功能简述</B><br>
     * date日期转字符串日期，指定日期格式
     *
     * @param date
     * @param format
     * @return
     * @date 2018/6/24 上午10:02
     * @author liuhongshen
     */
    public static String dateToStr(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String strDate = null;

        try {
            strDate = sdf.format(date);
        } catch (Exception e) {
            log.error("[日期]date_{}转字符串日期异常：", date, e);
        }

        return strDate;
    }

    /**
     * <B>功能简述</B><br>
     * 获取下一天的日期
     *
     * @param today
     * @return
     * @date 2018/6/24 上午10:15
     * @author liuhongshen
     */
    public static Date getNextDay(Date today) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(DATE, 1);
        return calendar.getTime();
    }

    /**
     * <B>功能简述</B><br>
     * 获取给定日期是星期几（中文）
     *
     * @param date
     * @return
     * @date 2018/6/24 上午11:17
     * @author liuhongshen
     */
    public static String getDayOfWeekCN(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return Week.get(calendar.get(DAY_OF_WEEK));
    }

    /**
     * <B>功能简述</B><br>
     * 获取给定日期所在月的第一天
     *
     * @param date
     * @return
     * @date 2018/6/24 下午3:29
     * @author liuhongshen
     */
    public static Date getFirstDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    /**
     * <B>功能简述</B><br>
     * 获取给定日期所在月的最后一天
     *
     * @param date
     * @return
     * @date 2018/6/24 下午4:13
     * @author liuhongshen
     */
    public static Date getLastDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(DAY_OF_MONTH, calendar.getActualMaximum(DAY_OF_MONTH));
        return calendar.getTime();
    }

    private DateUtils() {
    }
}
