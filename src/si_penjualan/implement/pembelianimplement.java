/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package si_penjualan.implement;

import java.sql.SQLException;
import si_penjualan.entity.detil_barang;
import si_penjualan.entity.pembelian;
import si_penjualan.interfc.pembelianinterfc;

/**
 *
 * @author systemfive
 */
public class pembelianimplement implements pembelianinterfc{

    @Override
    public int saveFaktur(pembelian pl) throws SQLException {
        String dataFaktur[] = {pl.getNo_faktur(),pl.getTgl_penjualan(),pl.getId_pelanggan()};
        int statusFaktur = pl.tambahFaktur(dataFaktur);
        if(statusFaktur == 1){
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    public int saveDetil(detil_barang debar) throws SQLException {
        String dataDetil[] = {debar.getFk_no_faktur(),debar.getFk_no_barang().toString(),debar.getDb_jumlah(),debar.getDb_harga()};
        int statusDetil = debar.tambahDetil(dataDetil);
        return statusDetil;
    }
    
}
