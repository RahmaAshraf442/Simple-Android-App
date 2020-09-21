package com.example.weare.translator;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Family extends AppCompatActivity {
    ListView list;
    MyWordsAdapter newadapt;
    private MediaPlayer m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);
        list = findViewById(R.id.list_of_family);

        // Array List with word data type have Numbers
        final ArrayList<Word> word =new ArrayList<Word>();
        word.add(new Word("'ama","GrandMather",R.drawable.family_grandmother , R.raw.family_grandmother));
        word.add(new Word("'pa'pa:","GrandFather",R.drawable.family_grandfather , R.raw.family_grandfather));
        word.add(new Word("'uta:","Mother" , R.drawable.family_mother , R.raw.family_mother));
        word.add(new Word("'upu:","Father" , R.drawable.family_father , R.raw.family_father));
        word.add(new Word("tun:ne'","Daughter" , R.drawable.family_daughter , R.raw.family_daughter));
        word.add(new Word("'angsi","Son" , R.drawable.family_son , R.raw.family_son));
        //Add data to adapter
        newadapt=new MyWordsAdapter(this,R.layout.activity_shape,word, R.color.green);
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