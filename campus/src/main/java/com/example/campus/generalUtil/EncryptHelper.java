package com.example.campus.generalUtil;

import org.apache.tomcat.util.buf.HexUtils;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author 康智波
 * 2022,03,29
 */
public class EncryptHelper {
    public static String Sha256Encrypt(String password) {
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


    public static String bCrypt(String passWordStr){
        String saltBef = BCrypt.gensalt();
        return BCrypt.hashpw(passWordStr, saltBef);
    }

}
