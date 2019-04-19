package aerolinea.busqueda;

import aerolinea.vuelo.AsientoVuelo;
import aerolinea.datosAsiento.DatosAsiento;
import aerolinea.datosAsiento.ClaseAsiento;
import aerolinea.datosAsiento.EstadoAsiento;
import aerolinea.datosAsiento.PrecioAsiento;
import aerolinea.datosAsiento.UbicacionAsiento;
import aerolinea.vuelo.CiudadDestino;
import aerolinea.vuelo.CiudadPartida;
import fecha.DatosFecha;
import fecha.Fecha;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


public class Busqueda {
    //Todos los parametros que me vienen son los que cumplen esta intefaz y implementan el metodo
    //propio de la misma, entonces los meto a todos en una lista y me podes mandar cuantos
    //argumentos se te ocurra que va a seguir funcionando, lo hacemos polimorfico y mas
    //mantenible
    LinkedList<FiltroBusqueda> filtroBusqueda;

    public Busqueda(FiltroBusqueda[] args) {
        filtroBusqueda = new LinkedList<>();
        for(int i=0 ; i < args.length ; i++){
            filtroBusqueda.add(args[i]);
        }
    }
    
    public List<DatosAsiento> cumplenParametro(LinkedList<AsientoVuelo> disponibles){
        List<AsientoVuelo> cumplenFiltro = disponibles.stream()
                .filter(asientoVuelo -> cumpleTodosRequisitos(asientoVuelo)).collect(Collectors.toList());
        
        List<DatosAsiento> asientosCumplenFiltro = cumplenFiltro.stream()
                .map(asientoVuelo -> asientoVuelo.getDatosAsiento()).collect(Collectors.toList());
        
        return asientosCumplenFiltro;
    }
    
    public boolean cumpleTodosRequisitos(AsientoVuelo asientoVuelo){
        return filtroBusqueda.stream().
                allMatch(filtroBusq -> filtroBusq.asientoVueloCumpleParametro(asientoVuelo));
    }
}
