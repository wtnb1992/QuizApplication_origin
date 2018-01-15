package com.example.repens.quizapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import static android.R.attr.id;

/**
 * Created by repens on 2017/08/08.
 */

public class TopActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        setContentView(R.layout.activity_top);

    }



/*    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                Intent intent = new Intent(this ,AnswerActivity.class);
//                Intent intent = new Intent(MainActivity.this ,TopActivity.class);
                startActivity(intent);
                break;
            case R.id.button2:
                intent = new Intent(this,ResultActivity.class);
                startActivity(intent);
                break;
            case R.id.button3:
                setContentView(R.layout.activity_top);
//                startActivity(intent);
                break;

            case R.id.textView:
                intent = new Intent(this ,TopActivity.class);
//                Intent intent = new Intent(MainActivity.this ,TopActivity.class);
                startActivity(intent);


                //                intent =  new Intent(this,SettingActivity.class);
                break;
        }
    }*/


}
//Soundation Studio 音源作成