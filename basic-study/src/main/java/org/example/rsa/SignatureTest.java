package org.example.rsa;

import cn.hutool.core.codec.Base64Decoder;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class SignatureTest {
    @Test
    public void testSignature() throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, SignatureException {
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC4OCd2Ru6jb84XRIa23mbI3uzd\n" +
                "MtUGBUp8AzVijwFdtUskH56aIjsuq30FGy4DQJP0mPRxWLlLy80AIJ+GOgp9s7Eu\n" +
                "gIgW44yhlUOk89KX8HoO+8LGdUqOOqjh1hS1tnGe1rwO1EoL+BPcB8uFK20fOTiR\n" +
                "/GgoerQ0ee1oD3PDPwIDAQAB";
        String str = "enterpriseParkName山纳合成橡胶有限责任公司enterpriseParkCode91140000717850635PenterpriseParkAddress山西省大同市阳高县龙泉工业园区area140221lngAndLat113.72,40.27industryType中外合资industryBranch合成橡胶制造performanceLevel3businessScope生产氯丁橡胶；生产盐酸、氢氧化钠、次氯酸钠、乙烯基乙炔、氯丁二烯、乙炔、废硫酸、二氯丁烯；corporation云华enterpriseParkPrincipal李黎enterpriseParkTel13934267055doorPostNum2transportVehicles80vehicleInFactory20mechanicInFactory30doorSystemFirmd3c69f9071244e258bb733bf2df400e1publicKey4D4947664D413047435371475349623344514542415155414134474E4144434269514B42675143344F4364325275366A6238345852496132336D624933757A640D0A4D74554742557038417A56696A7746647455736B48353661496A73757133304647793444514A50306D505278574C6C4C79383041494A2B474F677039733745750D0A67496757343479686C554F6B38394B5838486F4F2B384C476455714F4F716A6831685331746E47653172774F31456F4C2B425063423875464B3230664F5469520D0A2F47676F657251306565316F443350445077494441514142";
        byte[] bytes = Base64Decoder.decode(publicKey);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(bytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");

        RSAPublicKey plk = (RSAPublicKey) keyFactory.generatePublic(keySpec);
        String signaText = "BSXAWIqbtY/fi4jrqRLx2hQLjoXf0JjYU1YxsJDYe6g1L7Yi+XMANgpyxwuML544MuWiTbvo7zskk1Z2UiFcULLpXcpd55jV+ML2EhocvzryIVZJDaWftnBshcg8C0XPxCUXzdwig65aWh+czwALt7Cig8KmtE//J6mJS64cobg=";
        byte[] sign = Base64.getDecoder().decode(signaText);

        Signature signature = Signature.getInstance("SHA256withRSA");

        signature.initVerify(plk);
        signature.update(str.getBytes());
        boolean verify = signature.verify(sign);
        System.out.println(verify);
    }
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

    @Test
    public void testS() throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, SignatureException {
        String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAOMl9mMrTaLYDT/A\n" +
                "ptG9nNnH98jW7KOuxG9b1y+r/2/UrmLr4hLBayUVMyzysveCNo9A0yY8RECQYUI8\n" +
                "K4T0R51NK13wmB9fzHn/0zp8eTY1Ifmqz9jaNJLtL9yXF0L5NdslcLdGGCAHSL72\n" +
                "hnSgCI5ooX7Y8U6sdAJ0xr97LqOBAgMBAAECgYEAxNI5K3bzP5575Hj3U5g8GA0I\n" +
                "rJNm2vHtrhxjWiBsJqegL4D7FItaXvh+rnziDEtdIUXncCMadONmEvF2OC8++PCo\n" +
                "b4P2x+zF24WMXTaxnDOPyh7JhtTCG+oKBMQXZ+4nmH6XRkUTwUVPS/wYO4wuF5gT\n" +
                "9tcd+VVLUOO28dSojQECQQD/6B5X0pyiN4F8c6+0bX0DMvwBXRsrjgXRuar0AJsR\n" +
                "ULbW3BcClPzppxgaJK7v50JywDLcI58j8XmMSG0Ml7/RAkEA4zspACB2K2dyZ7ig\n" +
                "kr0Vxad3mkss4ImGcrvagSfLpLDb1+SeMDxRefs2Xn9bFpYxLV83etvrjpoVirsT\n" +
                "KbfEsQJBAPVcJNunf6648VnVwb2IzLfohl74Wjikb0fqcNKKUiOD9AqF8znyh5uv\n" +
                "LhjC20gBv2Auj5UqQkdAG345YvUT+kECQB4FzAYDQ/m6IkiIAVdB+mVyGgBd3GES\n" +
                "apwwK8+SxXpOD833m9r9rTozsdxMcWmLkJXRFdB6zCW8QApja0XAzRECQBcvSVgz\n" +
                "Drj8M7G+A7yOmUv+3jOhZR7yc43a1Ne6u7XRaHCH/tYJOCmEiUGfbxHKdB7goLPJ\n" +
                "AImGdHBZEVMREiQ=";
        String str = "enterpriseParkName山纳合成橡胶有限责任公司enterpriseParkCode91140000717850635PenterpriseParkAddress山西省大同市阳高县龙泉工业园区area140221lngAndLat113.72,40.27industryType中外合资industryBranch合成橡胶制造performanceLevel3businessScope生产氯丁橡胶；生产盐酸、氢氧化钠、次氯酸钠、乙烯基乙炔、氯丁二烯、乙炔、废硫酸、二氯丁烯；corporation云华enterpriseParkPrincipal李黎enterpriseParkTel13934267055doorPostNum2transportVehicles80vehicleInFactory20mechanicInFactory30doorSystemFirmd3c69f9071244e258bb733bf2df400e1publicKey30819F300D06092A864886F70D010101050003818D0030818902818100E325F6632B4DA2D80D3FC0A6D1BD9CD9C7F7C8D6ECA3AEC46F5BD72FABFF6FD4AE62EBE212C16B2515332CF2B2F782368F40D3263C44409061423C2B84F4479D4D2B5DF0981F5FCC79FFD33A7C79363521F9AACFD8DA3492ED2FDC971742F935DB2570B74618200748BEF68674A0088E68A17ED8F14EAC740274C6BF7B2EA3810203010001";
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");

        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(Base64Decoder.decode(privateKey));
        PrivateKey prk = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        Signature privateSignature = Signature.getInstance("SHA256withRSA");
        privateSignature.initSign(prk);
        privateSignature.update(str.getBytes(StandardCharsets.UTF_8));
        byte[] sign = privateSignature.sign();
        String encodeToString = Base64.getEncoder().encodeToString(sign);
        System.out.println(encodeToString);
    }
}
