package club.zqprime.sharding.algorithm;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
@Component
public class DatePreciseShardingAlgorithm implements PreciseShardingAlgorithm<Date> {


    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Date> shardingValue) {
        //根据日期，找到要存储的表名
        final Date value = shardingValue.getValue();
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        final String format = simpleDateFormat.format(value);
        final String[] split = format.split("-");
        String year = split[0];
        String month = String.valueOf(Integer.parseInt(split[1]));
        return shardingValue.getLogicTableName()+"_"+year+"_"+month;
    }
}
