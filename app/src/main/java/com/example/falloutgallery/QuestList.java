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
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
    private EditText searchET;
    private Button searchBTN, backBTN;
    private Map<String, Integer> allImages;
    private ArrayList<CardItem> cardItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest_list);

        searchBTN = findViewById(R.id.searchBTN);
        searchET = findViewById(R.id.searchET);
        recyclerView = findViewById(R.id.recyclerView);
        backBTN = findViewById(R.id.backBTN);

        cardItems = new ArrayList<>();
        //String draId = getResources().getResourceEntryName(R.drawable.f14);//имя картинки
        //int imageKey = getResources().getIdentifier("f" + 14, "drawable", getPackageName());//код картинки
        allImages = new HashMap<>();//мап нужен чтобы сделать возможность поиска в дальнейшем
        for (int i = 0; i < 238; i++) {
            if (getResources().getIdentifier("f" + i, "drawable", getPackageName()) != 0) {
                allImages.put("" + i, getResources().getIdentifier("f" + i, "drawable", getPackageName()));//закладываем в мап кей: Имя картинки. Валуе: Путь до картинки
            } else {
            }
        }
        for (int i = 0; i < 238; i++) {
            if (allImages.get("" + i) != null) {
                cardItems.add(new CardItem(allImages.get("" + i), "" + i));//создаём новые объект, первый арг: путь до картинки. Второй арг: название картинки
            } else {
            }
        }

        installAdapter();

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


    public void search(View view) {
        String searchT = searchET.getText().toString();
        for (int i = 0; i < 238; i++) {
            if(allImages.get(""+i)!=null){
                for(String key : allImages.keySet()){
                    if(key.equals(searchT)){
                        cardItems.clear();
                        cardItems.add(new CardItem(allImages.get(""+key), key));
                    }
                }
            }else{
                cardItems.clear();
            }
        }
        installAdapter();
        backBTN.setVisibility(View.VISIBLE);


    }
    private void installAdapter(){//мб весь этот целый метод можно было заменить одним notifyDataSetChanged  в сеттере адаптера?
        adapter = new AdapterForQuestList(cardItems, this);
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    public void back(View view) {
        cardItems.clear();
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
        installAdapter();
        backBTN.setVisibility(View.GONE);
    }
}

