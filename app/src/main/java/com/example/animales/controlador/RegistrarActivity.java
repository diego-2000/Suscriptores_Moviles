package com.example.animales.controlador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.animales.R;
import com.example.animales.conexion.QuerysSuscriptores;
import com.example.animales.modelo.Suscriptores;

public class RegistrarActivity extends AppCompatActivity {
    TextView edtId;
    EditText edtNombre;
    EditText edtCuentaTar;
    EditText edtUsuario;
    EditText edtContra;
    Button bttGuardar;
    QuerysSuscriptores querysSuscriptores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

       // limpiarCampos();
        edtId=(TextView) findViewById(R.id.editText_id);
        edtNombre=(EditText) findViewById(R.id.editText_nombre);
        edtCuentaTar=(EditText) findViewById(R.id.editText_cuenta);
        edtUsuario=(EditText) findViewById(R.id.editText_usuario);
        edtContra=(EditText) findViewById(R.id.editText_contra);
        bttGuardar=(Button) findViewById(R.id.button_guardar);
        limpiarCampos();
        bttGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validarCampos()){
                    Suscriptores suscriptores =new Suscriptores();
                                suscriptores.setContrasenia(edtContra.getText().toString());
                                suscriptores.setCuenta(edtCuentaTar.getText().toString());
                                suscriptores.setNombre(edtNombre.getText().toString());
                                suscriptores.setUsuario(edtUsuario.getText().toString());
                    insertSuscriptor(suscriptores);
                    Toast.makeText(getApplicationContext(),
                            "Registro Editado "+
                                    "\nNombre "+suscriptores.getNombre()+
                                    "\nUsuario "+suscriptores.getUsuario()+
                                    "\nCuenta "+suscriptores.getCuenta(),
                    Toast.LENGTH_SHORT).show();
                    limpiarCampos();
                }else{
                    Toast.makeText(getApplicationContext(),"Campo vacío", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void limpiarCampos(){
        edtId.setText("");
        edtNombre.setText("");
        edtCuentaTar.setText("");
        edtUsuario.setText("");
        edtContra.setText("");
    }

    public boolean validarCampos(){
        boolean estatusCampo=true;
        //edtId.setText("");
        if(edtNombre.getText().equals("") || edtCuentaTar.getText().equals("") || edtUsuario.getText().equals("") || edtContra.getText().equals("")) {
            estatusCampo=false;
        }
        return estatusCampo;
    }

    public void insertSuscriptor(Suscriptores suscriptores){
        querysSuscriptores= new QuerysSuscriptores(this);
        querysSuscriptores.insertSuscrip(suscriptores);
    }

}
