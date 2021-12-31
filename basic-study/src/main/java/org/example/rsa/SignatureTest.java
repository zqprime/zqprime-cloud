package org.example.rsa;

import cn.hutool.core.codec.Base64Decoder;

import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class SignatureTest {
    public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, SignatureException {
        String privateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQClGcxwa5r3sM1l3PCy1qOV1/p28wrsQ6FYFjmT6Bf\n" +
                "fyLUjE9tlVkBJyzqbnVAEAxeAKSs6XRjNL7/gM0JQHxVq/usrEDMicZy8plWjgo\n" +
                "+06FWBMf8jBUylPibTcWJsiR/E1Cs6jtabIsJpS/WScm\n" +
                "+nx94n37hbhGhFakABhHm29eixgLjxTMkzjbYr9U7sM8RtW3o3gv6wlkwqgA\n" +
                "+M46UuoGK0FUvBsl/G7KoxsHYjLa1NRs3CqaHb6k5jlXV5tmcMXnQt1EwFZdpTRvjUMSElRmxahPS7bw9gghyur9+hQ\n" +
                "L8MO/Xmt0ax0SxxGno9Niohk7rCAXfEomQCJdX1Nll3AgMBAAECggEAW/VVqJxW0XVZwk3gh0wEC5cju5M910EIIf8n\n" +
                "DNnuSkgJlEMgJX54CmI2/6wMgF\n" +
                "+UfF7x4+0svkTFU8RZQDVAAbuBExhP0vSC/5SKCKvVDUeHMJG/cSsneLZ4e7cgwiFSX5hph5E9uWUP8gRMAMjaphI\n" +
                "uC/mRPvAt/9PhWLcH8D581MRjYzIas0SKm\n" +
                "+UxMZetrISSPBxqGIJ0GpidcL3HHwLQv1A7QHpGPWckAjxgQS3YxuPGaVkhgg8D4NB5WPVpVIJs43ZYjRpNlkMsCxIY\n" +
                "y4TLnM+F2axIxtLVA/lBjf7IlKPhOkt92rQ+rURJ6nviFmG1EWH6C5Bu\n" +
                "+av3Nefs6QKBgQDQo7JRWIHmbPe4+aBiIz7n5xy/AUtuo/Ahp\n" +
                "+TdLTeqoXYvunwguQbGdiIK0BsEEV3BLOWPieC0qG6Fcnuv0kP31OzvSS8QXKF9KX2SakuBpb6Hp6jD6fRvVp7kVHi0\n" +
                "MfbHbM0G8hPyna7JFvmHq93q43WV3kE4qIzxxLKvE46jzQKBgQDKlAPNL1GYOT\n" +
                "+t7mWi92QqMX8rar2jW2jcLFqT3h3qNI++an7mZgLi3U3CEME9NTFT81oLpG63wLXKeMuL7RFmG2noNrmyflMc\n" +
                "dpUEU5DykkBxV7PeHHSR1hdmHUiZv9bbW1/wtvWlvPJNr1hriBwemgpJa52pbMJmbBSaDxI2UwKBgECxUVxZxkWNq\n" +
                "i5H8MwdQ6ciiU5Md3hCCvZUmele2PDmib/44f4/gPNOs/WIW6giPmDkq/Wa\n" +
                "+frqcwKb4fA9kWeqNSFpHtfC8SvfDpm0rd7wZqinevPseid/w1rnOlodV/i0KsqpizfiXszpe8vupavshYxH0w9fa/yXUhRp\n" +
                "SwRNAoGBAIiHUzyRXJOUWdeWaUd5JjfNniCb0u1q6PQirHUl6NF01UAHNDmBnQZbElHtyt6+n90tkI1yJ/CN37dyy/Ql\n" +
                "NWm0ph8L6wFiZA812F7PF0x0xxvceOwED4hOWvzGVazRfzPdlH5+QHaQLlmvCI\n" +
                "+IbzMsrCwpbFvIYgh3ZTcjWynjAoGAH1gW/ROMLnKXSRDN/Yigknrel5yzxa/tsWgPRsfimuwrHKNTcJI6gXKpBeC\n" +
                "+Vw0aWlWZxFgNlbrCSQEVKa1FlWfuIBacli2X0i3HdD4U67ToQ/xU9Ehl6zArLdKB2aBYYFJHowcGJFFQdeWuk3Ak9W\n" +
                "23zK6zZvp38jKJn8y4IiI=";
        String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEApRnMcGua97DNZdzwstajldf6dvMK7EOhWBY5k\n" +
                "+gX38i1IxPbZVZAScs6m51QBAMXgCkrOl0YzS\n" +
                "+/4DNCUB8Vav7rKxAzInGcvKZVo4KPtOhVgTH/IwVMpT4m03FibIkfxNQrOo7WmyLCaUv1knJvp8feJ9+4W4RoRWp\n" +
                "AAYR5tvXosYC48UzJM422K/VO7DPEbVt6N4L\n" +
                "+sJZMKoAPjOOlLqBitBVLwbJfxuyqMbB2Iy2tTUbNwqmh2+pOY5V1ebZnDF50LdRMBWXaU0b41DEhJUZsWoT0u28P\n" +
                "YIIcrq/foUC/DDv15rdGsdEscRp6PTYqIZO6wgF3xKJkAiXV9TZZdwIDAQAB";
        String str = "foo bar";
        byte[] bytes = Base64Decoder.decode(publicKey);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(bytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");

        RSAPublicKey plk = (RSAPublicKey) keyFactory.generatePublic(keySpec);
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(Base64Decoder.decode(privateKey));
        PrivateKey prk = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        Signature privateSignature = Signature.getInstance("NONEwithRSA");
        privateSignature.initSign(prk);
        privateSignature.update(str.getBytes(StandardCharsets.UTF_8));
        byte[] sign = privateSignature.sign();
        String encodeToString = Base64.getEncoder().encodeToString(sign);
        System.out.println(encodeToString);

        Signature signature = Signature.getInstance("NONEwithRSA");

        signature.initVerify(plk);
        signature.update(str.getBytes(StandardCharsets.UTF_8));
        boolean verify = signature.verify(sign);
        System.out.println(verify);
    }
}
