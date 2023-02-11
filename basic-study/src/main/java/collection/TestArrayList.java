package collection;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

@Slf4j
public class TestArrayList {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("b");
        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
            arrayList.add(UUID.randomUUID().toString());
        }
    }
}
