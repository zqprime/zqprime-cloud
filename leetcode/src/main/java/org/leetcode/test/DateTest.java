package org.leetcode.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.UUID;

public class DateTest {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        System.out.println(format.format(new Date()));
        System.out.println(UUID.randomUUID().toString().replace("-",""));
    }
}
