/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package si_penjualan.interfc;

import java.sql.SQLException;
import java.util.List;
import si_penjualan.entity.barang;
import si_penjualan.entity.pembelian;

/**
 *
 * @author SystemFive
 */
public interface penjualaninterfc {
    List getAll() throws SQLException;
    barang findById(String o) throws SQLException;
    int insert(pembelian o) throws SQLException;
    int delete(pembelian o) throws SQLException;
    int update(pembelian o) throws SQLException;
}
