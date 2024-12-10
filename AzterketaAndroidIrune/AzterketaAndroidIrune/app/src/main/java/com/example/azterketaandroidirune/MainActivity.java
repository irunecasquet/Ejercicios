package com.example.azterketaandroidirune;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etIzena = findViewById(R.id.etIzena);
        EditText etHerria = findViewById(R.id.etHerria);
        EditText etAdina = findViewById(R.id.etAdina);
        Spinner spinner = findViewById(R.id.spinner);
        Button btnGorde = findViewById(R.id.btnGorde);
        Button btnGarbitu = findViewById(R.id.btnGarbitu);


        btnGorde.setOnClickListener(v -> {
            String izenAbizenak = etIzena.getText().toString().trim();
            String herria = etHerria.getText().toString().trim();
            String adinaStr = etAdina.getText().toString().trim();

            if (eremuakBalidatu(izenAbizenak, herria, adinaStr, spinner)) {
                Intent intent = new Intent(MainActivity.this, OrdainketaActivity.class);
                intent.putExtra("izenAbizenak", izenAbizenak);
                intent.putExtra("herria", herria);
                intent.putExtra("adina", adinaStr);
                startActivity(intent);
            }
        });


        btnGarbitu.setOnClickListener(v -> {

            etIzena.setText("");
            etHerria.setText("");
            etAdina.setText("");

            
            spinner.setSelection(0);


            Toast.makeText(MainActivity.this, "Eremuak garbitu dira", Toast.LENGTH_SHORT).show();
        });
    }

    private boolean eremuakBalidatu(String izenAbizenak, String herria, String adinaStr, Spinner spinner) {

        if (TextUtils.isEmpty(izenAbizenak) || TextUtils.isEmpty(herria) || TextUtils.isEmpty(adinaStr)) {
            Toast.makeText(this, "Eremu guztiak bete behar dira", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (izenAbizenak.length() > 75) {
            Toast.makeText(this, "Izen-abizenak ezin dira 75 karaktere baino gehiago izan", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (herria.length() > 50) {
            Toast.makeText(this, "Herria ezin da 50 karaktere baino gehiago izan", Toast.LENGTH_SHORT).show();
            return false;
        }

        try {
            int adina = Integer.parseInt(adinaStr);
            if (adina < 16 || adina > 100) {
                Toast.makeText(this, "Adina 16 eta 100 artean egon behar da", Toast.LENGTH_SHORT).show();
                return false;
            }
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Mesedez, sartu balio duen adin bat", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}
