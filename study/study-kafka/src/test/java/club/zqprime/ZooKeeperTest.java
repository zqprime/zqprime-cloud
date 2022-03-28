package club.zqprime;

import club.zqprime.kafka.StudyKafkaMain;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {StudyKafkaMain.class})
public class ZooKeeperTest {
    @Resource(name = "zookeeperCluster")
    private ZooKeeper zooKeeper;

    public void testPrintZookeeper(String path) throws InterruptedException, KeeperException{
        List<String> kafka = zooKeeper.getChildren("/kafka", new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println(watchedEvent);
            }
        });
        System.out.println(path);
        System.out.println(kafka);
        if(!kafka.isEmpty()){
            kafka.forEach(e->{
                String s = new String(e.getBytes(StandardCharsets.UTF_8));
                if(!"cluster".equals(s) && !"controller_epoch".equals(s)){
                    try {
                        testPrintZookeeper(path+"/"+s);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });
        }
    }

    @Test
    public void testZookeeper() throws InterruptedException, KeeperException {
        testPrintZookeeper("/kafka");
        System.out.println(zooKeeper);
    }
}
