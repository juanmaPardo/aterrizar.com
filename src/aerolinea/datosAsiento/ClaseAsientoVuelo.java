package aerolinea.datosAsiento;

import aerolinea.vuelo.AsientoVueloLanchita;
import aerolinea.busqueda.FiltroBusqueda;
import aerolinea.vuelo.AsientoGeneralVuelo;

public class ClaseAsientoVuelo implements FiltroBusqueda{
    private ClasesAsientoVuelo claseAsiento;

    public ClaseAsientoVuelo(ClasesAsientoVuelo claseAsiento) {
        this.claseAsiento = claseAsiento;
    }

    public ClasesAsientoVuelo getClaseAsiento() {
        return claseAsiento;
    }
    
    @Override
    public boolean asientoVueloCumpleParametro(AsientoGeneralVuelo asiento) {
        return asiento.getDatosAsiento().getClase().getClaseAsiento() == claseAsiento;
    }
}
