package org.leetcode.test;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class AesUtil {
    public static void main(String[] args) throws GeneralSecurityException, IOException {
        String key = "cdjlztkyyxgs16899999999999999999";
        AesUtil util = new AesUtil(key.getBytes(StandardCharsets.UTF_8));
        String ciphertext = "CcU+LgDI2u1EV5LbKKZg7rrYlKJbZfW9dJey/ZGQ/h027gskp2bZ8FCnutBSW/IL7q2l8h4+ysc7L9dwD2hVLqWTtxDjebf19fNd0eqTKH8XgUTuY8dutCsppyjHw79FCMZdgF2Xr1fbzLmSRHcIKqoiShRI28NNcJniN0RoBkSLcRwSMVsUxBJQAdVIZ2nuGBDLCR6qHBIbghMyx9LMBNRA0nNHizpv2+/uxuryVWHknvL3/8lf7AVHpl7LkzNDZkJbz5JeRWg//+BiHqI4bbD7+C77p4zc+1v6LFrlriwE1wjBq9axFMmpTt+z7W3nRnJroIgdFW5nEfllWdL4tvWrlQrvPjrv8xrydPDN+n+Xj+XLrP6iq1W7e66NKIcc8ETjY5pkHbKValqLaHgHfPu610SNYzRh/0Os7ZOKXnFoZQgjwbHXOyibJxNtMAqBk/3EUAw7l56fesMmGmqlfkvecnxdZE+AdSZER1gkjLGNpRRC+atXb5F2fZjTKEgWrfE9XNQL3g6T9WFk2WvmVO5atAvT9gh+IHggHiJFGEGLVBBv5ulxSPbTtgrEWj6BRIAjb7beOrUqUupZSS5gvp/HaGAqLOnAq4EKS66Hlk5ugg4N6QT1RLUivu8uENStcIagz3pC1Y9D7iD93eL4DUYvg42a+hEPJWqSwkzdW+yd1u5/fIKqOhr6aB/ExPmK+XfD0fBt9St/aYePp8dZ3A2qO5oB/Q8MsF5a78TYol1DXAUpMXtZ5qWoM2XcgOYRRq8OkPTjgXMrKEqsyrw8QiNKzdUHs6x4aceLejh7r47wimxnVJzYKHHPaMhKLOFFQJp4WqAPdmQbI0Piqv4HZCXrCbKPNav3KgBwXnxypqdwgVVUPDLGdR+Pty4/4n+0j4TwWT2RO1W0YLRdFb+2kx4lJrAwkPC3X07AwRmtjgKwdNksvKCjiTjerEP9Q6Q03+ZPW7kGT0KfIlPlLJ0q51nlkv9pNa01gwJTwkWpsdGIOO92ky/uHg7RNXsbNgR4EVECbR7xIjWkIGOHnUvuRbotn0LvFVdEybbN9Wmz5ys+hmDB01gw+fSCmVVONcerqOTfPiKWfD8QWSK8U57AxxYDC7US22Tjr3CR56MdCVjBUyFBoC2wmdRogbfzwllTHGv6C3jyT/fdeBMzmIw3eidHpOkhBls0bjmUwryVRUq0ByPgaxWdpCksGtu5cmgh59rk2oSUc8e1hYsFyWmUKbqpTbfpp5GNOk5D77Vo/eba4urPGysQeH7Yems3pHYf8sc0JgOSUa4DHW+UyidAMnsNnOsz1ZwJF0xQ5Gpj8/8l9N25hTZNmcU8BCOqAOodCFG0sCn3Dv3m2Lj0kI5QzpeubraGSSGcUBwRTIiF3LMdPmQBmonNH5vQN4Tlw2vKwBzWwtZk0Fa3gf270T5S+cF5D6EueAKtbQqBbyvAWxfUOJi20R27Tmy2CWZdFOLXhx6sWRdyj+IuOaySATLOPkjwj6pUnqE8C2x2b25xEtJOKG7uMhyz0XTrm5KIZRosRjf96dQF8JPdrHISAHCIc90vw9Xc5ykgOexmunA9EenxI1BoADrV2naZwF94ooAqAiWKSCrFgtq1bfJMbgK8GUSp7UEHkl6uwUBfbVkB7rX9jbdArCU7MtTszkmloi8NPt033qS7WaoWKHhNKcu1iUKzwlUJLahzsH85DAe5sUqIlsiL1WNm+KvBBxX+4m9pMRkqz8/5pFqVLl691y3Vmse2Dk1mb5gRWs6p3IlQuYoel3T+wauaxnbjyz/sXJ6ZNWvI/RB3/Np2diHeNBV6+f/gEF9p5zmcgo9iEMw1iatk3HTHimDHbX6S2sAPOSjJ+C8rz+qelpZFUAydYT6O74tWr4JWtg==";
        String nonce = "b46ff915867b";
        String associatedData = "certificate";
        String decrypt = util.decryptToString(associatedData.getBytes(StandardCharsets.UTF_8)
                , nonce.getBytes(StandardCharsets.UTF_8), ciphertext
        );
        System.out.println(decrypt);
    }
    static final int KEY_LENGTH_BYTE = 32;
    static final int TAG_LENGTH_BIT = 128;
    private final byte[] aesKey;

    public AesUtil(byte[] key) {
        if (key.length != KEY_LENGTH_BYTE) {
            throw new IllegalArgumentException("无效的ApiV3Key，长度必须为32个字节");
        }
        this.aesKey = key;
    }

    public String decryptToString(byte[] associatedData, byte[] nonce, String ciphertext)
            throws GeneralSecurityException, IOException {
        try {
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");

            SecretKeySpec key = new SecretKeySpec(aesKey, "AES");
            GCMParameterSpec spec = new GCMParameterSpec(TAG_LENGTH_BIT, nonce);

            cipher.init(Cipher.DECRYPT_MODE, key, spec);
            cipher.updateAAD(associatedData);

            return new String(cipher.doFinal(Base64.getDecoder().decode(ciphertext)), "utf-8");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            throw new IllegalStateException(e);
        } catch (InvalidKeyException | InvalidAlgorithmParameterException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
