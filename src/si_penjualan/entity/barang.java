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
public class barang extends libCRUD{
    private String kode_barang;
    private String nama_barang;
    private int jumlah;
    private double harga;
    String jml = String.valueOf(jumlah);
    String hrg = String.valueOf(harga);
    public String getKode()
    {
        return this.kode_barang;
    }
    public String getNamaBarang()
    {
        return this.nama_barang;
    }
    public String getJml()
    {
        return this.jml;
    }
    public String getHarga()
    {
        return this.hrg;
    }
    public void setKode(String a)
    {
        this.kode_barang = a;
    }
    public void setNamaBarang(String a)
    {
        this.nama_barang = a;
    }
    public void setJml(String a)
    {
         this.jml = a;
    }
    public void setHarga(String a)
    {
        this.hrg = a;
    }
    
}
