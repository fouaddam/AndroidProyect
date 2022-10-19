package org.fouad.appandroid.Clases;

public class Producto {
    private int id;
    private String nombre;
    private String descp;

    public Producto(int id, String nombre, String descp) {
        this.id = id;
        this.nombre = nombre;
        this.descp = descp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescp() {
        return descp;
    }

    public void setDescp(String descp) {
        this.descp = descp;
    }
}
