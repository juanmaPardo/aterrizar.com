package aerolinea.datosAsiento;

import aerolinea.vuelo.AsientoVuelo;
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
    public boolean asientoVueloCumpleParametro(AsientoVuelo asiento) {
        return asiento.getDatosAsiento().getUbicacion() == ubicacionAsiento;
    }
}
