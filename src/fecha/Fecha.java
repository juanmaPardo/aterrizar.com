package fecha;

import fecha.excepcionesFecha.FechaNoValidaException;
import fecha.excepcionesFecha.FormatoFechaIncorrectoException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Fecha implements DatosFecha{
    protected int dia;
    protected int mes;
    protected int anio;

    public Fecha() {}
    
    public Fecha(String fecha, String dateFormat) throws FormatoFechaIncorrectoException, FechaNoValidaException {
        if(!cumpleFormato(fecha,dateFormat)){
            throw new FormatoFechaIncorrectoException("La fecha propiciada no cumple con "
                    + "el formato " + dateFormat);
        }
        if(!fechaValida(fecha,dateFormat)){
            throw new FechaNoValidaException("La fecha propiciada no es valida");
        }
       
    }
    
    protected boolean cumpleFormato(String fecha,String dateFormat){
        //De los numeros se encarga fecha valida, el formato nada mas mira
        //que sea cooerente en relacion al formato dado
        boolean cumpleFormato = true;
        if(fecha.length() != dateFormat.length())cumpleFormato = false;
        for(int i = 0 ; i < dateFormat.length() && cumpleFormato; i++){
            if(dateFormat.charAt(i) == '/'){
                cumpleFormato = fecha.charAt(i) == '/';
            }
            else{
                cumpleFormato = Character.isDigit(fecha.charAt(i));
            }
        }
        return cumpleFormato;
    }
    
    protected boolean fechaValida(String fecha, String dateFormat){
        try {
            DateFormat df = new SimpleDateFormat(dateFormat);
            df.setLenient(false);
            df.parse(fecha);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    @Override
    public int getDia() {
        return dia;
    }

    @Override
    public int getMes() {
        return mes;
    }

    @Override
    public int getAnio() {
        return anio;
    }

    @Override
    public int diasPasaron(DatosFecha a, DatosFecha b) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            
            Date fechaInicial=dateFormat.parse(a.representacionEnIso());
            Date fechaFinal=dateFormat.parse(b.representacionEnIso());
            
            return (int) ((fechaFinal.getTime()-fechaInicial.getTime())/86400000);
        } catch (ParseException ex) {
            Logger.getLogger(Fecha.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public DatosFecha fechaAnterior(DatosFecha a, DatosFecha b) {
        if(hayDiferenciaAnios(a,b)){
            return (a.getAnio() < b.getAnio()) ? a : b;
        }
        else if(hayDiferenciaMeses(a,b)){
            return (a.getMes() < b.getMes()) ? a : b;
        }
        else{
            return (a.getDia() <= b.getDia()) ? a : b;//Si es la misma fecha retorna a
        }
    }   
    
    private boolean hayDiferenciaAnios(DatosFecha a, DatosFecha b){
        return a.getAnio() != b.getAnio();
    }
    
    private boolean hayDiferenciaMeses(DatosFecha a, DatosFecha b){
        return a.getMes() != b.getMes();
    }

    @Override
    public String getDateFormat() {
        return this.DATE_FORMAT;
    }
    
    @Override
    public String representacionEnIso(){
        return anio + "/" + mes + "/" + dia;
    }
    
    @Override
    public String representacionEnNorteamericano(){
        return mes + "/" + dia + "/" + anio;
    }
    
    @Override
    public String representacionEnLatinoamericano(){
        return dia + "/" + mes + "/" + anio;
    }
}
