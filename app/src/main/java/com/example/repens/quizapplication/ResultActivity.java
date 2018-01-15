package com.example.repens.quizapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by repens on 2017/08/09.
 */

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
//        setContentView(R.layout.activity_top);
    }






    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button9:
//                Intent intent = new Intent(this, AnswerActivity.class);
//                Intent intent = new Intent(MainActivity.this ,TopActivity.class);
//                startActivity(intent);
                finish();
                break;



        }
    }

    //onPauseだからバックグラウンドでも戻るよ
    @Override
    protected void onPause(){
        super.onPause();
        finish();

    }

}