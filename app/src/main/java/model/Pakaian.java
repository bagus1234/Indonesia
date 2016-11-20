package model;

import java.io.Serializable;

/**
 * Created by User on 19/11/2016.
 */
public class Pakaian implements Serializable {
    public String judul;
    public String deskripsi;
    public String detail;
    public String foto;

    public Pakaian(String judul, String deskripsi, String detail, String foto) {

        this.judul = judul;
        this.deskripsi = deskripsi;
        this.detail = detail;
        this.foto = foto;
    }
}
