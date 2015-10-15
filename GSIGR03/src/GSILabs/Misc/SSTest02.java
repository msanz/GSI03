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
import javax.swing.table.TableModel;
import org.jopendocument.dom.OOUtils;
import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;


/**
 * Ejercicio 3
 * @author GR03
 */
public class SSTest02 {
    public static void main(String args[]) throws IOException{ 
        // Create the data to save.

        
        //defined matrix
        try {
            final int [][] data = {{7, 4, 7, 5, 19, 5,},{4, 7, 6, 18, 1, 6},{3, 11, 6, 15, 8, 9},{9, 8, 7, 22, 7, 13}}; 
            //Define new table
            final File file = new File("test02.ods");
            DefaultTableModel model = new DefaultTableModel(7,11);
            SpreadSheet.createEmpty(model).saveAs(file);
            Sheet sheet = SpreadSheet.createFromFile(file).getSheet(0);
            int k=0;
            for (int i = 4; i < 7; i++) {
                for (int j = 2; j < 11; j++) {
                    if (data[i-4][k] >= 10){
                        sheet.getCellAt(j,i).setValue(data[i-4][k]);
                        sheet.getCellAt(j,i).setBackgroundColor(Color.blue);
                    }
                    else {
                        System.out.println((i-4) + " " + (k));
                        sheet.getCellAt(j,i).setValue(data[i-4][k]);
                        sheet.getCellAt(j,i).setBackgroundColor(Color.red);

                    }

                }
            }
            for (int i = 0; i < 11; i++) {
                sheet.getCellAt(i,0).setValue("");
                
            }
            OOUtils.open(sheet.getSpreadSheet().saveAs(file));
            }
        catch (IOException ex){
            Logger.getLogger(SSTest02.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
}

