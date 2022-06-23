package club.zqprime.server;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Service;

@Service
public class DemoServer {
    @SentinelResource(blockHandler = "sayHelloBlockHandler")
    public String sayHello(String name) {
        return "Hello, " + name+" A";
    }

    public String sayHelloBlockHandler(String name, BlockException ex) {
        // This is the block handler.
        ex.printStackTrace();
        return String.format("Oops, <%s> blocked by Sentinel", name);
    }
}
