package model;

import java.io.Serializable;

/**
 * Created by Broom on 19/11/2016.
 */

public class Rumah implements Serializable {
    public String judul;
    public String deskripsi;
    public String detail;
    public String foto;

    public Rumah(String judul, String deskripsi, String detail, String foto) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.detail = detail;
        this.foto = foto;
    }
}
