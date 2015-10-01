/*
 * This document is part of the lab material for the subject:
 * Gestion de Sistemas de Informacion
 * to be released at the
 * Universidad Publica de Navarra
 * during the first semester of the Academic Year 2015-2016
 */

package BTesting;

import GSILabs.BModel.*;
import GSILabs.BSystem.BusinessSystem;

/**
 * Clase que realiza las pruebas de business system.
 * Comprueba que se cumplen los requisitos pedidos.
 * @author GR03
 * @version 1.0
 */
public class P01Tester {
    
    private static BusinessSystem businessSystem;
    
    private static Client client1;
    private static Client client2;
    private static Client client3;
    private static Client clientWithoutTickets;
    private static Client invalidClient;
    
    private static Artist artist1;
    private static Artist artist2;
    private static Artist artist3;
    private static Artist artist4;
    
    private static Collective collective1;
    private static Collective collective2;
    private static Collective collective3;
    private static Collective collective4;
    
    private static Ticket ticket1;
    private static Ticket ticket2;
    private static Ticket ticket3;
    private static Concert concert1;
    private static Location location1;
    private static Location location2;
    private static Location location3;
    private static Location location4;
    private static Concert concert2;
    private static Concert concert3;
    private static Concert concert4;
    private static Concert concert5;
    
    /**
     * 
     */
    public static void main(String args[]){  
        
        businessSystem = generateData();
        runTests();
    }
    
    /**
     * Metodo que ejecuta los tests de la aplicación
     */    
    static void runTests() {
        
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
        test9();
        test10();
    }
    
    /**
     * Metodo que crea los objetos necesarios para realizar las pruebas
     */
    private static BusinessSystem generateData() {
        
        businessSystem = new BusinessSystem();
        
        client1 = new Client(15846815, "pepe", "Randez", "Perez", new DateGeneral("14/2/1956"));
        invalidClient = new Client(11224569, "Lucas", "Martinez", "Otxandorena", new DateGeneral("2/1/2004"));
        
        client2 = new Client(12345678, "Juan", "Sanchez", "Rodriguez", new DateGeneral("20/09/1987"));
        client2.addCreditCard("5263214589758963");
        client2.addCreditCard("4587125963458710");
        
        client3 = new Client(44687509, "María", "Sanchez", "Juaniz", new DateGeneral("4/5/1990"));
        client3.addCreditCard("5263214589758963");
        
        clientWithoutTickets = new Client(12345690, "Perico", "El de Los", "Palotes", new DateGeneral("5/2/1980"));
        
        artist1 = new Artist("Maria", "Cantante de opera");
        artist2 = new Artist("Rihana", "Rihana");
        artist3 = new Artist("adsf", "Cantante de opera");
        artist4 = new Artist("", "");
        
        businessSystem.addCollective(new Collective("Barricada", ""));
        businessSystem.addCollective(new Collective("Los Delinquentes", ""));
        businessSystem.addCollective(new Collective("Flitter", ""));
        
        location1 = new Location("Madrid", 300, new Coordinates(123,287));
        location2 = new Location("Barcelona", 250, new Coordinates(100,250));
        location3 = new Location("Jerez de la Frontera", 190, new Coordinates(879,123));
        location4 = new Location("Bilbao", 187, new Coordinates(10,20));
        
        
        concert1 = new Concert("Concierto 1", artist1, location1, new DateConcert("14/2/1999","12:10"));
        concert2 = new Concert("Concierto 2", artist1, location2, new DateConcert("14/2/1999","12:10"));
        concert3 = new Concert("Concierto 3", artist1, location3, new DateConcert("14/2/1999","12:10"));
        concert4 = new Concert("Concierto 4", artist1, location4, new DateConcert("14/2/1999","12:10"));
        concert5 = new Concert("Concierto 5", artist1, location1, new DateConcert("14/2/1999","12:10"));
        
        
        ticket1 = new Ticket("Disturbed", businessSystem.getAtomicInteger());
        businessSystem.addNewTicket(ticket1);
        
        ticket2 = new Ticket("All that Remains", businessSystem.getAtomicInteger());
        businessSystem.addNewTicket(ticket2);
        
        ticket3 = new Ticket("Nickelback", businessSystem.getAtomicInteger());
        businessSystem.addNewTicket(ticket3);
        
        
        businessSystem.addClient(client1);
        businessSystem.addClient(client2);
        businessSystem.addClient(clientWithoutTickets);
        
        
        businessSystem.addArtist(artist1);
        businessSystem.addArtist(artist2);
        businessSystem.addArtist(artist3);
        businessSystem.addArtist(artist4);
        
        businessSystem.addCollective(collective1);
        businessSystem.addCollective(collective2);
        businessSystem.addCollective(collective3);
        businessSystem.addCollective(collective4);
        
        
        return businessSystem;
    }
    
