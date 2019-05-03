package aerolinea;

import aerolinea.busqueda.Busqueda;
import aerolinea.busqueda.ExcepcionesBusqueda.ParametrosInsuficienteException;
import aerolinea.datosAsiento.DatosAsientoLanchita;
import aerolinea.excepcionesAerolinea.PorcentajeIncorrectoException;
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
import usuario.Usuario;

public class AerolineaOceanic extends AerolineaGeneral{
    final static double RECARGO_AEROLINEA = 0.10;
    public AerolineaOceanic() throws PorcentajeIncorrectoException{
        super(RECARGO_AEROLINEA);
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
    
     
    public List<AsientoGeneralVuelo> asientosDisponiblesParaOrigen(String codigoOrigenOceanic, String fechaSalida) throws FormatoFechaIncorrectoException, FechaNoValidaException{
        String codigoOrigenModificado = modificarCodigoCiudad(codigoOrigenOceanic);
        return asientosDisponibles(new Busqueda(new CiudadPartida(codigoOrigenModificado), new FechaFlexible(fechaSalida)));
    }
    
    public List<AsientoGeneralVuelo> asientosDisponiblesParaOrigenYDestino(String codigoOrigenOceanic,String fechaSalida,String codigoDestinoOceanic) throws FormatoFechaIncorrectoException, FechaNoValidaException, ParametrosInsuficienteException{
        String codigoOrigenModificado = modificarCodigoCiudad(codigoOrigenOceanic);
        String codigoDestinoModificado = modificarCodigoCiudad(codigoDestinoOceanic);
        return asientosDisponibles(new Busqueda(new CiudadDestino(codigoDestinoModificado),new CiudadPartida(codigoOrigenModificado),new FechaFlexible(fechaSalida)));
    }
    
    /*public Boolean estaReservado(String codigoDeVuelo, Integer numeroDeAsiento);
    
    public Boolean comprarSiHayDisponibilidad(String dni, String codigoVuelo, Integer numeroDeAsiento);
    
    public Boolean reservar(String dni, String codigoVuelo, Integer numeroDeAsiento);*/

    
}
