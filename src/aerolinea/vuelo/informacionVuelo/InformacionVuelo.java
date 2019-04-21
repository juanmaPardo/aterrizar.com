package aerolinea.vuelo.informacionVuelo;

import fecha.Fecha;
import horarios.Hora;

public class InformacionVuelo {
    private Fecha fechaSalida;
    private Hora horaSalida;

    public InformacionVuelo(Fecha fechaSalida, Hora horaSalida) {
        this.fechaSalida = fechaSalida;
        this.horaSalida = horaSalida;
        
    }

    public Fecha getFechaSalida() {
        return fechaSalida;
    }

    public Hora getHoraSalida() {
        return horaSalida;
    }  
    
    
}
