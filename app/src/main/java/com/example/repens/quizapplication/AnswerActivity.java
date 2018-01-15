package com.example.repens.quizapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.StandaloneActionMode;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by repens on 2017/08/08.
 */

public class AnswerActivity extends AppCompatActivity {

    int AnswerNo;
    int QAnswer;
    int QA;
    int Z;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        //正誤読み込み
        SharedPreferences pref = getSharedPreferences("QA",MODE_PRIVATE|MODE_PRIVATE);
        QA=pref.getInt("QA",0);
            //正解・不正解で画像変更
            if(QA==1){
                ImageView imageView =(ImageView)findViewById(R.id.imageView2);
                imageView.setImageResource(R.drawable.seikai);

            }else{
                ImageView imageView =(ImageView)findViewById(R.id.imageView2);
                imageView.setImageResource(R.drawable.huseikai);
            }

        }
    @Override
    protected void onResume(){
        super.onResume();
        SharedPreferences pref = getSharedPreferences("Z",MODE_PRIVATE|MODE_PRIVATE);
        Z=pref.getInt("Z",1);
        Z= 1;
        //書き込み
        SharedPreferences.Editor e = pref.edit();
        e.putInt("Z" , Z);
        e.commit();

    }

    @Override
    protected void onPause(){
        super.onPause();

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
            case R.id.button4:
                Intent intent = new Intent(this, QuizActivity.class);
                Button btnA = (Button)findViewById(R.id.button4);
                //ボタンの文字を取得
                CharSequence btn = btnA.getText();
                //比較のためstring型に変更
                String Answer = btn.toString() ;
                if(Answer.equals("TOPに戻る")){
                    SharedPreferences pref = getSharedPreferences("Z",MODE_PRIVATE|MODE_PRIVATE);
                    Z=pref.getInt("Z",1);
                    Z= 1;
                    //書き込み
                    SharedPreferences.Editor e = pref.edit();
                    e.putInt("Z" , Z);
                    e.commit();
                    finish();
                }
                //正解数読み込み後int→stringに変換
                SharedPreferences pref = getSharedPreferences("AnswerNo",MODE_PRIVATE|MODE_PRIVATE);
                AnswerNo=pref.getInt("AnswerNo",0);
                String  answer = String.valueOf(AnswerNo);   //AnswerNo.toString() ;

                //回答数読み込み
                SharedPreferences pref2 = getSharedPreferences("QAnswer",MODE_PRIVATE|MODE_PRIVATE);
                QAnswer=pref2.getInt("QAnswer",0);

                if(QAnswer == 5){  //出題数増やすなら数字変更
                        ((TextView) findViewById(R.id.textView5)).setText(answer);
                        ((Button) findViewById(R.id.button4)).setText("TOPに戻る");
                        ((TextView) findViewById(R.id.textView5)).setText(answer + "問正解できました!!");
                        ImageView imageView = (ImageView) findViewById(R.id.imageView2);
                        imageView.setImageResource(R.drawable.syuuryou);
                }else{
                    finish();
                }
        }
    }
}
