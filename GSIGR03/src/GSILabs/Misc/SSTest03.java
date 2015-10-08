/*
 * This document is part of the lab material for the subject:
 * Gestion de Sistemas de Informacion
 * to be released at the
 * Universidad Publica de Navarra
 * during the first semester of the Academic Year 2015-2016
 */

package GSILabs.Misc;

import java.io.File;
import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

/**
 * Ejercicio 4
 * @author GR03
 * Dentro del paquete GSILib.Misc, cree una clase de nombre SSTest03 cuyo método main
sea capaz de leer los datos almacenados en el archivo test02.ods creado en el ejercicio anterior (el color
es innecesario, pero los datos numéricos han de recuperarse). La posición donde se encuentra la matriz
en la hoja de cálculo puede ser codificada de manera explícita (hard-coded) en la clase SSTest03.
Las hojas de cálculo se usan muy frecuentemente para almacenar información. Y, de hecho, soy
muy prácticas cuando la información puede almacenarse en tablas individuales. De alguna manera, toda
la información en una hoja de cálculo debe ser inventariable como tablas individuales, potencialmente
generando un cubo tridimensional. Las aplicaciones informáticas gestionan información donde esta
arquitectura no es muy adecuada, por razones que incluyen la cardinalidad de las relaciones entre
instancias, la inclusión lógica de instancias dentro de otras, etc. En esos casos los sistemas de información
deben complementar la información almacenada en la hoja de cálculo con elementos que no se soportan
de manera nativa, como pueden ser las jerarquías o las referencias cruzadas, etc.
 */
public class SSTest03 {
    public static void main(String args[]){  
       System.out.println("SSTest03");
       /*
        Ejemplo de recuperacion de datos de un ods
        // Load the file.
        File file = new File("template/invoice.ods");
        final Sheet sheet = SpreadSheet.createFromFile(file).getSheet(0);
        // Change date.
        sheet.getCellAt("I10").setValue(new Date());
        // Change strings.
        sheet.setValueAt("Filling test", 1, 1);
        sheet.getCellAt("B27").setValue("On site support");
        // Change number.
        sheet.getCellAt("F24").setValue(3);
        // Or better yet use a named range
        // (relative to the first cell of the range, wherever it might be).
        sheet.getSpreadSheet().getTableModel("Products").setValueAt(1, 5, 4);
        // Save to file and open it.
        File outputFile = new File("fillingTest.ods");
        OOUtils.open(sheet.getSpreadSheet().saveAs(outputFile)); 
       */
       //load the file.
       String fileName = new String("test02.ods");
       File file = new File(fileName);
       final Sheet sheet = SpreadSheet.createFromFile(file).getSheet(0);
       //How to set a cell contains what I want to modify??
       
       
       
    }
}
