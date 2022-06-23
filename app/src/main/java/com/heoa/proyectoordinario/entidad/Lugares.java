package com.heoa.proyectoordinario.entidad;

public class Lugares {
    private String nombre;
    private int image_id;

    public Lugares(String nombre, int image_id) {
        this.nombre = nombre;
        this.image_id = image_id;


    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }
}
