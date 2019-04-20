package aerolinea.vuelo.informacionVuelo;

import aerolinea.vuelo.CiudadDestino;
import aerolinea.vuelo.CiudadPartida;


public class InformacionRutaVuelo {
    private CiudadPartida origen;
    private CiudadDestino destino;

    public InformacionRutaVuelo(CiudadPartida origen, CiudadDestino destino) {
        this.origen = origen;
        this.destino = destino;
    }
    
    public String getOrigen() {
        return origen.getCiudad();
    }

    public String getDestino() {
        return destino.getCiudad();
    }
}
