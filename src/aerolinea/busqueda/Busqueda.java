package aerolinea.busqueda;

import aerolinea.busqueda.ExcepcionesBusqueda.ParametrosInsuficienteException;
import aerolinea.vuelo.AsientoGeneral;
import aerolinea.datosAsiento.DatosAsiento;
import aerolinea.datosAsiento.ClaseAsiento;
import aerolinea.datosAsiento.EstadoAsiento;
import aerolinea.datosAsiento.PrecioAsiento;
import aerolinea.datosAsiento.UbicacionAsiento;
import aerolinea.vuelo.CiudadDestino;
import aerolinea.vuelo.CiudadPartida;
import fecha.DatosFecha;
import fecha.Fecha;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


public class Busqueda {
    //Todos los parametros que me vienen son los que cumplen esta intefaz y implementan el metodo
    //propio de la misma, entonces los meto a todos en una lista y me podes mandar cuantos
    //argumentos se te ocurra que va a seguir funcionando, lo hacemos polimorfico y mas
    //mantenible
    private LinkedList<FiltroBusqueda> filtroBusqueda;
    private LinkedList<ClaseAsiento> filtroClaseAsiento;

    public Busqueda(FiltroBusqueda[] args) throws ParametrosInsuficienteException {
        filtroBusqueda = new LinkedList<>();
        filtroClaseAsiento = new LinkedList<>();
        if(!contieneCiudadOrigen(Arrays.asList(args))){
            throw new ParametrosInsuficienteException("Se debe propiciar la ciudad de origen");
        }
        if(!contieneCiudadDestino(Arrays.asList(args))){
            throw new ParametrosInsuficienteException("Se debe propiciar la ciudad de destino");
        }
        if(!contieneFecha(Arrays.asList(args))){
            throw new ParametrosInsuficienteException("Se debe propiciar una fecha");
        }
        for(int i=0 ; i < args.length ; i++){
            if(args[i] instanceof ClaseAsiento){
                filtroClaseAsiento.add((ClaseAsiento)args[i]);
            }
            else{
                filtroBusqueda.add(args[i]);
            }    
        }
    }
    
    private boolean contieneCiudadOrigen(List<FiltroBusqueda> parametros){
        return parametros.stream().anyMatch(elem -> elem instanceof CiudadPartida);
    }
    
    private boolean contieneFecha(List<FiltroBusqueda> parametros){
        return parametros.stream().anyMatch(elem -> elem instanceof DatosFecha);
    }
    
    private boolean contieneCiudadDestino(List<FiltroBusqueda> parametros){
        return parametros.stream().anyMatch(elem -> elem instanceof CiudadDestino);
    }
    
    public List<AsientoGeneral> asientosCumplenRequisitoBusqueda(LinkedList<AsientoGeneral> disponibles){
        List<AsientoGeneral> cumplenFiltroCaracterUnico = disponibles.stream()
                .filter(asientoVuelo -> cumpleTodosRequisitos(asientoVuelo)).collect(Collectors.toList());
        
        List<AsientoGeneral> asientosCumplenTodosFiltros = cumplenFiltroCaracterUnico.stream()
                .filter(asientoVuelo -> claseAsientoAceptable(asientoVuelo,filtroClaseAsiento)).collect(Collectors.toList());
        
        return asientosCumplenTodosFiltros;
    }
    
    private boolean claseAsientoAceptable(AsientoGeneral asiento,LinkedList<ClaseAsiento> asientosAceptables){
        return asientosAceptables.contains(asiento.getDatosAsiento().getUbicacion());
    }
    
    private boolean cumpleTodosRequisitos(AsientoGeneral asientoVuelo){
        return filtroBusqueda.stream().
                allMatch(filtroBusq -> filtroBusq.asientoVueloCumpleParametro(asientoVuelo));
    }
}
