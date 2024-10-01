package com.sci_all.demo.utils;

public class VerifyCodesUtils {

    public static String generateVerifyCode() {
        return String.valueOf((int) (Math.random() * 9000) + 1000);
    }

}
