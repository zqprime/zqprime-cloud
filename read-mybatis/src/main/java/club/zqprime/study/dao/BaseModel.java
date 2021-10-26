package club.zqprime.study.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class BaseModel {
    @TableId(value = "id",type = IdType.ASSIGN_ID)
    private Long id;
}
