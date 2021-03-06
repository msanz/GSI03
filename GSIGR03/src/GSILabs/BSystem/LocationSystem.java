/*
 * This document is part of the lab material for the subject:
 * Gestion de Sistemas de Informacion
 * to be released at the
 * Universidad Publica de Navarra
 * during the first semester of the Academic Year 2015-2016
 */

package GSILabs.BSystem;

import GSILabs.BModel.Location;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * LocationSystem is a subsystem for manage a hashset of locations
 * @author GR03
 * @version 1.0
 */
public class LocationSystem {
    
    private final HashSet<Location> locations;

    /**
    * Create a new Location System with a hashset of locations.
    */
    public LocationSystem(){
        locations = new HashSet<>();
    }

    /**
     * Adds a new location to the system
     * @param loc   The location
     * @return  True if and only if the location is not null, is well formed and 
     *  could be added to the system.
     */
    public boolean addLocation(Location loc) {
        return locations.add(loc);
    }

     /**
     * Retrieves a location by its exact name
     * @param name  The name of the location
     * @return  The location with that name, or null if it does not exist.
     */
    public Location getLocation(String name) {
        for (Location l:locations){
            if (l.getName().toLowerCase().equals(name.toLowerCase()))
                return l;
        }
        return null;
    }
    
     /**
     * Deletes a location from the system. This can only be done if there is no events
     *  associated with that location.
     * @param loc   The location to be removed
     * @return  True if an only if the location loc existed and could be removed.
     */
    public boolean deleteLocation(Location loc) {
        return locations.remove(loc);
    }
    
    /**
     * Retrieve the locations in the system with, at least, minCapacity attendance limit.
     * @param minCapacity   Attendance threshold
     * @return A list of 0+ locations
     */
    public Location[] getLocations(int minCapacity) {
        ArrayList<Location> list = new ArrayList();
        for (Location l:locations){
            if (l.getCapacity()>=minCapacity){
                list.add(l);
            }
        }
        if (list.isEmpty()){
            return null;
        }else{
            return (Location[]) list.toArray();
        }
    }
}
