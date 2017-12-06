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
import si_penjualan.entity.barang;
import si_penjualan.interfc.baranginterfc;

/**
 *
 * @author SystemFive
 */
public class barangimplement implements baranginterfc {

    @Override
    public List <barang> getAll() throws SQLException {
        barang model = new barang();
        List<barang> list = new ArrayList<barang>();
        ResultSet r = model.getBarang();
        while(r.next())
        {
            barang brg = new barang();
            brg.setKode(r.getString("kode_barang"));
            brg.setNamaBarang(r.getString("nama"));
            brg.setHarga(r.getString("harga"));
            brg.setJml(r.getString("jumlah"));
            list.add(brg);
        }
        return list;
    }

    @Override
    public int insert(barang o) throws SQLException {
        String[] data = {o.getKode(),o.getNamaBarang(),o.getJml(),o.getHarga()};
        int res = o.tambahBarang(data);
        return res;
    }

    @Override
    public int delete(barang o) throws SQLException {
       String[] data = {o.getKode()};
       System.out.print("DEBUG Implement := "+o.getKode());
       return o.hapusBarang(data);
    }

    @Override
    public int update(barang o) throws SQLException {
        String[] data = {o.getKode(),o.getNamaBarang(),o.getJml(),o.getHarga(),o.getKode()};
        return o.updateBarang(data);
    }
    
}
