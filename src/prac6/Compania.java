package prac6;

import prac6.LinkedOrderList;
import prac6.OrderedListADT;
import java.util.Iterator;

/**
 *
 * @author dorian
 */
public class Compania {
    /**
     * Name of company
     */
    private String nombreCompania;
    /**
     * List of flight
     */
    private OrderedListADT<Vuelo> listaVuelos;

    /**
     * Builder
     * @param nombre
     */
    public Compania(String nombre) {
        nombreCompania=nombre;
        listaVuelos=new LinkedOrderList<>();
    }

    /**
     * Get the name of company
     * @return the name of company
     */
    public String getNombreCompania() {
        return nombreCompania;
    }
    
    /**
     * Inserta un vuelo en la lista de vuelos de la compañía
     * @param v a flight to include
     */
    public void InsertaVuelo(Vuelo v){
        listaVuelos.add(v);
    }
    
    /**
     * Devuelve la edad del pasajero más joven de todos los vuelos de la lista
     * de vuelos
     * @return la edad más joven o -1 si no hay pasajeros
     */
    public int EdadMenorPas(){
        //set the age with the higher value
        int edad= Integer.MAX_VALUE;
        
        //iterate over all the flights
        for (Iterator<Vuelo> vuelo = listaVuelos.iterator(); vuelo.hasNext();) {
            Vuelo vueloActual = vuelo.next();
            //for every flight, iterate over all the passenger
            for (Iterator<Pasajero> pasajeros = vueloActual.iterator(); pasajeros.hasNext();) {
                Pasajero pasajero = pasajeros.next();
                //get the age
                if(pasajero.getEdad()<edad){
                    //if age is lower than the stored age, change it
                    edad=pasajero.getEdad();
                }
            }
        }
        
        //if no passenger, so age no changed, return -1
        if(edad==Integer.MAX_VALUE){
            edad=-1;
        }
        
        return edad;
    }
    
    /**
     * Devuelve la edad media de las edades de todos los pasajeros de todos
     * los vuelos
     * @return la media de edad o -1 si no hay pasajeros
     */
    public int mediaEdadPas(){
        int numeroPasajeros=0;
        int sumaEdades=0;
        
      //iterate over all the flights
        for (Iterator<Vuelo> vuelo = listaVuelos.iterator(); vuelo.hasNext();) {
            Vuelo vueloActual = vuelo.next();
          //for every flight, iterate over all the passenger
            for (Iterator<Pasajero> pasajeros = vueloActual.iterator(); pasajeros.hasNext();) {
                Pasajero pasajero = pasajeros.next();
                //increments the counter
                numeroPasajeros++;
                //sum the age
                sumaEdades+=pasajero.getEdad();
            }
        }
        
        //if no passenger, return -1
        if(numeroPasajeros==0){
            return -1;
        }
        
        //calculate the result
        return sumaEdades/numeroPasajeros;
    }
    
    /**
     * Devuelve el número total de asientos libres de todos los vuelos
     * @return number of free seat
     */
    public  int  totalAsientosLibres(){
        int asientosLibres=0;
      //iterate over all the flights
        for (Iterator<Vuelo> vuelos = listaVuelos.iterator(); vuelos.hasNext();) {
            Vuelo vuelo = vuelos.next();
            //sum the free seats
            asientosLibres+=vuelo.nAsientosLibres();
        }
        return asientosLibres;
    }

    /**
     * 
     * Return a string representation of this class
     * with the name of the company and the code of its flights
     */
    @Override
    public String toString() {
        StringBuilder result=new StringBuilder();
        //append the name of company
        result.append(this.getNombreCompania());
        //append the flights (the code of flights)
        result.append("\nVuelos:\n");
        for (Iterator<Vuelo> it = listaVuelos.iterator(); it.hasNext();) {
            Vuelo vuelo = it.next();
            result.append(vuelo.getCodigoVuelo());
            result.append("\n");
        }
        //return the result
        return result.toString();
    }
}
