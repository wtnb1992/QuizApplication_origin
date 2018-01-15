package com.example.repens.quizapplication;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;

/**
 * Created by repens on 2017/09/08.
 */

public class BgmPlayerClass {


    //配列5枠用意
    private MediaPlayer[] mediaPlayer = new MediaPlayer[5];

    public BgmPlayerClass(Context context) {


        //BGMファイル読み込み
        this.mediaPlayer[0] = MediaPlayer.create(context, R.raw.new_departure);
        this.mediaPlayer[1] = MediaPlayer.create(context, R.raw.away_from_the_moment);
        this.mediaPlayer[2] = MediaPlayer.create(context,R.raw.serenade);


        //ループ再生
        this.mediaPlayer[0].setLooping(true);
        this.mediaPlayer[1].setLooping(true);
        this.mediaPlayer[2].setLooping(true);
        //音量設定
        this.mediaPlayer[0].setVolume(1.0f, 1.0f);
        this.mediaPlayer[1].setVolume(1.0f, 1.0f);
        this.mediaPlayer[2].setVolume(1.0f, 1.0f);
    }

    //BGM再生   !は「否定」の論理演算子
    public void start(int aaa) {
        if (!mediaPlayer[aaa].isPlaying()) {
            mediaPlayer[aaa].seekTo(0);
            mediaPlayer[aaa].start();
        }
    }

    //BGM停止
    public void stop(int aaa) {
        if (mediaPlayer[aaa].isPlaying()) {
            mediaPlayer[aaa].stop();
            mediaPlayer[aaa].prepareAsync();
        }
    }

    //一時停止
    public void pause(int aaa) {
        if (mediaPlayer[aaa].isPlaying()) {
            mediaPlayer[aaa].pause();
            mediaPlayer[aaa].prepareAsync();
        }
    }

}