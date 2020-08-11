package com.wu.test;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MyMessageDigestTest {
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String input = "mbnoiuggdyqugqdqgqyudgqudgqudnjkcbhacbdscbywuyqetqueqyieqeqioeqeqqeq我就是我";
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(input.getBytes("UTF-8"));
        byte[] digest = md5.digest();
        BigInteger bigInteger = new BigInteger(1,digest);
        String s = bigInteger.toString(16);
        System.out.println(s);
    }
}
