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
    
    public CiudadPartida getOrigen() {
        return origen;
    }

    public CiudadDestino getDestino() {
        return destino;
    }
}
