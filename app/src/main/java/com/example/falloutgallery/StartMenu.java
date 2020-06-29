package com.example.falloutgallery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;
import androidx.fragment.app.FragmentManager;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.falloutgallery.classes.MyDialogFragment;

public class StartMenu extends AppCompatActivity {

    Button ql , yq;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_menu);

        ql = findViewById(R.id.questList);
        yq = findViewById(R.id.currentQuestList);
        ql.setText(getResources().getString(R.string.QuestList));
        yq.setText(getResources().getString(R.string.YourQuests));




    }

    public void goToQuestList(View view) {
        Intent intent = new Intent(StartMenu.this, QuestList.class);
        startActivity(intent);

    }

    public void goToYourQuests(View view) {
        Intent intent = new Intent(StartMenu.this, YourQuests.class);
        startActivity(intent);

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

        }
        return true;
    }
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        MenuItem home = menu.findItem(R.id.home);//кнопку хоум делаем на этом активити невидимым
        home.setVisible(false);

        return true;
    }


}
