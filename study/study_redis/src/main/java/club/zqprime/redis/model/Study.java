package club.zqprime.redis.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Study implements Serializable {

    private String name;

    private Integer dayNumber;
}
