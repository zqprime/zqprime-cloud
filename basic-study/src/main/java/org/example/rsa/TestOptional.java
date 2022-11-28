package org.example.rsa;

import java.util.Optional;

public class TestOptional {
    public static void main(String[] args) {
        String ss = null;
        final String ss2 = Optional.ofNullable(ss).orElse(new String("xxxx"));
        System.out.println(ss2);
    }

}
