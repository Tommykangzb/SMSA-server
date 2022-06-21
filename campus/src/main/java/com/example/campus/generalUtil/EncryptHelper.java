package com.example.campus.generalUtil;

import org.apache.tomcat.util.buf.HexUtils;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @author 康智波
 * 2022,03,29
 */
public class EncryptHelper {
    private static String sha256Encrypt(String password) {
        byte[] result;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            result = messageDigest.digest(password.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
        return HexUtils.toHexString(result);
    }


    private static String bCrypt(String passWordStr,String userId){
        String saltBef = BCrypt.gensalt();
        return BCrypt.hashpw(passWordStr, userId);
    }

    public static String encryption(String passWordStr,String userId){
        String psw = sha256Encrypt(passWordStr);
        return AESAndSha256Encode(userId,psw);
    }

    private static String AESAndSha256Encode(String encodeRules, String content) {
        try {
            encodeRules = sha256Encrypt(encodeRules);
            //1.构造密钥生成器，指定为AES算法,不区分大小写
            KeyGenerator keygen = KeyGenerator.getInstance("AES");
            //2.根据ecnodeRules规则初始化密钥生成器
            //生成一个128位的随机源,根据传入的字节数组
            keygen.init(128, new SecureRandom(encodeRules.getBytes()));
            //3.产生原始对称密钥
            SecretKey original_key = keygen.generateKey();
            //4.获得原始对称密钥的字节数组
            byte[] raw = original_key.getEncoded();
            //5.根据字节数组生成AES密钥
            SecretKey key = new SecretKeySpec(raw, "AES");
            //6.根据指定算法AES自成密码器
            Cipher cipher = Cipher.getInstance("AES");
            //7.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密解密(Decrypt_mode)操作，第二个参数为使用的KEY
            cipher.init(Cipher.ENCRYPT_MODE, key);
            //8.获取加密内容的字节数组(这里要设置为utf-8)不然内容中如果有中文和英文混合中文就会解密为乱码
            byte[] byte_encode = content.getBytes("utf-8");
            //9.根据密码器的初始化方式--加密：将数据加密
            byte[] byte_AES = cipher.doFinal(byte_encode);
            //10.将加密后的数据转换为字符串
            //这里用Base64Encoder中会找不到包
            //解决办法：
            //在项目的Build path中先移除JRE System Library，再添加库JRE System Library，重新编译后就一切正常了。
            String AES_encode = new BASE64Encoder().encode(byte_AES);
            //11.将字符串返回
            AES_encode = HexUtils.toHexString(AES_encode.getBytes()).toLowerCase();
            return AES_encode;
        } catch (Exception e) {
            e.printStackTrace();
        }
        //如果有错就返回null
        return null;
    }

}
