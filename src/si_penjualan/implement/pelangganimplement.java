/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package si_penjualan.implement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import si_penjualan.entity.pelanggan;
import si_penjualan.interfc.pelangganinterfc;
import system.dbconnection;

/**
 *
 * @author SystemFive
 */
public class pelangganimplement implements pelangganinterfc{

    @Override
    public List getAll() throws SQLException {
        pelanggan model = new pelanggan();
        List<pelanggan> list = new ArrayList<pelanggan>();
        ResultSet r = model.getPelanggan();
        while(r.next())
        {
            pelanggan pl = new pelanggan();
            pl.setKode(r.getString("id_pelanggan"));
            pl.setNama(r.getString("nama"));
            pl.setJK(r.getString("jk"));
            pl.setAlamat(r.getString("alamat"));
            pl.setTlp(r.getString("notlp"));
            list.add(pl);
        }
        return list;
    }

    @Override
    public int insert(pelanggan o) throws SQLException {
         String[] data = {o.getKode(),o.getNama(),o.getJK(),o.getAlamat(),o.getTlp()};
        int res = o.tambahPelanggan(data);
        return res;
    }

    @Override
    public int delete(pelanggan o) throws SQLException {
       String[] data = {o.getKode()};
       System.out.print("DEBUG Implement := "+o.getKode());
       return o.hapusPelanggan(data);
    }

    @Override
    public int update(pelanggan o) throws SQLException {
        String[] data = {o.getKode(),o.getNama(),o.getJK(),o.getAlamat(),o.getTlp(),o.getKode()};
        return o.updatePelanggan(data);
    }

    @Override
    public List set_detil(pelanggan o) throws SQLException {
       List<pelanggan> list = new ArrayList<pelanggan>();
       return list;
    }

    @Override
    public pelanggan finById(String o) throws SQLException {
        ResultSet r = null;
        pelanggan pl = new pelanggan();
        r = dbconnection.query_get("SELECT * FROM pelanggan WHERE id_pelanggan = '"+o+"'");
        while(r.next())
        {
           pl.setKode(r.getString("id_pelanggan"));
           pl.setNama(r.getString("nama"));
           pl.setAlamat(r.getString("alamat"));
        }
        return pl;
    }
    
}
