package aerolinea.vuelo.informacionVuelo;

import horarios.Hora;

public class InformacionHorariosVuelo {
    private Hora horaSalida;
    private Hora horaLlegada;

    public InformacionHorariosVuelo(Hora horaSalida, Hora horaLlegada) {
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
    }

    public Hora getHoraSalida() {
        return horaSalida;
    }

    public Hora getHoraLlegada() {
        return horaLlegada;
    }
    
    
}
