package club.zqprime.study.dao;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName(value = "hotel")
public class Hotel extends BaseModel{

    @TableField(value = "hotel_name")
    private String hotelName;

    @TableField(value = "hotel_code")
    private String hotelCode;

}
