/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GSILabs.BSystem;


import GSILabs.BModel.Artist;
import GSILabs.BModel.Client;
import GSILabs.BModel.Collective;
import GSILabs.BModel.Concert;
import GSILabs.BModel.Coordinates;
import GSILabs.BModel.DateConcert;
import GSILabs.BModel.DateGeneral;
import GSILabs.BModel.Festival;
import GSILabs.BModel.Location;
import GSILabs.BModel.Ticket;
import java.util.Date;

/**
 *
 * @author GR03
 */
public class P01Tester {
    public static void main(String args[]){  
        BusinessSystem businessSystem = new BusinessSystem();
        
        //S1
        System.out.println("S1) Si introduce a un cliente, este puede ser luego localizado a partir de su ID");
        
        Client client1 = new Client(15846815, "pepe", "Randez", "Perez", new DateGeneral("14/2/1956","12:10"));
        
        if(businessSystem.addClient(client1)){
            System.out.println("Cliente agregado correctamente");
        }else{
            System.out.println("Error al agregar el cliente");
        }
        
        //S2
        System.out.println("S2) Si busca a un cliente que no existe con findClient, el resultado es null;");
        Client client = businessSystem.retrieveClient(15846815);
        
        if (client != null){
            System.out.println("Cliente encontrado");
            System.out.println(client);
        }else{
            System.out.println("El cliente no ha sido encontrado");
        }
        
        //S3
        System.out.println("S3) No se pueden introducir un artista y un colectivo con el mismo nombre;");
        
        Artist artist1 = new Artist("Maria", "Cantante de opera");
        
        Collective collective1 = new Collective("Maria", "Muchas marias juntas");
        
        if(businessSystem.addArtist(artist1)){
            System.out.println("Artista agregado correctamente");
        }else{
            System.out.println("Error al agregar el artista");
        }
        
        if (businessSystem.addCollective(collective1)){
            System.out.println("Colectivo agregado correctamente");
        }else{
            System.out.println("Erro al agregar el colectivo");
        }
        
        //S4
        System.out.println("S4) Si se añade un artista, y se elimina posteriormente, se puede introducir un colectivo con el mismo nombre;");
        
        if (businessSystem.removePerformer("Maria")){
            System.out.println("Performer eliminado correctamente");
        }else{
            System.out.println("Error al eliminar el performer");
        }
        
        if (businessSystem.addCollective(collective1)){
            System.out.println("Colectivo agregado correctamente");
        }else{
            System.out.println("Error al agregar el colectivo");
        }
        
        //S6
        Ticket ticketS61 = new Ticket("Disturbed", businessSystem.getAtomicInteger());
        businessSystem.addNewTicket(ticketS61);
        
        Ticket ticketS62 = new Ticket("All that Remains", businessSystem.getAtomicInteger());
        businessSystem.addNewTicket(ticketS62);
        
        Ticket ticketS63 = new Ticket("Nickelback", businessSystem.getAtomicInteger());
        businessSystem.addNewTicket(ticketS63);
        
        Client clients6 = new Client(12345678, "Juan", "Sanchez", "Perez", new DateGeneral("14/2/1990","12:10"));
        clients6.addCreditCard("5263214589758963");
        if (businessSystem.addClient(clients6)){
            System.out.println("Cliente agregado correctamente");
        }else{
            System.out.println("Error al agregar el cliente");
        }
        
        Client clients7 = new Client(12345690, "Perico", "El de Los", "Palotes", new DateGeneral("14/2/1980","12:10"));
        clients7.addCreditCard("5263214589758963");
        if (businessSystem.addClient(clients7)){
            System.out.println("Cliente agregado correctamente");
        }else{
            System.out.println("Error al agregar el cliente");
        }
        
        businessSystem.addSale(ticketS61, clients6,(float)1.2, clients6.getCreditCard().toArray()[0].toString());
        businessSystem.addSale(ticketS62, clients6,(float)5.2, clients6.getCreditCard().toArray()[0].toString());
        System.out.println("Total gastado por clients6 " +businessSystem.getTotalSpending(clients6));
        businessSystem.addSale(ticketS63, clients7,(float)55.2222, clients7.getCreditCard().toArray()[0].toString());
        System.out.println("Total gastado por clients7 " +businessSystem.getTotalSpending(clients7));
        
        
        //S7
        System.out.println("S7) No se puede asociar un evento a una localización que no existe;");
        
        Location location1 = new Location("Madrid", 50, new Coordinates(10,20));
        Concert concert1 = new Concert("Concierto 1", artist1, location1, new DateConcert("14/2/1999","12:10"));
        
        if (businessSystem.addNewConcert(concert1)){
            System.out.println("Concierto agregado correctamente");
        }else{
            System.out.println("Error al agregar el concierto");
        }
        
        if (businessSystem.addLocation(location1)){
            System.out.println("Localizacion agregada correctamente");
        }else{
            System.out.println("Error al agregar la localizacion");
        }
       
        if (businessSystem.addNewConcert(concert1)){
            System.out.println("Concierto agregado correctamente");
        }else{
            System.out.println("Error al agregar el concierto");
        }
        
        Concert concert3 = new Concert("Concierto 3", artist1, location1, new DateConcert("14/2/2000","12:10")); 
        
        //S8
        System.out.println("S8) No se puede añadir a un festival un concierto que ya se le hubiera añadido.");
        Festival festival = new Festival("NavajaNegra"); 
        
        if (businessSystem.addNewFestival(festival)){
            System.out.println("Festival agregado correctamente");
        }else{
            System.out.println("Error al agregar el festvial");
        }
        
//        if(businessSystem.addConcertToFestival(festival, concert1)){
//            System.out.println("Concierto agregado a festvial correctamente");
//        }else{
//            System.out.println("Error al agregar el concierto al festival");
//        }
        
        /*
        if(businessSystem.addConcertToFestival(festival, concert1)){
            System.out.println("Concierto agregado a festvial correctamente");
        }else{
            System.out.println("Error al agregar el concierto al festival");
        }*/
        
        //S9
        System.out.println("S9) No se puede asignar una venta a un cliente que no existe.");
        
        Ticket ticket;
        for (int i = 0; i < 30; i++) {
            ticket = new Ticket("U2-Madrid", businessSystem.getAtomicInteger());
            businessSystem.addNewTicket(ticket);
        }
        ticket = new Ticket("U2-Barcelona", businessSystem.getAtomicInteger());
        businessSystem.addNewTicket(ticket);
        
        businessSystem.addLocation(location1);
        
        ticket = new Ticket("EventoRaruno", businessSystem.getAtomicInteger());
        businessSystem.addNewTicket(ticket);
        Client client2 = new Client(15846813, "pepe", "Randez", "Perez", new DateGeneral("14/2/1990","12:10"));
        client2.addCreditCard("5263214589758963");
        if (businessSystem.addClient(client2)){
            System.out.println("Cliente agregado correctamente");
        }else{
            System.out.println("Error al agregar el cliente");
        }
        
        if ( businessSystem.addSale(ticket, client2,(float)2.2222, client2.getCreditCard().toArray()[0].toString())) {
            System.out.println("Venta realizada correctamente.\nDetalle de la venta:" );
            System.out.println(businessSystem.ticketSystem.ticketSales);
        }else {
            System.out.println("Cliente no encontrado. Imposible realizar venta");
        }
        
        ticket = new Ticket("EventoRaruno", businessSystem.getAtomicInteger());
        businessSystem.addNewTicket(ticket);
        client = new Client(15846815, "Rogelio", "Benedicto", "Pascasio", new DateGeneral("11/5/2015","14:12"));
        if ( businessSystem.addSale(ticket, client,(float)2.2222, "creditcard")) {
            System.out.println("Venta realizada correctamente" );    
        }else{
            System.out.println("Cliente no encontrado. Imposible realizar venta");
        }
        
        //S10
        System.out.println("S10) No se puede introducir un usuario menor de edad.");
        client2 = new Client(15846815, "pepe", "Randez", "Perez", new DateGeneral("14/2/2010","12:10"));
        if (businessSystem.addClient(client2)){
            System.out.println("Cliente agregado correctamente");
        }else{
            System.out.println("Error al agregar el cliente");
        }
        
        
    }
    
/**
 * 
 * S5) No se pueden añadir dos eventos diferentes del mismo artista el mismo día;
 * S6) El sistema calcula de manera adecuada el gasto de cada cliente en entradas (probar con más de
 *     dos entradas, así como con entradas asociadas a diferentes clientes). 
 */
}
