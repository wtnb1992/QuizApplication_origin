package com.example.repens.quizapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by repens on 2017/08/09.
 */

public class ResultActivity extends AppCompatActivity {

    int sample ;

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


//                finish();
//                break;


                //DBオープン
//                DatabaseHelper dbHelper = new DatabaseHelper(this);
                DatabaseChart dbHelper = new DatabaseChart(this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
//                Cursor c = db.rawQuery("select*from MyTable",null);
                Cursor c = db.rawQuery("select*from AnswerTable",null);
                sample = c.getCount();
                c.close();

                //追加データ設定。      value.put("追加するDBのカラム","追加する内容")　　　※追加する内容が変数の場合は""は必要ない
                //ここからDB更新　ただし、.javaには更新分は反映されない。
                sample = sample + 1;
                ContentValues values = new ContentValues();
                values.put("Number", sample);   //sampleは変数です。18行目に定義。

/*                values.put("Pref", sample);   //sampleは変数です。18行目に定義。
                values.put("Answer0", "test");
                values.put("Answer1", "テスト");
                values.put("Answer2", "てすと");
                values.put("Answer3", "試験");
                values.put("Answer4", "tesuto");
*/
                long ret;       //DBに追加するための変数を設定。

                try {
                    ret = db.insert("AnswerTable", null, values);    //insertでDBに追加。 db.insert("DBのテーブル名",null,追加内容を定義した変数)

                } finally {
                    db.close();    //開いたDBはしっかり閉じましょう。
                }
                if (ret == -1) {
                    Toast.makeText(this, "insert失敗", Toast.LENGTH_SHORT).show();
                } else {
                    //long型の変数retをString型にしてトースト表示     数字が増えていればDBに内容が追加されています。
                    String s = Long.toString(ret);
                    Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
                }
                //ここまで


        }

    }
    //onPauseだからバックグラウンドでも戻るよ
    @Override
    protected void onPause () {
        super.onPause();
        finish();

    }

}
