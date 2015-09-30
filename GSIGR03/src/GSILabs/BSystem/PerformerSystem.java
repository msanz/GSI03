/*
 * This document is part of the lab material for the subject:
 * Gestion de Sistemas de Informacion
 * to be released at the
 * Universidad Publica de Navarra
 * during the first semester of the Academic Year 2015-2016
 */

package GSILabs.BSystem;

import GSILabs.BModel.Artist;
import GSILabs.BModel.Collective;
import GSILabs.BModel.Performer;
import java.util.HashSet;

/**
 * PerformerSystem is a subsystem for manage a hashset of performers
 * @author GR03
 * @version 1.0
 */
public class PerformerSystem {
    
    private HashSet<Performer> performers;

    /**
    * Create a new Performer System with a hashset of performers.
    */
    public PerformerSystem(){
        performers = new HashSet<Performer>();
    }
    
    /**
     * Adds a new artist to the system
     * @param a The new artist
     * @return True if the artist a is not null, is well formed and could be added to the
     *  system
     */
    public boolean addArtist(Artist a) {
        if (!this.existsPerformer(a.getName())) {
            return performers.add(a);       
        }
        return false;
    }

    /**
     * Adds a new collective of artists to the system
     * @param c The new collective
     * @return True if the collective c is not null, is well formed and could be added to the
     *  system
     */
    public boolean addCollective(Collective c) {
        if (!this.existsPerformer(c.getName())) {
            return performers.add(c);
        }
        return false;
    }
    
    /**
     * Replaces the information in the system related to the artist e.
     * @param a The new version of the artist
     * @return True if an only if a previous version of the artist existed,
     *  e is well formed, and it does not produce clashes with the information already
     *  in the system.
     */
    public boolean modifyArtist(Artist a) {
       if (a == null || (this.existsPerformer(a.getName()))){ 
           return false;
       }
       for (Performer p:performers){
            if (p.equals(a)){
                performers.remove(p);
                return this.addArtist(a);
            }
        }
        return false;
    }
    
    /**
     * Replaces the information in the system related to the collective e.
     * @param c The new version of the collective
     * @return True if an only if a previous version of the collective existed,
     *  e is well formed, and it does not produce clashes with the information already
     *  in the system.
     */
    public boolean modifyCollective(Collective c) {
        if (c == null || (this.existsPerformer(c.getName()))){ 
           return false;
       }
        for (Performer p:performers){
            if (p.getName().toLowerCase().equals(c.getName().toLowerCase())){
                performers.remove(p);
                this.addCollective(c);
            }
        }
        return false;
    }
    
    /**
     * Deletes the record of a performer from the system, provided it has no
     *  events to which it is associated
     * @param performerName The name of the performer
     * @return True if and only if the performer with that name existed and could be removed.
     */
    public boolean removePerformer(String performerName) {
        for (Performer p:performers){
            if (p.getName().toLowerCase().equals(performerName.toLowerCase())){
                return performers.remove(p);
            }
        }
        return false;
    }
    
    /**
     * Checks whether there exist a performer with that name in the system
     * @param performerName Name of interest
     * @return True if and only if it exists
     */
    public boolean existsPerformer(String performerName) {
       for (Performer p:performers){
            if (p.getName().toLowerCase().equals(performerName.toLowerCase())){
                return true;
            }
        }
        return false;
    }

    /**
     * Checks whether there exist a performer with that name in the system
     * @param artistName Name of interest
     * @return True if and only if it exists
     */
    public boolean existsArtist(String artistName) {
        for (Performer p:performers){
            if ((p.getName().toLowerCase().equals(artistName.toLowerCase())) && (p instanceof Artist)){
                return true;
            }
        }
        return false;
    }

    /**
     * Checks whether there exist a performer with that name in the system
     * @param artistName Name of interest
     * @return True if and only if it exists
     */
    public boolean existsCollective(String artistName) {
        for (Performer p:performers){
            if ((p.getName().toLowerCase().equals(artistName.toLowerCase())) && (p instanceof Collective)){
                return true;
            }
        }
        return false;
    }

     /**
     * Retrieves the record of a performer from the system by its name.
     * @param performerName The name of the performer
     * @return The performer, if existing. Null otherwise.
     */
    public Performer retrievePerformer(String performerName) {
       for (Performer p:performers){
            if (p.getName().toLowerCase().equals(performerName.toLowerCase()))
                return p;
        }
        return null;
    }
}
