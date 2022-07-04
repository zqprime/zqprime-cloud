package org.leetcode.lamda;

import java.util.function.BinaryOperator;

public class TestOperator {
    public static void main(String[] args) {

    }
    public static String operator(BinaryOperator<String> operator,String a,String b) {
         return operator.apply(a,b);
    }
}
