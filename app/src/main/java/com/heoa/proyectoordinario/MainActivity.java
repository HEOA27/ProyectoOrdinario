package com.heoa.proyectoordinario;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.heoa.proyectoordinario.adaptador.AdapterViewPage;
import com.heoa.proyectoordinario.entidad.Lugares;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    AdapterViewPage adapterViewPages;
    ArrayList<Lugares> lugaresArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=findViewById(R.id.vp);
        lugaresArrayList =new ArrayList<Lugares>();
        CrearLugares();
        adapterViewPages =new AdapterViewPage(lugaresArrayList, this);
        viewPager.setAdapter(adapterViewPages);
        viewPager.setPadding(50,0,50,50);
    }

    private void CrearLugares() {
        lugaresArrayList.add(new Lugares("Aurrera",R.drawable.bodega));
        lugaresArrayList.add(new Lugares("Coppel",R.drawable.coppel));
        lugaresArrayList.add(new Lugares("Dentista",R.drawable.dentista));
        lugaresArrayList.add(new Lugares("Unistmo",R.drawable.unistmo));
    }
}