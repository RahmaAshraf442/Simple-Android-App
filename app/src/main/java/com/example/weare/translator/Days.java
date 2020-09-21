package com.example.weare.translator;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class Days extends AppCompatActivity {
    ListView list;
    MyWordsAdapter newadapt;
    private MediaPlayer m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days);
        list = findViewById(R.id.list_of_days);
        // Array List with word data type have Numbers
        final ArrayList<Word> word = new ArrayList<Word>();
        word.add(new Word("Saturday", "السبت", R.raw.phrase_are_you_coming));
        word.add(new Word("Sunday", "الاحد", R.raw.phrase_come_here));
        word.add(new Word("Monday", "الاثنين", R.raw.phrase_how_are_you_feeling));
        word.add(new Word("Tuesday", "الثلاثاء", R.raw.phrase_im_feeling_good));
        word.add(new Word("Wednesday", "الاربعاء", R.raw.phrase_what_is_your_name));
        word.add(new Word("Thursday", "الخميس", R.raw.phrase_where_are_you_going));
        word.add(new Word("Friday", "الجمعة", R.raw.calm_music));

        //Add data to adapter
        newadapt = new MyWordsAdapter(this, R.layout.activity_shape, word, R.color.green);
        list.setAdapter(newadapt);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Word w = word.get(position);
                releaseMediaPlayer();
                m = MediaPlayer.create(Days.this, w.getAudio_source());
                //im.setImageResource(R.drawable.ic_play);

                m.start();
                //im.setImageResource(R.drawable.ic_pause);
                m.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        releaseMediaPlayer();
                    }
                });

            }
        });
    }

    // stop song on exit the app
@Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
    //on click in another item stop the current audio
    private void releaseMediaPlayer() {
        if (m != null) {
            m.release();
            m = null;
        }
    }
}