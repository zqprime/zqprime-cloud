package org.example.rsa;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.HexUtil;
import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import org.junit.Test;

public class SM4Test {
    @Test
    public void testSm4(){
        String content = "test中文";
        SymmetricCrypto sm4 = SmUtil.sm4();

        String encryptHex = sm4.encryptHex(content);
        String decryptStr = sm4.decryptStr(encryptHex, CharsetUtil.CHARSET_UTF_8);
        System.out.println(decryptStr);
    }

    @Test
    public void testSm4Ha(){
        String key = "4dd531fc7fd9bc25ee27b0ad28db47f4";
        SymmetricCrypto sm4 = SmUtil.sm4(HexUtil.decodeHex(key));
        String value = "7xQaPmprxeyUiAfOGjLCp3qwzu0MyxZnN4hKaak8PYc=";

        String decryptStr = sm4.decryptStr(value, CharsetUtil.CHARSET_UTF_8);
        System.out.println(decryptStr);
    }

    @Test
    public void testSm4he(){
        String key = "4dd531fc7fd9bc25ee27b0ad28db47f4";
        SymmetricCrypto sm4 = SmUtil.sm4(HexUtil.decodeHex(key));
        final byte[] encrypt = sm4.encrypt("510726198007135417");
        System.out.println(Base64.encode(encrypt));
    }
}
