package aerolinea.datosAsiento;

import aerolinea.vuelo.AsientoVuelo;
import aerolinea.busqueda.FiltroBusqueda;

public enum ClaseAsiento implements FiltroBusqueda{
    TURISTA,
    EJECUTIVO,
    PRIMERA_CLASE;

    @Override
    public boolean asientoVueloCumpleParametro(AsientoVuelo asiento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
