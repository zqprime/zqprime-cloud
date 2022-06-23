package club.zqprime.pool;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PoolTest {

    public static void main(String[] args) {
        List<Foo> foos = new ArrayList<>();
        try{
            FooManager manager = new FooManager();
            for (int i = 0; i < 20; i++) {
                Foo foo = manager.borrowFoo();
                System.out.println(foo);
                System.out.println(i);
                foos.add(foo);
            }
            Thread.sleep(20000L);
            List<Foo> tmp = foos.stream().limit(13).collect(Collectors.toList());
            for (Foo foo : tmp) {
                manager.returnObject(foo);
            }
            foos.removeAll(tmp);
            System.out.println(foos.size());
            for (int i = 0; i < 20; i++) {
                Foo foo = manager.borrowFoo();
                System.out.println(foo);
                System.out.println(i);
                foos.add(foo);
            }
            Thread.sleep(500000L);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
