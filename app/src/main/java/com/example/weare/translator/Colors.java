package com.example.weare.translator;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Colors extends AppCompatActivity {

    ListView list;
    MyWordsAdapter newadapt;
    private MediaPlayer m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);
        list = findViewById(R.id.list_for_color);

        // Array List with word data type have Numbers
        final ArrayList<Word> word =new ArrayList<Word>();
        word.add(new Word("kulul:i","Black",R.drawable.color_black , R.raw.color_black));
        word.add(new Word("kelel:i","White",R.drawable.color_white , R.raw.color_white));
        word.add(new Word("che˙we˙w:i","Gray" , R.drawable.color_gray , R.raw.color_gray));
        word.add(new Word("chitit:i","Green" , R.drawable.color_green , R.raw.color_green));
        word.add(new Word("bfd:dsv'h",  "Mustard Yellow " ,R.drawable.color_mustard_yellow , R.raw.color_mustard_yellow));
        word.add(new Word("yoyol:i","Red" , R.drawable.color_red , R.raw.color_red));
        word.add(new Word("tatat:i","Brown" , R.drawable.color_brown , R.raw.color_brown));
        //Add data to adapter
        newadapt=new MyWordsAdapter(this,R.layout.activity_shape,word,R.color.green);
        list.setAdapter(newadapt);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Word w =word.get(position);
                releaseMediaPlayer();
                m = MediaPlayer.create(getBaseContext(), w.getAudio_source());

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
    private void releaseMediaPlayer(){
        if(m != null){
            m.release();
            m =null;
        }
    }
}