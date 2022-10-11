package org.example.rsa;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;

public class Testxxx {
    public static void main(String[] args) {
        System.out.println(yuanToFen(new BigDecimal("0.01").toString()));
    }

    private static String yuanToFen(String amount){
        NumberFormat format = NumberFormat.getInstance();
        try{
            Number number = format.parse(amount);
            double temp = number.doubleValue() * 100.0;
            format.setGroupingUsed(false);
            // 设置返回数的小数部分所允许的最大位数
            format.setMaximumFractionDigits(0);
            amount = format.format(temp);
        } catch (ParseException e){
            e.printStackTrace();
        }
        return amount;
    }

}
