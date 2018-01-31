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

    String frag_graph;
    String[] sample = new String[999];
    int[] i = new int[999] ;
    int x =0;
//    String lab[] = {"1","2","3"} ;
//    String[] lab = new String[999];


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
        int dbdata = c.getCount();


        //DBのカーソルを最初に持ってくる。(必須)
        c.moveToFirst();


        //グラフ表示準備

        LineChart lineChart=(LineChart)findViewById(R.id.chart1);
        ArrayList<Entry> entries = new ArrayList<Entry>();

/*//otamesi//
        i[x] = c.getInt(c.getColumnIndex("Number"));
        c.moveToNext();
        entries.add(new Entry(i[x],x));
        LineDataSet dataSet = new  LineDataSet(entries,"weight");
//        x=x+2;
//                lab[x] = String.valueOf(x);

//        LineData data = new LineData(lab,dataSet);

        String [] labels ={"1","2","3","4","5","6","7","8","9","10"};
        LineData data = new LineData(labels,dataSet);
        lineChart.setData(data);
//        System.out.println(labels[1]);
//        System.out.println(lab[x]);


//         //*/




        //DBにデータがある場合成績表示
        if(dbdata!=0){

            //DB内のデータをリストに格納
            while(x < dbdata){
                i[x] = c.getInt(c.getColumnIndex("Number"));
                c.moveToNext();
//                System.out.println(i[x]);




                entries.add(new Entry(i[x],x));
                //データをセット
                LineDataSet dataSet = new  LineDataSet(entries,"weight");



                //ラベル　　//loopで表示
                String [] labels ={"1","2","3","4","5","6,","7"};
//                labels[x] = String.valueOf(x);
//                String  answer = String.valueOf(AnswerNo);   //AnswerNo.toString() ;


                //LineDataインスタンス作成
                LineData data = new LineData(labels,dataSet);


                //LineDataをLineChartにセット
                lineChart.setData(data);


                x++;

            }



            //DBクローズ
//            c.close();
//            db.close();


            //説明文
            lineChart.setDescription("正解数");


            //背景色
            lineChart.setBackgroundColor(Color.WHITE);

            //アニメーション
            lineChart.animateX(1200);




            //データベースの変数をセット　　　　本当ならループ文で記載
//        String a= c.getString(c.getColumnIndex("Number"));
//        int a= c.getInt(c.getColumnIndex("Number"));
//        c.moveToNext();

/*
        LineChart lineChart=(LineChart)findViewById(R.id.chart1);

        //グラフ用データ　　　本来ならループ文で記載、保存データ数によりグラフが変化するようにしたい
        ArrayList<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry(a,0));
//        entries.add(new Entry(d,1));
//        entries.add(new Entry(e,2));
//        entries.add(new Entry(f,3));
//        entries.add(new Entry(g,4));

        //データをセット
        LineDataSet dataSet = new  LineDataSet(entries,"weight");

        //DBクローズ
        c.close();
        db.close();

        //ラベル　　//loopで表示
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
*/



        }
        c.close();
        db.close();


        //データベースの変数をセット　　　　本当ならループ文で記載
//        String a= c.getString(c.getColumnIndex("Number"));
//        int a= c.getInt(c.getColumnIndex("Number"));
//        c.moveToNext();
//        int d= c.getInt(c.getColumnIndex("Number"));
//        c.moveToNext();
//        int e= c.getInt(c.getColumnIndex("Number"));
//        c.moveToNext();
//        int f= c.getInt(c.getColumnIndex("Number"));
//        c.moveToNext();
//        int g= c.getInt(c.getColumnIndex("Number"));



/*
        LineChart lineChart=(LineChart)findViewById(R.id.chart1);

        //グラフ用データ　　　本来ならループ文で記載、保存データ数によりグラフが変化するようにしたい
        ArrayList<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry(a,0));
//        entries.add(new Entry(d,1));
//        entries.add(new Entry(e,2));
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
*/
    }


}
