package com.example.kalkulatorbangundatar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class lingkaranActivity extends AppCompatActivity {

    private EditText jariJari;
    private Button Hasil, Reset;
    private TextView layar, layar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lingkaran);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Lingkaran");

        jariJari = findViewById(R.id.txt_jariJari);
        Hasil = findViewById(R.id.btn_hasil);
        Reset = findViewById(R.id.btn_reset);
        layar = findViewById(R.id.Layar);
        layar2 = findViewById(R.id.Layar2);

        Hasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String jarijari = jariJari.getText().toString();
                if (jarijari.isEmpty()){
                    jariJari.setError("Data Tidak Boleh Kosong !!");
                    jariJari.requestFocus();
                } else {
                    final double phi = 3.14;
                    Double jarijarii = Double.parseDouble(jarijari);

                    Double luas = phi * jarijarii * jarijarii;
                    layar.setText(String.valueOf(luas));
                    Double keliling = 2 * phi * jarijarii;
                    layar2.setText(String.valueOf(keliling));
                    hidekeyboard();
                }
            }
        });
        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String jarijari = jariJari.getText().toString();

                if (jarijari.isEmpty()){
                    Toast.makeText(lingkaranActivity.this, "Sepertinya Ada Yang Salah !!", Toast.LENGTH_SHORT).show();
                } else {
                    jariJari.setText("");
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