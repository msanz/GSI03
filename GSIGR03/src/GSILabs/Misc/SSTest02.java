/*
 * This document is part of the lab material for the subject:
 * Gestion de Sistemas de Informacion
 * to be released at the
 * Universidad Publica de Navarra
 * during the first semester of the Academic Year 2015-2016
 */

package GSILabs.Misc;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.jopendocument.dom.OOUtils;
import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

/**
 * Create a bidimensional array 4x6 and save the date on test02.ods
 * This test is with colors.
 * @author GR03
 * @version 1.0
 */
public class SSTest02 {
    /**
     * Main class of SSTest02.
     */
    public static void main(){ 
        try {
            System.out.println("SSTest02");
            
            // Create the data to save.
            final int [][] data = {{7, 4, 7, 5, 19, 5,},{4, 7, 6, 18, 1, 6},{3, 11, 6, 15, 8, 9},{9, 8, 7, 22, 7, 13}}; 
            
            // Create the file.
            final File file = new File("test02.ods");
            
            DefaultTableModel model = new DefaultTableModel(7,11);
            SpreadSheet.createEmpty(model).saveAs(file);
            Sheet sheet = SpreadSheet.createFromFile(file).getSheet(0);
            
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 6; j++) {
                    if (data[i][j] >= 10){
                        sheet.getCellAt(j+2,i+4).setValue(data[i][j]);
                        sheet.getCellAt(j+2,i+4).setBackgroundColor(Color.cyan);
                    }
                    else {
                        sheet.getCellAt(j+2,i+4).setValue(data[i][j]);
                        sheet.getCellAt(j+2,i+4).setBackgroundColor(Color.red);
                    }
                }
            }
            
            //Clean the first row
            for (int i = 0; i < 11; i++) {
                sheet.getCellAt(i,0).setValue("");
            }
            
            // Save and open the file
            OOUtils.open(sheet.getSpreadSheet().saveAs(file));
        }catch (IOException ex){
            Logger.getLogger(SSTest02.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}