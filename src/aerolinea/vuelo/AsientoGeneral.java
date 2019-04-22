package aerolinea.vuelo;

import aerolinea.datosAsiento.DatosAsientoGeneral;
import fecha.Fecha;
import horarios.Hora;

public interface AsientoGeneral {
    
    public CiudadDestino getDestino();

    public CiudadPartida getOrigen();

    public DatosAsientoGeneral getDatosAsiento();

    public Fecha getFechaSalida();

    public Hora getHoraSalida();
}
