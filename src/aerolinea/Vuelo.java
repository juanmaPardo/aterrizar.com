package aerolinea;

import aerolinea.datosAsiento.AsientoVuelo;
import java.util.LinkedList;

public class Vuelo {
    private LinkedList<AsientoVuelo> asientosVuelo;

    public Vuelo() {
        asientosVuelo = new LinkedList<>();
    }

    public Vuelo(LinkedList<AsientoVuelo> asientosVuelo) {
        this.asientosVuelo = new LinkedList<>();
        this.asientosVuelo.addAll(asientosVuelo);
    }
    
    public void agregarAsiento(AsientoVuelo asientoVuelo){
        asientosVuelo.add(asientoVuelo);
    }
    
}
