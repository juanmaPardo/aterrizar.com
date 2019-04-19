package aerolinea;

import aerolinea.vuelo.AsientoVuelo;
import aerolinea.vuelo.Vuelo;
import aerolinea.datosAsiento.DatosAsiento;
import aerolinea.datosAsiento.ClaseAsiento;
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
    public List<DatosAsiento> asientosDisponibles(Busqueda parametrosBusqueda) {
        LinkedList<AsientoVuelo> asientosDisponibles = obtenerAsientosVuelos();
        List<DatosAsiento> asientosCumplenSolicitud = parametrosBusqueda.cumplenParametro(asientosDisponibles);
        return asientosCumplenSolicitud;
    }
    
    private LinkedList<AsientoVuelo> obtenerAsientosVuelos(){
        LinkedList<AsientoVuelo> asientosVuelos = new LinkedList<>();
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
