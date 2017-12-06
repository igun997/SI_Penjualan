/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package si_penjualan.entity;

import si_penjualan.library.libCRUD;

/**
 *
 * @author SystemFive
 */
public class detil_barang extends libCRUD{
    private String fk_no_faktur;
    private String fk_no_barang;
    private String db_jumlah;
    private String db_harga;

    public String getFk_no_faktur() {
        return fk_no_faktur;
    }

    public void setFk_no_faktur(String fk_no_faktur) {
        this.fk_no_faktur = fk_no_faktur;
    }

    public String getFk_no_barang() {
        return fk_no_barang;
    }

    public void setFk_no_barang(String fk_no_barang) {
        this.fk_no_barang = fk_no_barang;
    }

    public String getDb_jumlah() {
        return this.db_jumlah;
    }

    public void setDb_jumlah(String db_jumlah) {
        this.db_jumlah = db_jumlah;
    }

    public String getDb_harga() {
        return this.db_harga;
    }

    public void setDb_harga(String db_harga) {
        this.db_harga = db_harga;
    }
    
}
