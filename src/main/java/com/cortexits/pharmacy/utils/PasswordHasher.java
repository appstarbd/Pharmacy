package com.cortexits.pharmacy.utils;

import org.apache.commons.codec.binary.Hex;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHasher {
//    public static void main(String[] paramArrayOfString) throws Exception {
//        PosLog.info(PasswordHasher.class, hashPassword("123"));
//    }

    public static String hashPassword(String paramString) {
        byte[] arrayOfByte1 = null;
        MessageDigest messageDigest = null;
        arrayOfByte1 = paramString.getBytes(StandardCharsets.UTF_8);
        try {
            messageDigest = MessageDigest.getInstance("SHA1");
        } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            AppLog.error(PasswordHasher.class, noSuchAlgorithmException);
        }
        byte[] arrayOfByte2 = messageDigest.digest(arrayOfByte1);
        return Hex.encodeHexString(arrayOfByte2);
    }
}
