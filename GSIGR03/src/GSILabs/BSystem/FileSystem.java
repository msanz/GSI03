/*
 * This document is part of the lab material for the subject:
 * Gestion de Sistemas de Informacion
 * to be released at the
 * Universidad Publica de Navarra
 * during the first semester of the Academic Year 2015-2016
 */

package GSILabs.BSystem;

import GSILabs.Misc.SSTest01;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;
import persistence.ODSPersistent;

/**
 * FileSystem is a subsystem for manage the files to load and save info
 * @author GR03
 * @version 1.0
 */
public class FileSystem implements ODSPersistent{
    
    @Override
    public boolean loadFromFile(File f) {
        return false;
    }

    @Override
    public boolean saveToFile(File f) {
        return false;
    }
    
    public String[] importConcerts(File file){
        ArrayList<String> concerts = new ArrayList<>();
        try {
            final Sheet sheet = SpreadSheet.createFromFile(file).getSheet(0);
            //int col = sheet.getColumnCount();
            int row = sheet.getRowCount();
            
            // Show the info 
            for (int i = 0; i < row; i++) {
                concerts.add(sheet.getCellAt(0,i).getValue().toString()); // Name
                concerts.add(sheet.getCellAt(1,i).getValue().toString()); // Performer
                concerts.add(sheet.getCellAt(2,i).getValue().toString()); // Location
                concerts.add(sheet.getCellAt(3,i).getValue().toString()); // Date
            }
  
            return concerts.toArray(new String[concerts.size()]);
        } catch (IOException ex) {
            Logger.getLogger(SSTest01.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }   
    }
    
}