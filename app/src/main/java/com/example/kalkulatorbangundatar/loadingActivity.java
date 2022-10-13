package com.example.kalkulatorbangundatar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.content.Intent;
import android.view.WindowManager;

public class loadingActivity extends AppCompatActivity {

    private int waktu_loading = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent omah = new Intent(loadingActivity.this, DataListActivity.class);
                startActivity(omah);
                finish();
            }
        },waktu_loading);
    }
}