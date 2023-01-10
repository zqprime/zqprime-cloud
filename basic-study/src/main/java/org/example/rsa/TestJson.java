package org.example.rsa;

import com.alibaba.fastjson.JSON;
import lombok.Data;

public class TestJson {

    @Data
    public static class Obj{
        private String id;
        private String tableId;
    }

    public static void main(String[] args) {
        final Obj obj = new Obj();
        obj.setId("xxxx|");
        obj.setTableId("uuuuu");
//        String str = "{\"id\":\"ea38ddd51d0e4a41ad9d94695826fb89\",\"tableId\":\"ce125a5bc3ce475a92eff8c66b68768f\"}";
//        final Obj parseObject = JSON.parseObject(str, Obj.class);
        final String string = JSON.toJSONString(obj);
        System.out.println(string);
        System.out.println(JSON.parseObject(string,Obj.class));
    }
}
