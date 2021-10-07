package model;

public class Dato {

    private int r,g,b;
    private String nombre;
    private int cantidad;
    private int posX,posY;

    public Dato() {
    }

    public Dato(int r, int g, int b, String nombre, int cantidad, int posX, int posY) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.posX = posX;
        this.posY = posY;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
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
