package club.zqprime.sharding.algorithm;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Date;
@Component
public class DatePreciseShardingAlgorithm implements PreciseShardingAlgorithm<Date> {


    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Date> shardingValue) {
        System.out.println("");
        return null;
    }
}
