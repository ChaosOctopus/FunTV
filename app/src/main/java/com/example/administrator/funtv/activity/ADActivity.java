package com.example.administrator.funtv.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.funtv.R;
import com.example.administrator.funtv.base.BaseActivity;
import com.example.administrator.funtv.base.BaseApplication;
import com.example.administrator.funtv.entity.ADBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ADActivity extends BaseActivity {

    @BindView(R.id.ad_iv)
    ImageView adIv;
    @BindView(R.id.time_tv)
    TextView timeTv;
    private ADBean adBean;
    private boolean adJump=true;//跳转的布尔值开关


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad);
        ButterKnife.bind(this);
        initData();
        initView();

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if(keyCode==KeyEvent.KEYCODE_BACK){
            return  true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void initView() {
        //Glide默认加载RGB565格式图片
//        Glide.with(this).load(adBean.getAndroidstart().get(0).getThumb()).into(adIv);
        new ClickTask(5).execute();
    }

    private void initData() {
        BaseApplication baseapplication = (BaseApplication) getApplication();
        adBean = baseapplication.getAdBean();

    }

    @OnClick(R.id.time_tv)
    public void onClick() {
        adJump=false;
        openActivityAndClose(MainActivity.class);


    }

    class ClickTask extends AsyncTask<Void, Integer, Void> {
        private int time;

        public ClickTask(int time) {
            this.time = time;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            while (time > 0&&adJump) {
                time--;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                publishProgress(time);
            }
            return null;

        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            timeTv.setText(values[0]+" 点击跳转");
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (adJump){
                openActivityAndClose(MainActivity.class);
            }

        }
    }
}
