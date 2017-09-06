package com.example.administrator.funtv.base.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * @author bodhixu
 * 
 * Tost工具类，解决多个Toast时长问题
 *
 */
public class ToastUtils {
	
	private static Toast toast;
		
	public static void showTost(Context context, String text) {
		if (toast == null) {
			toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
		} else {
			toast.setText(text);
		}
		toast.show();		
	}

}
