/*
 * This document is part of the lab material for the subject:
 * Gestion de Sistemas de Informacion
 * to be released at the
 * Universidad Publica de Navarra
 * during the first semester of the Academic Year 2015-2016
 */
package GSILabs.BModel;

/**
 * An artist is a person who takes part of concert or exhibition.
 * @author GR03
 * @version 1.0
 */
public class Artist implements Performer {
    String name;
    String workDescription;
    String web;
    
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
     * @return Other style to show the information
     */
    @Override
    public String toString() {
        return "Name artist: "+ name +
               "\nWork description: " + workDescription +
               "\nWeb: " + web;
    }
    
    /**
     * Returns the name of the artist.
     * @return name The name of the artist.
     */
    @Override
    public String getName() {
        return name;
    }
    
    /**
     * Returns the work description of the artist.
     * @return workDescription The artwork description
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
     * @return web Official website
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
    
    @Override
    public boolean equals(Object o ) {
        if (o == null) 
            return false;
        Artist a = (Artist)o;
        return this.getName().toLowerCase().equals(a.getName().toLowerCase());
    }
}
