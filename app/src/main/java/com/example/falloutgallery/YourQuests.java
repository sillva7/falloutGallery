package com.example.falloutgallery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.falloutgallery.adapters.AdapterForYourQuests;
import com.example.falloutgallery.classes.CardItem;
import com.example.falloutgallery.classes.MyDialogFragment;

import java.util.ArrayList;

public class YourQuests extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    public static ArrayList<CardItem> cardItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_quests);


        Intent intent = getIntent();



        recyclerView = findViewById(R.id.recyclerViewOfYourQuests);
        adapter = new AdapterForYourQuests(cardItems, this);


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


    public void changeView(View view) {
        if(Utils.VIEW){
            Utils.VIEW=false;

            recyclerView = findViewById(R.id.recyclerViewOfYourQuests);
            adapter = new AdapterForYourQuests(cardItems, this);


            layoutManager = new LinearLayoutManager(this);

            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(layoutManager);

        }else{
            Utils.VIEW=true;
            adapter = new AdapterForYourQuests(cardItems, this);


            layoutManager = new GridLayoutManager(this, 2);


            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(layoutManager);
        }


    }
}
