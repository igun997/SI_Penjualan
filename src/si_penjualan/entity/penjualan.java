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
public class penjualan extends detil_barang {
    private String no_faktur;
    private String tgl_penjualan;
    private String id_pelanggan;
    private String nama_pelanggan;
    private int total;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getNama_pelanggan() {
        return nama_pelanggan;
    }

    public void setNama_pelanggan(String nama_pelanggan) {
        this.nama_pelanggan = nama_pelanggan;
    }

    public String getNo_faktur() {
        return no_faktur;
    }

    public void setNo_faktur(String no_faktur) {
        this.no_faktur = no_faktur;
    }

    public String getTgl_penjualan() {
        return tgl_penjualan;
    }

    public void setTgl_penjualan(String tgl_penjualan) {
        this.tgl_penjualan = tgl_penjualan;
    }

    public String getId_pelanggan() {
        return id_pelanggan;
    }

    public void setId_pelanggan(String id_pelanggan) {
        this.id_pelanggan = id_pelanggan;
    }
    
}
