package org.leetcode.test;

import java.util.*;

public class ListTest {
    public static void main(String[] args) {
        Random random = new Random();
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            A a = new A();
            a.setName(UUID.randomUUID().toString());
            a.setSource(random.nextInt(20));
            list.add(a);
        }
        List<?> l = list;
        Optional first = l.stream().map(e -> (A) e).findFirst();
        System.out.println(first.get());
    }

    public static class A{
        private String name;
        private Integer source;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getSource() {
            return source;
        }

        public void setSource(Integer source) {
            this.source = source;
        }
    }
}
