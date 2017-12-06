/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package si_penjualan.interfc;
import java.sql.SQLException;
import java.util.List;
import si_penjualan.entity.barang;

/**
 *
 * @author SystemFive
 */
public interface baranginterfc {
    List getAll() throws SQLException;
    int insert(barang o) throws SQLException;
    int delete(barang o) throws SQLException;
    int update(barang o) throws SQLException;
}
