package org.leetcode.test;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class TestHttp {
    public static void main(String[] args) throws IOException, InterruptedException {
        for (int j = 0; j < 1; j++) {
            for (int i = 0; i < 20; i++) {
                new Thread(()->{
                    String uuid = UUID.randomUUID().toString().replaceAll("\\-","");
                    try {
                        pay(uuid);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    //===================退款======================
                    try {
                        refund(uuid);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }).start();
            }
//            Thread.sleep(2000);
        }

    }
    public static void pay(String uuid) throws IOException {
        CloseableHttpClient build = HttpClientBuilder.create().build();

        HttpPost request = new HttpPost("http://162.14.97.85:18080/wxqsf/wxqsfPay.do");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        System.out.println(format.format(new Date()));

        String body = "{\r\n\t\"outTradeNo\": \""+uuid+"\",\r\n\t\"contractId\": \"2022062215133861832906405639\",\r\n\t\"description\": \"第三中学-轻松付-食堂扣费\",\r\n\t\"total\": 1,\r\n\t\"startTime\": " +
                "\""+format.format(new Date())+"+08:00\",\r\n\t\"currency\": \"CNY\",\r\n\t\"sceneType\": \"CANTEEN\",\r\n\t\"sign\": \"签名内容\"\r\n}";
        HttpEntity entity = new StringEntity(body, ContentType.APPLICATION_JSON);
        System.out.println("================");
        System.out.println(body);
        System.out.println("================");
        request.setEntity(entity);
        request.setHeader("User-Agent", "Apipost client Runtime/+https://www.apipost.cn/");
        request.setHeader("Content-Type", "application/json");
        HttpResponse httpResponse = build.execute(request);
        System.out.println(httpResponse.getStatusLine());
        if (httpResponse.getEntity() != null) {
            String html = EntityUtils.toString(httpResponse.getEntity());
            System.out.println(html);
        }
    }
    public static void refund(String no) throws IOException {
        CloseableHttpClient build = HttpClientBuilder.create().build();
        String uuid = UUID.randomUUID().toString().replaceAll("\\-","");
        HttpPost request = new HttpPost("http://162.14.97.85:18080/wxqsf/refunds.do");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        System.out.println(format.format(new Date()));

        String body = "{\r\n    \"schoolId\":\"16073235139441\",\r\n    \"outTradeNo\":\""+no+"\",\r\n    \"outRefundNo\":\""+uuid+"\",\r\n    \"total\":\"1\",\r\n    \"refund\":\"1\",\r\n    \"currency\":\"CNY\",\r\n    \"sign\": \"签名内容\"\r\n}";


        HttpEntity entity = new StringEntity(body, ContentType.APPLICATION_JSON);
        System.out.println("================");
        System.out.println(body);
        System.out.println("================");
        request.setEntity(entity);
        request.setHeader("User-Agent", "Apipost client Runtime/+https://www.apipost.cn/");
        request.setHeader("Content-Type", "application/json");
        HttpResponse httpResponse = build.execute(request);
        System.out.println(httpResponse.getStatusLine());
        if (httpResponse.getEntity() != null) {
            String html = EntityUtils.toString(httpResponse.getEntity());
            System.out.println(html);
        }
    }
}
