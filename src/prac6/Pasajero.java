/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prac6;

/**
 *
 * @author dorian
 */
public class Pasajero implements Comparable<Pasajero>{
    /**
     * The DNI of passenger
     */
    private DNI DNI;
    /**
     * The name of passenger
     */
    private String nombre;
    /**
     * The last name of passenger
     */
    private String apellidos;
    /**
     * The age of passenger
     */
    private int edad;

    /**
     * A Builder
     * Throw a PasajeroException if something is not correct
     * @param dni the dni of passenger
     * @param nombre the name of passenger
     * @param apellidos the last name of passenger
     * @param edad the age of passenger
     */
    public Pasajero(DNI dni, String nombre, String apellidos, int edad) {
        //check if i have all dates, otherwise, throw an exception
        if(dni==null){
            throw new PasajeroException("Introduzca DNI");
        }else if(nombre==null || apellidos==null){
            throw new PasajeroException("Introduzca nombre y apellidos");
        }else if(nombre.isEmpty() || apellidos.isEmpty()){
            throw new PasajeroException("Introduzca nombre y apellidos");
        }else if(edad<0 || edad>150){
            throw new PasajeroException("Edad incorrecta");
        }
        
        this.DNI = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }
    
    /**
     * Get the Passenger's DNI
     * @return the Passenger's DNI
     */
    public DNI getDNI(){
        return DNI;
    }

    /**
     * Get the Passenger's age
     * @return the Passenger's age
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Set the age
     * @param edad the new age
     */
    public void setEdad(int edad) {
        if(edad>0 && edad<150){
            this.edad = edad;
        }
    }

    /**
     * Get the Passenger's last name
     * @return the Passenger's last name
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Get the Passenger's name
     * @return the Passenger's name
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Set the last name of passenger
     * @param apellidos the new last name
     */
    public void setApellidos(String apellidos) {
        if(apellidos!=null){
            if(!apellidos.isEmpty()){
                this.apellidos = apellidos;
            }
        }
    }

    /**
     * Set the name of passenger
     * @param nombre the new name
     */
    public void setNombre(String nombre) {
        if(nombre!=null){
            if(!nombre.isEmpty()){
                this.nombre = nombre;
            }
        }
    }
    
    /**
     * Return a string representation of the passenger, with its dates
     */
    @Override
    public String toString(){
        StringBuilder result=new StringBuilder();
        result.append(DNI.toString());
        result.append(": ");
        result.append(apellidos);
        result.append(", ");
        result.append(nombre);
        result.append(" (");
        result.append(edad);
        result.append(")");
        return result.toString();
    }

    /**
     * 
     * @see java.lang.Comparable#compareTo(java.lang.Object)  
     */
    @Override
    public int compareTo(Pasajero o) {
        return DNI.compareTo(o.getDNI());
    }
    
}
