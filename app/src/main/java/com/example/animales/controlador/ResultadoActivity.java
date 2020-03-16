package com.example.animales.controlador;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.animales.R;
import com.example.animales.conexion.QuerysSuscriptores;
import com.example.animales.modelo.Suscriptores;

public class ResultadoActivity extends AppCompatActivity {
    private ImageView img;
    private TextView nombre,usuario,cuenta,contrasenia,id;
    private Button eliminar,editar;
    private Intent intent;
    private String id_i;
    private String nombre_i;
    private String usuario_i;
    private String cuenta_i;
    private String contrasenia_i;
    private Suscriptores su;
    private QuerysSuscriptores querysSuscriptores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        querysSuscriptores= new QuerysSuscriptores(this);
        ActionBar actionBar = getSupportActionBar();

        this.img            =      findViewById(R.id.id_image_sus);
        this.id         =      findViewById(R.id.id_sus);
        this.nombre         =      findViewById(R.id.id_nombre_sus);
        this.usuario        =      findViewById(R.id.id_usuario_sus);
        this.cuenta           =      findViewById(R.id.id_cuenta_sus);
        this.contrasenia    =      findViewById(R.id.id_contra_sus);

        intent =getIntent();
        id_i=intent.getStringExtra("id");
        nombre_i= intent.getStringExtra("nombre");
        usuario_i=intent.getStringExtra("usuario");
        cuenta_i=intent.getStringExtra("cuenta");
        contrasenia_i=intent.getStringExtra("contrasenia");

        this.id.setText("ID: "+id_i);
        this.nombre.setText("Nombre: "+nombre_i);
        this.usuario.setText("Usuario: "+usuario_i);
        this.cuenta.setText("Cuenta: "+cuenta_i);
        this.contrasenia.setText("Contraseña: ************");
        su= new Suscriptores();
        Integer id=Integer.parseInt(id_i);
            su.setId(id);
            su.setUsuario(usuario_i);
            su.setNombre(nombre_i);
            su.setCuenta(cuenta_i);
            su.setContrasenia(contrasenia_i);
        eliminar=(Button) findViewById(R.id.button_eliminar);
        editar=(Button) findViewById(R.id.button_editar);
        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Registro ID "+id_i+" eliminado", Toast.LENGTH_SHORT).show();
               // QuerysSuscriptores querysSuscriptores
               querysSuscriptores.deleteSuscrip(su);
               finish();
            }
        });

        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultadoIntent();
            }
        });
  }

    public void resultadoIntent(){
        Intent intento= new Intent(this, EditarActivity.class);
            intento.putExtra("id",""+su.getId());
            intento.putExtra("nombre",su.getNombre());
            intento.putExtra("usuario",su.getUsuario());
            intento.putExtra("cuenta",su.getCuenta());
            intento.putExtra("contrasenia",su.getContrasenia());
        startActivity(intento);
    }
}
