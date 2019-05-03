package aerolinea.datosAsiento;

import aerolinea.vuelo.AsientoVueloLanchita;
import aerolinea.busqueda.FiltroBusqueda;
import aerolinea.datosAsiento.excepcionesAsiento.AsientoVendidoException;
import aerolinea.vuelo.AsientoGeneral;
import aerolinea.vuelo.AsientoGeneralVuelo;

public class EstadoAsiento implements FiltroBusqueda{
    private EstadoAsientoVuelo estadoAsiento;

    public EstadoAsiento() {
        this.estadoAsiento = EstadoAsientoVuelo.DISPONIBLE;
    }
    
    public void reservarAsiento(){
        if(estadoAsiento == EstadoAsientoVuelo.VENDIDO){
            throw new AsientoVendidoException("No se puede reservar un asiento que fue vendido");
        }
        estadoAsiento = EstadoAsientoVuelo.RESERVADO;
    }
    
    public boolean estaReservado(){
        return estadoAsiento == EstadoAsientoVuelo.RESERVADO;
    }
    
    public void venderAsiento(){
        estadoAsiento = EstadoAsientoVuelo.VENDIDO;
    }
    
    public void asientoDisponible(){
        estadoAsiento = EstadoAsientoVuelo.DISPONIBLE;
    }
    
    public boolean asientoVendido(){
        return estadoAsiento == EstadoAsientoVuelo.VENDIDO;
    }
    
    public EstadoAsientoVuelo getEstadoAsiento() {
        return estadoAsiento;
    }
    
    
    @Override
    public boolean asientoVueloCumpleParametro(AsientoGeneralVuelo asiento) {
        //Es decir, si solo busca disponibles devolvemos true si el estado de nuestro asiento es disponible
        //Si buscamos incluir los reservados tambien devolvemos true ya que queremos mostrar todos
        EstadoAsientoVuelo estadoPermite = asiento.getDatosAsiento().getEstado().getEstadoAsiento();
        if(estadoPermite == EstadoAsientoVuelo.VENDIDO)return false;//Estos no se muestran en busquedas
        return (estadoPermite == EstadoAsientoVuelo.DISPONIBLE) ? estadoPermite == estadoAsiento : true  ;
    }
}
