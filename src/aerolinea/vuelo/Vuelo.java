package aerolinea.vuelo;

import aerolinea.datosAsiento.DatosAsientoGeneral;
import aerolinea.datosAsiento.DatosAsientoLanchita;
import aerolinea.vuelo.informacionVuelo.InformacionVuelo;
import fecha.Fecha;
import horarios.Hora;
import java.util.LinkedList;


public class Vuelo {
    private LinkedList<DatosAsientoGeneral> asientosVuelo;
    private CiudadPartida origen;
    private CiudadDestino destino;
    private Hora horaSalida;
    private Fecha fechaSalida;

    public Vuelo(CiudadPartida origen, CiudadDestino destino, Hora horaSalida, Fecha fechaSalida) {
        this.asientosVuelo = new LinkedList<>();
        this.origen = origen;
        this.destino = destino;
        this.horaSalida = horaSalida;
        this.fechaSalida = fechaSalida;
    }


    public Vuelo(LinkedList<DatosAsientoGeneral> asientosVuelo,CiudadPartida origen, CiudadDestino destino, Hora horaSalida, Fecha fechaSalida) {
        this.asientosVuelo = new LinkedList<>();
        this.asientosVuelo.addAll(asientosVuelo);
        this.origen = origen;
        this.destino = destino;
        this.horaSalida = horaSalida;
        this.fechaSalida = fechaSalida;
    }
    
    public LinkedList<AsientoGeneralVuelo> getDatosAsientoVuelo(){
        LinkedList<AsientoGeneralVuelo> datoAsientoVuelo = new LinkedList<>();
        asientosVuelo.forEach(asiento ->{
            datoAsientoVuelo.add(new AsientoVueloLanchita(asiento, destino, origen, fechaSalida, horaSalida));
        });
        return datoAsientoVuelo;
    }
    
    public void agregarAsiento(DatosAsientoGeneral asientoVuelo){
        asientosVuelo.add(asientoVuelo);
    }

    public LinkedList<DatosAsientoGeneral> getAsientosVuelo() {
        return asientosVuelo;
    }
    
}
