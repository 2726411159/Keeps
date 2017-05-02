package com.example.zyl.keeps;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Page extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGHT = 3000; // 延迟3秒
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);

        preferences = getSharedPreferences("phone", Context.MODE_PRIVATE);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                if (preferences.getBoolean("firststart", true)) {
                    editor = preferences.edit();
                    //将登录标志位设置为false，下次登录时不在显示首次登录界面
                    editor.putBoolean("firststart", false);
                    editor.commit();
                    Intent intent=new Intent();
                    intent.setClass(Page.this,ViewPage.class);
                    Page.this.startActivity(intent);
                    Page.this.finish();
                }else{
                    Intent intent=new Intent();
                    intent.setClass(Page.this,MainActivity.class);
                    Page.this.startActivity(intent);
                    Page.this.finish();

                }

            }
        },SPLASH_DISPLAY_LENGHT);
    }


}
