package com.example.repens.quizapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by repens on 2017/08/21.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context){

        //任意の"dbファイル名"と.verを指定
        super(context,"MyTable.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        //テーブル作成     表示する要素が固定の場合最初に定義
        db.execSQL("CREATE TABLE MyTable " +
                "(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT" +
                ", Pref TEXT" +
                ", Answer0 TEXT" +
                ", Answer1 TEXT" +
                ", Answer2 TEXT" +
                ", Answer3 TEXT" +
                ", Answer4 TEXT" +
//                ", Clear INTEGER" +
                ")");
        //初期データ投入
//        db.execSQL("INSERT INFO MyTable(Pref,Answer0, Answer1, Answer2, Answer3, Answer4) values ('問題文','正解','回答１','','','');");
/**        db.execSQL("INSERT INTO MyTable(Pref,Answer0, Answer1, Answer2, Answer3, Answer4) values ('日本の首都といえばどこでしょう？','東京都','北海道','大阪府','東京都','新潟県');");
 db.execSQL("INSERT INTO MyTable(Pref,Answer0, Answer1, Answer2, Answer3, Answer4) values ('落語の噺の１つで、とても長い名前の男の子が登場する噺といえばなんでしょう？','寿限無','まんじゅうこわい','寿限無','こんにゃく問答','目黒のさんま');");
 db.execSQL("INSERT INTO MyTable(Pref,Answer0, Answer1, Answer2, Answer3, Answer4) values ('「一見簡単そうに見えるが、最初に行うことは難しい」ということわざ、コロンブスの何でしょう？','卵','卯','鶏','夢','卵');");
 db.execSQL("INSERT INTO MyTable(Pref,Answer0, Answer1, Answer2, Answer3, Answer4) values ('コナン・ドイルの作品、「シャーロック・ホームズ」に出てくるホームズの友人であり医者でもある人物の名前は？','ワトソン','ワトソン','パトロン','ハドソン','ワセリン');");
 db.execSQL("INSERT INTO MyTable(Pref,Answer0, Answer1, Answer2, Answer3, Answer4) values ('世界三大瀑布に数えられ、「悪魔の喉笛」と呼ばれる滝壺が有名な滝といえば？','イグアスの滝','ナイアガラの滝','エンジェルフォール','ヴィクトリアの滝','イグアスの滝');");
 db.execSQL("INSERT INTO MyTable(Pref,Answer0, Answer1, Answer2, Answer3, Answer4) values ('アメリカ出身の音楽家、ジョン・ケージが1952年に作曲した全楽章が休符で構成された曲といえば？','4分33秒','33-4','silent','迷い子達の奇想曲','4分33秒');");
 db.execSQL("INSERT INTO MyTable(Pref,Answer0, Answer1, Answer2, Answer3, Answer4) values ('パスタの料理法の一つで「漁師風」という意味の魚介類のパスタ料理といえば？','ペスカトーレ','ペスカトーレ','アラビアータ','マリナーラ','マリナータ');");
 db.execSQL("INSERT INTO MyTable(Pref,Answer0, Answer1, Answer2, Answer3, Answer4) values ('「3 以上の自然数 n について、x^n + y^n = z^n となる自然数の組 (x, y, z) は存在しない」という定理を提唱したフランスの数学者といえば誰でしょう？','フェルマー','ピエトロ','ピタゴラス','フェルマー','デューマ');");
 db.execSQL("INSERT INTO MyTable(Pref,Answer0, Answer1, Answer2, Answer3, Answer4) values ('日本酒のうち、「醸造アルコールを使用せず、精米歩合が50パーセント以下」のものは何と呼ばれるでしょう？','純米大吟醸','特別醸造酒','純米大吟醸','特別純米酒','純米酒');");
 db.execSQL("INSERT INTO MyTable(Pref,Answer0, Answer1, Answer2, Answer3, Answer4) values ('宝石の研磨方式の１つで、58面体にカットする方式といえば？','ブリリアントカット','ブリリアントカット','板倉式研磨法','エレガントカット','ダイヤモンドカット');");
 db.execSQL("INSERT INTO MyTable(Pref,Answer0, Answer1, Answer2, Answer3, Answer4) values ('日本の剣術家宮本武蔵が完成させた大太刀と小太刀を使う二刀の流派といえば？','二天一流','卜伝流','飛天御剣流','示現流','二天一流');");
 db.execSQL("INSERT INTO MyTable(Pref,Answer0, Answer1, Answer2, Answer3, Answer4) values ('現在の埼玉県にある、「浮き城」とも呼ばれる日本の城の名前といえば？','忍城','白鷺城','鶴ヶ城','忍城','丸亀城');");
 db.execSQL("INSERT INTO MyTable(Pref,Answer0, Answer1, Answer2, Answer3, Answer4) values ('イタリアの美術家「レオナル・ド・ダヴィンチ」の油彩画で、女性の上半身のみが描かれている肖像画といえば？','モナ・リザ','モナ・リザ','真珠の耳飾りの少女','ヴィーナスの誕生','鏡の前の女');");
 db.execSQL("INSERT INTO MyTable(Pref,Answer0, Answer1, Answer2, Answer3, Answer4) values ('光の三原色の組み合わせとして正しいものはどれでしょう？','赤・青・緑','赤・青・黄','赤・緑・白','赤・青・緑','白・青・黄');");
 db.execSQL("INSERT INTO MyTable(Pref,Answer0, Answer1, Answer2, Answer3, Answer4) values ('普段は海で遮られている陸地と島が干潮時にのみつながる現象といえば？','トンボロ現象','トレモロ現象','トンドロ現象','トンボロ現象','トカレフ現象');");
 db.execSQL("INSERT INTO MyTable(Pref,Answer0, Answer1, Answer2, Answer3, Answer4) values ('マイクロソフト社の共同創業者であるポール・アレンが2015年に発見した、シブヤン海で沈没した旧日本軍の戦艦といえば？','武蔵','大和','武蔵','長門','陸奥');");
 db.execSQL("INSERT INTO MyTable(Pref,Answer0, Answer1, Answer2, Answer3, Answer4) values ('真珠湾攻撃時に打電された暗号文「ニイタカヤマノボレ」の意味といえば？','戦闘行動開始せよ','戦闘行動開始せよ','全軍、突撃セヨ','我、奇襲に成功セリ','第二次攻撃の要あり');");
 db.execSQL("INSERT INTO MyTable(Pref,Answer0, Answer1, Answer2, Answer3, Answer4) values ('別名「海の悪魔」とも呼ばれている生物といえば？','タコ','アンコウ','タコ','サメ','シャチ');");
 db.execSQL("INSERT INTO MyTable(Pref,Answer0, Answer1, Answer2, Answer3, Answer4) values ('北欧神話に登場する主神オーディンが所持する、槍を向けた軍勢に勝利をもたらす槍といえば？','グングニル','グングニル','グレイプニル','ミョルニル','レーヴァテイン');");
 db.execSQL("INSERT INTO MyTable(Pref,Answer0, Answer1, Answer2, Answer3, Answer4) values ('「昔者荘周夢に胡蝶と為る。栩栩然として胡蝶なり。」で始まる、荘子の説話といえば？','胡蝶の夢','山月記','胡蝶の夢','塞翁馬','矛盾');");
 db.execSQL("INSERT INTO MyTable(Pref,Answer0, Answer1, Answer2, Answer3, Answer4) values ('シェイクスピアの四台悲劇といえば、「ハムレット」、「オセロー」、「リア王」と何でしょう？','マクベス','マクベス','ロミオとジュリエット','ジョン王','ジンベリン');");
 db.execSQL("INSERT INTO MyTable(Pref,Answer0, Answer1, Answer2, Answer3, Answer4) values ('夏の大三角形を構成する星座の組み合わせで正しいのはどれ？','はくちょう座・こと座・わし座','うお座・こと座・はくちょう座','はくちょう座・こぐま座・おとめ座','しし座・おとめ座・こと座','はくちょう座・こと座・わし座');");
 db.execSQL("INSERT INTO MyTable(Pref,Answer0, Answer1, Answer2, Answer3, Answer4) values ('アニメ「ドラえもん」のドラえもんは何型ロボットでしょう？','ネコ','タヌキ','ネコ','キツネ','パンダ');");
 db.execSQL("INSERT INTO MyTable(Pref,Answer0, Answer1, Answer2, Answer3, Answer4) values ('出世魚の代表である「ブリ」、ブリと呼ばれるようになる1つ前はなんと呼ばれるでしょう？','ワラサ','ワラサ','イナダ','コノシロ','オジサン');");
 db.execSQL("INSERT INTO MyTable(Pref,Answer0, Answer1, Answer2, Answer3, Answer4) values ('現在の12月のことを旧暦では何と呼ぶでしょう？','師走','水無月','霜月','神無月','師走');");
 db.execSQL("INSERT INTO MyTable(Pref,Answer0, Answer1, Answer2, Answer3, Answer4) values ('春の七草のひとつ、「すずしろ」いえば何の野菜のことでしょうか？','大根','カブ','大根','もやし','水菜');");
 db.execSQL("INSERT INTO MyTable(Pref,Answer0, Answer1, Answer2, Answer3, Answer4) values ('別名「黒いダイヤ」とも呼ばれる食べ物といえば？','トリュフ','キャビア','トリュフ','胡椒','カカオ');");
 db.execSQL("INSERT INTO MyTable(Pref,Answer0, Answer1, Answer2, Answer3, Answer4) values ('人体の構成成分の中で一番多いものといえば？','水分','ミネラル','水分','タンパク質','脂肪');");
 db.execSQL("INSERT INTO MyTable(Pref,Answer0, Answer1, Answer2, Answer3, Answer4) values ('強烈なにおいを放つ世界最大の花といえば？','ラフレシア','ひまわり','ラフレシア','カサブランカ','リンドウ');");
 db.execSQL("INSERT INTO MyTable(Pref,Answer0, Answer1, Answer2, Answer3, Answer4) values ('【イントロクイズ】\n答えはセレナード','セレナード','セレナード','エチュード','ノクターン','ワルツ');");
 */

    }

    //DB更新時
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }

}
