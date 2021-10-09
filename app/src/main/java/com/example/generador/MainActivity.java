package com.example.generador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;

import model.Dato;

public class MainActivity extends AppCompatActivity {


    private Button crearBtn;
    private Button borrarBtn;
    private Button rojoBtn;
    private Button verdeBtn;
    private Button azulBtn;
    private EditText nombreTxt;
    private String nombre;
    private EditText cantidadTxt;
    private int cantidad;
    private EditText posxTxt;
    private int posX;
    private EditText posyTxt;
    private int posY;
    private int r,g,b;
    private boolean click=false;


    private String json;

    BufferedReader bfr;
    BufferedWriter bfw;

    Dato datos;
    Gson gson;

   // private ArrayList<PVector> posiciones;


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

        datos =  new Dato();
        gson = new Gson();

        new Thread(
                ()->{
                    try {
                        Socket socket = new Socket("10.0.2.2",9000);

                        InputStream is = socket.getInputStream();
                        InputStreamReader isr =  new InputStreamReader(is);
                        bfr = new BufferedReader(isr);

                        OutputStream os = socket.getOutputStream();
                        OutputStreamWriter osw =  new OutputStreamWriter(os);
                        bfw= new BufferedWriter(osw);


                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
        ).start();


        rojoBtn.setOnClickListener(
                (v) -> {
                    r = 122;
                    g = 9;
                    b= 9;
                }
        );

        verdeBtn.setOnClickListener(
                (v) -> {
                    r = 71;
                    g = 88;
                    b = 23;
                }
        );

        azulBtn.setOnClickListener(
                (v) -> {
                    r = 50;
                    g = 89;
                    b = 135;
                }
        );

        crearBtn.setOnClickListener((view)->{

            nombre = nombreTxt.getText().toString();
            cantidad= Integer.parseInt(cantidadTxt.getText().toString());
            posX= Integer.parseInt(posxTxt.getText().toString());
            posY= Integer.parseInt(posyTxt.getText().toString());

            Dato datos = new Dato (r, g, b, nombre,cantidad,posX,posY);

           json = gson.toJson(datos);
           enviarMensaje(json);

            nombreTxt.getText().clear();
            cantidadTxt.getText().clear();
            posxTxt.getText().clear();
            posyTxt.getText().clear();


        });

        borrarBtn.setOnClickListener((view)->{
            click=true;
            json = gson.toJson(datos);
            enviarMensaje(json);
        });


    }
    public void enviarMensaje (String sms) {

        new Thread(()->{
            try {
                bfw.write(sms + "\n");
                bfw.flush();

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }).start();


    }
}