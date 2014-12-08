/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simple.kasir;

import java.sql.ResultSet;

/**
 *
 * @author cincun
 */
public class Barang {

    String nama;
    String harga;
    String id;
    public boolean ismasuk = false;

    public Barang() {
    }

    public Barang(String nama, String harga, String id) {
        this.nama = nama;
        this.harga = harga;
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMaksID(String tabel) {
        DatabaseMinikasir db = new DatabaseMinikasir();
        int maks = 0;
        try {
            ResultSet rs = db.getData("select id from " + tabel);
            while (rs.next()) {
                if (maks < Integer.parseInt(rs.getString("id"))) {
                    maks = Integer.parseInt(rs.getString("id"));
                }
            }
            rs.close();
        } catch (Throwable f) {
            f.printStackTrace();
        }
        return maks;
    }

    public void insertBarang() {
        DatabaseMinikasir db = new DatabaseMinikasir();
        int ID = getMaksID("Barang");
        String s = "insert into Barang values('" + (++ID) + "','" + getNama() + "','" + getHarga() + "');";
        db.query(s); //Memasukan ke Method Query
        if (db.ismasuk) {
            this.ismasuk = true; //True jika method db true. Jika true maka semua kolom akan dikosongkan
        } else {
            this.ismasuk = false;
        }
    }

    public void updateBarang() {
        DatabaseMinikasir db = new DatabaseMinikasir();
        String s = "UPDATE Barang SET ID = " + getId() + ", " + "NAMA = '" + getNama() + "'," + "HARGA = " + getHarga() + " WHERE Barang.ID =" + getId() + ";";
        System.out.println(s);
        db.query(s);
        if (db.ismasuk) {
            this.ismasuk = true; //True jika method db true. Jika true maka semua kolom akan dikosongkan
        } else {
            this.ismasuk = false;
        }
    }

    public void deleteBarang() {
        DatabaseMinikasir db = new DatabaseMinikasir();
        String s = "DELETE FROM Barang " + "WHERE ID =" + getId();
        System.out.println(s);
        db.query(s);
        if (db.ismasuk) {
            this.ismasuk = true; //True jika method db true. Jika true maka semua kolom akan dikosongkan
        } else {
            this.ismasuk = false;
        }
    }
}
