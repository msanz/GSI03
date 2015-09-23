/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GSILabs.BSystem;


import GSILabs.BModel.Artist;
import GSILabs.BModel.Client;
import GSILabs.BModel.Concert;
import GSILabs.BModel.DateGeneral;
import GSILabs.BModel.Location;
import GSILabs.BModel.Coordinates;
import GSILabs.BModel.Event;
import GSILabs.BModel.Festival;
import java.util.ArrayList;

/**
 *
 * @author GR03
 */
public class P01Tester {
     public static void main(String args[]){
        BusinessSystem businessSystem = new BusinessSystem();
        
        /*Concert c = new Concert();
        Festival f = new Festival();
        ArrayList<Event> events = new ArrayList();
        events.add(c);
        events.add(f);
        for(Event e:events){
            if (e instanceof Concert)
                System.out.println("Soy Concert");
            if (e instanceof Festival)
                System.out.println("Soy Festival");
        }*/
                
        Client client1 = new Client(15846815, "pepe", "Randez", "Perez", new DateGeneral("14/2/1956"));
        System.out.println(client1);

        Location location1 = new Location("Madrid", 50, new Coordinates(10,20));
        businessSystem.addLocation(location1);
        System.out.println(businessSystem.getLocation("Madrid").toString());
        
        Artist artist1 = new Artist("Maria", "Cantante de opera");

     }
    
/**
 * 
 * S1) Si introduce a un cliente, este puede ser luego localizado a partir de su ID;
 * S2) Si busca a un cliente que no existe con findClient, el resultado es null;
 * S3) No se pueden introducir un artista y un colectivo con el mismo nombre;
 * S4) Si se añade un artista, y se elimina posteriormente, se puede introducir un colectivo con el mismo nombre;
 * S5) No se pueden añadir dos eventos diferentes del mismo artista el mismo día;
 * S6) El sistema calcula de manera adecuada el gasto de cada cliente en entradas (probar con más de
 *     dos entradas, así como con entradas asociadas a diferentes clientes);
 * S7) No se puede asociar un evento a una localización que no existe;
 * S8) No se puede añadir a un festival un concierto que ya se le hubiera añadido;
 * S9) No se puede asignar una venta a un cliente que no existe;
 * S10) No se puede introducir un usuario menor de edad.
 */
}
