package com.example.animales;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animales.controlador.ResultadoActivity;
import com.example.animales.modelo.Suscriptores;
import com.example.animales.modelo.ClickItem;

import java.util.List;

public class Adapter extends RecyclerView.Adapter <Holder>{
    Context cont;
    List<Suscriptores> arrSuscriptores;
    public Adapter(Context cont, List<Suscriptores> arrSuscriptores){
        this.cont=cont;
        this.arrSuscriptores = arrSuscriptores;
    }

    public Context getCont() {
        return cont;
    }

    public void setCont(Context cont) {
        this.cont = cont;
    }

    public List<Suscriptores> getArrSuscriptores() {
        return arrSuscriptores;
    }

    public void setArrSuscriptores(List<Suscriptores> arrSuscriptores) {
        this.arrSuscriptores = arrSuscriptores;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,null);
        return new Holder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

      //  holder.img.setImageResource(arrAnimal.get(position).getImg());
        holder.nombre.setText("Nombre: "+arrSuscriptores.get(position).getNombre());
        holder.usuario.setText("Usuario: "+arrSuscriptores.get(position).getUsuario());
        holder.cuenta.setText("Cuenta: "+arrSuscriptores.get(position).getCuenta());

        holder.setClickItem(new ClickItem() {
            @Override
            public void onClickItem(View v, int i) {

            Integer id= arrSuscriptores.get(i).getId();
            String nombre= arrSuscriptores.get(i).getNombre();
            String usuario= arrSuscriptores.get(i).getUsuario();
            String cuenta= arrSuscriptores.get(i).getCuenta();
            String contrasenia= arrSuscriptores.get(i).getContrasenia();

            Intent intetn = new Intent(cont, ResultadoActivity.class);

                intetn.putExtra("id",""+id);
                intetn.putExtra("nombre",nombre);
                intetn.putExtra("usuario",usuario);
                intetn.putExtra("cuenta",cuenta);
                intetn.putExtra("contrasenia",contrasenia);

            cont.startActivity(intetn);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrSuscriptores.size();
    }
}
