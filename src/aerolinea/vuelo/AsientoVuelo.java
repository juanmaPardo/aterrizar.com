package aerolinea.vuelo;

import aerolinea.datosAsiento.DatosAsiento;


public class AsientoVuelo {
    private DatosAsiento datosAsiento;
    private CiudadPartida origen;
    private CiudadDestino destino;

    public AsientoVuelo(DatosAsiento datosAsiento, CiudadPartida origen, CiudadDestino destino) {
        this.datosAsiento = datosAsiento;
        this.origen = origen;
        this.destino = destino;
    }

    public DatosAsiento getDatosAsiento() {
        return datosAsiento;
    }

    public String getOrigen() {
        return origen.getCiudad();
    }

    public String getDestino() {
        return destino.getCiudad();
    }
    
    
}
