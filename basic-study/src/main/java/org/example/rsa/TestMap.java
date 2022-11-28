package org.example.rsa;

import java.util.*;

public class TestMap {
    public static void main(String[] args) {
        Map<String,String> A = new HashMap<>();
        A.put("A","a");
        A.put("B","c");
        A.put("C","c");

        List<String> B = new ArrayList<>();
        B.add("B");
        B.add("C");
        B.forEach(A.keySet()::remove);

        System.out.println(A);
    }
}
