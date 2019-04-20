
package aerolinea;

import aerolinea.busqueda.Busqueda;
import aerolinea.datosAsiento.DatosAsiento;
import java.util.List;

public class AerolineaOceanic implements Aerolinea{
    
    public AerolineaOceanic(){};
    
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
    public List<DatosAsiento> asientosDisponibles(Busqueda parametrosBusqueda) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void comprar(String codigoAsiento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
