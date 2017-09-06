package com.example.administrator.funtv.util;

import android.util.Log;

/**
 * Created by acer on 2016/11/23.
 */

public class NumberChangeUtils {
   // 直播观看 人数显示转换
    public static String numchange(String view){
        Integer integer = Integer.valueOf(view);
        if(integer>=10000){
            double v = integer / 10000.0;
            String s = String.valueOf(v);
            int i = s.indexOf(".");
            String substring = s.substring(0, i + 2);
            view = substring+"W";
            Log.e("TAG", "onBindMyViewHolder: "+i );
            Log.e("TAG", "onBindMyViewHolder: "+s );
        }
        return  view;
    }
}
