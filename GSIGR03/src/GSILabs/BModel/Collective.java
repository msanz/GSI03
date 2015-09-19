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
     
    //mirar que coleccion conviene utilizar
    public SortedSet<Artist> members;
    
    public Collective(String name, String workDescription) {
        super(name, workDescription);
    }

    public Collective(String name, String workDescription, String web) {
        super(name, workDescription);
        this.web = web;
    }

    @Override
    public String toString() {
        return "Name: "+ super.name +" ArtWork: " + super.workDescription +" Web: " + web +"\n";
    }
}
