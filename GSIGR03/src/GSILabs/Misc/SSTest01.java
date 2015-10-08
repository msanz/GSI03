/*
 * This document is part of the lab material for the subject:
 * Gestion de Sistemas de Informacion
 * to be released at the
 * Universidad Publica de Navarra
 * during the first semester of the Academic Year 2015-2016
 */

package GSILabs.Misc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.jopendocument.dom.OOUtils;
import org.jopendocument.dom.spreadsheet.SpreadSheet;


/**
 * Ejercicio 2
 * @author GR03
 */
public class SSTest01 {
    
    /**
     * Create an integer array(4x6)
     * @param args 
     */
    public static void main(String args[]){  
        try {
            System.out.println("SSTest01");
            // Create the data to save.
            final Object[][] data = new Object[4][6];
            data[0] = new Object[] { "January", 1 };
            data[1] = new Object[] { "February", 3 };
            data[2] = new Object[] { "March", 8 };
            data[3] = new Object[] { "April", 10 };
            
            String[] columns = new String[] { "Month", "Temp" };
            
            TableModel model = new DefaultTableModel(data, columns);
            
            // Save the data to an ODS file and open it.
            final File file = new File("temperature.ods");
            SpreadSheet.createEmpty(model).saveAs(file);
            
            OOUtils.open(file);
        } catch (IOException ex) {
            Logger.getLogger(SSTest01.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}