    static void test1() {
    //S1
        System.out.println("S1) Si introduce a un cliente, este puede ser luego localizado a partir de su ID");
        
        System.out.println(businessSystem.retrieveClient(client1.getDNI()));
    }
    
    static void test2() {
        //S2
        System.out.println("S2) Si busca a un cliente que no existe con findClient, el resultado es null;");
        Client client = businessSystem.retrieveClient(client1.getDNI());
        
        if (client != null) {
            System.out.println("Cliente encontrado");
            System.out.println(client);
        }
        else {
            System.out.println("El cliente no ha sido encontrado");
        }
    }
    
    static void test3() {
        //S3
        System.out.println("S3) No se pueden introducir un artista y un colectivo con el mismo nombre;");
        
        System.out.println(artist1);
        System.out.println(collective1);
 
        System.out.println("Resultado de añadir el artista: " + businessSystem.addArtist(artist1));
        System.out.println("Resultado de añadir el colectivo: " + businessSystem.addCollective(collective1));
    }
    
    static void test4() {
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
    }
    
    static void test5() {
        System.out.println("S5) No se pueden añadir dos eventos diferentes del mismo artista el mismo día");
    }
    
    static void test6() {
        //S6
        System.out.println("S6) El sistema calcula de manera adecuada el gasto de cada cliente en entradas");
        //introducir un nuevo cliente sin tickets
        System.out.println(clientWithoutTickets);
        //agregar varios tickets al cliente y mostrar cada ticket por pantalla
        //mostrar la suma por pantalla
        
        System.out.println(ticket1);
        System.out.println(ticket2);
        businessSystem.addSale(ticket1, clientWithoutTickets,(float)1.2, clientWithoutTickets.getCreditCard().toArray()[0].toString());
        businessSystem.addSale(ticket2, clientWithoutTickets,(float)5.2, clientWithoutTickets.getCreditCard().toArray()[0].toString());
        System.out.println("Total gastado por el cliente: " + businessSystem.getTotalSpending(clientWithoutTickets));
        
        businessSystem.addSale(ticket3, client3,(float)55.2222, client3.getCreditCard().toArray()[0].toString());
        System.out.println("Total gastado por clients7 " +businessSystem.getTotalSpending(client3));
        
    }
    
    static void test7() {
    //S7
        System.out.println("S7) No se puede asociar un evento a una localización que no existe;");
        
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
        
    }
    
    static void test8() {
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
        

        if(businessSystem.addConcertToFestival(festival, concert1)){
            System.out.println("Concierto agregado a festvial correctamente");
        }else{
            System.out.println("Error al agregar el concierto al festival");
        }
        
    }
    
    static void test9() {
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
            System.out.println("Venta realizada correctamente.");
        }else {
            System.out.println("Cliente no encontrado. Imposible realizar venta");
        }
        
        ticket = new Ticket("EventoRaruno", businessSystem.getAtomicInteger());
        businessSystem.addNewTicket(ticket);
        Client client5 = new Client(15846815, "Rogelio", "Benedicto", "Pascasio", new DateGeneral("11/5/2015","14:12"));
        if ( businessSystem.addSale(ticket, client5,(float)2.2222, "creditcard")) {
            System.out.println("Venta realizada correctamente" );    
        }else{
            System.out.println("Cliente no encontrado. Imposible realizar venta");
        }
    }
    
    static void test10() {
    //S10
        System.out.println("S10) No se puede introducir un usuario menor de edad.");
        if (businessSystem.addClient(invalidClient)){
            System.out.println("Cliente agregado correctamente");
        }else{
            System.out.println("Error al agregar el cliente");
        }
    }
}
