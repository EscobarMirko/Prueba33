package com.example.appya;

public class Contacto {
    int id;
    String nombre;
    String precio;
    String marca;
    int cant;
    String com;

    public Contacto() {
    }

    public Contacto(String nombre, String precio, String marca, int cant, String com) {
        this.nombre = nombre;
        this.precio = precio;
        this.marca = marca;
        this.cant = cant;
        this.com = com;
    }

    public Contacto(int id, String nombre, String precio, String marca, int cant, String com) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.marca = marca;
        this.cant = cant;
        this.com = com;
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

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {

        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public String getCom() {
        return com;
    }

    public void setCom(String com) {
        this.com = com;
    }
}
