package com.example.falloutgallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.falloutgallery.classes.CardItem;

import java.util.ArrayList;

public class StartMenu extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_menu);
    }

    public void goToQuestList(View view) {
        Intent intent = new Intent(StartMenu.this, QuestList.class);
        startActivity(intent);

    }
    public void goToYourQuests(View view) {
        Intent intent = new Intent(StartMenu.this, YourQuests.class);
        startActivity(intent);

    }


}
