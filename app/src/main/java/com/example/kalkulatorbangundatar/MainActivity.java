package com.example.kalkulatorbangundatar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

public class MainActivity extends AppCompatActivity {
    private ImageButton btnPersegi, btnPersegiPanjang, btnSegitiga, btnJajargenjang, btnTrapesium, btnBelahketupat, btnLingkaran, btnLayang;
    private ImageView btnSetting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPersegi = findViewById(R.id.btn1);
        btnPersegiPanjang = findViewById(R.id.btn2);
        btnSegitiga = findViewById(R.id.btn3);
        btnJajargenjang = findViewById(R.id.btn4);
        btnTrapesium = findViewById(R.id.btn5);
        btnBelahketupat = findViewById(R.id.btn6);
        btnLingkaran = findViewById(R.id.btn7);
        btnLayang = findViewById(R.id.btn8);
        btnSetting = findViewById(R.id.btn_setting);

        btnPersegi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,persegiActivity.class);
                startActivity(intent);
            }
        });

        btnPersegiPanjang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,persegiPanjangActivity.class);
                startActivity(intent);
            }
        });

        btnSegitiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, segitigaActivity.class);
                startActivity(intent);
            }
        });
        btnJajargenjang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, jajarGenjangActivity.class);
                startActivity(intent);
            }
        });
        btnTrapesium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, trapesiumActivity.class);
                startActivity(intent);
            }
        });
        btnBelahketupat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, belahKetupatActivity.class);
                startActivity(intent);
            }
        });
        btnLingkaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, lingkaranActivity.class);
                startActivity(intent);
            }
        });
        btnLayang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, layangLayangActivity.class);
                startActivity(intent);
            }
        });
        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this);
        finish();
    }
}