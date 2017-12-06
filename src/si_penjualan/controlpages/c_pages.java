/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package si_penjualan.controlpages;

import si_penjualan.library.libCRUD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import si_penjualan.views.*;

/**
 *
 * @author SystemFive
 */
public class c_pages {
    static  v_home h = new v_home();
    static v_barang b = new v_barang();    
    static v_pelanggan p = new v_pelanggan();
    static v_pembelian pj = new v_pembelian();
    static libCRUD mhome = new libCRUD();
    public void barang()
    {
        b.setVisible(true);
        b.setDefaultCloseOperation(b.DISPOSE_ON_CLOSE);
        b.setAlwaysOnTop(true);
    }
    public void pembelian()
    {
        pj.setVisible(true);
        pj.setAlwaysOnTop(true);
        pj.setDefaultCloseOperation(b.DISPOSE_ON_CLOSE);
    }
    public void home()
    {
       
        h.setLocationByPlatform(true);
        h.setExtendedState(h.MAXIMIZED_BOTH); 
        h.setAlwaysOnTop(true);
        h.setVisible(true);
        
    }
    public void pelanggan()
    {
        p.setVisible(true);
        p.setAlwaysOnTop(true);
        p.setDefaultCloseOperation(b.DISPOSE_ON_CLOSE);
    }
}
