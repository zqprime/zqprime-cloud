package org.leetcode.lamda;

import java.util.function.Consumer;

public class TestConsumer {
    public static void main(String[] args) {
        doWork(TestConsumer::say,"haha");
        doWork(TestConsumer::sayLoop,"haha");
    }

    public static void doWork(Consumer<String> consumer,String a) {
        consumer.accept(a);
    }

    public static void say(String a){
        System.out.println(a);
    }

    public static void sayLoop(String a){
        for (int i = 0; i < 20; i++) {
            System.out.println(a);
        }
    }
}
