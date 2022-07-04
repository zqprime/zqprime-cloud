package org.leetcode.lamda;

import java.util.function.Supplier;

public class TestSupplier {
    public static void main(String[] args) {
        final String supplier = supplier(TestSupplier::provider);
        System.out.println(supplier);
    }

    public static String supplier(Supplier<String> supplier){
        return supplier.get();
    }

    public static String provider(){
        return "hello ";
    }
}
