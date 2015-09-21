/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
     * @return Another way to show the information
     */
    @Override
    public String toString() {
        return "Name: "+ name +" workDescription: " + workDescription +" Web: " + web +"\n";
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
}
