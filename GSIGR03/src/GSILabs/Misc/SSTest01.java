/*
 * This document is part of the lab material for the subject:
 * Gestion de Sistemas de Informacion
 * to be released at the
 * Universidad Publica de Navarra
 * during the first semester of the Academic Year 2015-2016
 */

package GSILabs.Misc;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.jopendocument.dom.OOUtils;
import org.jopendocument.dom.spreadsheet.Sheet;
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
            final int[][] data = {{7,4,6,1,7,9},{4,7,1,2,1,6},{7,4,6,1,7,9},{4,7,1,2,1,6}};
            
            // Create the file.
            final File file = new File("test01.ods");
            
            DefaultTableModel model = new DefaultTableModel(4,6);
            SpreadSheet.createEmpty(model).saveAs(file);
            Sheet sheet = SpreadSheet.createFromFile(file).getSheet(0);
            
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 6; j++) {
                    sheet.getCellAt(j,i).setValue(data[i][j]);
                }
            }
            
            OOUtils.open(sheet.getSpreadSheet().saveAs(file));
        } catch (IOException ex) {
            Logger.getLogger(SSTest01.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}