package prac6;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author dorian
 */
public class DNITest {
    DNI dni;
    
    @Before
    public void setUp(){
        dni=new DNI("71463395A");
    }
    
    @Test
    public void DNICorrect(){
        DNI temporalDNI=new DNI("71463395A");
        assertEquals("71463395A", temporalDNI.toString());
        
        temporalDNI=new DNI("71463395a");
        assertEquals("71463395A", temporalDNI.toString());
        
        temporalDNI=new DNI(71463395, "A");
        assertEquals("71463395A", temporalDNI.toString());
        
        temporalDNI=new DNI(71463395, "a");
        assertEquals("71463395A", temporalDNI.toString());
    }
    
    @Test
    (expected = DNIException.class)
    public void wrongNumber(){
        DNI temporalDNI=new DNI("7146SSERA");
    }
    
    @Test
    (expected = DNIException.class)
    public void wrongLetter(){
        DNI temporalDNI=new DNI("71463395B");
    }
    
    @Test
    (expected = DNIException.class)
    public void dniEmpty(){
        DNI temporalDNI=new DNI("");
    }
    
    @Test
    (expected = DNIException.class)
    public void dniTooLong(){
        DNI temporalDNI=new DNI("714444363395A");
    }
    
    @Test
    (expected = DNIException.class)
    public void dniTooShort(){
        DNI temporalDNI=new DNI("A");
    }
    
    @Test
    public void getNumDNI(){
        assertEquals(71463395, dni.getNumDNI());
    }
    
    @Test
    public void getLetra(){
        assertEquals("A", dni.getLetra());
        DNI temporalDNI=new DNI("71463395a");
        assertEquals("A", temporalDNI.getLetra());
    }
    
    @Test
    public void testToString(){
        assertEquals("71463395A", dni.toString());
        DNI temporalDNI=new DNI("71463395a");
        assertEquals("71463395A", temporalDNI.toString());
    }
    
    @Test
    public void compareTo(){
        DNI temporalDNI=new DNI("71463395a");
        assertEquals(0, dni.compareTo(temporalDNI));
        temporalDNI=new DNI("12345678Z");
        assertTrue(dni.compareTo(temporalDNI)>0);
        assertTrue(temporalDNI.compareTo(dni)<0);
    }
}