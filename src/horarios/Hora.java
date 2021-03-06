package horarios;

import aerolinea.busqueda.FiltroBusqueda;
import aerolinea.vuelo.AsientoGeneral;
import aerolinea.vuelo.AsientoGeneralVuelo;
import horarios.excepcionesHora.FormatoHoraIncorrectoException;
import horarios.excepcionesHora.HoraInvalidaException;
import java.util.Arrays;

public class Hora implements FiltroBusqueda{
    //Sistema 24hs
    private int hora;
    private int minutos;
    private String horaFormatoString;
    
    final static String HORA_FORMAT = "hh:mm";
    public Hora(String hora) throws FormatoHoraIncorrectoException, HoraInvalidaException {
        String[] horasValidas = horasValidas();
        String[] minutosValidos = minutosValidos();
        String posibleHora = hora.substring(0,2);
        String posibleMinutos = hora.substring(3,5);
        
        if(hora.length() != 5 || hora.charAt(2) != ':'){
            throw new FormatoHoraIncorrectoException("El formato ingresado no correlata con el esperado: "
                    + HORA_FORMAT);
        }
        
        if(!Arrays.stream(horasValidas).anyMatch(posibleHora::equals) ||
           !Arrays.stream(minutosValidos).anyMatch(posibleMinutos::equals)){
            throw new HoraInvalidaException("La hora propiciada es incorrecta");
        }
        
        this.hora = Integer.parseInt(posibleHora);
        this.minutos = Integer.parseInt(posibleMinutos);
        this.horaFormatoString = hora;
    }
    
    private String[] horasValidas(){
        String[] horasValidas = {"00","02","03","04","05","06","07","08","09","10","11","12"
        ,"13","14","15","16","17","18","19","20","21","22","23"};
        return horasValidas;
    }
    
    private String[] minutosValidos(){
        String[] minutosValidos = {"00","02","03","04","05","06","07","08","09","10","11","12"
        ,"13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29"
        ,"30","31","32","33","34","34","35","36","37","38","39","40","41","42","43","44","45"
        ,"46","47","48","49","50","51","52","53","54","55","56","57","58","59"};
        return minutosValidos;
    }

    public int getHora() {
        return hora;
    }

    public int getMinutos() {
        return minutos;
    }

    public String getHoraFormatoString() {
        return horaFormatoString;
    }
   
    @Override
    public boolean asientoVueloCumpleParametro(AsientoGeneralVuelo asiento) {
        return asiento.getHoraSalida().getHoraFormatoString() == horaFormatoString;
    }
    
    
}
