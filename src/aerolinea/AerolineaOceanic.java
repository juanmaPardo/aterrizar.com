
package aerolinea;

import aerolinea.busqueda.Busqueda;
import aerolinea.datosAsiento.DatosAsientoLanchita;
import aerolinea.vuelo.AsientoGeneral;
import aerolinea.vuelo.AsientoGeneralVuelo;
import aerolinea.vuelo.CiudadDestino;
import aerolinea.vuelo.CiudadPartida;
import aerolinea.vuelo.Vuelo;
import fecha.Fecha;
import fecha.FechaFlexible;
import fecha.excepcionesFecha.FechaNoValidaException;
import fecha.excepcionesFecha.FormatoFechaIncorrectoException;
import java.util.LinkedList;
import java.util.List;

public class AerolineaOceanic extends AerolineaGeneral implements Aerolinea{
    
    public AerolineaOceanic(){
        super();
    }
    
    public String modificarCodigoCiudad (String codigoCiudad){
        String nuevoCodigoCiudad;
        if (codigoCiudad.length() == 2){
            if ("LA".equals(codigoCiudad)){
                nuevoCodigoCiudad = "SLA";
            }
            else{
                nuevoCodigoCiudad = codigoCiudad + "_";
            }
        }
        else{
            nuevoCodigoCiudad = codigoCiudad;
        }
        return nuevoCodigoCiudad;
    }
    
    private LinkedList<AsientoGeneral> obtenerAsientosVuelos(){
        LinkedList<AsientoGeneral> asientosVuelos = new LinkedList<>();
        vuelosDisponibles.forEach(vuelo ->{
            asientosVuelos.addAll(vuelo.getDatosAsientoVuelo());
        });
        return asientosVuelos;
    }
    
    @Override
    public List<AsientoGeneral> asientosDisponibles(Busqueda parametrosBusqueda) {
        LinkedList<AsientoGeneral> asientosDisponibles = obtenerAsientosVuelos();
        List<AsientoGeneral> asientosCumplenSolicitud = parametrosBusqueda.asientosCumplenRequisitoBusqueda(asientosDisponibles);
        return asientosCumplenSolicitud;
    }
    
    
    public List<AsientoGeneral> asientosDisponiblesParaOrigen(String codigoOrigenOceanic, String fechaSalida) throws FormatoFechaIncorrectoException, FechaNoValidaException{
        String codigoOrigenModificado = modificarCodigoCiudad(codigoOrigenOceanic);
        return asientosDisponibles(new Busqueda(new CiudadPartida(codigoOrigenModificado), new FechaFlexible(fechaSalida)));
    }
    
    public List<AsientoGeneral> asientosDisponiblesParaOrigenYDestino(String codigoOrigenOceanic,String fechaSalida,String codigoDestinoOceanic) throws FormatoFechaIncorrectoException, FechaNoValidaException{
        String codigoOrigenModificado = modificarCodigoCiudad(codigoOrigenOceanic);
        String codigoDestinoModificado = modificarCodigoCiudad(codigoDestinoOceanic);
        return asientosDisponibles(new Busqueda(new CiudadDestino(codigoDestinoModificado),new CiudadPartida(codigoOrigenModificado),new FechaFlexible(fechaSalida)));
    }
    
    /*public Boolean estaReservado(String codigoDeVuelo, Integer numeroDeAsiento);
    
    public Boolean comprarSiHayDisponibilidad(String dni, String codigoVuelo, Integer numeroDeAsiento);
    
    public Boolean reservar(String dni, String codigoVuelo, Integer numeroDeAsiento);*/

    @Override
    public void comprar(String codigoAsiento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
