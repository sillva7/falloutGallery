package com.example.falloutgallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.falloutgallery.classes.CardItem;

import com.example.falloutgallery.YourQuests;

import java.util.ArrayList;

public class inTheCard extends AppCompatActivity {
    Context context;
    Intent intentToYourQuests;
    CardItem cardItem;
    Intent intent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_the_card);

        ImageView imageView = findViewById(R.id.innerIV);
        TextView textView = findViewById(R.id.innerTitle);
        intent= getIntent();



        if(intent != null){
            textView.setText(intent.getStringExtra("title"));
            imageView.setImageResource(intent.getIntExtra("imgRsrc", 0));
        }

        intentToYourQuests = new Intent(inTheCard.this, YourQuests.class);










    }

    public void addToYourQuests(View view) {
        cardItem = new CardItem(intent.getIntExtra("imgRsrc", 0), intent.getStringExtra("title"));


        intentToYourQuests.putExtra("imgRsrc",cardItem.getImgRsrc());
        intentToYourQuests.putExtra("title", cardItem.getTitle());




    }

    public void toYoursQuest(View view) {

        startActivity(intentToYourQuests);

    }
}
