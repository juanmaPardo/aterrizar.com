
package aerolinea.datosAsiento;

import aerolinea.vuelo.AsientoGeneral;
import aerolinea.vuelo.CiudadDestino;
import aerolinea.vuelo.CiudadPartida;
import fecha.FechaFormatoLatinoamericano;

public class DatosAsientoOceanic extends AsientoGeneral{
    private String horaDeSalida;
    private FechaFormatoLatinoamericano fechaDeSalida;
    
    public DatosAsientoOceanic (DatosAsiento datosAsiento, CiudadPartida origen, CiudadDestino destino,String horaDeSalida, FechaFormatoLatinoamericano fechaDeSalida){
        super(datosAsiento,origen,destino);
        this.horaDeSalida = horaDeSalida;
        this.fechaDeSalida = fechaDeSalida;  
    }
}
