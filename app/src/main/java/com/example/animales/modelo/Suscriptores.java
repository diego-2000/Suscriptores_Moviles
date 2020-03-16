package com.example.animales.modelo;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

public class Suscriptores extends AppCompatActivity implements Serializable {

   // private int img;
   private Integer id;
    private String nombre;
    private String usuario;
    private String cuenta;
    private String contrasenia;

    public Suscriptores(Integer id, String nombre, String usuario, String cuenta, String contrasenia) {
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
        this.cuenta = cuenta;
        this.contrasenia = contrasenia;
    }

    public Suscriptores() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
/*
    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
*/

}
