package aerolinea.datosAsiento;

import aerolinea.vuelo.AsientoVuelo;
import aerolinea.busqueda.FiltroBusqueda;

//Esta clases no serian necesarias si no fuese por la busqueda, todo esto se esta haciendo
//para que todos los parametros de busqueda implementen una interfaz que les permita analizar
//si un asiento de vuelo cumple con los parametros, esto se hace para que sea mantenible y que si 
//en un futuro hay que agregar mas parametros de busqueda lo unico que se tenga que hacer es
//agregar un parametro y hacer que implemente la interfaz y todo sigue funcionando como lo hacia
//antes. Basicamente el motivo es para hacer los parametros de busqueda polimorficos
public class PrecioAsiento implements FiltroBusqueda {
    double precioAsiento;

    public PrecioAsiento(double precioAsiento) throws PrecioNegativoException {
        if(precioAsiento < 0){
            throw new PrecioNegativoException("El precio del asiento no puede ser negativo");
        }
        this.precioAsiento = precioAsiento;
    }

    public double getPrecioAsiento() {
        return precioAsiento;
    }
    
    @Override
    public boolean asientoVueloCumpleParametro(AsientoVuelo asiento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
