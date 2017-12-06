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
public class pelanggan extends libCRUD{
    private String id_pelanggan;
    private String nama;
    private String jk;
    private String alamat;
    private String notlp;
    
    public String getKode()
    {
        return this.id_pelanggan;
    }
    public String getNama()
    {
        return this.nama;
    }
    public String getAlamat()
    {
        return this.alamat;
    }
    public String getJK()
    {
        return this.jk;
    }
    public String getTlp()
    {
        return this.notlp;
    }
     public void setKode(String a)
    {
        this.id_pelanggan = a;
    }
    public void setNama(String a)
    {
        this.nama = a;
    }
    public void setAlamat(String a)
    {
        this.alamat = a;
    }
    public void setJK(String a)
    {
        this.jk  = a;
    }
    public void setTlp(String a)
    {
        this.notlp  = a;
    }
}
