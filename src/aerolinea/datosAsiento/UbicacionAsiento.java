package aerolinea.datosAsiento;

import aerolinea.vuelo.AsientoGeneral;
import aerolinea.busqueda.FiltroBusqueda;

public class UbicacionAsiento implements FiltroBusqueda{
    private UbicacionAsientoVuelo ubicacionAsiento;

    public UbicacionAsiento(UbicacionAsientoVuelo ubicacionAsiento) {
        this.ubicacionAsiento = ubicacionAsiento;
    }

    public UbicacionAsientoVuelo getUbicacionAsiento() {
        return ubicacionAsiento;
    }
    
    
    @Override
    public boolean asientoVueloCumpleParametro(AsientoGeneral asiento) {
        return asiento.getDatosAsiento().getUbicacion() == ubicacionAsiento;
    }
}
