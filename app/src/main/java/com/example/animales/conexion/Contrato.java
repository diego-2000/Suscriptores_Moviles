package com.example.animales.conexion;

public class Contrato {
    public static final String NOMBRE_TABLA="suscriptores";
    public static final String ID="id";
    public static final String NOMBRE ="nombre";
    public static final String USUARIO ="usuario";
    public static final String CUENTA ="cuenta";
    public static final String CONTRASENIA ="contrasenia";

    public static final String TABLA_SUSCRIPTORES="create table "+
            NOMBRE_TABLA+
            " (" +
                ID+" integer primary key autoincrement," +
                NOMBRE+" text," +
                USUARIO+" text," +
                CUENTA+" text," +
                CONTRASENIA+" text" +
            ")";
}
