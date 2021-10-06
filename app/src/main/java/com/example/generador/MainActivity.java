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

    private String json;

    BufferedReader bfr;
    BufferedWriter bfw;

    Dato datos;
    Gson gson;


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
       // gson = new Gson();


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



        crearBtn.setOnClickListener((view)->{

                    nombre = nombreTxt.getText().toString();
                    cantidad= Integer.parseInt(cantidadTxt.getText().toString());
                    posX= Integer.parseInt(posxTxt.getText().toString());
                    posY= Integer.parseInt(posyTxt.getText().toString());

                });




        rojoBtn.setOnClickListener(
                (v) -> {
                    datos.setColor("rojo");
                    datos.setPosX(posX);
                    datos.setPosY(posY);
                    json = gson.toJson(datos);
                    enviarMensaje(json);
                }
        );

        verdeBtn.setOnClickListener(
                (v) -> {
                    datos.setColor("verde");
                    datos.setPosX(posX);
                    datos.setPosY(posY);
                    json = gson.toJson(datos);
                    enviarMensaje(json);
                }
        );

        azulBtn.setOnClickListener(
                (v) -> {
                    datos.setColor("azul");
                    datos.setPosX(posX);
                    datos.setPosY(posY);
                    json = gson.toJson(datos);
                    enviarMensaje(json);
                }
        );


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