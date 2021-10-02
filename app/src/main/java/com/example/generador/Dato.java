package com.example.generador;

public class Dato {

    private String color;
    private String nombre;
    private int cantidad;
    private int posX,posY;

    public Dato() {
    }

    public Dato(String color, String nombre, int cantidad, int posX, int posY) {
        this.color = color;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.posX = posX;
        this.posY = posY;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
}
