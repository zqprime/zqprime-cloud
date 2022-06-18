package org.leetcode.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateTest {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-DD'T'HH:mm:ss");
        String[] split = "2017-08-26T09:43:39+07:00".split("\\+");
        format.setTimeZone(TimeZone.getTimeZone("GMT+"+split[1]));
        Date date = format.parse(split[0]);
        System.out.println(date);
    }
}
