package com.example.repens.quizapplication;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.Random;

import static android.R.attr.fingerprintAuthDrawable;
import static android.R.attr.id;

/**
 * Created by repens on 2017/08/08.
 */

public class TopActivity  extends AppCompatActivity {
//    public class TopActivity  extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glaph);

//保存したDBのデータを読み込んでグラフ表示
        DatabaseChart dbHelper = new DatabaseChart(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        int b=1;

        //_idとQuestionNoを比べる
        String sql = "SELECT Number FROM AnswerTable WHERE_id" + b;
        Cursor c = db.rawQuery(sql,null);
        //DBのカーソルを最初に持ってくる。(必須)
        c.moveToFirst();
        //データベースの変数をセット　　　　本当ならループ文で記載
        int a= c.getInt(c.getColumnIndex("Number"));
        c.moveToNext();
        int d= c.getInt(c.getColumnIndex("Number"));
        c.moveToNext();
        int e= c.getInt(c.getColumnIndex("Number"));
//        c.moveToNext();
//        int f= c.getInt(c.getColumnIndex("Number"));
//        c.moveToNext();
//        int g= c.getInt(c.getColumnIndex("Number"));




        LineChart lineChart=(LineChart)findViewById(R.id.chart1);

        //グラフ用データ　　　本来ならループ文で記載、保存データ数によりグラフが変化するようにしたい
        ArrayList<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry(a,0));
        entries.add(new Entry(d,1));
        entries.add(new Entry(e,2));
//        entries.add(new Entry(f,3));
//        entries.add(new Entry(g,4));

        //データをセット
        LineDataSet dataSet = new  LineDataSet(entries,"weight");

        //DBクローズ
        c.close();
        db.close();

        //ラベル
        String [] labels ={"2005","2006","2007","2008","2009","2010,","2011"};


        //LineDataインスタンス作成
        LineData data = new LineData(labels,dataSet);


        //LineDataをLineChartにセット
        lineChart.setData(data);

        //説明文
        lineChart.setDescription("正解数");


        //背景色
        lineChart.setBackgroundColor(Color.WHITE);

        //アニメーション
        lineChart.animateX(1200);

    }

}
