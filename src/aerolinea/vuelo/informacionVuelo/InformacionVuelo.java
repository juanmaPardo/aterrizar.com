package aerolinea.vuelo.informacionVuelo;

import fecha.Fecha;
import horarios.Hora;

public class InformacionVuelo {
    private InformacionFechaVuelo informacionFecha;
    private InformacionHorariosVuelo informacionHorarios;

    public InformacionVuelo(InformacionFechaVuelo informacionFecha, InformacionHorariosVuelo informacionHorarios) {
        this.informacionFecha = informacionFecha;
        this.informacionHorarios = informacionHorarios;
    }

    public InformacionFechaVuelo getInformacionFecha() {
        return informacionFecha;
    }

    public InformacionHorariosVuelo getInformacionHorarios() {
        return informacionHorarios;
    }
    
    
    
}
