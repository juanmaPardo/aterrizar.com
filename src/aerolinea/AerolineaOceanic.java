
package aerolinea;

import aerolinea.busqueda.Busqueda;
import aerolinea.datosAsiento.DatosAsientoLanchita;
import aerolinea.vuelo.AsientoGeneralVuelo;
import aerolinea.vuelo.Vuelo;
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
    
    
    /*public asientosDisponiblesParaOrigen(String codigoOrigenOceanic, String fechaSalida);
    
    public asientosDisponiblesParaOrigenYDestino(String codigoOrigenOceanic,String fechaSalida,String codigoDestinoOceanic);
    
    public Boolean estaReservado(String codigoDeVuelo, Integer numeroDeAsiento);
    
    public Boolean comprarSiHayDisponibilidad(String dni, String codigoVuelo, Integer numeroDeAsiento);
    
    public Boolean reservar(String dni, String codigoVuelo, Integer numeroDeAsiento);*/

   

    @Override
    public void comprar(String codigoAsiento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AsientoGeneralVuelo> asientosDisponibles(Busqueda parametrosBusqueda) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
