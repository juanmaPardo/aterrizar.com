package aerolinea;

import aerolinea.datosAsiento.AsientoVuelo;
import fecha.DatosFecha;
import horarios.Hora;
import java.util.LinkedList;

public interface Aerolinea {
    
    public LinkedList<AsientoVuelo> asientosDisponibles(String origen,DatosFecha fechaSalida,
            DatosFecha fechaLlegada,Hora horaSalida, Hora horaLlegada);
    
    public void comprar(String codigoAsiento);
}
