package aerolinea.datosAsiento;

import aerolinea.vuelo.AsientoVuelo;
import aerolinea.busqueda.FiltroBusqueda;

public enum EstadoAsiento implements FiltroBusqueda{
    RESERVADO,
    DISPONIBLE;

    @Override
    public boolean asientoVueloCumpleParametro(AsientoVuelo asiento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
