package org.leetcode.test;

import java.nio.charset.StandardCharsets;

public class StringEncodeTest {
    public static void main(String[] args) {
        String str = " 你好啊!!";
        System.out.println(str.length());
        System.out.println(str.getBytes(StandardCharsets.UTF_8).length);
    }
}
