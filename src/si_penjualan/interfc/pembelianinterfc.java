/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package si_penjualan.interfc;
import java.sql.SQLException;
import si_penjualan.entity.detil_barang;
import si_penjualan.entity.pembelian;
/**
 *
 * @author systemfive
 */
public interface pembelianinterfc {
    int saveFaktur(pembelian pl) throws SQLException;
    int saveDetil(detil_barang debar) throws SQLException;
}
