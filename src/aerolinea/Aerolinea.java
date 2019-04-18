package aerolinea;

import fecha.DatosFecha;
import horarios.Hora;

public interface Aerolinea {
    
    public DatosVuelo[] asientosDisponibles(String origen,DatosFecha fechaSalida,
            DatosFecha fechaLlegada,Hora horaSalida, Hora horaLlegada);
    
    public void comprar(String codigoAsiento);
}
