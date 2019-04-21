package aerolinea.vuelo;

import aerolinea.datosAsiento.DatosAsientoGeneral;
import aerolinea.datosAsiento.DatosAsientoLanchita;
import fecha.Fecha;
import horarios.Hora;

public class AsientoGeneralVuelo {
    private DatosAsientoGeneral datosAsiento;
    private CiudadDestino destino;
    private CiudadPartida origen;
    private Fecha fechaSalida;
    private Hora horaSalida;

    public AsientoGeneralVuelo(DatosAsientoGeneral datosAsiento, CiudadDestino destino, CiudadPartida origen, Fecha fechaSalida, Hora horaSalida) {
        this.datosAsiento = datosAsiento;
        this.destino = destino;
        this.origen = origen;
        this.fechaSalida = fechaSalida;
        this.horaSalida = horaSalida;
    }

    public CiudadDestino getDestino() {
        return destino;
    }

    public CiudadPartida getOrigen() {
        return origen;
    }

    
    public DatosAsientoGeneral getDatosAsiento() {
        return datosAsiento;
    }

    public Fecha getFechaSalida() {
        return fechaSalida;
    }

    public Hora getHoraSalida() {
        return horaSalida;
    }
    
    
}
