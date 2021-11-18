package org.example.rsa;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.rsa.crypto.KeyStoreKeyFactory;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.text.ParseException;
import java.util.Base64;
import java.util.Date;

public class TestRsa {

    @Test
    public void getKeys() {
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource("jwt.jks"), "zqprime".toCharArray());
        KeyPair keyPair = keyStoreKeyFactory.getKeyPair("jwt", "zqprime".toCharArray());
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();

        RSAKey key = new RSAKey.Builder(publicKey).build();
        JSONObject object = new JWKSet(key).toJSONObject();
        JSONArray keys = (JSONArray)object.get("keys");
        Object[] objects = keys.toArray();
        JSONObject jsonObject = (JSONObject) objects[0];
        Object n = jsonObject.get("n");
//        return n.toString();
    }

    public String getPublicKey() throws ParseException {
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource("jwt.jks"), "zqprime".toCharArray());
        KeyPair keyPair = keyStoreKeyFactory.getKeyPair("jwt", "zqprime".toCharArray());
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAKey key = new RSAKey.Builder(publicKey).build();
        JSONObject object = new JWKSet(key).toJSONObject();
        JSONArray keys = (JSONArray)object.get("keys");
        Object[] objects = keys.toArray();
        JSONObject jsonObject = (JSONObject) objects[0];
        Object n = jsonObject.get("n");
        return n.toString();
    }
    public String a(String a,StringBuffer b){
        System.out.println(b);
        a = "haha";
        b.append("xxx");
        return a;
    }
    public static void main(String[] args) throws ParseException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException {
        TestRsa rsa = new TestRsa();

    }



    private static void extracted() {
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource("jwt.jks"), "zqprime".toCharArray());
        KeyPair keyPair = keyStoreKeyFactory.getKeyPair("jwt", "zqprime".toCharArray());
        byte[] encoded = keyPair.getPrivate().getEncoded();
        System.out.println(encoded.length);
        String string = Base64.getEncoder().encodeToString(encoded);
        System.out.println(string);
        System.out.println("===============");

        byte[] pencoded = keyPair.getPublic().getEncoded();
        String pstring = Base64.getEncoder().encodeToString(pencoded);
        System.out.println(pstring);
    }

    @Test
    public void deTest() throws Exception {
        String enStr = "enK1b6iqgq0N5LThpmXr3CXFnUlPjHBOClzD3BizYjOt7pEhYX/IV/6m/gAshdPAvXVvJOR1cvq1FfTkJ76wlUDGjBDe4L9wiub8E6bFOCrbdHXA/khF/Q49VJD/vOj4WBmLhmxVV0kPXass5cy/n0jCJ/YMENu7LSZvVcHpeeGuVuMs+KGGCVukipjYZKvxpN8XxHE7dh++xVIK+7et7Yw9APqilZpg9RR7tgebXZsULgK5wEiH7oJq23crgFNLP3ifNqO82tnd16/iWPimsJrUr0ekmq9rXxNPAcFedXHtGBYlfAFt4oqhxWWNOJ0iU9uLYhQmhz/HXNlT7Wj1TA==";
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource("jwt.jks"), "zqprime".toCharArray());
        KeyPair keyPair = keyStoreKeyFactory.getKeyPair("jwt", "zqprime".toCharArray());
        PrivateKey privateKey = keyPair.getPrivate();
        Cipher cipher = Cipher.getInstance(privateKey.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE,privateKey);
        byte[] bytes = cipher.doFinal(Base64.getDecoder().decode(enStr));
        System.out.println(new String(bytes));

    }
    @Test
    public void privateKeyTest() throws JOSEException {
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource("jwt.jks"), "zqprime".toCharArray());
        KeyPair keyPair = keyStoreKeyFactory.getKeyPair("jwt", "zqprime".toCharArray());
        PrivateKey privateKey = keyPair.getPrivate();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAKey key = new RSAKey.Builder(publicKey).build();
        JSONObject jsonObject = new JWKSet(key).toJSONObject();
        System.out.println(jsonObject);

//        System.out.println(privateKey.getFormat());
//        JWSHeader header = new JWSHeader.Builder(new JWSAlgorithm(privateKey.getAlgorithm()))
        JWSHeader header = new JWSHeader.Builder(JWSAlgorithm.RS256)
                .type(JOSEObjectType.JWT)
                .build();
        JSONObject object = new JSONObject();
        object.put("name","张三");
        object.put("date",new Date());

        Payload payload = new Payload(object);
        JWSObject jwsObject = new JWSObject(header, payload);
        RSASSASigner signer = new RSASSASigner(privateKey, true);

        jwsObject.sign(signer);
        String serialize = jwsObject.serialize();
        System.out.println(serialize);
    }

    @Test
    public void descTest() {
//        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJuYW1lIjoi5byg5LiJIn0.oyavsxXEyJl4m3jb_Yys7RS63Rhyj8lnumOM6ui6OnQ31-mFtKYde84Puy7oMCKbReUOrxTZicCosie6HdWKQSieetjTONR-OlcA5sJ5eQscp-o5-RHAn2-L3NhsJsGWnhAV6MM1nGVvp5b1zL0w3GaZyfwpLe9BaIED93jo8Wg-2Zcg0aU7Yv2vpqT-MSTDoP88MnGzIGtFwzqE934XOMsBocRQF4Ytc7A7Cjcls2CprZhuurKkjj_zykbzyCaLjg_Tq5T7ypIDagvfH7rIZDhaiujA9ifK7hhRKReO99Kx9EPCEH5Fywkpf2sfCnO6fFue6oyHquBy9s6HztqYqw";
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJkYXRlIjoiVHVlIE5vdiAwMiAxNTo1Njo0MiBDU1QgMjAyMSIsIm5hbWUiOiLlvKDkuIkifQ.mORli6uFFm9tzSao7AWzYmW6uu7gxBhrme_dXhZthQw8KA2ZIe0aZ-Z3Fvnsq-WrNXb3b_03CgGOcdzOInUOSANbOVyLj9YImAH1Y1rhe84HwGbBTlhYiXhBx1MKvBb-t7Ivv35SDXlf6k2Je_QMGYSqBkMhVv0MdO7m81CBcHSUM0SUrnQksB8StTy-pTdtyv8CfI9VFvIpDVk0SRArA30NbG1MqmkHVZVkg2SoSsWK0PYxGwXzttu4wwf8d9T6nD8wbk1GYSeUCQt-d-A9HLkdbqvKuPPP-As91vm53xTO_CKt1meAOyGLqpH0Dp8sD6iq6mq1Raqw-2EhG4F7og";
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource("jwt.jks"), "zqprime".toCharArray());
        KeyPair keyPair = keyStoreKeyFactory.getKeyPair("jwt", "zqprime".toCharArray());
        RSAPublicKey publicKey =  (RSAPublicKey) keyPair.getPublic();

        try {
            JWSObject jwsObject = JWSObject.parse(token);
            JWSVerifier jwsVerifier = new RSASSAVerifier(publicKey);
            if (!jwsObject.verify(jwsVerifier)) {
                System.out.println("token签名不合法！");
            }
            String payload = jwsObject.getPayload().toString();
            System.out.println(payload);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (JOSEException e) {
            e.printStackTrace();
        }

    }
}
