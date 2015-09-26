/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GSILabs.BModel;

import java.util.SortedSet;

/**
 *
 * @author GR03
 */
public class Collective extends Artist implements Performer {
    SortedSet<Artist> members;
    
    public Collective(String name, String workDescription) {
        super(name, workDescription);
    }

    public Collective(String name, String workDescription, String web) {
        super(name, workDescription);
        this.web = web;
    }
    
    /**
     * Rewriting the toString() method
     * @return Another way to show the information
     */
    @Override
    public String toString() {
        return "Name: "+ super.name +" ArtWork: " + super.workDescription +" Web: " + web +"\n";
    }
    
    @Override
    public boolean equals(Object o ) {
        if (o == null) 
            return false;
        Collective a = (Collective)o;
        return this.getName().toLowerCase().equals(a.getName().toLowerCase());
    }
}
