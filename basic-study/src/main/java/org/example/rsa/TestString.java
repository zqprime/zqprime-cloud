package org.example.rsa;

import org.junit.Test;

import java.util.Optional;

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


    @Test
    public void testLength2(){
       String value =  Optional.<String>empty().orElse("xxxx");
        System.out.println(value);
    }
}
