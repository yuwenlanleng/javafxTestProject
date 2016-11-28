/*
 * TestLocalDateAndLocalTime.java
 * 
 * Copyright(c) 2007-2016 by Yingzhi Tech
 *` All Rights Reserved
 * 
 * Created at 2016-11-23 14:08:29
 */
package com.yzhtech.test.java8;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * 测试jdk8日期和时间
 * @author 赵洪坤 <zhaohongkun@yzhtech.com>
 */
public class TestLocalDateAndLocalTime {

    public static void main(String[] args) {
        /**
         * LocalDate
         */
        System.out.println("对于日期类型");
        //①输出当前日期
        System.out.println("①" + LocalDate.now());
        //②输出当前时间
        System.out.println("②" + LocalTime.now());
        //③根据年月日取日期，12月就是12
        System.out.println("③" + LocalDate.of(2014, 12, 25)); // -> 2014-12-25
        //④根据字符串取：// 严格按照ISO yyyy-MM-dd验证，02写成2都不行
        System.out.println("④" + LocalDate.parse("2016-11-23"));
        //⑤根据字符串取：当然也有一个重载方法允许自己定义格式
        System.out.println("⑤" + LocalDate.parse("20160203", DateTimeFormatter.ofPattern("yyyyMMdd")));
        //⑥取本月第1天：
        LocalDate firstDayOfThisMonth = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth()); // 2014-12-01
        System.out.println("⑥" + firstDayOfThisMonth);
        //⑦取本月第2天：
        LocalDate secondDayOfThisMonth = LocalDate.now().withDayOfMonth(2); // 2014-12-02
        System.out.println("⑦" + secondDayOfThisMonth);
        //⑧取本月最后一天，再也不用计算是28，29，30还是31：
        LocalDate lastDayOfThisMonth = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()); // 2014-12-31
        System.out.println("⑧" + lastDayOfThisMonth);
        //⑨取下一天：
        LocalDate firstDayOf2015 = lastDayOfThisMonth.plusDays(1); // 变成了2015-01-01
        System.out.println("⑨" + firstDayOf2015);
        //⑩取2015年1月第一个周一，这个计算用Calendar要死掉很多脑细胞：
        LocalDate firstMondayOf2015 = LocalDate.parse("2015-01-01").with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)); // 2015-01-05
        System.out.println("⑩" + firstMondayOf2015);

        /**
         * LocalTime
         */
        System.out.println("对于时间类型");
        //LocalTime包含毫秒：
        LocalTime now = LocalTime.now(); // 11:09:09.240
        System.out.println("⑪"+now);
        //你可能想清除毫秒数：
        LocalTime nowTime = LocalTime.now().withNano(0); // 11:09:09
        System.out.println("⑫"+nowTime);
        //构造时间也很简单：
        LocalTime zero = LocalTime.of(0, 0, 0); // 00:00:00
        System.out.println(zero);
        LocalTime mid = LocalTime.parse("12:00:00"); // 12:00:00
        System.out.println("⑬"+mid);
        //时间也是按照ISO格式识别，但可以识别以下3种格式：
        //12:00
        //12:01:02
        //12:01:02.345
        /**
         * JDBC使用时间
         */
        System.out.println("JDBC使用时间");
        //SQL -> Java
        //--------------------------
        //date -> LocalDate
        //time -> LocalTime
        //timestamp -> LocalDateTime
    }
}
