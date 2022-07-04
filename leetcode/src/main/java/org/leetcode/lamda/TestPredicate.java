package org.leetcode.lamda;

import java.util.Objects;
import java.util.function.BiPredicate;

public class TestPredicate {
    public static void main(String[] args) {
        final boolean result = getResult(TestPredicate::compare, "haha", "haha");
        System.out.println(result);
    }
    public static boolean getResult(BiPredicate<String,String> predicate,String a,String b){
        return predicate.test(a,b);
    }
    public static boolean compare(String a,String b){
        return Objects.equals(a, b);
    }
}
