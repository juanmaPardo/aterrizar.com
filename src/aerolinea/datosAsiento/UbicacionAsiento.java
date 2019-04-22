package aerolinea.datosAsiento;

import aerolinea.vuelo.AsientoVueloLanchita;
import aerolinea.busqueda.FiltroBusqueda;
import aerolinea.vuelo.AsientoGeneralVuelo;

public class UbicacionAsiento implements FiltroBusqueda{
    private UbicacionAsientoVuelo ubicacionAsiento;

    public UbicacionAsiento(UbicacionAsientoVuelo ubicacionAsiento) {
        this.ubicacionAsiento = ubicacionAsiento;
    }

    public UbicacionAsientoVuelo getUbicacionAsiento() {
        return ubicacionAsiento;
    }
    
    
    @Override
    public boolean asientoVueloCumpleParametro(AsientoGeneralVuelo asiento) {
        return asiento.getDatosAsiento().getUbicacionAsiento().getUbicacionAsiento() == ubicacionAsiento;
    }
}
