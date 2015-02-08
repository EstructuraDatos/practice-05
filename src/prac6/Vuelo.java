package prac6;

import prac6.LinkedOrderList;
import prac6.OrderedListADT;
import java.util.Calendar;
import java.util.Iterator;

/**
 *
 * @author dorian
 */
public class Vuelo implements Comparable<Vuelo>{
    /**
     * Flight's code
     */
    private String codigoVuelo;
    /**
     * Destiny
     */
    private String destino;
    /**
     * Origin
     */
    private String origen;
    /**
     * Date of flight
     */
    private Calendar salidaVuelo;
    /**
     * List of passengers
     */
    private OrderedListADT<Pasajero> pasajeros;
    /**
     * Limit of passsengers
     */
    private int limitePasajeros;

    /**
     * Builder
     * @param codigoVuelo flight's code
     * @param destino destiny
     * @param origen origin
     * @param salidaVuelo date of flight
     * @param limitePasajeros limits of passengers
     */
    public Vuelo(String codigoVuelo, String destino, String origen, 
            Calendar salidaVuelo, int limitePasajeros) {
        this.codigoVuelo = codigoVuelo;
        this.destino = destino;
        this.origen = origen;
        this.salidaVuelo = salidaVuelo;
        this.limitePasajeros = limitePasajeros;
        this.pasajeros=new LinkedOrderList<>();
    }

    /**
     * Builder
     * @param codigoVuelo flight's code
     * @param destino destiny
     * @param origen origin
     * @param salidaVuelo date of flight
     * @param pasajeros list of passengers
     * @param limitePasajeros limits of passengers
     */
    public Vuelo(String codigoVuelo, String destino, String origen, 
            Calendar salidaVuelo, OrderedListADT<Pasajero> pasajeros, int limitePasajeros) {
        this.codigoVuelo = codigoVuelo;
        this.destino = destino;
        this.origen = origen;
        this.salidaVuelo = salidaVuelo;
        this.pasajeros = pasajeros;
        this.limitePasajeros = limitePasajeros;
    }
    
    /**
     * Get the hour of departure
     * @return the hour of departure
     */
    public String getHoraVuelo(){
        StringBuilder hora=new StringBuilder();
        hora.append(salidaVuelo.get(Calendar.HOUR_OF_DAY));
        hora.append(":");
        hora.append(salidaVuelo.get(Calendar.MINUTE));
        return hora.toString();
    }
    
    /**
     * Get the date of departure
     * @return the date of departure
     */
    public String getFechaVuelo(){
        StringBuilder fecha=new StringBuilder();
        fecha.append(salidaVuelo.get(Calendar.DAY_OF_MONTH));
        fecha.append("-");
        fecha.append(salidaVuelo.get(Calendar.MONTH));
        fecha.append("-");
        fecha.append(salidaVuelo.get(Calendar.YEAR));
        return fecha.toString();
    }
    
    /**
     * Get the date and hour of departure
     * @return the date and hour of departure
     */
    public String getSalidaVuelo(){
        return getFechaVuelo()+" "+getHoraVuelo();
    }

    /**
     * Get the flight's code
     * @return the flight's code
     */
    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    /**
     * Get the destiny
     * @return the destiny
     */
    public String getDestino() {
        return destino;
    }

    /**
     * Get the origin of flight
     * @return the origin
     */
    public String getOrigen() {
        return origen;
    }

    /**
     * Get the list of passengers
     * @return
     */
    public OrderedListADT<Pasajero> getPasajeros() {
        return pasajeros;
    }
    
    
    
    /**
     * Número total de asientos libres
     * @return 
     */
    public int nAsientosLibres(){
        return limitePasajeros-pasajeros.size();
    }
    
    /**
     * Inserta el pasajero en la lista  de  pasajeros.  
     * Si  el  nº  de  asientos  libres  es  0  lanza  la 
     * excepción: VueloCompletoException. 
     * @param p 
     */
    public void insertaPasajero(Pasajero p){
        if(nAsientosLibres()==0){
            throw new VueloCompletoException("Vuelo completo");
        }else{
            pasajeros.add(p);
        }
    }
    
    /**
     * Get an iterator of passengers
     * @return an iterator of passengers
     */
    public Iterator<Pasajero> iterator() {
        return pasajeros.iterator();
    }
    
    /**
     * Return a representation of the flight
     * (code, date, destiny, origin and a list of passengers
     */
    @Override
    public String toString(){
        StringBuilder result=new StringBuilder();
        result.append("Vuelo: ");
        result.append(getCodigoVuelo());
        result.append("\n");
        
        result.append("Origen: ");
        result.append(getOrigen());
        result.append("\n");
        
        result.append("Destino: ");
        result.append(getDestino());
        result.append("\n");
        
        result.append("Fecha de salida: ");
        result.append(getSalidaVuelo());
        result.append("\n");
        
        result.append("Pasajeros: \n");
        //iterate over all passengers
        for (Iterator<Pasajero> it = pasajeros.iterator(); it.hasNext();) {
            Pasajero pasajero = it.next();
            result.append(pasajero.toString());
            result.append("\n");
        }
        
        return result.toString();
    }

    /**
     * 
     * @see java.lang.Comparable#compareTo(java.lang.Object)  
     */
    @Override
    public int compareTo(Vuelo o) {
        return o.getCodigoVuelo().compareToIgnoreCase(codigoVuelo);
    }
    
}
