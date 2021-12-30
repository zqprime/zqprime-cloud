package org.example.rsa;

import org.junit.Test;

public class TestString {
    @Test
    public void testLength(){
        String ss = "哈哈，怎么了====";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            result.append(ss);
        }
        
        System.out.println(result.toString().length());
        System.out.println(result.toString());
    }
}
