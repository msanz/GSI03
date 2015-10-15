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
import org.jopendocument.dom.spreadsheet.Cell;
import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

/**
 * Ejercicio 4
 * @author GR03
 */

public class SSTest03 {
    /**
     * Read a file ODS with data
     * @param args 
     */
    public static void main(String args[]){  
        try {
            System.out.println("SSTest03");
            final File file = new File("test01.ods");
            final Sheet sheet = SpreadSheet.createFromFile(file).getSheet(0);
            Cell cell;

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 6; j++) {
                    cell = sheet.getCellAt(j,i);
                    System.out.print(cell.getValue()+ " ");
                }
                 System.out.print("\n");
            }
        } catch (IOException ex) {
            Logger.getLogger(SSTest01.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
}