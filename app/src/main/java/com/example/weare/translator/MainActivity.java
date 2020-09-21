package com.example.weare.translator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView num , day , country , name , color ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //inflate
        num=findViewById(R.id.numbers_text_view);
        name=findViewById(R.id.names_text_view);
        day=findViewById(R.id.days_text_view);
        color=findViewById(R.id.color_text_view);

        //on Click Numbers
        num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getBaseContext(),Numbers.class);
                startActivity(intent);
            }
        });
        //on Click Names
        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getBaseContext(), Family.class);
                startActivity(intent);
            }
        });
        //on Click Days
        day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getBaseContext(),Days.class);
                startActivity(intent);
            }
        });


        //on Click colors
        color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getBaseContext(),Colors.class);
                startActivity(intent);
            }
        });

    }
}