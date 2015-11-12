/*
 * This document is part of the lab material for the subject:
 * Gestion de Sistemas de Informacion
 * to be released at the
 * Universidad Publica de Navarra
 * during the first semester of the Academic Year 2015-2016
 */

package GSILabs.BModel;

import GSILabs.serializable.XMLRepresentable;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The coordinates X and Y of the location festival, concert or exhibition
 * @author GR03
 */
public class Coordinates implements XMLRepresentable{
    
    private int x;
    private int y;
    
    /**
     * Create a new coordinates object with x and y values.
     * @param x coordinate value X of the location
     * @param y coordinate value Y of the location
     */
    public Coordinates(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Returns the X coordinates
     * @return coordinates object
     */
    public int getX()
    {
        return this.x;
    }
    
    /**
     * Returns the Y coordinates
     * @return coordinates object
     */
    public int getY()
    {
        return this.y;
    }
    
    /**
     * Set values X and Y of the location.
     * @param x coordinate value X of the location
     * @param y coordinate value Y of the location
     */
    public void set(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toXML() {
        XStream xstream = new XStream();
        xstream.alias("coordinates",Coordinates.class);
        String xml = xstream.toXML(this);
        return xml;
    }

    @Override
    public boolean saveToXML(File f) {
                
        String xml = this.toXML();

        try (FileWriter writer = new FileWriter(f)) {
            writer.write(xml);
            return true;
        }
        catch (IOException ex) {
            Logger.getLogger(Artist.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
    }

    @Override
    public boolean saveToXML(String filePath) {
        return saveToXML(new File(filePath));
    }
}