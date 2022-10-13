package com.example.kalkulatorbangundatar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.inputmethodservice.Keyboard;
import android.os.Build;
import android.os.Bundle;
import android.security.ConfirmationCallback;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.Key;

public class layangLayangActivity extends AppCompatActivity {

    private EditText diagonalPanj, diagonalPen, sisiPen, sisiPanj;
    private Button Hasil, reset;
    private TextView layar, layar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layang_layang);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Layang-Layang");

        diagonalPanj = findViewById(R.id.txt_diagonalpan);
        diagonalPen = findViewById(R.id.txt_diagonalpen);
        sisiPen = findViewById(R.id.txt_sisiPendek);
        sisiPanj = findViewById(R.id.txt_sisiPanjang);
        Hasil = findViewById(R.id.btn_hasil);
        reset = findViewById(R.id.btn_reset);
        layar = findViewById(R.id.Layar);
        layar2 = findViewById(R.id.Layar2);

        Hasil.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                String diagonalpanj = diagonalPanj.getText().toString();
                String diagonalpen = diagonalPen.getText().toString();
                String sisipen = sisiPen.getText().toString();
                String sisipanj = sisiPanj.getText().toString();

                if (diagonalpanj.trim().isEmpty() && diagonalpen.trim().isEmpty() && sisipen.trim().isEmpty() && sisipanj.trim().isEmpty()) {
                    Toast.makeText(layangLayangActivity.this, "Sepertinya Ada Yang Salah !!", Toast.LENGTH_SHORT).show();
                } else if (diagonalpanj.isEmpty() && diagonalpen.isEmpty() || diagonalpanj.isEmpty() || diagonalpen.isEmpty()) {
                    if (sisipen.isEmpty() || sisipanj.isEmpty()) {
                        Toast.makeText(layangLayangActivity.this, "Sepertinya Ada Yang Salah !!", Toast.LENGTH_SHORT).show();
                    } else {
                        Double sisipenn = Double.parseDouble(sisipen);
                        Double sisipanjj = Double.parseDouble(sisipanj);

                        Double keliling = 2 * (sisipenn + sisipanjj);
                        layar2.setText(String.valueOf(keliling));
                        layar.setText("0.0");
                        hidekeyboard();
                    }
                } else if (sisipen.isEmpty() && sisipanj.isEmpty() || sisipen.isEmpty() || sisipanj.isEmpty()) {
                    if (diagonalpanj.isEmpty() || diagonalpen.isEmpty()) {
                        Toast.makeText(layangLayangActivity.this, "Sepertinya Ada Yang Salah !!", Toast.LENGTH_SHORT).show();
                    } else {
                        Double diagonalpanjj = Double.parseDouble(diagonalpanj);
                        Double diagonalpenn = Double.parseDouble(diagonalpen);

                        Double luas = (diagonalpanjj * diagonalpenn) / 2;
                        layar.setText(String.valueOf(luas));
                        layar2.setText("0.0");
                        hidekeyboard();
                    }
                } else {
                    Double diagonalpanjj = Double.parseDouble(diagonalpanj);
                    Double diagonalpenn = Double.parseDouble(diagonalpen);
                    Double sisipenn = Double.parseDouble(sisipen);
                    Double sisipanjj = Double.parseDouble(sisipanj);

                    Double luas = (diagonalpanjj * diagonalpenn) / 2;
                    layar.setText(String.valueOf(luas));
                    Double keliling = 2 * (sisipenn + sisipanjj);
                    layar2.setText(String.valueOf(keliling));
                    hidekeyboard();
                }
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String diagonalpanj = diagonalPanj.getText().toString();
                String diagonalpen = diagonalPen.getText().toString();
                String sisipen = sisiPen.getText().toString();
                String sisipanj = sisiPanj.getText().toString();

                if (diagonalpanj.isEmpty() && diagonalpen.isEmpty() && sisipen.isEmpty() && sisipanj.isEmpty()) {
                    Toast.makeText(layangLayangActivity.this, "Sepertinya Ada Yang Salah !!", Toast.LENGTH_SHORT).show();
                } else {
                    diagonalPanj.setText("");
                    diagonalPen.setText("");
                    sisiPen.setText("");
                    sisiPanj.setText("");
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