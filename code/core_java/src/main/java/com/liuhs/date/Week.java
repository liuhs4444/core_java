package com.liuhs.date;

import java.util.Arrays;

/**
 * <B>功能简述</B><br>
 * 星期枚举值
 *
 * @author liuhongshen
 * @date 2018/6/24 下午12:13
 */
public enum Week {

    Sunday(1, "星期日"),

    Monday(2, "星期一"), Tuesday(3, "星期二"), Wednesday(4, "星期三"),

    Thursday(5, "星期四"), Friday(6, "星期五"), Saturday(7, "星期六");

    private int index;

    private String dayStr;

    Week(int index, String dayStr) {
        this.index = index;
        this.dayStr = dayStr;
    }

    public static String get(int index) {
        final String[] dayStr = {""};
        Arrays.stream(Week.values()).filter(week -> week.index == index)
                .findAny().ifPresent(week -> dayStr[0] = week.dayStr);
        return dayStr[0];
    }
}
