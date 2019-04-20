package aerolinea.vuelo.informacionVuelo;

import fecha.Fecha;
import horarios.Hora;

public class InformacionVuelo {
    private InformacionFechaVuelo informacionFecha;
    private InformacionHorariosVuelo informacionHorarios;
    private InformacionRutaVuelo informacionRuta;

    public InformacionVuelo(InformacionFechaVuelo informacionFecha, InformacionHorariosVuelo informacionHorarios, InformacionRutaVuelo informacionRuta) {
        this.informacionFecha = informacionFecha;
        this.informacionHorarios = informacionHorarios;
        this.informacionRuta = informacionRuta;
    }

    public InformacionRutaVuelo getInformacionRuta() {
        return informacionRuta;
    }
    
    public InformacionFechaVuelo getInformacionFecha() {
        return informacionFecha;
    }

    public InformacionHorariosVuelo getInformacionHorarios() {
        return informacionHorarios;
    }
    
    
    
}
