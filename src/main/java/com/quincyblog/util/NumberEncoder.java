package com.quincyblog.util;

import java.util.Base64;

public class NumberEncoder {
    public static String numberEncoder(String number){
     return Base64.getEncoder().encodeToString(String.valueOf(number).getBytes());
    }
}
