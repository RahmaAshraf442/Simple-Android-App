package com.example.weare.translator;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.text.ParsePosition;
import java.util.ArrayList;

public class Numbers extends AppCompatActivity {
    ListView list;
    MyWordsAdapter newadapt;
    ImageView im;
    private MediaPlayer m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        list = findViewById(R.id.list_view_num);
        im =findViewById(R.id.imageView_play);
        // Array List with word data type have Numbers
        final ArrayList<Word> word =new ArrayList<Word>();
        word.add(new Word("Lut:i","One",R.drawable.number_one,R.raw.number_one));
        word.add(new Word("’oṭi:ko","Two",R.drawable.number_two, R.raw.number_two));
        word.add(new Word("tolo:koshu","three" , R.drawable.number_three, R.raw.number_three));
        word.add(new Word("oy:is:a","Four" , R.drawable.number_four,R.raw.number_four));
        word.add(new Word("mash:ok:a",  "Five" ,R.drawable.number_five, R.raw.number_five));
        word.add(new Word("tem:ok:a","Six" , R.drawable.number_six, R.raw.number_six));
        word.add(new Word("kenek:aku","Seven" , R.drawable.number_seven, R.raw.number_seven));
        word.add(new Word("kenek:aku","Eight" , R.drawable.number_eight, R.raw.number_eight));
        word.add(new Word("Wo'e","Nine" , R.drawable.number_nine , R.raw.number_nine));
        word.add(new Word("na’a:cha","Ten" , R.drawable.number_ten , R.raw.number_ten));
        //Add data to adapter
        newadapt=new MyWordsAdapter(this,R.layout.activity_shape,word , R.color.green);
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