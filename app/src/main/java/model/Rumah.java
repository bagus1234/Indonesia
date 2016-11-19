package model;

import android.graphics.drawable.Drawable;

/**
 * Created by Broom on 19/11/2016.
 */

public class Rumah {
    public String judul;
    public String deskripsi;
    public Drawable foto;

    public Rumah(String judul, String deskripsi, Drawable foto) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.foto = foto;
    }
}
