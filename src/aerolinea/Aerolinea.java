package aerolinea;

import aerolinea.datosAsiento.DatosAsiento;
import fecha.DatosFecha;
import horarios.Hora;
import java.util.LinkedList;
import aerolinea.busqueda.Busqueda;
import java.util.List;

public interface Aerolinea {
    
    public List<DatosAsiento> asientosDisponibles(Busqueda parametrosBusqueda);
    
    public void comprar(String codigoAsiento);
}
