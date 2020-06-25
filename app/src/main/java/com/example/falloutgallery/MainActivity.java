package com.example.falloutgallery;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.falloutgallery.classes.CardItem;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<CardItem> cardItems = new ArrayList<>();

        cardItems.add(new CardItem(R.drawable.qqqqq, "001"));
        cardItems.add(new CardItem(R.drawable.qqqqq, "002"));
        cardItems.add(new CardItem(R.drawable.qqqqq, "003"));
        cardItems.add(new CardItem(R.drawable.qqqqq, "004"));
        cardItems.add(new CardItem(R.drawable.qqqqq, "005"));
        cardItems.add(new CardItem(R.drawable.qqqqq, "006"));
        cardItems.add(new CardItem(R.drawable.qqqqq, "007"));

        recyclerView = findViewById(R.id.recyclerView);
        adapter = new RecyclerViewAdapter(cardItems);
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

    }




}

