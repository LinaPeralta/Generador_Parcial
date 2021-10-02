package com.example.generador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    private Button crearBtn;
    private Button borrarBtn;
    private Button rojoBtn;
    private Button verdeBtn;
    private Button azulBtn;
    private EditText nombreTxt;
    private EditText cantidadTxt;
    private EditText posxTxt;
    private EditText posyTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        crearBtn = findViewById(R.id.crearBtn);
        borrarBtn = findViewById(R.id.borrarBtn);
        rojoBtn = findViewById(R.id.rojoBtn);
        verdeBtn = findViewById(R.id.verdeBtn);
        azulBtn = findViewById(R.id.azulBtn);
        nombreTxt = findViewById(R.id.nombreTxt);
        cantidadTxt = findViewById(R.id.cantidadTxt);
        posxTxt = findViewById(R.id.posxTxt);
        posyTxt = findViewById(R.id.posyTxt);



    }
}