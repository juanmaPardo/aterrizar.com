package aerolinea;

import aerolinea.datosAsiento.DatosAsientoLanchita;
import fecha.DatosFecha;
import horarios.Hora;
import java.util.LinkedList;
import aerolinea.busqueda.Busqueda;
import java.util.List;

public interface Aerolinea {
    
    public List<DatosAsientoLanchita> asientosDisponibles(Busqueda parametrosBusqueda);
    
    public void comprar(String codigoAsiento);
}
