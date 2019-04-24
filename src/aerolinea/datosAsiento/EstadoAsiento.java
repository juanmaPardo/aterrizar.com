package aerolinea.datosAsiento;

import aerolinea.vuelo.AsientoVueloLanchita;
import aerolinea.busqueda.FiltroBusqueda;
import aerolinea.vuelo.AsientoGeneral;
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
    public boolean asientoVueloCumpleParametro(AsientoGeneral asiento) {
        //Es decir, si solo busca disponibles devolvemos true si el estado de nuestro asiento es disponible
        //Si buscamos incluir los reservados tambien devolvemos true ya que queremos mostrar todos
        EstadoAsientoVuelo estadoPermite = asiento.getDatosAsiento().getEstado().getEstadoAsiento();
        return (estadoPermite == EstadoAsientoVuelo.DISPONIBLE) ? estadoPermite == estadoAsiento : true  ;
    }
}
