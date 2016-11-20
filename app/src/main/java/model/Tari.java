package model;

import java.io.Serializable;

/**
 * Created by Shafira Pramatana on 11/16/2016.
 */

public class Tari implements Serializable {
    public String judul;
    public String deskripsi;
    public String detail;
    public String foto;

    public Tari(String judul, String deskripsi, String detail, String foto) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.detail = detail;
        this.foto = foto;
    }
}
