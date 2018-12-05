package com.ujiuye.util;

import java.util.Random;
import java.util.UUID;

public class IDUtil {
    public static int getID(){
        Random random = new Random();
        return random.nextInt(1000000000);
    }

    public static String getUUID(){

        return UUID.randomUUID().toString();
    }
}
