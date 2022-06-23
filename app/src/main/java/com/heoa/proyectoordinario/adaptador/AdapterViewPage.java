package com.heoa.proyectoordinario.adaptador;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.heoa.proyectoordinario.R;
import com.heoa.proyectoordinario.entidad.Lugares;
import com.heoa.proyectoordinario.mapa.Mapa;

import java.util.ArrayList;

public class AdapterViewPage extends PagerAdapter {
    private ArrayList<Lugares> lugaresList;
    private Context contexto;
    private LayoutInflater layoutInflater;

    public AdapterViewPage(ArrayList<Lugares> lugaresList, Context contexto) {
        this.lugaresList = lugaresList;
        this.contexto = contexto;
    }

    @Override
    public int getCount() {
       return lugaresList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = layoutInflater.from(contexto);
        View v=layoutInflater.inflate(R.layout.menu,container,false);
        ImageView imageView;
        TextView tvimg1;
        imageView= v.findViewById(R.id.img1);
        tvimg1=v.findViewById(R.id.tv1);
        imageView.setImageResource(lugaresList.get(position).getImage_id());
        tvimg1.setText(lugaresList.get(position).getNombre());

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(contexto, Mapa.class);
                switch (tvimg1.getText()+""){
                    case "Aurrera":
                        intent.putExtra("latitud",-95.09634190327981);
                        intent.putExtra("longitud",16.558400318624354);
                        intent.putExtra("nombre",tvimg1.getText());

                        contexto.startActivity(intent);

                        //16.558400318624354, -95.09634190327981
                        break;
                    case "Coppel":
                        intent.putExtra("latitud",-95.0950353474598);
                        intent.putExtra("longitud", 16.556014069412186);
                        intent.putExtra("nombre",tvimg1.getText());

                        contexto.startActivity(intent);
                        //16.556014069412186, -95.0950353474598
                        break;
                    case "Dentista":
                        intent.putExtra("latitud",-95.09796452885894);
                        intent.putExtra("longitud", 16.5678086260322);
                        intent.putExtra("nombre",tvimg1.getText());

                        contexto.startActivity(intent);
                        //16.5678086260322, -95.09796452885894
                        break;
                    case "Unistmo":
                        intent.putExtra("16.560480414065527","-95.12273844349176");
                        intent.putExtra("latitud",-95.12273844349176);
                        intent.putExtra("longitud", 16.560480414065527);
                        intent.putExtra("nombre",tvimg1.getText());

                        contexto.startActivity(intent);
                        //16.560480414065527, -95.12273844349176
                        break;


                }
            }
        });


        container.addView(v,0);
        return v;    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
