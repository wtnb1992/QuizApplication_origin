package com.example.repens.quizapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import static com.example.repens.quizapplication.R.id.textView3;

/**
 * Created by repens on 2017/09/01.
 */


public class QuizActivity extends AppCompatActivity {

    int QuestionNo;
    String Seikai;
    private BgmPlayerClass bgm;
    int aaa = 1;
    int[] Q = new int[9999];
    private String[] Answer = new String[4];
    int[] array = {0,1,2,3};
    int AnswerNo;
    int QAnswer;
    int V;   //問題の最大数。
    int QA;
    int Z;
    boolean bgmsetting;

    CountDown countDown = new CountDown(10000,100); //タイマー10秒,100msec更新





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        this.bgm = new BgmPlayerClass(this);

        //DBオープンしてMyTableを指定、問題の最大数を取得
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor c = db.rawQuery("select*from MyTable",null);
        V = c.getCount();
        //開いたら閉じましょう
        c.close();
        db.close();


        SharedPreferences pref = getSharedPreferences("questionNo",MODE_PRIVATE|MODE_PRIVATE);
        QuestionNo=pref.getInt("key",9999);
        //ランダムにしたら消す
        if(QuestionNo == 9999){

            //問題ランダム化
            Random r = new Random();
            for (int i = 0; i < 6; i++) {   //問題の表示数+1でシャッフルを繰り返す
                Q[i] = r.nextInt(V)+1;
                int x = Q[i];
                for (i = 0; i < 6; i++)     //問題の表示数+1でシャッフルを繰り返す
                    if (Q[i] == x)
                        break;
            }

            QuestionNo = 1;

        }

    }

    @Override
    protected void onResume(){
        super.onResume();
        setQuestion();

        //BGMフラグ
        SharedPreferences pref = getSharedPreferences("bgmsetting",MODE_PRIVATE|MODE_PRIVATE);
        bgmsetting =pref.getBoolean("bgmsetting",true);

        if (bgmsetting == true){
            bgm.start(aaa);
        }

        //カウントダウン開始
        countDown.start();

        pref = getSharedPreferences("Z",MODE_PRIVATE|MODE_PRIVATE);
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
    protected void onStop(){
        super.onStop();
        //BGM停止
        bgm.stop(aaa);
        countDown.cancel();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences pref = getSharedPreferences("Z", MODE_PRIVATE | MODE_PRIVATE);
        Z = pref.getInt("Z", 1);
        Z = 0;
        //書き込み
        SharedPreferences.Editor e = pref.edit();
        e.putInt("Z", Z);
        e.commit();
    }





    //ここからDB読み取り開始
    public void setQuestion() {
        //DatabaseHelperクラス読み取り
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        //_idとQuestionNoを比べる
        String sql = "SELECT Pref, Answer0, Answer1, Answer2, Answer3, Answer4 FROM MyTable WHERE _id=" + Q[QuestionNo];
        Cursor c = db.rawQuery(sql,null);
        //DBのカーソルを最初に持ってくる。(必須)
        c.moveToFirst();

        //データベースの変数をセット
        String Question = c.getString(c.getColumnIndex("Pref"));
        Seikai = c.getString(c.getColumnIndex("Answer0"));
        Answer[0] = c.getString(c.getColumnIndex("Answer1"));
        Answer[1] = c.getString(c.getColumnIndex("Answer2"));
        Answer[2] = c.getString(c.getColumnIndex("Answer3"));
        Answer[3] = c.getString(c.getColumnIndex("Answer4"));

        //選択肢ランダム化
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            array[i] = r.nextInt(4);
            int x = array[i];
            for (i = 0; i < 4; i++)
                if (array[i] == x)
                    break;
        }

        //DBクローズ
        c.close();
        db.close();

        //変数をボタンにセット
        ((TextView)findViewById(R.id.textView6)).setText(Question);
        ((Button)findViewById(R.id.button5)).setText(Answer[array[0]]);
        ((Button)findViewById(R.id.button6)).setText(Answer[array[1]]);
        ((Button)findViewById(R.id.button7)).setText(Answer[array[2]]);
        ((Button)findViewById(R.id.button8)).setText(Answer[array[3]]);
        aaa = 1;
        //ここまで

        //イントロクイズ
        if(Q[QuestionNo] == 30){
            bgm.stop(aaa);
            aaa = 2;
            bgm.start(aaa);

        }

    }

    class CountDown extends CountDownTimer{
        public CountDown(long millisInFuture, long countDownInterval){
            super(millisInFuture,countDownInterval);
        }

        @Override
        public void onFinish(){
            ((TextView)findViewById(textView3)).setText("残り時間0秒");
            TimeUP();
//            }

        }

        @Override
        public void onTick(long millisUntilfinished){
            long ss = millisUntilfinished / 1000 % 60;
            ((TextView)findViewById(textView3)).setText("残り時間" + ss + "秒");
        }

    }



    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button5:
                //ボタンの文字の取得準備
                Button btnA = (Button)findViewById(R.id.button5);
                Answer(btnA);
                break;
            case R.id.button6:
                btnA = (Button)findViewById(R.id.button6);
                Answer(btnA);
                break;
            case R.id.button7:
                btnA = (Button)findViewById(R.id.button7);
                Answer(btnA);
                break;
            case R.id.button8:
                btnA = (Button)findViewById(R.id.button8);
                Answer(btnA);
                break;
        }
    }

    //時間切れ処理
    public void TimeUP(){
        //問題番号＋
        QuestionNo= QuestionNo + 1;
        SharedPreferences pref = getSharedPreferences("questionNo",MODE_PRIVATE|MODE_PRIVATE);
        SharedPreferences.Editor e = pref.edit();
        e.putInt("key", QuestionNo);
        e.commit();

        //回答数読み込み
        pref = getSharedPreferences("QAnswer",MODE_PRIVATE|MODE_PRIVATE);
        QAnswer=pref.getInt("QAnswer",0);
        ++ QAnswer;
        //書き込み
        e = pref.edit();
        e.putInt("QAnswer", QAnswer);
        e.commit();

        //正誤受け渡し
        pref = getSharedPreferences("QA",MODE_PRIVATE|MODE_PRIVATE);
        QA=pref.getInt("QA",0);
        QA=0;
        //書き込み
        e = pref.edit();
        e.putInt("QA", QA);
        e.commit();

        //アクティビティ起動
        Intent intent = new Intent(this, AnswerActivity.class);
        startActivity(intent);
        if(QAnswer==5){

            finish();
        }

    }

    public void Answer(Button btnA){
        bgm.stop(aaa);
        countDown.cancel();

        //問題数+1
        QuestionNo= QuestionNo + 1;
        SharedPreferences pref = getSharedPreferences("questionNo",MODE_PRIVATE|MODE_PRIVATE);
        SharedPreferences.Editor e = pref.edit();
        e.putInt("key", QuestionNo);
        e.commit();


        //ボタンの文字を取得
        CharSequence btn = btnA.getText();
        //比較のためstring型に変更
        String answer = btn.toString() ;
        //正解判定
        if(answer.equals(Seikai)) {

            //正解数読み込み
            pref = getSharedPreferences("AnswerNo",MODE_PRIVATE|MODE_PRIVATE);
            AnswerNo=pref.getInt("AnswerNo",0);
            ++ AnswerNo;
            //書き込み
            e = pref.edit();
            e.putInt("AnswerNo", AnswerNo);
            e.commit();

            //回答数読み込み
            pref = getSharedPreferences("QAnswer",MODE_PRIVATE|MODE_PRIVATE);
            QAnswer=pref.getInt("QAnswer",0);
            ++ QAnswer;
            //書き込み
            e = pref.edit();
            e.putInt("QAnswer", QAnswer);
            e.commit();

            //正誤受け渡し
            pref = getSharedPreferences("QA",MODE_PRIVATE|MODE_PRIVATE);
            QA=pref.getInt("QA",0);
            QA=1;
            //書き込み
            e = pref.edit();
            e.putInt("QA", QA);
            e.commit();

            Intent intent = new Intent(this, AnswerActivity.class);
            startActivity(intent);
            if(QAnswer==5){

                finish();
            }
        }else{

            //回答数読み込み
            pref = getSharedPreferences("QAnswer",MODE_PRIVATE|MODE_PRIVATE);
            QAnswer=pref.getInt("QAnswer",0);
            ++ QAnswer;
            //書き込み
            e = pref.edit();
            e.putInt("QAnswer", QAnswer);
            e.commit();

            //正誤受け渡し
            pref = getSharedPreferences("QA",MODE_PRIVATE|MODE_PRIVATE);
            QA=pref.getInt("QA",0);
            QA=0;
            //書き込み
            e = pref.edit();
            e.putInt("QA", QA);
            e.commit();

            Intent intent = new Intent(this, AnswerActivity.class);
            startActivity(intent);

            //5問終了したら
            if(QAnswer==5){
                finish();
            }

        }

    }
}
