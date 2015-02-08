package prac6;

import prac6.OrderedListADT;
import java.util.Calendar;
import java.util.Iterator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dorian
 */
public class VueloTest {
    Vuelo vuelo;
    Calendar fecha;
    
    @Before
    public void setUp() {
        fecha=Calendar.getInstance();
        fecha.set(2007, 3, 5, 13, 53);
        
        vuelo=new Vuelo("B5R23", "Suecia", "España", fecha, 6);
        
        DNI dni=new DNI("71463395A");
        Pasajero pasajero=new Pasajero(dni, "Dorian", "Cadenas Álvarez", 22);
        vuelo.insertaPasajero(pasajero);
        dni=new DNI("12345678Z");
        pasajero=new Pasajero(dni, "Fulanito", "Mendez", 5);
        vuelo.insertaPasajero(pasajero);
        
    }
    
    @Test
    public void getFechaVuelo(){
        assertEquals("5-3-2007", vuelo.getFechaVuelo());
    }
    
    @Test
    public void getHoraVuelo(){
        assertEquals("13:53", vuelo.getHoraVuelo());
    }
    
    @Test
    public void getSalidaVuelo(){
        assertEquals("5-3-2007 13:53", vuelo.getSalidaVuelo());
    }
    
    @Test
    public void getCodigoVuelo(){
        assertEquals("B5R23", vuelo.getCodigoVuelo());
    }
    
    @Test
    public void getOrigen(){
        assertEquals("España", vuelo.getOrigen());
    }
    
    @Test
    public void getDestino(){
        assertEquals("Suecia", vuelo.getDestino());
    }
    
    @Test
    public void getPasajeros(){
        OrderedListADT<Pasajero> pasajerosDevueltos=vuelo.getPasajeros();
        StringBuilder result=new StringBuilder();
        for (Iterator<Pasajero> it = pasajerosDevueltos.iterator(); it.hasNext();) {
            Pasajero pasajero = it.next();
            result.append(pasajero.toString());
            result.append("\n");
        }
        assertEquals("71463395A: Cadenas Álvarez, Dorian (22)\n" +
            "12345678Z: Mendez, Fulanito (5)\n", result.toString());
        
        Vuelo vacio=new Vuelo("BdE3", "somewhere", "somewhere", fecha, 10);
        assertEquals("", vacio.getPasajeros().toString());
        
    }
    
    @Test
    public void nAsientosLibres(){
        assertEquals(4, vuelo.nAsientosLibres());
        
        DNI dni=new DNI("55555555K");
        Pasajero pasajero=new Pasajero(dni, "Dorian", "Cadenas Álvarez", 22);
        vuelo.insertaPasajero(pasajero);
        
        assertEquals(3, vuelo.nAsientosLibres());
    }
    
    @Test
    public void insertaPasajero(){
        StringBuilder result=new StringBuilder();
        for (Iterator<Pasajero> it = vuelo.iterator(); it.hasNext();) {
            Pasajero pasajero = it.next();
            result.append(pasajero.toString());
            result.append("\n");
        }
        assertEquals("71463395A: Cadenas Álvarez, Dorian (22)\n" +
            "12345678Z: Mendez, Fulanito (5)\n", result.toString());
        
        DNI dni=new DNI("55555555K");
        Pasajero pasajero=new Pasajero(dni, "Julián", "Cadenas Álvarez", 22);
        vuelo.insertaPasajero(pasajero);
        
        result=new StringBuilder();
        for (Iterator<Pasajero> it = vuelo.iterator(); it.hasNext();) {
            Pasajero introduce = it.next();
            result.append(introduce.toString());
            result.append("\n");
        }
        assertEquals("71463395A: Cadenas Álvarez, Dorian (22)\n"
                + "55555555K: Cadenas Álvarez, Julián (22)\n" +
            "12345678Z: Mendez, Fulanito (5)\n", result.toString());
        
        Vuelo nuevoVuelo=new Vuelo("code", "nowhere", "fromnothing", fecha, 5);
        nuevoVuelo.insertaPasajero(pasajero);
    }
    
    @Test
    (expected = VueloCompletoException.class)
    public void listaPasajerosCompleta(){
        DNI dni=new DNI("71463395A");
        Pasajero pasajero=new Pasajero(dni, "Dorian", "Cadenas Álvarez", 22);
        while(true){
            vuelo.insertaPasajero(pasajero);
        }        
    }
    
    @Test
    public void iterator(){
        StringBuilder result=new StringBuilder();
        for (Iterator<Pasajero> it = vuelo.iterator(); it.hasNext();) {
            Pasajero pasajero = it.next();
            result.append(pasajero.toString());
            result.append("\n");
        }
        assertEquals("71463395A: Cadenas Álvarez, Dorian (22)\n" +
            "12345678Z: Mendez, Fulanito (5)\n", result.toString());
    }
    
    @Test
    public void testToString(){
        assertEquals("Vuelo: B5R23\n" +
            "Origen: España\n" +
            "Destino: Suecia\n" +
            "Fecha de salida: 5-3-2007 13:53\n" +
            "Pasajeros: \n" +
            "71463395A: Cadenas Álvarez, Dorian (22)\n" +
            "12345678Z: Mendez, Fulanito (5)\n", vuelo.toString());
    }
    
    @Test
    public void compareTo(){
        Vuelo otroVuelo=new Vuelo("Fall", "Suecia", "España", fecha, 6);
        
        assertEquals(0, vuelo.compareTo(vuelo));
        assertTrue(vuelo.compareTo(otroVuelo)>0);
        assertTrue(otroVuelo.compareTo(vuelo)<0);
    }
}