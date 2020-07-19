package com.example.falloutgallery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.falloutgallery.adapters.AdapterForQuestList;
import com.example.falloutgallery.classes.CardItem;
import com.example.falloutgallery.classes.MyDialogFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class QuestList extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest_list);


        ArrayList<CardItem> cardItems = new ArrayList<>();
        String draId = getResources().getResourceEntryName(R.drawable.f14);//имя картинки
        int imageKey = getResources().getIdentifier("f" + 14, "drawable", getPackageName());//код картинки
        Map<String, Integer> allImages = new HashMap<>();
        for (int i = 0; i < 238; i++) {
            if (getResources().getIdentifier("f" + i, "drawable", getPackageName()) != 0) {
                allImages.put("" + i, getResources().getIdentifier("f" + i, "drawable", getPackageName()));
            } else {
            }
        }
        for (int i = 0; i < 238; i++) {
            if (allImages.get("" + i) != null) {
                cardItems.add(new CardItem(allImages.get("" + i), "" + i));
            } else {
            }
        }


//            int[] myImageList = new int[]{R.drawable.f14};
        Log.d("shoow", allImages + "");
        Log.d("shoow", allImages.size() + "");


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

