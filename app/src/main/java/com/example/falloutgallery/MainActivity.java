package com.example.falloutgallery;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    private static final int CODE_GALLERY = 1;

    ImageView uploadIV;
    Button uploadBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uploadIV = findViewById(R.id.uploadIV);
        uploadBTN = findViewById(R.id.uploadBTN);//Связываемся с нашей кнопкой Button:

        uploadBTN.setOnClickListener(new View.OnClickListener() { //Настраиваем для нее обработчик нажатий OnClickListener:
            @Override
            public void onClick(View v) {
                //Вызываем стандартную галерею для выбора изображения с помощью Intent.ACTION_PICK:
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                //Тип получаемых объектов - image:
                intent.setType("image/*");
                //Запускаем переход с ожиданием обратного результата в виде информации об изображении:
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), CODE_GALLERY);


            }
        });
    }

//    public void uploadClick(View view) {
//        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
//        startActivityForResult(intent, CODE_GALLERY);
//
//    }

    //Обрабатываем результат выбора в галерее:
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == CODE_GALLERY && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri uri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                uploadIV.setImageBitmap(bitmap);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public void BUM(View view) {
        TextView textView = findViewById(R.id.TV);
        textView.setText("PRPRPRPRP");
    }
}

