package com.example.weare.translator;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.zip.Inflater;

import static java.security.AccessController.getContext;

public class MyWordsAdapter extends BaseAdapter {
    private Context context ;
    private int resource ;
    private ArrayList<Word> words ;
    private int back;
    public MyWordsAdapter(Context context , int resource , ArrayList<Word> words , int back){
        this.context = context;
        this.resource = resource;
        this.words = words;
        this.back=back;
    }
    @Override
    public int getCount() {
        return words.size();
    }

    @Override
    public Word getItem(int i) {
        return words.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v =view;
        if(v == null){
            v = LayoutInflater.from(context).inflate(resource,null,false);
        }
        TextView eng=v.findViewById(R.id.english_word_tv);
        TextView ar=v.findViewById(R.id.arabic_word_tv);
        ImageView im =v.findViewById(R.id.image_view);
        View linear = v.findViewById(R.id.linear_layout);
        int color = ContextCompat.getColor(context ,this.back);
        linear.setBackgroundColor(color);

        Word w =words.get(i);

        eng.setText(w.getEnglish_word());
        ar.setText(w.getArabic_word());
        im.setImageResource(w.getImage_source());
        return v;
    }
}
