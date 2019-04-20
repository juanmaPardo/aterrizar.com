package aerolinea.datosAsiento;

import aerolinea.vuelo.AsientoVuelo;
import aerolinea.busqueda.FiltroBusqueda;

public class EstadoAsiento implements FiltroBusqueda{
    private EstadoAsientoVuelo estadoAsiento;

    public EstadoAsiento(EstadoAsientoVuelo estadoAsiento) {
        this.estadoAsiento = estadoAsiento;
    }
    
    public void reservarAsiento(){
        estadoAsiento = EstadoAsientoVuelo.RESERVADO;
    }

    public EstadoAsientoVuelo getEstadoAsiento() {
        return estadoAsiento;
    }
    
    
    @Override
    public boolean asientoVueloCumpleParametro(AsientoVuelo asiento) {
        return asiento.getDatosAsiento().getEstado() == estadoAsiento;
    }
}
