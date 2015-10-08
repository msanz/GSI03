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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.jopendocument.dom.OOUtils;
import org.jopendocument.dom.spreadsheet.SpreadSheet;


/**
 * Ejercicio 3
 * @author GR03
 */
public class SSTest02 {
    public static void main(String args[]) throws IOException{ 
        // Create the data to save.
        final Object[][] data = new Object[4][2];
        data[0] = new Object[] { 1, 3 };
        data[1] = new Object[] { 2, 10 };
        data[2] = new Object[] { 4, 15 };
        data[3] = new Object[] { 5, 18 };

        String[] columns = new String[] { "Month", "Temp" };

        TableModel model = new DefaultTableModel(data, columns);  

        // Save the data to an ODS file and open it.
        final File file = new File("temperature.ods");
        SpreadSheet.createEmpty(model).saveAs(file);

        OOUtils.open(file);
    }
}
