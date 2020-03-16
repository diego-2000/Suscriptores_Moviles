package com.example.animales.conexion;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.animales.modelo.Suscriptores;


import java.util.ArrayList;

public class QuerysSuscriptores {
private Conexion conn;

    public QuerysSuscriptores(Context context) {
        conn= new Conexion(context);
    }

    public void deleteSuscrip(Suscriptores suscriptores){
        SQLiteDatabase db =conn.getWritableDatabase();
     //   db.execSQL("DELETE FROM "+Contrato.NOMBRE_TABLA+" WHERE "+Contrato.ID+"= "+suscriptores.getId());
        String[] arguDelete = {String.valueOf(suscriptores.getId())};
        db.delete(Contrato.NOMBRE_TABLA, "id = ?", arguDelete);
    }

    public void insertSuscrip(Suscriptores suscriptores){

        SQLiteDatabase db = conn.getWritableDatabase();
        ContentValues insertar = new ContentValues();
        insertar.put("nombre", suscriptores.getNombre());
        insertar.put("usuario", suscriptores.getUsuario());
        insertar.put("cuenta", suscriptores.getCuenta());
        insertar.put("contrasenia", suscriptores.getContrasenia());
         db.insert(Contrato.NOMBRE_TABLA, null, insertar);
    }

    public void updateSuscrip(Suscriptores suscriptores){
        SQLiteDatabase db = conn.getWritableDatabase();
        ContentValues insertar = new ContentValues();
                    insertar.put("nombre", suscriptores.getNombre());
                    insertar.put("contrasenia", suscriptores.getContrasenia());
                    insertar.put("cuenta", suscriptores.getCuenta());
                    insertar.put("usuario", suscriptores.getUsuario());
        String[] argUpdate = {String.valueOf(suscriptores.getId())};
        db.update(Contrato.NOMBRE_TABLA, insertar, "id = ?", argUpdate);
    }

    public ArrayList<Suscriptores> selectSuscriptores() {
        ArrayList<Suscriptores> suscriptores = new ArrayList<>();
        SQLiteDatabase db = conn.getWritableDatabase();
        String[] columnas =
                            {
                                Contrato.ID,
                                Contrato.NOMBRE,
                                Contrato.USUARIO,
                                Contrato.CUENTA,
                                Contrato.CONTRASENIA,
                            };

        Cursor cursor = db.query(
                Contrato.NOMBRE_TABLA,
                columnas,
                null,
                null,
                null,
                null,
                null
        );

        if (cursor == null||!cursor.moveToFirst()) {
            return suscriptores;
        }

        do {
            Integer id = cursor.getInt(0);
            String nombre = cursor.getString(1);
            String usuario = cursor.getString(2);
            String cuenta = cursor.getString(3);
            String contrasenia = cursor.getString(4);
            Suscriptores sus = new Suscriptores(id, nombre, usuario, cuenta, contrasenia);
            suscriptores.add(sus);
        }while (cursor.moveToNext());

        cursor.close();
        return suscriptores;
    }

}
