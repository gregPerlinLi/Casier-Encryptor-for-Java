package com.pa.util;

import java.security.MessageDigest;

public class MD5Encrypt {
    public static String stringMD5(String input) {
        try {

           // 拿到一个MD5转换器（如果想要SHA1参数换成”SHA1”）
           MessageDigest messageDigest =MessageDigest.getInstance("MD5");
           // 输入的字符串转换成字节数组
           byte[] inputByteArray = input.getBytes();
           // inputByteArray是输入字符串转换得到的字节数组
           messageDigest.update(inputByteArray);
           // 转换并返回结果，也是字节数组，包含16个元素
           byte[] resultByteArray = messageDigest.digest();
           // 字符数组转换成字符串返回
           return byteArrayToHex(resultByteArray);
        } catch (NoSuchAlgorithmException e) {
      
           return null;
        }
    }
}
