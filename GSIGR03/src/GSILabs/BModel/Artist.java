/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GSILabs.BModel;

/**
 *
 * @author GR03
 */
public class Artist implements Performer {
    
    String name;
    String workDescription;
    String web;

    Artist(String name, String workDescription){
        this.name = name;
        this.workDescription = workDescription;
    }
    
    Artist(String name, String workDescription, String web){
        this.name = name;
        this.workDescription = workDescription;
        this.web = web;
    }
    
    @Override
    public String toString() {
        return "Name: "+ name +" orkDescription: " + workDescription +" Web: " + web +"\n";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getWorkDescription() {
        return workDescription;
    }

    @Override
    public void setWorkDescription(String description) {
        this.workDescription = description;
    }
}
