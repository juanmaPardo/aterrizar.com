package aerolinea;

import aerolinea.datosAsiento.AsientoVuelo;
import java.util.LinkedList;

public class Vuelo {
    private LinkedList<AsientoVuelo> asientosVuelo;
    private String origen;
    private String destino;

    public Vuelo(String origen,String destino) {
        asientosVuelo = new LinkedList<>();
        this.origen = origen;
        this.destino = destino;
    }

    public Vuelo(LinkedList<AsientoVuelo> asientosVuelo,String origen, String destino) {
        this.asientosVuelo = new LinkedList<>();
        this.asientosVuelo.addAll(asientosVuelo);
        this.origen = origen;
        this.destino = destino;
    }
    
    public void agregarAsiento(AsientoVuelo asientoVuelo){
        asientosVuelo.add(asientoVuelo);
    }

    public LinkedList<AsientoVuelo> getAsientosVuelo() {
        return asientosVuelo;
    }
    
}
