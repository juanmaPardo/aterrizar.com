package aerolinea.vuelo;

import aerolinea.datosAsiento.DatosAsiento;


public class AsientoGeneral extends AsientoGeneralVuelo {
    private CiudadPartida origen;
    private CiudadDestino destino;

    public AsientoGeneral(DatosAsiento datosAsiento, CiudadPartida origen, CiudadDestino destino) {
        super(datosAsiento);
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
