package aerolinea.datosAsiento;

import aerolinea.vuelo.AsientoVuelo;
import aerolinea.busqueda.FiltroBusqueda;

public class ClaseAsiento implements FiltroBusqueda{
    private ClasesAsientoVuelo claseAsiento;

    public ClaseAsiento(ClasesAsientoVuelo claseAsiento) {
        this.claseAsiento = claseAsiento;
    }

    public ClasesAsientoVuelo getClaseAsiento() {
        return claseAsiento;
    }
    
    @Override
    public boolean asientoVueloCumpleParametro(AsientoVuelo asiento) {
        return asiento.getDatosAsiento().getClaseAsiento() == claseAsiento;
    }
}
