/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package si_penjualan.views.report;

import java.io.InputStream;

/**
 *
 * @author SystemFive
 */
public class getFile {
    public InputStream fetch(String name)
    {
        return getFile.class.getResourceAsStream(name);
    }
}
