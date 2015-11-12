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
import java.io.Writer;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * An artist is a person who takes part of concert or exhibition.
 * @author GR03
 * @version 1.0
 */
public class Artist implements Performer,XMLRepresentable {
    
    private String name;
    private String workDescription;
    private String web;
    
    /**
     * Create a new artist void.
     */
    public Artist(){}
    
    /**
     * Create a new Artist with name and work description.
     * @param name The name of the artist.
     * @param workDescription  A little description about the artwork.
     */
    public Artist(String name, String workDescription){
        this.name = name;
        this.workDescription = workDescription;
        this.web = "Unknown";
    }
    
    /**
     * Create a new Artist with name, work description and website.
     * @param name The name of the artist.
     * @param workDescription  A little description about the artwork.
     * @param web The artist website.
     */
    public Artist(String name, String workDescription, String web){
        this.name = name;
        this.workDescription = workDescription;
        this.web = web;
    }
    
    /**
     * Rewriting the toString() method
     * @return other style to show the information
     */
    @Override
    public String toString() {
        return "Name artist: "+ name +
               "\nWork description: " + workDescription +
               "\nWeb: " + web;
    }
    
    /**
     * Returns the name of the artist.
     * @return the name of the artist.
     */
    @Override
    public String getName() {
        return name;
    }
    
    /**
     * Set the name of the artist.
     * @param name the name of the artist.
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Returns the work description of the artist.
     * @return the artwork description
     */
    @Override
    public String getWorkDescription() {
        return workDescription;
    }
    
    /**
     * Set the work description of the artist.
     * @param workDescription A little description about the artwork.
     */
    @Override
    public void setWorkDescription(String workDescription) {
        this.workDescription = workDescription;
    }
    
    /**
     * Returns the web of the artist.
     * @return the official website
     */
    public String getWeb() {
        return web;
    }
    
    /**
     * Set the web of the artist.
     * @param web Official website
     */
    public void setWeb(String web) {
        this.web = web;
    }
    
    /**
    * Checks if the name the objects is the same.
    * @param o Object
    * @return true if and only if the name in lowercase is the same and false otherwise
    */
    @Override
    public boolean equals(Object o ) {
        if (o instanceof Artist){ 
            Artist a = (Artist)o;
            return this.getName().toLowerCase().equals(a.getName().toLowerCase());
        }else{
            return false;
        }
    }

    /**
     * Generate a hashcode based in name. 
     * @return the hash of the object
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public String toXML() {
        XStream xstream = new XStream();
        xstream.alias("artist",Artist.class);
        String xml = xstream.toXML(this);
        return xml;
                    
    }

    @Override
    public boolean saveToXML(File f) {
                
        String xml = this.toXML();
        try {
            FileWriter writer = new FileWriter(f);
            writer.write(xml);
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(Artist.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return false;

        
    }

    @Override
    public boolean saveToXML(String filePath) {
        return saveToXML(new File(filePath));
    }
}
