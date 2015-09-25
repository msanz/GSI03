/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GSILabs.BSystem;


import GSILabs.BModel.Artist;
import GSILabs.BModel.Client;
import GSILabs.BModel.Concert;
import GSILabs.BModel.Coordinates;
import GSILabs.BModel.DateConcert;
import GSILabs.BModel.DateGeneral;
import GSILabs.BModel.Event;
import GSILabs.BModel.Exhibition;
import GSILabs.BModel.Location;
import GSILabs.BModel.Ticket;

/**
 *
 * @author GR03
 */
public class P01Tester {
    public static void main(String args[]){  
        BusinessSystem businessSystem = new BusinessSystem();

        Client client1 = new Client(15846815, "pepe", "Randez", "Perez", new DateGeneral("14/2/1956","12:10"));
        businessSystem.addClient(client1);
        
        Artist artist1 = new Artist("Maria", "Cantante de opera");
        Artist artist2 = new Artist("Ana", "Cantante de opera");
        
        Location location1 = new Location("Madrid", 50, new Coordinates(10,20));
        businessSystem.addArtist(artist2);
        //businessSystem.addArtist(artist1);
        Concert concert1 = new Concert(new DateConcert("14/2/1999","12:10"), "Concierto 1", artist1, location1);
        Concert concert2 = new Concert(new DateConcert("14/2/2000","12:10"), "Concierto 1", artist2, location1);    
        

        businessSystem.addNewConcert(concert1);
            
        
        System.out.println(concert2.getClass().getName());    
       
        businessSystem.replaceConcert(concert2);

        Ticket ticket;

        for (int i = 0; i < 30; i++) {
            ticket = new Ticket("U2-Madrid", businessSystem.getAtomicInteger());
            businessSystem.addNewTicket(ticket);
        }
        ticket = new Ticket("U2-Barcelona", businessSystem.getAtomicInteger());
        businessSystem.addNewTicket(ticket);
        
        businessSystem.addLocation(location1);
        System.out.println(businessSystem.getLocation("Madrid").toString());

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
