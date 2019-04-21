package aerolinea.vuelo;

import aerolinea.datosAsiento.DatosAsiento;

public class AsientoGeneralVuelo {
    private DatosAsiento datosAsiento;

    public AsientoGeneralVuelo(DatosAsiento datosAsiento) {
        this.datosAsiento = datosAsiento;
    }
    
    public DatosAsiento getDatosAsiento() {
        return datosAsiento;
    }
}
