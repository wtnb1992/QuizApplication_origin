package com.example.repens.quizapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Switch;

/**
 * Created by repens on 2017/08/09.
 */

public class SettingActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    boolean bgmsetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        //BGM設定読み込み
        SharedPreferences pref = getSharedPreferences("bgmsetting",MODE_PRIVATE|MODE_PRIVATE);
        bgmsetting =pref.getBoolean("bgmsetting",true);
        Switch switch1 = (Switch) findViewById(R.id.switch1);
        switch1.setChecked(bgmsetting);
        //設定が無ければ
        if(switch1 != null){
            switch1.setOnCheckedChangeListener(this);
        }
    }
    @Override
    public  void onCheckedChanged(CompoundButton buttonView, boolean bgmsetting){
        //BGM設定(スイッチ)
        if (bgmsetting == true) {
            SharedPreferences pref = getSharedPreferences("bgmsetting",MODE_PRIVATE|MODE_PRIVATE);
            SharedPreferences.Editor e = pref.edit();
            e.putBoolean("bgmsetting", true);
            e.commit();
            System.out.println(bgmsetting);

        } else {
            System.out.println(bgmsetting);
            SharedPreferences pref = getSharedPreferences("bgmsetting",MODE_PRIVATE|MODE_PRIVATE);
            SharedPreferences.Editor e = pref.edit();
            e.putBoolean("bgmsetting", false);
            e.commit();

        }


    }

}
