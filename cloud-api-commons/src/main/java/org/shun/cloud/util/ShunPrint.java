package org.shun.cloud.util;

public class ShunPrint {
    static boolean flag = true;
    public static void print(Object msg){
        if(flag){
            System.out.println(msg);
        }
    }
}
