package aerolinea.vuelo;

import aerolinea.datosAsiento.DatosAsientoGeneral;
import aerolinea.datosAsiento.DatosAsientoLanchita;
import fecha.Fecha;
import horarios.Hora;


public class AsientoVueloLanchita extends AsientoGeneralVuelo {

    public AsientoVueloLanchita(DatosAsientoGeneral datosAsiento, CiudadDestino destino, CiudadPartida origen, Fecha fechaSalida, Hora horaSalida) {
        super(datosAsiento, destino, origen, fechaSalida, horaSalida);
    }
    
    
}
