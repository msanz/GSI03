/*
 * This document is part of the lab material for the subject:
 * Gestion de Sistemas de Informacion
 * to be released at the
 * Universidad Publica de Navarra
 * during the first semester of the Academic Year 2015-2016
 */

package GSILabs.BTesting;

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
    
    private static Location location1;
    private static Location location2;
    private static Location location3;
    private static Location location4;
    
    private static Concert concert1;
    private static Concert concert2;
    private static Concert concert3;
    private static Concert concert4;
    private static Concert concert5;
    
    
    public static void main(String args[]){  
        businessSystem = generateData();
        runTests();
    }
    
    /**
     * Metodo que ejecuta los tests de la aplicación
     */    
    static void runTests() {
        testCompareDate();
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
     * Metodo encargado de poblar nuestro businessSystem.
     * Instancia los objetos necesarios para realizar las pruebas y los añade al sistema.
     */
    private static BusinessSystem generateData() {
        
        businessSystem = new BusinessSystem();
        
        client1 = new Client(15846815, "pepe", "Randez", "Perez", new DateGeneral("14/2/1956 15:00"));
        invalidClient = new Client(11224569, "Lucas", "Martinez", "Otxandorena", new DateGeneral("2/1/2004 10:00"));
        
        client2 = new Client(12345678, "Juan", "Sanchez", "Rodriguez", new DateGeneral("20/09/1987 11:00"));
        client2.addCreditCard("5263214589758963");
        client2.addCreditCard("4587125963458710");
        
        client3 = new Client(44687509, "María", "Sanchez", "Juaniz", new DateGeneral("4/5/1990 12:00"));
        client3.addCreditCard("5263214589758963");
        
        clientWithoutTickets = new Client(12345690, "Perico", "El de Los", "Palotes", new DateGeneral("5/2/1980 15:00"));
        clientWithoutTickets.addCreditCard("5263214589758936");
        artist1 = new Artist("Maria", "Cantante de opera", "maria.com");
        artist2 = new Artist("Rihana", "Rihana");
        artist3 = new Artist("adsf", "Cantante de opera");
        artist4 = new Artist("", "");
        
        businessSystem.addCollective(new Collective("Barricada", ""));
        businessSystem.addCollective(new Collective("Los Delinquentes", ""));
        businessSystem.addCollective(new Collective("Flitter", ""));
        Location location1 = new Location("Madrid", 300, new Coordinates(123,287));
        businessSystem.addLocation(location1);
        businessSystem.addLocation(new Location("Barcelona", 250, new Coordinates(100,250)));
        businessSystem.addLocation(new Location("Jerez de la Frontera", 190, new Coordinates(879,123)));
        businessSystem.addLocation(new Location("Bilbao", 187, new Coordinates(10,20)));
        
        concert1 = new Concert("Concierto 1", artist1, businessSystem.getLocation("Madrid"), new DateEvent("14/2/1999","12:10"));
        concert2 = new Concert("Concierto 2", artist1, businessSystem.getLocation("Barcelona"), new DateEvent("5/8/1999","12:10"));
        concert3 = new Concert("Concierto 3", artist1, businessSystem.getLocation("Jerez de la Frontera"), new DateEvent("21/12/2015","12:10"));
        concert4 = new Concert("Concierto 4", artist1, businessSystem.getLocation("Bilbao"), new DateEvent("30/5/2015","12:10"));
        concert5 = new Concert("Concierto 5", artist1, businessSystem.getLocation("Madrid"), new DateEvent("28/11/2015","12:10"));
        
        
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
        
        
        return businessSystem;
    }
    static void testCompareDate() {
        DateGeneral dg = new DateGeneral("12/12/12");
        DateGeneral dg1 = new DateGeneral("12/12/12");
        DateGeneral dg2 = new DateGeneral("12/2/12");
        DateEvent dc = new DateEvent("12/12/12", "21:30");
        DateEvent dc1 = new DateEvent("12/12/12", "21:30");
        DateEvent dc2 = new DateEvent("12/12/12", "22:30");
        DateEvent dc3 = new DateEvent("12/1/12", "22:30");
    }
    
    static void test1() {
    //S1
        System.out.println("\nS1) Si introduce a un cliente, este puede ser luego localizado a partir de su ID");
        System.out.println("Buscamos el cliente con DNI 15846815.");
        System.out.println(businessSystem.retrieveClient(client1.getDNI()));
    }
    
    static void test2() {
        //S2
        System.out.println("\nS2) Si busca a un cliente que no existe con findClient(), el resultado es null;");
        System.out.println("Buscamos en el sistema un cliente que no existe usando un identificador no válido");
        if (businessSystem.retrieveClient(00000000) == null)
            System.out.println("El cliente 00000000 no existe");
        if (businessSystem.retrieveClient(client1.getDNI()) != null)
            System.out.println("El cliente" + client1.getDNI() + " existe");
    }
    
    static void test3() {
        //S3
        System.out.println("\nS3) No se pueden introducir un artista y un colectivo con el mismo nombre;");
        System.out.println(businessSystem.retrievePerformer("Maria"));
        System.out.println("\nInstanciamos un colectivo con el mismo nombre.");
        collective1 = new Collective("Maria", "sculptor");
        System.out.println(collective1);
        System.out.println("Resultado de intentar añadir el colectivo creado: " + businessSystem.addCollective(collective1));
    }
    
    static void test4() {
        //S4
        System.out.println("\nS4) Si se añade un artista, y se elimina posteriormente, se puede introducir un colectivo con el mismo nombre;");
        
        System.out.println("Tenemos a Maria en el sistema");
        System.out.println(businessSystem.retrievePerformer("Maria"));
        System.out.println("La borramos del sistema: " + businessSystem.removePerformer("Maria"));
        
        System.out.println("Añadimos un colectivo con el mismo nombre");
        if (businessSystem.addCollective(collective1))
            System.out.println("Colectivo agregado correctamente");
        System.out.println("Comprobamos que el colectivo está en el sistema\n" + businessSystem.retrievePerformer("Maria"));
    }
    
    static void test5() {
        System.out.println("\nS5) No se pueden añadir dos eventos diferentes del mismo artista el mismo día");
        System.out.println("Probamos a añadir dos eventos de Flitter el mismo dia");
        Collective collective = businessSystem.retrieveCollective("Flitter");
        Location madrid = businessSystem.getLocation("Madrid");
        Location bilbao = businessSystem.getLocation("Bilbao");
        DateEvent date = new DateEvent("12/7/2015 21:30", "12/7/2015 22:30");
        Concert flitterMadrid = new Concert("Flitter-Madrid", collective, madrid, date);
        Concert flitterBilbao = new Concert("Flitter-Bilbao", collective, bilbao, date);
       
        businessSystem.addNewConcert(flitterBilbao);    
        businessSystem.addNewConcert(flitterMadrid);
    }
    
    static void test6() {
        //S6
        System.out.println("S6) El sistema calcula de manera adecuada el gasto de cada cliente en entradas");
        //introducir un nuevo cliente sin tickets
        
        //agregar varios tickets al cliente y mostrar cada ticket por pantalla
        //mostrar la suma por pantalla
        
        System.out.println(ticket1);
        System.out.println(ticket2);
        businessSystem.addSale(ticket1, clientWithoutTickets,(float)1.2, clientWithoutTickets.getCreditCard().toArray()[0].toString());
        businessSystem.addSale(ticket2, clientWithoutTickets,(float)5.2, clientWithoutTickets.getCreditCard().toArray()[0].toString());
        System.out.println("Total gastado por el cliente: " + businessSystem.getTotalSpending(clientWithoutTickets));
               
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
        Client client2 = new Client(15846813, "pepe", "Randez", "Perez", new DateEvent("14/2/1990 12:10","14/2/1990 16:10"));
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
        Client client5 = new Client(15846815, "Rogelio", "Benedicto", "Pascasio", new DateEvent("11/5/2015 14:12","11/5/2015 15:12"));
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
