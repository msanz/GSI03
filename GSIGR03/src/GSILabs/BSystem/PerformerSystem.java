/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GSILabs.BSystem;

import GSILabs.BModel.Artist;
import GSILabs.BModel.Collective;
import GSILabs.BModel.Performer;
import java.util.HashSet;

/**
 *
 * @author GR03
 */
public class PerformerSystem {
    
    HashSet<Performer> performers;
    
    PerformerSystem(){
        performers = new HashSet<Performer>();
    }
    
    /**
     * Adds a new artist to the system
     * @param a The new artist
     * @return True if the artist a is not null, is well formed and could be added to the
     *  system
     */
    public boolean addArtist(Artist a) {
        return performers.add(a);
    }

    /**
     * Adds a new collective of artists to the system
     * @param c The new collective
     * @return True if the collective c is not null, is well formed and could be added to the
     *  system
     */
    public boolean addCollective(Collective c) {
        return performers.add(c);
    }
    
    /**
     * Replaces the information in the sytem related to the artist e.
     * @param a The new version of the artist
     * @return True if an only if a previous version of the artist existed,
     *  e is well formed, and it does not produce clashes with the information already
     *  in the system.
     */
    public boolean modifyArtist(Artist a) {
       if (a == null) return false;
       for (Performer p:performers){
            if (p.equals(a)){
                performers.remove(p);
                return this.addArtist(a);
            }
        }
        return false;
    }
    
    /**
     * Replaces the information in the sytem related to the collective e.
     * @param c The new version of the collective
     * @return True if an only if a previous version of the collective existed,
     *  e is well formed, and it does not produce clashes with the information already
     *  in the system.
     */
    public boolean modifyCollective(Collective c) {
        if (c == null) return false;
        for (Performer p:performers){
            if (p.getName().equals(c.getName())){
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
            if (p.getName().equals(performerName))
                return performers.remove(p);
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
            if (p.getName().equals(performerName))
                return true;
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
            if ((p.getName().equals(artistName)) && (p instanceof Artist))
                return true;
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
            if ((p.getName().equals(artistName)) && (p instanceof Collective))
                return true;
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
            if (p.getName().equals(performerName))
                return p;
        }
        return null;
    }
}
