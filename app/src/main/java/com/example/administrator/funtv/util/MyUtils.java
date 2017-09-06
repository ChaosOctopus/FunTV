package com.example.administrator.funtv.util;

/**
 * Created by Bodhixu on 2017/2/9.
 */

public class MyUtils {

    //将数量int转换成字符串
    public static String getFans(int fansCount) {
        if (fansCount >= 10000) {
            java.text.DecimalFormat df = new java.text.DecimalFormat("#.##");
            double  d = fansCount/10000.00;
            return df.format(d) + "万";
        }
        return String.valueOf(fansCount);
    }

    //将数量int转换成字符串
    public static String getFans(String fansCount) {
        int fans = Integer.valueOf(fansCount);
        if (fans >= 10000) {
            java.text.DecimalFormat df =new java.text.DecimalFormat("#.##");
            double  d = fans/10000.00;
            return df.format(d) + "万";
        }
        return String.valueOf(fansCount);
    }
}
