package prac6;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author dorian
 */
public class CompaniaTest {
    DNI dni;
    Pasajero pasajero;
    Vuelo vuelo;
    Compania compania;
    Compania vacio;
    
    @Before
    public void setUp(){
        dni=new DNI("71463395A");
        pasajero=new Pasajero(dni, "Dorian", "Cadenas", 22);
        vuelo = new Vuelo("Codigo", "Destino", "Origen", null, 5);
        compania = new Compania("Ryanair");
        vuelo.insertaPasajero(pasajero);
        compania.InsertaVuelo(vuelo);
        vacio=new Compania("Vacio");
    }
    
    @Test
    public void getNombreCompaniaTest(){
        assertEquals("Ryanair", compania.getNombreCompania());
        assertEquals("Vacio", vacio.getNombreCompania());
    }
    
    @Test
    public void insertaVuelo(){
        assertEquals(4, compania.totalAsientosLibres());
        vuelo=new Vuelo("code", "destino", "origen", null, 10);
        compania.InsertaVuelo(vuelo);
        assertEquals(14, compania.totalAsientosLibres());
        assertEquals("Ryanair\n" +
                    "Vuelos:\n" +
                    "code\nCodigo\n", compania.toString());
        
        vuelo=new Vuelo("aaa", "destino", "origen", null, 10);
        compania.InsertaVuelo(vuelo);
        assertEquals("Ryanair\n" +
                    "Vuelos:\n" +
                    "aaa\n"
                    + "code\n"
                    +  "Codigo\n", compania.toString());
        
        assertEquals(0, vacio.totalAsientosLibres());
        vacio.InsertaVuelo(vuelo);
        assertEquals(10, vacio.totalAsientosLibres());
    }
    
    @Test
    public void totalAsientosLibres(){
        assertEquals(4, compania.totalAsientosLibres());
        vuelo.insertaPasajero(pasajero);
        assertEquals(3, compania.totalAsientosLibres());
        assertEquals(0, vacio.totalAsientosLibres());
    }
    
    @Test
    public void edadMenorPas(){
        assertEquals(22, compania.EdadMenorPas());
        pasajero=new Pasajero(dni, "otro", "apellidos", 32);
        vuelo.insertaPasajero(pasajero);
        pasajero=new Pasajero(dni, "otro", "apellidos", 18);
        vuelo.insertaPasajero(pasajero);
        pasajero=new Pasajero(dni, "otro", "apellidos", 42);
        vuelo.insertaPasajero(pasajero);
        assertEquals(18, compania.EdadMenorPas());
        assertEquals(-1, vacio.EdadMenorPas());
    }
    
    @Test
    public void mediaEdadPas(){
        assertEquals(22, compania.mediaEdadPas());
        pasajero=new Pasajero(dni, "otro", "apellidos", 32);
        vuelo.insertaPasajero(pasajero);
        pasajero=new Pasajero(dni, "otro", "apellidos", 18);
        vuelo.insertaPasajero(pasajero);
        pasajero=new Pasajero(dni, "otro", "apellidos", 42);
        vuelo.insertaPasajero(pasajero);
        assertEquals(28, compania.mediaEdadPas());
        assertEquals(-1, vacio.mediaEdadPas());
    }
    
    @Test
    public void testToString(){
        assertEquals("Ryanair\n" +
                        "Vuelos:\n" +
                        "Codigo\n", compania.toString());
        assertEquals("Vacio\n" +
                    "Vuelos:\n", vacio.toString());
    }
    
    
}