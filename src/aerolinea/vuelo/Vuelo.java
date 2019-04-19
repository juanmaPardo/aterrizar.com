package aerolinea.vuelo;

import aerolinea.datosAsiento.DatosAsiento;
import java.util.LinkedList;


public class Vuelo {
    private LinkedList<DatosAsiento> asientosVuelo;
    private CiudadPartida origen;
    private CiudadDestino destino;

    public Vuelo(CiudadPartida origen,CiudadDestino destino) {
        asientosVuelo = new LinkedList<>();
        this.origen = origen;
        this.destino = destino;
    }

    public Vuelo(LinkedList<DatosAsiento> asientosVuelo,CiudadPartida origen, CiudadDestino destino) {
        this.asientosVuelo = new LinkedList<>();
        this.asientosVuelo.addAll(asientosVuelo);
        this.origen = origen;
        this.destino = destino;
    }
    
    public LinkedList<AsientoVuelo> getDatosAsientoVuelo(){
        LinkedList<AsientoVuelo> datoAsientoVuelo = new LinkedList<>();
        asientosVuelo.forEach(asiento ->{
            datoAsientoVuelo.add(new AsientoVuelo(asiento, origen, destino));
        });
        return datoAsientoVuelo;
    }
    
    public void agregarAsiento(DatosAsiento asientoVuelo){
        asientosVuelo.add(asientoVuelo);
    }

    public LinkedList<DatosAsiento> getAsientosVuelo() {
        return asientosVuelo;
    }

    public String getOrigen() {
        return origen.getCiudad();
    }

    public String getDestino() {
        return destino.getCiudad();
    }
   
}
