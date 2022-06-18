package org.leetcode.test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.Signature;
import java.security.cert.*;

public class SignUtil {
    public static void main(String[] args) throws Exception {
        Signature signature = Signature.getInstance("SHA256withRSA");
        //证书
//        FileInputStream inputStream = new FileInputStream("D:\\IdeaProjects\\zqprime-cloud\\leetcode\\src\\main\\java\\org\\leetcode\\test\\sign.cer");
        CertificateFactory factory = CertificateFactory.getInstance("X.509");
        String xxx = "-----BEGIN CERTIFICATE-----\nMIID3DCCAsSgAwIBAgIUQSWsxTeYV6RGFlYfMUSUIy/Q1K8wDQYJKoZIhvcNAQELBQAwXjELMAkGA1UEBhMCQ04xEzARBgNVBAoTClRlbnBheS5jb20xHTAbBgNVBAsTFFRlbnBheS5jb20gQ0EgQ2VudGVyMRswGQYDVQQDExJUZW5wYXkuY29tIFJvb3QgQ0EwHhcNMTkwODI3MDc0NzI1WhcNMjQwODI1MDc0NzI1WjBuMRgwFgYDVQQDDA9UZW5wYXkuY29tIHNpZ24xEzARBgNVBAoMClRlbnBheS5jb20xHTAbBgNVBAsMFFRlbnBheS5jb20gQ0EgQ2VudGVyMQswCQYDVQQGDAJDTjERMA8GA1UEBwwIU2hlblpoZW4wggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQC+Jdq9/GTHXSaEoUMklaDPBEXOZGNae8IIF4Fqlb5gmTTlyS9KbGwuMJCpDP9/ht/v86ETyBl8JVM4AfeYs+W0KcGgAOssUspUnONrVUc5wTmsxqTiMW0NfQ+j0BdRehyLwccNkBZhfdtx5gMYuRe+lpIRgajQSOBicI9O/u6jzf4NgJfDbDUcFVn1TRr4vDTEet42kuNBUpukHL+35mE53fyGz1F9lAlYgLvzej5Wq9FrxF4GkY2yiwjhLyPks3/jDNGJkI7xTrANf8UBQyn90WmGI8GSKD15viKkHR0UJJyLP7/Z9S7FgAV75rd6OURIo4N1m4Rdb0kI1DS0XIy9AgMBAAGjgYEwfzAJBgNVHRMEAjAAMAsGA1UdDwQEAwIE8DBlBgNVHR8EXjBcMFqgWKBWhlRodHRwOi8vZXZjYS5pdHJ1cy5jb20uY24vcHVibGljL2l0cnVzY3JsP0NBPTFCRDQyMjBFNTBEQkMwNEIwNkFEMzk3NTQ5ODQ2QzAxQzNFOEVCRDIwDQYJKoZIhvcNAQELBQADggEBAJLI42cNfSNWhqZxwlHNxC4NkiNwu7iZizsWff4UjHwHT6QRsq+3PtMIxgnzYWSDG4eMaANg18y5wvyAKrLp0JIhmKdoJ0a00ZISwFWFCh/2KStb2x1EPDujsuE5nBVKhOmlrW3LWErcM0ugdqyQUXO8a0W0wiXWUtkgXfUmwtrXvc+EiW8sNRs6fHYcz/OnFSB+fPtTqgfzr5BfnZOTjDdbnOoTIoO28i7ZjqKI/9O+H//UKk3hezS7fp6pqVovNsQq/bwwF/Z9A9wDXLWWvbN7eleDzUi6jxPrKeex+oR4vkrA2wMnigdOmBk0LFpvQuf9xGdsFFXXry0+p96PMZE=\n-----END CERTIFICATE-----";
        System.out.println(xxx);
        ByteArrayInputStream stream = new ByteArrayInputStream(xxx.getBytes(StandardCharsets.UTF_8));
//        Certificate cert = factory.generateCertificate(stream);
        X509Certificate certificate = loadCertificate(stream);
//        inputStream.close();
        signature.initVerify(certificate);
        //签名
        String body = "asdfasdfsa";
        //报文
        String signTxt = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
        signature.update(body.getBytes(StandardCharsets.UTF_8));
        boolean verify = signature.verify(signTxt.getBytes(StandardCharsets.UTF_8));
        System.out.println(verify);

    }

    public static X509Certificate loadCertificate(InputStream inputStream) {
        try {
            CertificateFactory cf = CertificateFactory.getInstance("X509");
            X509Certificate cert = (X509Certificate) cf.generateCertificate(inputStream);
            cert.checkValidity();
            return cert;
        } catch (CertificateExpiredException e) {
            throw new RuntimeException("证书已过期", e);
        } catch (CertificateNotYetValidException e) {
            throw new RuntimeException("证书尚未生效", e);
        } catch (CertificateException e) {
            throw new RuntimeException("无效的证书", e);
        }
    }
}
