package com.example.kalkulatorbangundatar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class persegiPanjangActivity extends AppCompatActivity {

    private EditText txt_panjang;
    private EditText txt_lebar;
    private Button btn_hasil, btn_reset;
    private TextView display, display2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persegi_panjang);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Persegi Panjang");

        txt_panjang = findViewById(R.id.txt_panjang);
        txt_lebar = findViewById(R.id.txt_lebar);
        btn_hasil = findViewById(R.id.btn_hasil);
        btn_reset = findViewById(R.id.btn_reset);
        display = findViewById(R.id.Layar);
        display2 = findViewById(R.id.Layar2);

        btn_hasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String panjang = txt_panjang.getText().toString();
                String lebar = txt_lebar.getText().toString();

                if (panjang.isEmpty()){
                    txt_panjang.setError("Data Tidak Boleh Kosong !!");
                    txt_panjang.requestFocus();
                }else if (lebar.isEmpty()){
                    txt_lebar.setError("Data Tidak Boleh Kosong !!");
                    txt_lebar.requestFocus();
                } else {
                    Double panjangg = Double.parseDouble(panjang);
                    Double lebarr = Double.parseDouble(lebar);

                    Double luas = panjangg * lebarr;
                    display.setText(String.valueOf(luas));
                    Double keliling = 2 * (panjangg + lebarr);
                    display2.setText(String.valueOf(keliling));
                    hidekeyboard();
                }
            }
        });
        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String panjang = txt_panjang.getText().toString();
                String lebar = txt_lebar.getText().toString();

                if (panjang.isEmpty() && lebar.isEmpty()){
                    Toast.makeText(persegiPanjangActivity.this, "Sepertinya Ada Yang Salah !!", Toast.LENGTH_SHORT).show();
                } else {
                    txt_panjang.setText("");
                    txt_lebar.setText("");
                    display.setText("");
                    display2.setText("");
                    hidekeyboard();
                }
            }
        });
    }
    private void hidekeyboard(){
        View view = this.getCurrentFocus();
        if (view !=null){
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }
}