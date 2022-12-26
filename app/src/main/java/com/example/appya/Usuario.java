package com.example.appya;

public class Usuario {
    int Id;
    String Nombre, Apellidos, Usuario, Password, Titulo, Fecha, Lugar;

    public Usuario() {
    }

    public Usuario(String nombre, String apellidos, String usuario, String password, String titulo, String fecha, String lugar) {
        Nombre = nombre;
        Apellidos = apellidos;
        Usuario = usuario;
        Password = password;
        Titulo = titulo;
        Fecha = fecha;
        Lugar = lugar;

    }

    public boolean isNull(){
        if (Nombre.equals("")&&Apellidos.equals("")&&Usuario.equals("")&&Password.equals("")&&Titulo.equals("")&&Fecha.equals("")&&Lugar.equals("")){
        return false;
        }else{
            return true;
        }
}

    @Override
    public String toString() {
        return "Usuario{" +
                "Id=" + Id +
                ", Nombre='" + Nombre + '\'' +
                ", Apellidos='" + Apellidos + '\'' +
                ", Usuario='" + Usuario + '\'' +
                ", Password='" + Password + '\'' +
                ", Titulo='" + Titulo + '\'' +
                ", Fecha='" + Fecha + '\'' +
                ", Lugar='" + Lugar + '\'' +
                '}';
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getTitulo() {return Titulo;}

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getLugar() {
        return Lugar;
    }

    public void setLugar(String lugar) {
        Lugar = lugar;
    }
}
