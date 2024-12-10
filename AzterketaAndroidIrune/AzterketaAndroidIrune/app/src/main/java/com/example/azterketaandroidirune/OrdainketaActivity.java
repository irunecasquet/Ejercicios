package com.example.azterketaandroidirune;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class OrdainketaActivity extends AppCompatActivity {

    private EditText txartelaEditText, cvcEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordainketa);


        Intent intent = getIntent();
        String izenAbizenak = intent.getStringExtra("izenAbizenak");

        txartelaEditText = findViewById(R.id.txartelaEditText);
        cvcEditText = findViewById(R.id.cvcEditText);

        Button btnOrdaindu = findViewById(R.id.btnOrdaindu);

        btnOrdaindu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txartelaEditText.setText("");
                cvcEditText.setText("");


                String mensaje = "Eskerrik asko " + izenAbizenak + ", ordainketa ondo burutu da.";
                Toast.makeText(OrdainketaActivity.this, mensaje, Toast.LENGTH_LONG).show();


                Intent intent = new Intent(OrdainketaActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Button btnItzuli = findViewById(R.id.btnItzuli);
        btnItzuli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrdainketaActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
