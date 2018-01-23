package com.example.repens.quizapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by repens on 2018/01/23.
 */

//正解数保存用のデータベース
public class DatabaseChart extends SQLiteOpenHelper {

    public DatabaseChart(Context context){

        //任意の"dbファイル名"と.verを指定
        super(context,"AnswerTable.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        //テーブル作成     表示する要素が固定の場合最初に定義
        db.execSQL("CREATE TABLE AnswerTable " +
                "(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT" +
                ", Number TEXT" +
//                ", Clear INTEGER" +
                ")");
    }

    //DB更新時
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }

}

