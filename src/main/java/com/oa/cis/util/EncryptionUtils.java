package com.oa.cis.util;

import java.security.NoSuchAlgorithmException;

public class EncryptionUtils {
    /**
     * MD5+SHA-512 加密
     *
     * @param password
     * @return
     */
    public static String encryption(String password) {
        String shaResult = null;
        try {
            String md5Result = MessageDigestTools.encryptMD5(password.getBytes());
            shaResult = MessageDigestTools.encryptSHA(md5Result.getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return shaResult;
    }

    /*public static void main(String[] args) {
        System.out.println(encryption("admin"));
    }*/
}
