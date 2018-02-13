package com.gym.util;

/**
 * Created by Alejandro on 12/2/2018.
 */
public class NumberUtils {
    public static Long toLong(String s){
        Long num=-1L;
        try {
            num = Long.valueOf(s);
        }catch (NumberFormatException n){
            num=-1L;
        }
        return num;
    }
}
