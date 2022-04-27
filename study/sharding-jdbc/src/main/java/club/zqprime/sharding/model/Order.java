package club.zqprime.sharding.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@Data
@TableName(value = "t_order")
public class Order {

    @TableId(type = IdType.ASSIGN_ID)
    private Long orderId;

    private Long userId;

    private String orderNo;

    private String createName;

    private String price;
}
