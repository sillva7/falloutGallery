package com.example.falloutgallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class inTheCard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_the_card);

        ImageView imageView = findViewById(R.id.innerIV);
        TextView textView = findViewById(R.id.innerTitle);
        Intent intent = getIntent();




        if(intent != null){
            textView.setText(intent.getStringExtra("title"));
            imageView.setImageResource(intent.getIntExtra("imgRsrc", 0));
        }


    }

    public void addToYourQuests(View view) {



    }
}
