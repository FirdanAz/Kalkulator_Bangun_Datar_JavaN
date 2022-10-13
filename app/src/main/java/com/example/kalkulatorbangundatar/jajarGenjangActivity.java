package com.example.kalkulatorbangundatar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class jajarGenjangActivity extends AppCompatActivity {

    private EditText txt_alas, txt_tinggi, txt_sisiMiring;
    private Button hasil, reset;
    private TextView layar, layar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jajar_genjang);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Jajar Genjang");

        txt_alas = findViewById(R.id.txt_alas);
        txt_tinggi = findViewById(R.id.txt_tinggi);
        txt_sisiMiring = findViewById(R.id.txt_sisiMiring);
        hasil = findViewById(R.id.btn_hasil);
        reset = findViewById(R.id.btn_reset);
        layar = findViewById(R.id.Layar);
        layar2 = findViewById(R.id.Layar2);


        hasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String alas = txt_alas.getText().toString();
                String tinggi = txt_tinggi.getText().toString();
                String sisimiring = txt_sisiMiring.getText().toString();

                if (alas.isEmpty()){
                    txt_alas.setError("Data tidak boleh kosong !!");
                    txt_alas.requestFocus();
                } else if (tinggi.isEmpty() && sisimiring.isEmpty()){
                    Toast.makeText(jajarGenjangActivity.this,"Periksa Kembali !!",Toast.LENGTH_SHORT).show();
                } else if (tinggi.isEmpty()){
                    txt_tinggi.setText("");
                    Double alass = Double.parseDouble(alas);
                    Double sisimiringg = Double.parseDouble(sisimiring);

                    layar.setText(String.valueOf(0.0));
                    Double hasill = 2 * (alass + sisimiringg);
                    layar2.setText(String.valueOf(hasill));
                    hidekeyboard();
                } else if (sisimiring.isEmpty()){
                    txt_sisiMiring.setText("");
                    Double alass = Double.parseDouble(alas);
                    Double tinggii = Double.parseDouble(tinggi);

                    Double hasil = (alass * tinggii);
                    layar.setText(String.valueOf(hasil));
                    layar2.setText(String.valueOf(0.0));
                    hidekeyboard();
                }
                else {
                    Double alass = Double.parseDouble(alas);
                    Double tinggii = Double.parseDouble(tinggi);
                    Double sisimiringg = Double.parseDouble(sisimiring);

                    Double hasil = (alass * tinggii);
                    layar.setText(String.valueOf(hasil));
                    Double hasill = 2 * (alass + sisimiringg);
                    layar2.setText(String.valueOf(hasill));
                    hidekeyboard();
                }
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String alas = txt_alas.getText().toString();
                String tinggi = txt_tinggi.getText().toString();
                String sisimiring = txt_sisiMiring.getText().toString();

                if (alas.isEmpty() && tinggi.isEmpty() && sisimiring.isEmpty()){
                    Toast.makeText(jajarGenjangActivity.this,"Sepertinya Ada Yang Salah !!",Toast.LENGTH_SHORT).show();
                } else {
                    txt_alas.setText("");
                    txt_tinggi.setText("");
                    txt_sisiMiring.setText("");
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