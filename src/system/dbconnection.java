/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SystemFive
 */
public class dbconnection {
    private static Connection conn;
    private static Connection c;
    private static Statement s;
    private static ResultSet r;
    private static PreparedStatement st;
    public static Connection getConnection()
    {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/java_penjualan","root","");
            
        } catch (SQLException ex) {
            Logger.getLogger(dbconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    public static ResultSet query_get(String query) throws SQLException
    {
        c = getConnection();
        s = c.createStatement();
        return r = s.executeQuery(query);
    }
    public static  void close_statement() throws SQLException
    {
        s.close();
        r.close();
    }

    public static int query_update(String query,String[] data) {
        
        int rs = 0;
        try {
            c = getConnection();
            st = c.prepareStatement(query);
            for(int i = 0; i < data.length; i++)
            {
                int n = i+1;
                st.setString(n,data[i]);
            }
            rs = st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(dbconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs; 
        
    }
}
