package fecha;

import fecha.excepcionesFecha.FechaNoValidaException;
import fecha.excepcionesFecha.FormatoFechaIncorrectoException;

public class FechaFormatoLatinoamericano extends Fecha {
    final static String DATE_FORMAT = "MM/dd/yyyy";
    
    public FechaFormatoLatinoamericano(String fecha) throws FormatoFechaIncorrectoException, FechaNoValidaException{
        super(fecha,DATE_FORMAT);
        
    }
    protected int substraerDia(String fecha){
        return Integer.parseInt(fecha.substring(0,2));
    }
    
    protected int substraerMes(String fecha){
        return Integer.parseInt(fecha.substring(3,5));
    }
    
    protected int substraerAnio(String fecha){
        return Integer.parseInt(fecha.substring(6,10));
    }
  
}
