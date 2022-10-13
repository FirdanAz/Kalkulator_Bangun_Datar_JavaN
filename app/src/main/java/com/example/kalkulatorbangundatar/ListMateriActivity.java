package com.example.kalkulatorbangundatar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ListMateriActivity extends AppCompatActivity {

    private CardView btn_persegi, btn_ppanjang, btn_segitiga, btn_jajar_genjang, btn_trapesium, btn_belah_ketupat, btn_lingkaran, btn_layang;
    private ImageView imageView;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_materi);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Materi");

        btn_persegi = findViewById(R.id.btn_persegi);
        btn_ppanjang = findViewById(R.id.btn_ppanjang);
        btn_segitiga = findViewById(R.id.btn_segitiga);
        btn_jajar_genjang = findViewById(R.id.btn_jajar_genjang);
        btn_trapesium = findViewById(R.id.btn_trapesium);
        btn_belah_ketupat = findViewById(R.id.btn_belah_ketupat);
        btn_lingkaran = findViewById(R.id.btn_lingkaran);
        btn_layang = findViewById(R.id.btn_layang);
        imageView = findViewById(R.id.img_set_display);

        btn_persegi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.img_persegi);
            }
        });
        btn_ppanjang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.img_persegi_panjang);
            }
        });
        btn_segitiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.img_segitiga);
            }
        });
        btn_jajar_genjang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.img_jajar_genjang);
            }
        });
        btn_trapesium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.img_trapesium);
            }
        });
        btn_belah_ketupat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.img_belah_ketupat);
            }
        });
        btn_lingkaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.img_lingkaran);
            }
        });
        btn_layang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.img_layang);
            }
        });
    }
}