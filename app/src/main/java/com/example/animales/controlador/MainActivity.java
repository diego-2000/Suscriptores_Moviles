package com.example.animales.controlador;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.animales.Adapter;
import com.example.animales.R;
import com.example.animales.conexion.QuerysSuscriptores;
import com.example.animales.modelo.Suscriptores;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Adapter adapter;
    QuerysSuscriptores querysSuscriptores;
    List<Suscriptores> listSuscriptores;
    Button registrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listSuscriptores= new ArrayList<>();

        querysSuscriptores= new QuerysSuscriptores(MainActivity.this);
        recyclerView=findViewById(R.id.id_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listSuscriptores=querysSuscriptores.selectSuscriptores();
        adapter= new Adapter(this,listSuscriptores);
        recyclerView.setAdapter(adapter);
        registrar=(Button) findViewById(R.id.registrar);
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generarRegistro();
            }
        });
    }

    public void generarRegistro(){
        Intent intento= new Intent(this, RegistrarActivity.class);
        startActivity(intento);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        listSuscriptores=querysSuscriptores.selectSuscriptores();
        adapter.setArrSuscriptores(listSuscriptores);
        adapter.notifyDataSetChanged();
    }


}
