package model;

import android.graphics.drawable.Drawable;

/**
 * Created by Shafira Pramatana on 11/16/2016.
 */
public class Tari {
    public String judul;
    public String deskripsi;
    public Drawable foto;

    public Tari(String judul, String deskripsi, Drawable foto) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.foto = foto;
    }
}
