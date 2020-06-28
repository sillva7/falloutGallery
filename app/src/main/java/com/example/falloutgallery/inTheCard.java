package com.example.falloutgallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.falloutgallery.classes.CardItem;

public class inTheCard extends AppCompatActivity {
    Context context;
    Intent intentToYourQuests;
    CardItem cardItem;
    Intent intent;

    Button addBTN, removeBTN, goToYourQuests;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_the_card);

        ImageView imageView = findViewById(R.id.innerIV);
        TextView textView = findViewById(R.id.innerTitle);
        addBTN = findViewById(R.id.addBTN);
        removeBTN = findViewById(R.id.removeBTN);
        goToYourQuests = findViewById(R.id.goToYourQuests);


        intent = getIntent();

        if (intent.getStringExtra("whereFromThisIntent").equals("AdapterForQuestList")) {

            addBTN.setVisibility(View.VISIBLE);
            removeBTN.setVisibility(View.GONE);

        }else if(intent.getStringExtra("whereFromThisIntent").equals("AdapterForYourQuests")){

            removeBTN.setVisibility(View.VISIBLE);
            addBTN.setVisibility(View.GONE);

        }


        if (intent != null) {
            textView.setText(intent.getStringExtra("title"));
            imageView.setImageResource(intent.getIntExtra("imgRsrc", 0));
        }

        intentToYourQuests = new Intent(inTheCard.this, YourQuests.class);
        cardItem = new CardItem(intent.getIntExtra("imgRsrc", 0), intent.getStringExtra("title"));

    }

    public void addToYourQuests(View view) {

        YourQuests.cardItems.add(cardItem);


        intentToYourQuests.putExtra("imgRsrc", cardItem.getImgRsrc());
        intentToYourQuests.putExtra("title", cardItem.getTitle());

        Toast.makeText(this, "ADDED", Toast.LENGTH_LONG).show();


    }

    public void toYoursQuest(View view) {

        startActivity(intentToYourQuests);

    }

    public void removeFromYourQuests(View view) {

        for (int i = 0; i < YourQuests.cardItems.size(); i++) {
            if (cardItem.getTitle().equals(YourQuests.cardItems.get(i).getTitle())) {
                YourQuests.cardItems.remove(i);
            }
        }

        Toast.makeText(this, "REMOVED", Toast.LENGTH_LONG).show();

    }
}
