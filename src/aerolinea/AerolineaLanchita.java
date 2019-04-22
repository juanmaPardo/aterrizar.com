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
import aerolinea.datosAsiento.DatosAsientoGeneral;
import aerolinea.vuelo.AsientoGeneralVuelo;
import java.util.List;

public class AerolineaLanchita extends AerolineaGeneral implements Aerolinea {

    public AerolineaLanchita() {
        super();
    }

    public AerolineaLanchita(LinkedList<Vuelo> vuelosDisponibles) {
        super(vuelosDisponibles);
    }
    
    @Override
    public List<AsientoGeneralVuelo> asientosDisponibles(Busqueda parametrosBusqueda) {
        LinkedList<AsientoGeneralVuelo> asientosDisponibles = obtenerAsientosVuelos();
        List<AsientoGeneralVuelo> asientosCumplenSolicitud = parametrosBusqueda.asientosCumplenRequisitoBusqueda(asientosDisponibles);
        return asientosCumplenSolicitud;
    }
    
    private LinkedList<AsientoGeneralVuelo> obtenerAsientosVuelos(){
        LinkedList<AsientoGeneralVuelo> asientosVuelos = new LinkedList<>();
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
