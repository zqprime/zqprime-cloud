package collection;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Iterator;

@Slf4j
public class TestArrayList {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("e");
        arrayList.add("f");
        arrayList.add("g");
        arrayList.add("h");
        Iterator<String> iterator = arrayList.iterator();
        int i = 0;
        int size = arrayList.size();
        while (iterator.hasNext()) {
            i++;
            String next = iterator.next();
            arrayList.add("xxx");
            arrayList.remove("xxx");
            System.out.println(next);
            if(size > i){
                arrayList.set(i,"0");
            }

        }
    }
}
