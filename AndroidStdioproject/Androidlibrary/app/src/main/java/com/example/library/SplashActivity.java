package com.example.library;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends Activity implements View.OnClickListener {
    //倒计时时间为5秒
    private int reclen=5;
    private TextView tv;
    Timer timer=new Timer();
    private Handler handle;
    private Runnable runnable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //定义全屏参数
        int flag= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        //设置当前窗体为全屏显示
        getWindow().setFlags(flag,flag);
        setContentView(R.layout.activity_splash2);
        initView();
        //设置倒计时任务，并在主线程中更新。
        TimerTask task=new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        reclen--;
                        tv.setText("跳过"+reclen);
                        if(reclen<0)
                        {
                            timer.cancel();
                            tv.setVisibility(View.GONE);
                        }
                    }
                });
            }
        };
        //等待一秒，时间周期为1秒
        timer.schedule(task,1000,1000);
        handle=new Handler();
        //正常情况下不点击跳过
        handle.postDelayed(runnable=new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
            }
        },5000);


    }


    //初始化视图
    private void initView() {
        tv=findViewById(R.id.tv);
        tv.setOnClickListener(this);
    }
    //设置监听事件
    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            //如果文本被点击则就进行跳转，并取消handle回调
            case R.id.tv:
                Intent intent=new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
                if(runnable!=null)
                {
                    handle.removeCallbacks(runnable);
                }
                break;
            default:
                break;
        }
    }
}
