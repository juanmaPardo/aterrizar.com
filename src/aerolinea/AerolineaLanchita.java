package aerolinea;

import aerolinea.datosAsiento.AsientoVuelo;
import aerolinea.datosAsiento.ClaseAsiento;
import aerolinea.datosAsiento.UbicacionAsiento;
import fecha.DatosFecha;
import horarios.Hora;
import java.util.LinkedList;
import usuario.Busqueda;

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
    public LinkedList<AsientoVuelo> asientosDisponibles(Busqueda parametrosBusqueda) {
        LinkedList<AsientoVuelo> asientosDisponibles = new LinkedList<>();
        return asientosDisponibles;
    }

    @Override
    public void comprar(String codigoAsiento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
