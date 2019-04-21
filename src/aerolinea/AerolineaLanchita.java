package aerolinea;

import aerolinea.vuelo.AsientoVueloLanchita;
import aerolinea.vuelo.Vuelo;
import aerolinea.datosAsiento.DatosAsientoLanchita;
import aerolinea.datosAsiento.ClaseAsientoVuelo;
import aerolinea.datosAsiento.UbicacionAsiento;
import fecha.DatosFecha;
import horarios.Hora;
import java.util.LinkedList;
import aerolinea.busqueda.Busqueda;
import java.util.List;

public class AerolineaLanchita implements Aerolinea {
    private LinkedList<Vuelo> vuelosDisponibles;

    public AerolineaLanchita() {
        vuelosDisponibles = new LinkedList<>();
    }

    public AerolineaLanchita(LinkedList<Vuelo> vuelosDisponibles) {
        this.vuelosDisponibles = new LinkedList<>();
        this.vuelosDisponibles.addAll(vuelosDisponibles);
    }
    
    @Override
    public List<DatosAsientoLanchita> asientosDisponibles(Busqueda parametrosBusqueda) {
        LinkedList<AsientoVueloLanchita> asientosDisponibles = obtenerAsientosVuelos();
        List<DatosAsientoLanchita> asientosCumplenSolicitud = parametrosBusqueda.asientosCumplenRequisitoBusqueda(asientosDisponibles);
        return asientosCumplenSolicitud;
    }
    
    private LinkedList<AsientoVueloLanchita> obtenerAsientosVuelos(){
        LinkedList<AsientoVueloLanchita> asientosVuelos = new LinkedList<>();
        vuelosDisponibles.forEach(vuelo ->{
            asientosVuelos.addAll(vuelo.getDatosAsientoVuelo());
        });
        return asientosVuelos;
    }

    @Override
    public void comprar(String codigoAsiento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
