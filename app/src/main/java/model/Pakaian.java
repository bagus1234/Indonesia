package model;

import android.graphics.drawable.Drawable;

/**
 * Created by User on 19/11/2016.
 */
public class Pakaian {
    public String judul;
    public String deskripsi;
    public Drawable foto;

    public Pakaian(String judul, String deskripsi, Drawable foto) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.foto = foto;
    }
}
