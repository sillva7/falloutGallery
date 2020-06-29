package com.example.falloutgallery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.falloutgallery.adapters.AdapterForQuestList;
import com.example.falloutgallery.classes.CardItem;
import com.example.falloutgallery.classes.MyDialogFragment;

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
    public boolean onCreateOptionsMenu(Menu menu) {//меню
        getMenuInflater().inflate(R.menu.main_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {//создание меню и всплывающего окна
        switch (item.getItemId()) {

            case R.id.about:
                FragmentManager manager = getSupportFragmentManager();
                MyDialogFragment myDialogFragment = new MyDialogFragment();
                myDialogFragment.show(manager, "myDialog");
                return true;
            case R.id.home:
                startActivity(new Intent(this, StartMenu.class));
                return true;

        }
        return true;
    }




}

