package com.col.common.utils;

import java.util.Random;

/**
 * Created by liu.min on 2018/6/26.
 * 随机码工具类
 */
public class RandomCodeUtil {

    //生成5位随机大写英文字母入库码
    public static String randomIncode(){
        String str = "";
        Random rand = new Random();
        for(int i=0;i<5;i++){
//            int num = rand.nextInt(3);
            int num = 1;
            switch(num){
                case 0:
                    char c1 = (char)(rand.nextInt(26)+'a');//生成随机小写字母
                    str += c1;
                    break;
                case 1:
                    char c2 = (char)(rand.nextInt(26)+'A');//生成随机大写字母
                    str += c2;
                    break;
                case 2:
                    str += rand.nextInt(10);//生成随机数字
            }
        }
        return str;
    }

    public static String randomPhone(){
        String str = "186";
        Random rand = new Random();
        for(int i=0;i<8;i++){
            str += rand.nextInt(10);
        }
        return str;
    }
}
