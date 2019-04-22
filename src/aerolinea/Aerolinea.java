package aerolinea;

import aerolinea.datosAsiento.DatosAsientoLanchita;
import fecha.DatosFecha;
import horarios.Hora;
import java.util.LinkedList;
import aerolinea.busqueda.Busqueda;
import aerolinea.datosAsiento.DatosAsientoGeneral;
import aerolinea.vuelo.AsientoGeneral;
import aerolinea.vuelo.AsientoGeneralVuelo;
import aerolinea.vuelo.Vuelo;
import java.util.List;

public interface Aerolinea {
    
    public List<AsientoGeneral> asientosDisponibles(Busqueda parametrosBusqueda);
     
    public void comprar(String codigoAsiento);
}
