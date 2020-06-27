package com.example.falloutgallery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.falloutgallery.adapters.AdapterForQuestList;
import com.example.falloutgallery.adapters.AdapterForYourQuests;
import com.example.falloutgallery.classes.CardItem;

import java.util.ArrayList;

public class YourQuests extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_quests);

        ArrayList<CardItem> cardItems = new ArrayList<>();

        Intent intent = getIntent();

        CardItem cardItem = new CardItem(intent.getIntExtra("imgRsrc", 0), intent.getStringExtra("title"));
        cardItems.add(cardItem);

        recyclerView = findViewById(R.id.recyclerViewOfYourQuests);
        adapter = new AdapterForYourQuests(cardItems, this);
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);



//        cardItems = new ArrayList<>();
//
//        Intent intent = getIntent();
//        if (intent != null) {
//            CardItem cardItem = new CardItem(intent.getIntExtra("imgRsrc", 0), intent.getStringExtra("title"));
//            cardItems.add(cardItem);
//            recyclerView = findViewById(R.id.recyclerView);
//            adapter = new AdapterForYourQuests(cardItems, this);
//            layoutManager = new LinearLayoutManager(this);
//
//            recyclerView.setAdapter(adapter);
//            recyclerView.setLayoutManager(layoutManager);
//
//        }else{
//            recyclerView.setLayoutManager(layoutManager);
//
//        }




    }


}
