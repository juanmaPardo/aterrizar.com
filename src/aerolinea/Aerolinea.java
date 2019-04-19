package aerolinea;

import aerolinea.datosAsiento.AsientoVuelo;
import fecha.DatosFecha;
import horarios.Hora;

public interface Aerolinea {
    
    public AsientoVuelo[] asientosDisponibles(String origen,DatosFecha fechaSalida,
            DatosFecha fechaLlegada,Hora horaSalida, Hora horaLlegada);
    
    public void comprar(String codigoAsiento);
}
