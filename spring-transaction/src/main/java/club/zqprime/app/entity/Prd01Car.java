package club.zqprime.app.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 汽车
 * </p>
 *
 * @author baomidou
 * @since 2022-10-11
 */
@Data
@TableName("prd01_car")
public class Prd01Car implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @TableField(value = "name")
    private String name;

    @TableField(value = "price")
    private BigDecimal price;

    @TableField(value = "version")
    private Integer version;

    @TableField(value = "is_delete")
    private Boolean isDelete;
}
