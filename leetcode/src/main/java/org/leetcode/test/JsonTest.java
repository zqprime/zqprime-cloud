package org.leetcode.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Objects;

public class JsonTest {
    public static void main(String[] args) {
        JSONObject object = new JSONObject();
        object.put("a","A");
        object.put("b","B");
        object.put("c","C");
        System.out.println(object.toString());
        System.out.println(object.toJSONString());
        System.out.println(JSON.toJSON(object));

        String s = "{\"result\":true,\"code\":200,\"msg\":\"\",\"errorMsg\":null,\"obj\":null}";
        JSONObject jsonObject = JSON.parseObject(s);
        Object code = jsonObject.get("code");
        System.out.println(Objects.equals(String.valueOf(code), "200"));
    }
}
