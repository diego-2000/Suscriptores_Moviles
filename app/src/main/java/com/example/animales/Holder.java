package com.example.animales;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animales.modelo.ClickItem;

public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {
    ImageView img;
    TextView nombre;
    TextView usuario;
    TextView cuenta;

    ClickItem click;
    Holder(@NonNull View itemView) {
        super(itemView);
      //  this.img=itemView.findViewById(R.id.id_image_view);
        this.nombre=itemView.findViewById(R.id.id_nombre_carv);
        this.usuario=itemView.findViewById(R.id.id_usuario_carv);
        this.cuenta=itemView.findViewById(R.id.id_cuenta_carv);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        this.click.onClickItem(view,getLayoutPosition());
    }

    public void setClickItem(ClickItem a){
        this.click=a;
    }
}
