package model;

import android.graphics.drawable.Drawable;

/**
 * Created by Shafira Pramatana on 11/20/2016.
 */
public class Senjata {
    public String judul;
    public String deskripsi;
    public Drawable foto;

    public Senjata(String judul, String deskripsi, Drawable foto) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.foto = foto;
    }
}
