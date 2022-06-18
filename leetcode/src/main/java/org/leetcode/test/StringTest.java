package org.leetcode.test;

public class StringTest {
    public static void main(String[] args) {
//        System.out.println(UUID.randomUUID());

        String a ="MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDvaT6Y/IgbKFB8"
                + "EiKVh3bwNKcSeC+Zs28EnEExiGQju4/w5riKLK/QMxCyBfPXieCQr/kRUD25Q1AF"
                + "QNDzSrr7govJU8eMOsUkxDlyHD1sGr2i16fiJLt8kkXf5lTG5l59fCmwl45PEqsm"
                + "wXbE/0gGJiRWZNmaAamd1r48+ngM2oCVMHp0hiH11B07zAERvcy6cLKPj8qPsgFc"
                + "RVZGO2YhMu1oYNhVIClBKqlrPVewdXU+RS5GtnuQWNkiZh9HxBJbo787Jnji9wrB"
                + "/o4F4PC2R++kwSeWcc9Z5DMDxe2/Adb/5GyavtPGLZt3OMA62ayGspneO5MyXLgm"
                + "kxSA/3/DAgMBAAECggEANzKmshMXNlu3IsPzoVIYRA1/r6xyHRfXstJr3YW6wNpP"
                + "t5UaWxEuf+wmH0VsEPfDBNjtreY4NOymGG/3PQCv16kjnYlpapVqOq3bKMoGB1Sr"
                + "AE6EcIlTiMcYwSSTyz/17SyhWAu5TdXaDBdy0Lyi2HgWzKx31yAnATMvrVN6NkwA"
                + "Q1NaeuM0JX4wVUt0zvjSh87gHLUNm15DPv62pxZqMhewGimadhdSWFuJv8gqzq7a"
                + "fDGn1MUg9rEd5Dj+BFZ7VW7Qurtbc0mQ7OzRDR18AlvuEDAEa8mIziaiHYZi6AVC"
                + "mOUamdU9rejKC0CgG71uZFs7F6ZQVGOwMrIn+XsGcQKBgQD9/pup4a4enGVW6z2f"
                + "y+w09h9IJHg88RyNVLpG2g8gLvb+ZRGfa/yp7cJdl6j+XZ2aLLdhgOusSALRrAVv"
                + "0xa6LSCqG+suEcvvO/s420X0d43dAwia44wv714ODGYji+1+u1eXX0fk+h/5NGgF"
                + "g17GwyRK1KPuOrh7f788/SjnbQKBgQDxTSjLC9oYr1vnXHQMuQiP/x5I6c00XBHv"
                + "jWOXIn08e9eqQ1tXru2c8lRNZY6LbMVVtsYmZA1UhVPRFqNVMqk3UJkA1ShqUa0n"
                + "aKOkbJqgn4DEL7JwpT37/q2U8/opcWQQu/cjY4Tm0I1QDj+lMZMw0ooVHQS4VmrK"
                + "ysX4unGV7wKBgQCqyh2Z6erPIpLyE1RosxKtuiHmvL8tG2P7lNF8+vvYxDvJa+Sh"
                + "slc/XGSp0mUMRZ7IIPFeWvYd7n4WxvkQ7HwHzHh+ai+F1umugEK5RJiRfiKiTnvm"
                + "ysNlKCuyfpvfoyObaBXJ74PEcHw3cgnQSznbpTQuLTXd5xZN1OSe+gwbMQKBgQCX"
                + "d2mt2uiyKhE0b3JhMhzP1sJ53ljzDwArMMNc8UdPmiVMOS+zIJkCtZJ5atBJcKOG"
                + "JE7JdnBvp6lvTBiGuGBD2pHQVf0ij9ZzMFnYMlv1i2nWvGH0F6WK8tie8W8MaKL5"
                + "ZiPB0QxxnmO15tvIpA/Sy7Xlfuuhko1CcnpGoTH/fQKBgQCDUGDLJ/ccatw2mM1v"
                + "EUK0/G4WYs5iLHvOtGOre43CYjEk5i5TsPNKp4KiYdq6Gw0mlbp88tVGwNp5Cl3/"
                + "VQmY46zMMkrkpwiWIH/AHK/LkTcb3DCFVXgsP0iEXDzjQtUwlKmVkdZWvcYd9rps"
                + "jwknaT524AA2bq3xOdxd00NiGQ==";
        String b = "MIID8DCCAtigAwIBAgIUOqdyIDp+zjiP5SzndztqRO0J1fUwDQYJKoZIhvcNAQEL" +
                "BQAwXjELMAkGA1UEBhMCQ04xEzARBgNVBAoTClRlbnBheS5jb20xHTAbBgNVBAsT" +
                "FFRlbnBheS5jb20gQ0EgQ2VudGVyMRswGQYDVQQDExJUZW5wYXkuY29tIFJvb3Qg" +
                "Q0EwHhcNMjEwNjI4MDkzNDI2WhcNMjYwNjI3MDkzNDI2WjCBgTETMBEGA1UEAwwK" +
                "MTU0NTEyODI4MTEbMBkGA1UECgwS5b6u5L+h5ZWG5oi357O757ufMS0wKwYDVQQL" +
                "DCTmiJDpg73lkInogZTorq/pgJrnp5HmioDmnInpmZDlhazlj7gxCzAJBgNVBAYM" +
                "AkNOMREwDwYDVQQHDAhTaGVuWmhlbjCCASIwDQYJKoZIhvcNAQEBBQADggEPADCC" +
                "AQoCggEBAKXKZv3aLz6BAb1tRdBAmxSbV8ch/uez1dRCQPML0sGnonrNgwEF/SZ8" +
                "mjX3dZEmGmb54fPXdUnDxrddu2+OdbJh8bI+AOwEIP3UQoeciHLPBy/OmIbrxumn" +
                "r7I02GDHFeiD669tnO2Rwqidp9thvTr6ZN06ipStjfLMnLzd/e9txrjDrZTKCQGU" +
                "s/mImkKLe1HZV9z9wXT+cs9EOkW1dazZ3CkNPoX/6h+hK4OA5ItECGLVPszTz3cP" +
                "Zuldm2J7/Lq0YjWjhKCDjgX7/lvekU46qkKQJpFXbzLniXtw3Sb37RpO7dtYkVR0" +
                "U7Sdl7/vEADP/2BT1C0w2pxIsafTJZUCAwEAAaOBgTB/MAkGA1UdEwQCMAAwCwYD" +
                "VR0PBAQDAgTwMGUGA1UdHwReMFwwWqBYoFaGVGh0dHA6Ly9ldmNhLml0cnVzLmNv" +
                "bS5jbi9wdWJsaWMvaXRydXNjcmw/Q0E9MUJENDIyMEU1MERCQzA0QjA2QUQzOTc1" +
                "NDk4NDZDMDFDM0U4RUJEMjANBgkqhkiG9w0BAQsFAAOCAQEAV0+w4ML2Rd5R8V2L" +
                "v1poop0NxMM4lWixs1QGI3svXtntTCDP51gY2FPds99gusKiXUK6RY6/kE2B+kTm" +
                "u9RksVD40hhgcVV3+sqY2F51eirw8cCKNzhNGpCvd1tma1LBcJtLmluEcj2eEDfg" +
                "tLK4Q/C1+f3JmhJiJEn+1jHyoAlaD3Vv9CIgGxHIqcmkfWnG8pCfRTp4avRZTCDo" +
                "osCOaQRg9NUVIT8cdUFfuPM8du79p6Rz2PCZqYzL6Nas5rcuTgi4/oKFQBJsQ+By" +
                "NGKlPrtyh9SQFzaIWWH4dftbDYdAjwR4ltouc8xT22Fuf60JH9DUigNCFH2RNsmY" +
                "JlrKKg==";
        System.out.println(a);

        String c = "-----BEGIN CERTIFICATE-----\n" +
                "MIID3DCCAsSgAwIBAgIUQSWsxTeYV6RGFlYfMUSUIy/Q1K8wDQYJKoZIhvcNAQEL" +
                "BQAwXjELMAkGA1UEBhMCQ04xEzARBgNVBAoTClRlbnBheS5jb20xHTAbBgNVBAsT" +
                "FFRlbnBheS5jb20gQ0EgQ2VudGVyMRswGQYDVQQDExJUZW5wYXkuY29tIFJvb3Qg" +
                "Q0EwHhcNMTkwODI3MDc0NzI1WhcNMjQwODI1MDc0NzI1WjBuMRgwFgYDVQQDDA9U" +
                "ZW5wYXkuY29tIHNpZ24xEzARBgNVBAoMClRlbnBheS5jb20xHTAbBgNVBAsMFFRl" +
                "bnBheS5jb20gQ0EgQ2VudGVyMQswCQYDVQQGDAJDTjERMA8GA1UEBwwIU2hlblpo" +
                "ZW4wggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQC+Jdq9/GTHXSaEoUMk" +
                "laDPBEXOZGNae8IIF4Fqlb5gmTTlyS9KbGwuMJCpDP9/ht/v86ETyBl8JVM4AfeY" +
                "s+W0KcGgAOssUspUnONrVUc5wTmsxqTiMW0NfQ+j0BdRehyLwccNkBZhfdtx5gMY" +
                "uRe+lpIRgajQSOBicI9O/u6jzf4NgJfDbDUcFVn1TRr4vDTEet42kuNBUpukHL+3" +
                "5mE53fyGz1F9lAlYgLvzej5Wq9FrxF4GkY2yiwjhLyPks3/jDNGJkI7xTrANf8UB" +
                "Qyn90WmGI8GSKD15viKkHR0UJJyLP7/Z9S7FgAV75rd6OURIo4N1m4Rdb0kI1DS0" +
                "XIy9AgMBAAGjgYEwfzAJBgNVHRMEAjAAMAsGA1UdDwQEAwIE8DBlBgNVHR8EXjBc" +
                "MFqgWKBWhlRodHRwOi8vZXZjYS5pdHJ1cy5jb20uY24vcHVibGljL2l0cnVzY3Js" +
                "P0NBPTFCRDQyMjBFNTBEQkMwNEIwNkFEMzk3NTQ5ODQ2QzAxQzNFOEVCRDIwDQYJ" +
                "KoZIhvcNAQELBQADggEBAJLI42cNfSNWhqZxwlHNxC4NkiNwu7iZizsWff4UjHwH" +
                "T6QRsq+3PtMIxgnzYWSDG4eMaANg18y5wvyAKrLp0JIhmKdoJ0a00ZISwFWFCh/2" +
                "KStb2x1EPDujsuE5nBVKhOmlrW3LWErcM0ugdqyQUXO8a0W0wiXWUtkgXfUmwtrX" +
                "vc+EiW8sNRs6fHYcz/OnFSB+fPtTqgfzr5BfnZOTjDdbnOoTIoO28i7ZjqKI/9O+" +
                "H//UKk3hezS7fp6pqVovNsQq/bwwF/Z9A9wDXLWWvbN7eleDzUi6jxPrKeex+oR4" +
                "vkrA2wMnigdOmBk0LFpvQuf9xGdsFFXXry0+p96PMZE=\n" +
                "-----END CERTIFICATE-----";
        System.out.println(c);
    }
}

