/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package si_penjualan.interfc;

import java.sql.SQLException;
import java.util.List;
import si_penjualan.entity.pelanggan;

/**
 *
 * @author SystemFive
 */
public interface pelangganinterfc {
    List getAll() throws SQLException;
    int insert(pelanggan o) throws SQLException;
    int delete(pelanggan o) throws SQLException;
    int update(pelanggan o) throws SQLException;
    List set_detil(pelanggan o) throws SQLException;
    pelanggan finById(String o) throws SQLException;
}
