package com.example.campus.generalUtil;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author 康智波
 * 2022,04,21
 */
public class ImageHelper {
    public static byte[] readFileByBytes(String fileName) throws Exception {
        InputStream in = null;
        try {
            // 一次读多个字节
            int byteRead;
            in = new FileInputStream(fileName);
            byte[] tempBytes = new byte[in.available()];
            // 读入多个字节到字节数组中，byteRead为一次读入的字节数
            while ((byteRead = in.read(tempBytes)) != -1) {
                System.out.println(byteRead);
            }
            return tempBytes;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("catch an file read exception: " + e);
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

}
