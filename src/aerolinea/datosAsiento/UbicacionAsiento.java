package aerolinea.datosAsiento;

import aerolinea.vuelo.AsientoVueloLanchita;
import aerolinea.busqueda.FiltroBusqueda;
import aerolinea.vuelo.AsientoGeneral;
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
    public boolean asientoVueloCumpleParametro(AsientoGeneral asiento) {
        return asiento.getDatosAsiento().getUbicacionAsiento().getUbicacionAsiento() == ubicacionAsiento;
    }
}
