/*
 * This document is part of the lab material for the subject:
 * Gestion de Sistemas de Informacion
 * to be released at the
 * Universidad Publica de Navarra
 * during the first semester of the Academic Year 2015-2016
 */

package GSILabs.BModel;

import java.util.SortedSet;

/**
 * A collective is a collection of artist that take part of concert or exhibition.
 * @author GR03
 * @version 1.0
 */
public class Collective extends Artist implements Performer {
    private SortedSet<Artist> members;
    
    /**
     * Create a new collective 
     * @param name The name of collective
     * @param workDescription The artwork description
     */
    public Collective(String name, String workDescription) {
        super(name, workDescription);
    }
    
    /**
     * Create a new collective 
     * @param name The name of collective
     * @param workDescription The artwork description
     * @param web The website of the collective
     */
    public Collective(String name, String workDescription, String web) {
        super(name, workDescription);
        this.setWeb(web);
    }
    
    /**
     * Rewriting the toString() method
     * @return Another way to show the information
     */
    @Override
    public String toString() {
        return "Name: "+ super.getName() +" ArtWork: " + super.getWorkDescription() +" Web: " + super.getWeb() +"\n";
    }
    
    /**
    * Checks if the name the objects is the same.
    * @param o Object
    * @return true if and only if the name in lowercase is the same and false otherwise
    */
    @Override
    public boolean equals(Object o ) {
        if (o instanceof Artist){ 
            Collective a = (Collective)o;
            return this.getName().toLowerCase().equals(a.getName().toLowerCase());
        }
        return false;
    }
}
