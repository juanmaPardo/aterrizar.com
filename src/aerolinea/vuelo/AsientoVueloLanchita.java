package aerolinea.vuelo;

import aerolinea.datosAsiento.DatosAsientoLanchita;
import fecha.Fecha;
import horarios.Hora;


public class AsientoVueloLanchita extends AsientoGeneralVuelo {
    private CiudadPartida origen;
    private CiudadDestino destino;

    public AsientoVueloLanchita(CiudadPartida origen, CiudadDestino destino, DatosAsientoLanchita datosAsiento, Fecha fechaSalida, Hora horaSalida) {
        super(datosAsiento, fechaSalida, horaSalida);
        this.origen = origen;
        this.destino = destino;
    }


    public String getOrigen() {
        return origen.getCiudad();
    }

    public String getDestino() {
        return destino.getCiudad();
    }
    
    
}
