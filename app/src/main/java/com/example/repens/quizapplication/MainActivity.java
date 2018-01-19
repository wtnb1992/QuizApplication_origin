package com.example.repens.quizapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private View startview;
    private BgmPlayerClass bgm;
    public int aaa = 0;
    int AnswerNo;
    int QAnswer;
    int QuestionNo;
    int Z;
    boolean bgmsetting;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setScreenMain();
        this.bgm = new BgmPlayerClass(this);
    }

    private void setScreenMain(){
        //画面表示フラグ読み込み
        SharedPreferences pref = getSharedPreferences("Z",MODE_PRIVATE|MODE_PRIVATE);
        Z=pref.getInt("Z",0);
        if(Z == 0) {

            setContentView(R.layout.activity_top);
            startview = findViewById(R.id.textView);

            //フォント変更
            TextView top = (TextView)findViewById(R.id.textView7);
            top.setTypeface(Typeface.createFromAsset(getAssets(),"hkgyokk.ttf"));
            startview.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    setContentView(R.layout.activity_main);
                }
            });        }else{        setContentView(R.layout.activity_main);}
        //画面表示記憶
        pref = getSharedPreferences("Z",MODE_PRIVATE|MODE_PRIVATE);
        Z=pref.getInt("Z",1);
        Z= 1;
        //書き込み
        SharedPreferences.Editor e = pref.edit();
        e.putInt("Z" , Z);
        e.commit();

    }

    @Override
    protected void onResume(){
        super.onResume();
        //BGM再生

//      設定からBGMを流すかを取得
        SharedPreferences pref = getSharedPreferences("bgmsetting",MODE_PRIVATE|MODE_PRIVATE);
        bgmsetting =pref.getBoolean("bgmsetting",true);
        System.out.println(bgmsetting);

        if (bgmsetting == true){
            bgm.start(aaa);

        }

    }

    @Override
    protected void onPause(){
        super.onPause();
        //BGM停止
        bgm.stop(aaa);

        SharedPreferences pref = getSharedPreferences("Z",MODE_PRIVATE|MODE_PRIVATE);
        Z=pref.getInt("Z",1);
        Z= 0;
        //書き込み
        SharedPreferences.Editor e = pref.edit();
        e.putInt("Z" , Z);
        e.commit();

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();

        SharedPreferences pref = getSharedPreferences("Z",MODE_PRIVATE|MODE_PRIVATE);
        Z=pref.getInt("Z",1);
        Z= 0;
        //書き込み
        SharedPreferences.Editor e = pref.edit();
        e.putInt("Z" , Z);
        e.commit();

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:

                //正解数リセット
                SharedPreferences pref = getSharedPreferences("AnswerNo",MODE_PRIVATE|MODE_PRIVATE);
                AnswerNo=pref.getInt("AnswerNo",0);
                AnswerNo= 0;
                //書き込み
                SharedPreferences.Editor e = pref.edit();
                e.putInt("AnswerNo", AnswerNo);
                e.commit();

                //回答数リセット
                pref = getSharedPreferences("QAnswer",MODE_PRIVATE|MODE_PRIVATE);
                QAnswer=pref.getInt("QAnswer",0);
                QAnswer= 0;
                //書き込み
                e = pref.edit();
                e.putInt("QAnswer", QAnswer);
                e.commit();

                //問題番号リセット
                pref = getSharedPreferences("questionNo",MODE_PRIVATE|MODE_PRIVATE);
                QuestionNo=pref.getInt("key",0);
                QuestionNo=9999;
                //書き込み
                e = pref.edit();
                e.putInt("key", QuestionNo);
                e.commit();


                Intent intent = new Intent(this ,QuizActivity.class);
                startActivity(intent);
                break;
            case R.id.button2:
//                intent = new Intent(this,GlaphActivity.class);
//                intent = new Intent(this,TopActivity.class);

                intent = new Intent(this,ResultActivity.class);
                startActivity(intent);
                break;
            case R.id.button3:
                intent = new Intent(this,SettingActivity.class);
                startActivity(intent);
                break;

        }
    }

}



//参考：http://letsunity.wpblog.jp/2015/06/18/post-337/
