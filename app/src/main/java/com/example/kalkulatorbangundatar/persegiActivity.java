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

public class persegiActivity extends AppCompatActivity {

    private EditText txt_sisi, txt_luas;
    private TextView display, display2;
    private Button btn_hasil, btn_reset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persegi);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Persegi");

            txt_sisi = findViewById(R.id.txt_sisi);
            txt_luas = findViewById(R.id.txt_luas);
            btn_hasil = findViewById(R.id.btn_hasil);
            btn_reset = findViewById(R.id.btn_reset);
            display = findViewById(R.id.Layar);
            display2 = findViewById(R.id.Layar2);

            btn_hasil.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String sisi = txt_sisi.getText().toString();
                    String luas = txt_luas.getText().toString();

                    if (sisi.isEmpty() && luas.isEmpty()){
                        Toast.makeText(persegiActivity.this, "Periksa Kembali !!", Toast.LENGTH_SHORT).show();
                    } else if (sisi.isEmpty()){
                        Double Luas = Double.parseDouble(luas);

                        Double Sisi = Luas;
                        double akar,x;
                        x = Double.valueOf(Sisi);
                        akar = Math.sqrt(x);
                        txt_sisi.setText(String.valueOf(akar));

                        Double luass = akar * akar;
                        display.setText(String.valueOf(luass));
                        Double keliling = akar * 4;
                        display2.setText(String.valueOf(keliling));
                        hidekeyboard();
                    } else {
                        Double sisii = Double.parseDouble(sisi);

                        Double luass = sisii * sisii;
                        display.setText(String.valueOf(luass));
                        Double keliling = sisii * 4;
                        display2.setText(String.valueOf(keliling));
                        hidekeyboard();
                    }
                }
            });

            btn_reset.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String sisi = txt_sisi.getText().toString();
                    String luas = txt_luas.getText().toString();

                    if (sisi.isEmpty() && luas.isEmpty()){
                        Toast.makeText(persegiActivity.this, "Sepertinya Ada Yang Salah !!", Toast.LENGTH_SHORT).show();
                    } else {
                        txt_sisi.setText("");
                        txt_luas.setText("");
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