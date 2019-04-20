package aerolinea.vuelo.informacionVuelo;

import fecha.Fecha;


public class InformacionFechaVuelo {
    private Fecha fechaSalida;
    private Fecha fechaLlegada;

    public InformacionFechaVuelo(Fecha fechaSalida, Fecha fechaLlegada) {
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
    }

    public Fecha getFechaSalida() {
        return fechaSalida;
    }

    public Fecha getFechaLlegada() {
        return fechaLlegada;
    }
    
    
}
