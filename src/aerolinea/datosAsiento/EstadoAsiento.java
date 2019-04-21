package aerolinea.datosAsiento;

import aerolinea.vuelo.AsientoVueloLanchita;
import aerolinea.busqueda.FiltroBusqueda;
import aerolinea.vuelo.AsientoGeneralVuelo;

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
    public boolean asientoVueloCumpleParametro(AsientoGeneralVuelo asiento) {
        return asiento.getDatosAsiento().getEstado() == estadoAsiento;
    }
}
