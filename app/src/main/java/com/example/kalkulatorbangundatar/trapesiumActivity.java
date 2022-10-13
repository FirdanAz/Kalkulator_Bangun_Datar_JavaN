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

public class trapesiumActivity extends AppCompatActivity {

    private EditText sisiBawah, sisiAtas, Tinggi, sisiMiring;
    private Button hasil, reset;
    private TextView layar, layar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trapesium);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Trapesium");

        sisiBawah = findViewById(R.id.txt_sisiBawah);
        sisiAtas = findViewById(R.id.txt_sisiAtas);
        Tinggi = findViewById(R.id.txt_tinggi);
        sisiMiring = findViewById(R.id.txt_sisiMiring);
        hasil = findViewById(R.id.btn_hasil);
        reset = findViewById(R.id.btn_reset);
        layar = findViewById(R.id.Layar);
        layar2 = findViewById(R.id.Layar2);

        hasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sisibawah = sisiBawah.getText().toString();
                String sisiatas = sisiAtas.getText().toString();
                String tinggi = Tinggi.getText().toString();
                String sisimiring = sisiMiring.getText().toString();

                if (sisibawah.isEmpty()){
                    sisiBawah.setError("Data Tidak Boleh Kosong !!");
                    sisiBawah.requestFocus();
                }
                else if (sisiatas.isEmpty()){
                    sisiAtas.setError("Data Tidak Boleh Kosong !!");
                    sisiAtas.requestFocus();
                }
                else if (tinggi.isEmpty()) {
                    if (sisimiring.isEmpty()){
                        Toast.makeText(trapesiumActivity.this, "Cek Kembali !!", Toast.LENGTH_SHORT).show();
                    } else {
                    Double sisibawahh = Double.parseDouble(sisibawah);
                    Double sisiatass = Double.parseDouble(sisiatas);
                    Double sisimiringg = Double.parseDouble(sisimiring);

                    Tinggi.setText("");
                    layar.setText(String.valueOf(0.0));
                    Double keliling = sisibawahh + sisiatass + sisimiringg + sisimiringg;
                    layar2.setText(String.valueOf(keliling));
                    hidekeyboard();}
                }
                else if (sisimiring.isEmpty()) {
                    if (tinggi.isEmpty()){
                        Toast.makeText(trapesiumActivity.this, "Cek Kembali !!", Toast.LENGTH_SHORT).show();
                    } else {
                    Double sisibawahh = Double.parseDouble(sisibawah);
                    Double sisiatass = Double.parseDouble(sisiatas);
                    Double tinggii = Double.parseDouble(tinggi);

                    Double sisimir = (sisibawahh - sisiatass)/2;
                    Double sisimirr = (sisimir * sisimir) + (tinggii * tinggii);
                    double akar, x;
                    x = Double.valueOf(sisimirr);
                    akar = Math.sqrt(x);
                    Double Akar =akar;
                    Double hasilSisimiring = Akar;
                    sisiMiring.setText(String.valueOf(hasilSisimiring));
                    Double luas = (sisibawahh + sisiatass) * tinggii / 2;
                    layar.setText(String.valueOf(luas));
                    Double keliling = sisibawahh + sisiatass + tinggii + hasilSisimiring;
                    layar2.setText(String.valueOf(keliling));
                    hidekeyboard();}
                }
                else {
                    Double sisibawahh = Double.parseDouble(sisibawah);
                    Double sisiatass = Double.parseDouble(sisiatas);
                    Double tinggii = Double.parseDouble(tinggi);
                    Double sisimiringg = Double.parseDouble(sisimiring);

                    Double luas = (sisibawahh + sisiatass) * tinggii / 2;
                    layar.setText(String.valueOf(luas));
                    Double keliling = sisibawahh + sisiatass + tinggii + sisimiringg;
                    layar2.setText(String.valueOf(keliling));
                    hidekeyboard();
                }
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sisibawah = sisiBawah.getText().toString();
                String sisiatas = sisiAtas.getText().toString();
                String tinggi = Tinggi.getText().toString();
                String sisimiring = sisiMiring.getText().toString();

                if (sisibawah.isEmpty() && sisiatas.isEmpty() && tinggi.isEmpty() && sisimiring.isEmpty()){
                    Toast.makeText(trapesiumActivity.this, "Sepertinya Ada Yang Salah !!", Toast.LENGTH_SHORT).show();
                } else {
                    sisiBawah.setText("");
                    sisiAtas.setText("");
                    Tinggi.setText("");
                    sisiMiring.setText("");
                    layar.setText("");
                    layar2.setText("");
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