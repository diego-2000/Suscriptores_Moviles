package com.example.animales.controlador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.animales.R;
import com.example.animales.conexion.QuerysSuscriptores;
import com.example.animales.modelo.Suscriptores;

public class EditarActivity extends AppCompatActivity {
    private TextView edtId;
    private EditText edtNombre;
    private EditText edtCuenta;
    private EditText edtUsuario;
    private EditText edtContra;
    private Button bttGuardar;
    private QuerysSuscriptores querysSuscriptores;

    private Intent intent;
    private String id_update;
    private String nombre_update;
    private String usuario_update;
    private String cuenta_update;
    private String contrasenia_update;
    private Suscriptores su;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);
        querysSuscriptores= new QuerysSuscriptores(this);

        edtId=(TextView) findViewById(R.id.updateText_id);
        edtNombre=(EditText) findViewById(R.id.updateText_nombre);
        edtCuenta=(EditText) findViewById(R.id.updateText_cuenta);
        edtUsuario=(EditText) findViewById(R.id.updateText_usuario);
        edtContra=(EditText) findViewById(R.id.updateText_contra);
        bttGuardar=(Button) findViewById(R.id.button_guardar_update);
    //pasar a un intent de objetos
        intent =getIntent();
        id_update=intent.getStringExtra("id");
        nombre_update= intent.getStringExtra("nombre");
        usuario_update=intent.getStringExtra("usuario");
        cuenta_update=intent.getStringExtra("cuenta");
        contrasenia_update=intent.getStringExtra("contrasenia");
    //pasar a un intent de objetos
        this.edtId.setText(id_update);
        this.edtNombre.setText(nombre_update);
        this.edtUsuario.setText(usuario_update);
        this.edtCuenta.setText(cuenta_update);
        this.edtContra.setText(contrasenia_update);

        Integer id_Par=Integer.parseInt(id_update);
        su=new Suscriptores(id_Par,nombre_update,usuario_update,cuenta_update,contrasenia_update);



        bttGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateOpSuscrip();
                querysSuscriptores.updateSuscrip(su);
                Toast.makeText(getApplicationContext(),
                        "Registro Editado "+
                         "\nNombre "+su.getNombre()+
                        "\nUsuario "+su.getUsuario()+
                        "\nCuenta "+su.getCuenta(),
                Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void updateOpSuscrip(){
        su.setNombre(edtNombre.getText().toString());
        su.setUsuario(edtUsuario.getText().toString());
        su.setCuenta(edtCuenta.getText().toString());
        su.setContrasenia(edtContra.getText().toString());
    }

}
