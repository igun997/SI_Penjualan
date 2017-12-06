/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package si_penjualan;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import si_penjualan.controlpages.c_pages;

/**
 *
 * @author SystemFive
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            final InputStream imageStream = Main.class.getResourceAsStream("splashscreen.jpg");
            final SplashGuard splashScreen = new SplashGuard(imageStream);
            splashScreen.showProgress(25, 1);
            TimeUnit.SECONDS.sleep(1);
            splashScreen.showProgress(25, 75, 2);
            TimeUnit.SECONDS.sleep(2);
            splashScreen.showProgress(90, 2);
            TimeUnit.SECONDS.sleep(2);
            splashScreen.showProgress(100, 2);
            TimeUnit.SECONDS.sleep(2);
            splashScreen.close();
            c_pages ob = new c_pages();
            ob.home();
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
