package com.heoa.proyectoordinario.mapa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.heoa.proyectoordinario.R;

public class Mapa extends AppCompatActivity implements OnMapReadyCallback {
    private Intent recudatos;
    private double latitud;
    private double longitud;
    private String nombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);
        SupportMapFragment sp= (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
        sp.getMapAsync(this);
        recudatos =getIntent();
        longitud=recudatos.getDoubleExtra("longitud", 0);
        latitud=recudatos.getDoubleExtra("latitud", 0);
        nombre=recudatos.getStringExtra("nombre");
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        LatLng coordenadas =new LatLng(longitud, latitud);
        // googleMap.addMarker(new MarkerOptions().position(coordenadas).title(nombre));
        googleMap.addMarker(new MarkerOptions().position(coordenadas).title(nombre).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(coordenadas));
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.builder().target(coordenadas).zoom(14).build()));

    }
}