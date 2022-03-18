package club.zqprime.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.URI;

/**
 * @author zqprime
 */
public class HdfsClient {

    FileSystem fs;

    @Before
    public void init() throws Exception{
        URI uri = new URI("hdfs://172.37.0.2:9000");
        Configuration configuration = new Configuration();
        configuration.set("dfs.client.block.write.replace-datanode-on-failure.policy","NEVER");
        configuration.set("dfs.client.block.write.replace-datanode-on-failure.enable","true");
        fs = FileSystem.get(uri, configuration);
    }

    @After
    public void destroy() throws Exception{
        fs.close();
    }

    @Test
    public void testMkdir() throws Exception{
        boolean mkdirs = fs.mkdirs(new Path("/haha"));
        System.out.println(mkdirs);
    }

    @Test
    public void testPut() throws Exception{
        fs.copyFromLocalFile(false,false,new Path("./src/main/resources/weiguo.txt"),new Path("/haha"));
    }

    @Test
    public void testAppend() throws Exception{
        FSDataOutputStream outputStream = fs.append(new Path("/sanguo/shuguo.txt"));
        outputStream.write("\nguojia".getBytes());
        outputStream.close();
    }
}
