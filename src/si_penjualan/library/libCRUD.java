/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package si_penjualan.library;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import system.dbconnection;

/**
 *
 * @author SystemFive
 */
public class libCRUD {
    public int hitungPenjualanByTgl(String o){
        ResultSet r = null;
        int hit = 0;
        try {
            r = dbconnection.query_get("SELECT * FROM penjualan WHERE tgl_penjualan = '"+o+"'");
            while(r.next())
            {
                hit++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(libCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return hit;
    }
    public ResultSet getBarang()
    {
        ResultSet r = null;
        try {
            r = dbconnection.query_get("SELECT * FROM barang");
        } catch (SQLException ex) {
            Logger.getLogger(libCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
    public ResultSet getPenjualan()
    {
        ResultSet r = null;
        try {
            r = dbconnection.query_get("SELECT penjualan.no_faktur,penjualan.tgl_penjualan,penjualan.id_pelanggan,pelanggan.nama as nama_pelanggan,detil_jual.kode_barang,detil_jual.harga as total_bayar,detil_jual.jumlah as qty_beli,barang.nama,barang.jumlah as stok FROM penjualan JOIN detil_jual ON detil_jual.no_faktur = penjualan.no_faktur JOIN barang ON barang.kode_barang = detil_jual.kode_barang JOIN pelanggan ON pelanggan.id_pelanggan = penjualan.id_pelanggan GROUP BY penjualan.no_faktur");
        } catch (SQLException ex) {
            Logger.getLogger(libCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
    public ResultSet getDetilBarang(String no_faktur)
    {
        ResultSet r = null;
        try {
            r = dbconnection.query_get("SELECT penjualan.no_faktur,penjualan.tgl_penjualan,penjualan.id_pelanggan,detil_jual.kode_barang,detil_jual.harga as total_bayar,detil_jual.jumlah as qty_beli,barang.nama,barang.jumlah as stok FROM penjualan JOIN detil_jual ON detil_jual.no_faktur = penjualan.no_faktur JOIN barang ON barang.kode_barang = detil_jual.kode_barang WHERE penjualan.no_faktur = '"+no_faktur+"'");
        } catch (SQLException ex) {
            Logger.getLogger(libCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
    public ResultSet getPelanggan()
    {
        ResultSet r = null;
        try {
            r = dbconnection.query_get("SELECT * FROM pelanggan");
        } catch (SQLException ex) {
            Logger.getLogger(libCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
    public ResultSet getBarangByID(String id)
    {
        ResultSet r = null;
        try {
            r = dbconnection.query_get("SELECT * FROM barang WHERE kode_barang = "+id);
        } catch (SQLException ex) {
            Logger.getLogger(libCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
    public ResultSet getBarangByName(String id)
    {
        ResultSet r = null;
        try {
            r = dbconnection.query_get("SELECT * FROM barang WHERE nama LIKE  '%"+id+"%'");
        } catch (SQLException ex) {
            Logger.getLogger(libCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
    
    public int tambahDetil(String[] data)
    {
        int r = 0;
        r = dbconnection.query_update("INSERT INTO detil_jual (no_faktur,kode_barang,jumlah,harga) VALUES (?,?,?,?)",data);
        return r;
    }
    public int tambahFaktur(String[] data)
    {
        int r = 0;
        r = dbconnection.query_update("INSERT INTO penjualan (no_faktur,tgl_penjualan,id_pelanggan) VALUES (?,?,?)",data);
        return r;
    }
    
    public int tambahPelanggan(String[] data)
    {
        int r = 0;
        r = dbconnection.query_update("INSERT INTO pelanggan (id_pelanggan,nama,jk,alamat,notlp) VALUES (?,?,?,?,?)",data);
        return r;
    }
     public int updatePelanggan(String[] data)
    {
        int r = 0;
        r = dbconnection.query_update("UPDATE pelanggan SET id_pelanggan = ?,nama = ?,jk = ?,alamat = ?,notlp = ? WHERE id_pelanggan = ?",data);
        return r;
    }
    public int hapusPelanggan(String[] data)
    {
        int r = 0;
        r = dbconnection.query_update("DELETE FROM pelanggan WHERE id_pelanggan = ? ",data);
        return r;
    }
    public int tambahBarang(String[] data)
    {
        int r = 0;
        r = dbconnection.query_update("INSERT INTO barang (kode_barang,nama,jumlah,harga) VALUES (?,?,?,?)",data);
        return r;
    }
     public int updateBarang(String[] data)
    {
        int r = 0;
        r = dbconnection.query_update("UPDATE barang SET kode_barang = ?,nama = ?,jumlah = ?,harga = ? WHERE kode_barang = ?",data);
        return r;
    }
    public int hapusBarang(String[] data)
    {
        int r = 0;
        r = dbconnection.query_update("DELETE FROM barang WHERE kode_barang = ? ",data);
        return r;
    }
}
