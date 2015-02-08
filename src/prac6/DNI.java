/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prac6;

/**
 *
 * @author dorian
 */
public class DNI implements Comparable<DNI>{
    /**
     * The number of DNI
     */
    private int numDNI;
    /**
     * The letter of DNI
     */
    private String letraDNI;

    /**
     * Builder
     * Throw a DNIException if DNI is not correct
     * @param numDNI the number of dni
     * @param letra the letter of dni
     */
    public DNI(int numDNI, String letra) {
        //check if number and letter is correct
        if(checkDNI(numDNI, letra)){
            this.numDNI = numDNI;
            this.letraDNI = letra.toUpperCase();
            
        //else, throw an exception
        }else{
            throw new DNIException("Not correct DNI");
        }
    }
    
    /**
     * Builder
     * Throw a DNIException if DNI is not correct
     * @param dni the dni
     */
    public DNI(String dni){
        //check the dni
        if(checkDNI(dni)){
            //if its correct, store the dni
           this.numDNI = Integer.parseInt(dni.substring(0, dni.length()-1));
           this.letraDNI = dni.substring(dni.length()-1).toUpperCase();
           
        //if not, throw an exception
        }else{
            throw new DNIException("Not correct DNI");
        }
    }
    
    /**
     * Check if DNI is correct
     * @param numDNI the number of DNI
     * @param letra the letter of DNI
     * @return true if all correct, false otherwise
     */
    private boolean checkDNI(int numDNI, String letra){
        //the characters of DNI
        String characters="TRWAGMYFPDXBNJZSQVHLCKET";
        //calculate the letter that corresponds to this number
        String letraResultado=String.valueOf(characters.charAt(numDNI%23));
        //if correct, return true, otherwise, false
        if(letraResultado.equals(letra.toUpperCase())){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Check if DNI is correct
     * @param DNI dni to check
     * @return true if all correct, false otherwise
     */
    private boolean checkDNI(String DNI){
        boolean correcto=false;
        //check if length is correct
        if(DNI.length()>1 && DNI.length()<=9){
            //try to get the letter and number
            try {
                String letra=String.valueOf(DNI.charAt(DNI.length()-1)).toUpperCase();
                int numeroDni=Integer.parseInt(DNI.substring(0, DNI.length()-1));
                //check it
                correcto=checkDNI(numeroDni, letra);
                
            } catch (Exception e) {
                throw new DNIException("Not a number with a letter");
            }
        }
        
        return correcto;
    }
    
    /**
     * Get the number of DNI
     * @return the number of DNI
     */
    public int getNumDNI(){
        return numDNI;
    }

    /**
     * Get the letter of DNI
     * @return the letter of DNI
     */
    public String getLetra() {
        return letraDNI;
    }

    /**
     * 
     * Return the String representation of the DNI
     */
    @Override
    public String toString() {
        return numDNI+letraDNI;
    }

    /**
     * 
     * @see java.lang.Comparable#compareTo(java.lang.Object)  
     */
    @Override
    public int compareTo(DNI o) {
        Comparable dni1=(Comparable)numDNI;
        Comparable dni2=(Comparable)o.getNumDNI();
        return dni1.compareTo(dni2);
    }
    
}
