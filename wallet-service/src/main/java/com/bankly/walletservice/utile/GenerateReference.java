package com.bankly.walletservice.utile;

import java.security.SecureRandom;

public class GenerateReference {

    private static SecureRandom random = new SecureRandom();

    private static final String ALPHA_CAPS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMERIC = "0123456789";
    private static final int  lenght =8;

    public static String generateReference(int lenght, String dic) {
        String result = "";
        for (int i = 0; i < lenght; i++) {
            int index = random.nextInt(dic.length());
            result += dic.charAt(index);
        }
        return result;
    }

    public static String applyGenerateReference(){
        return generateReference(lenght,ALPHA_CAPS + NUMERIC);
    }

}
