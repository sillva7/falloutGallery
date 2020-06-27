package com.example.falloutgallery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.falloutgallery.adapters.AdapterForQuestList;
import com.example.falloutgallery.classes.CardItem;

import java.util.ArrayList;

public class QuestList extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest_list);

        ArrayList<CardItem> cardItems = new ArrayList<>();

        cardItems.add(new CardItem(R.drawable.qqqqq, "001"));
        cardItems.add(new CardItem(R.drawable.qqqqq, "002"));
        cardItems.add(new CardItem(R.drawable.qqqqq, "003"));
        cardItems.add(new CardItem(R.drawable.qqqqq, "004"));
        cardItems.add(new CardItem(R.drawable.qqqqq, "005"));
        cardItems.add(new CardItem(R.drawable.qqqqq, "006"));
        cardItems.add(new CardItem(R.drawable.qqqqq, "007"));

        recyclerView = findViewById(R.id.recyclerView);
        adapter = new AdapterForQuestList(cardItems, this);
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

    }




}

