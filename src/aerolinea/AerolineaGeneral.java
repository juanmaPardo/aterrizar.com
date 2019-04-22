package aerolinea;

import aerolinea.vuelo.Vuelo;
import java.util.LinkedList;

public class AerolineaGeneral {
    protected LinkedList<Vuelo> vuelosDisponibles;

    public AerolineaGeneral(LinkedList<Vuelo> vuelosDisponibles) {
        this.vuelosDisponibles = new LinkedList<>();
        this.vuelosDisponibles.addAll(vuelosDisponibles);
    }

    public AerolineaGeneral() {
        vuelosDisponibles = new LinkedList<>();
    }
     
    public void agregarVuelo(Vuelo vuelo){
        vuelosDisponibles.add(vuelo);
    }
}
