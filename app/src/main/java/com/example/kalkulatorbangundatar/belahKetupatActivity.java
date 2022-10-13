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

public class belahKetupatActivity extends AppCompatActivity {

    private EditText diagonalHor, diagonalVer, Sisi;
    private Button Hasil, reset;
    private TextView layar, layar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_belah_ketupat);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Belah Ketupat");

        diagonalHor = findViewById(R.id.txt_diagonalHor);
        diagonalVer = findViewById(R.id.txt_diagonalVer);
        Sisi = findViewById(R.id.txt_Sisi);
        Hasil = findViewById(R.id.btn_hasil);
        reset = findViewById(R.id.btn_reset);
        layar = findViewById(R.id.Layar);
        layar2 = findViewById(R.id.Layar2);

        Hasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String diagonalhor = diagonalHor.getText().toString();
                String diagonalver = diagonalVer.getText().toString();
                String sisi = Sisi.getText().toString();

                if (diagonalhor.isEmpty()){
                    diagonalHor.setError("Data Tidak Boleh Kosong !!");
                    diagonalHor.requestFocus();
                } else if (diagonalver.isEmpty()){
                    diagonalVer.setError("Data Tidak Boleh Kosong !!");
                    diagonalVer.requestFocus();
                } else if (sisi.isEmpty()) {
                    Double diagonalhorr = Double.parseDouble(diagonalhor);
                    Double diagonalverr = Double.parseDouble(diagonalver);

                    Double hasil = ((0.5 * diagonalhorr) * (0.5 * diagonalhorr)) + ((0.5 * diagonalverr) * (0.5 * diagonalverr));
                    double akar, x;
                    x = Double.valueOf(hasil);
                    akar = Math.sqrt(x);
                    Double HasilSisi = akar;
                    Sisi.setText(String.valueOf(HasilSisi));

                    Double luas = (diagonalhorr * diagonalverr) / 2;
                    layar.setText(String.valueOf(luas));
                    Double keliling = 4 * HasilSisi;
                    layar2.setText(String.valueOf(keliling));
                    hidekeyboard();
                } else {
                    Double diagonalhorr = Double.parseDouble(diagonalhor);
                    Double diagonalverr = Double.parseDouble(diagonalver);
                    Double sisii = Double.parseDouble(sisi);

                    Double luas = (diagonalhorr * diagonalverr) / 2;
                    layar.setText(String.valueOf(luas));
                    Double keliling = 4 * sisii;
                    layar2.setText(String.valueOf(keliling));
                    hidekeyboard();
                }
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String diagonalhor = diagonalHor.getText().toString();
                String diagonalver = diagonalVer.getText().toString();
                String sisi = Sisi.getText().toString();

                if (diagonalhor.isEmpty() && diagonalver.isEmpty() && sisi.isEmpty()){
                    Toast.makeText(belahKetupatActivity.this, "Sepertinya Ada Yang Salah !!", Toast.LENGTH_SHORT).show();
                } else {
                    diagonalHor.setText("");
                    diagonalVer.setText("");
                    Sisi.setText("");
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