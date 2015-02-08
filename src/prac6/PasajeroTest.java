package prac6;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dorian
 */
public class PasajeroTest {
    Pasajero pasajero;
    DNI dni;
    
    @Before
    public void setUp() {
        dni=new DNI("71463395A");
        pasajero=new Pasajero(dni, "Dorian", "Cadenas Álvarez", 22);
    }
    
    @Test
    public void pasajero(){
        pasajero=new Pasajero(dni, "Fulanito", "Mendez", 5);
    }
    
    @Test
    (expected = PasajeroException.class)
    public void dniNull(){
        pasajero=new Pasajero(null, "Fulanito", "Mendez", 5);
    }
    
    @Test
    (expected = PasajeroException.class)
    public void nombreNull(){
        pasajero=new Pasajero(dni, null, "Mendez", 5);
    }
    
    @Test
    (expected = PasajeroException.class)
    public void apellidosNull(){
        pasajero=new Pasajero(dni, "Fulanito", null, 5);
    }
    
    @Test
    (expected = PasajeroException.class)
    public void nombreEmpty(){
        pasajero=new Pasajero(dni, "", "Mendez", 5);
    }
    
    @Test
    (expected = PasajeroException.class)
    public void apellidosEmpty(){
        pasajero=new Pasajero(dni, "Fulanito", "", 5);
    }
    
    @Test
    (expected = PasajeroException.class)
    public void edadIncorrectaMinimo(){
        pasajero=new Pasajero(dni, "Fulanito", "Mendez", -2);
    }
    
    @Test
    (expected = PasajeroException.class)
    public void edadIncorrectaMaximo(){
        pasajero=new Pasajero(dni, "Fulanito", "Mendez", 170);
    }
    
    @Test
    public void getDNI(){
        assertEquals(dni, pasajero.getDNI());
    }
    
    @Test
    public void setEdad(){
        assertEquals(22, pasajero.getEdad());
        pasajero.setEdad(23);
        assertEquals(23, pasajero.getEdad());
        pasajero.setEdad(-4);
        assertEquals(23, pasajero.getEdad());
    }
    
    @Test
    public void getEdad(){
        assertEquals(22, pasajero.getEdad());
    }
    
    @Test
    public void getApellidos(){
        assertEquals("Cadenas Álvarez", pasajero.getApellidos());
    }
    
    @Test
    public void setApellidos(){
        assertEquals("Cadenas Álvarez", pasajero.getApellidos());
        pasajero.setApellidos("Mendez");
        assertEquals("Mendez", pasajero.getApellidos());
        pasajero.setApellidos("");
        assertEquals("Mendez", pasajero.getApellidos());
        pasajero.setApellidos(null);
        assertEquals("Mendez", pasajero.getApellidos());
    }
    
    @Test
    public void getNombre(){
        assertEquals("Dorian", pasajero.getNombre());
    }
    
    @Test
    public void setNombre(){
        assertEquals("Dorian", pasajero.getNombre());
        pasajero.setNombre("Julián");
        assertEquals("Julián", pasajero.getNombre());
        pasajero.setNombre("");
        assertEquals("Julián", pasajero.getNombre());
        pasajero.setNombre(null);
        assertEquals("Julián", pasajero.getNombre());
    }
    
    @Test
    public void testToString(){
        assertEquals("71463395A: Cadenas Álvarez, Dorian (22)",
                pasajero.toString());
    }
    
    @Test
    public void compareTo(){
        DNI temporalDNI=new DNI("12345678Z");
        Pasajero temporalPasajero=new Pasajero(temporalDNI, "Fulanito", "Mendez", 25);
        
        assertEquals(0, pasajero.compareTo(pasajero));
        assertTrue(pasajero.compareTo(temporalPasajero)>0);
        assertTrue(temporalPasajero.compareTo(pasajero)<0);
    }
}