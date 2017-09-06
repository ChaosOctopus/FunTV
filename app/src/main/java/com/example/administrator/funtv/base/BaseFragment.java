package com.example.administrator.funtv.base;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/4/5 0005.
 */

public class BaseFragment extends Fragment {
    private BaseActivity activity;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity  = (BaseActivity) context;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.gc();
    }
    public void showToast(String msg){
        Toast.makeText(activity,msg,Toast.LENGTH_SHORT).show();
    }

}
