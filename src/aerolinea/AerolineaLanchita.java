package aerolinea;

import aerolinea.vuelo.AsientoVueloLanchita;
import aerolinea.vuelo.Vuelo;
import aerolinea.datosAsiento.DatosAsientoLanchita;
import aerolinea.datosAsiento.ClaseAsientoVuelo;
import aerolinea.datosAsiento.UbicacionAsiento;
import fecha.DatosFecha;
import horarios.Hora;
import java.util.LinkedList;
import aerolinea.busqueda.Busqueda;
import aerolinea.datosAsiento.CodigoAsiento;
import aerolinea.datosAsiento.DatosAsientoGeneral;
import aerolinea.datosAsiento.excepcionesAsiento.AsientoVendidoException;
import aerolinea.datosAsiento.excepcionesAsiento.CodigoAsientoException;
import aerolinea.excepcionesAerolinea.CodigoAsientoNoEncontradoException;
import aerolinea.excepcionesAerolinea.PorcentajeIncorrectoException;
import aerolinea.vuelo.AsientoGeneral;
import aerolinea.vuelo.AsientoGeneralVuelo;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import usuario.Usuario;

public class AerolineaLanchita extends AerolineaGeneral implements Aerolinea {
    final static double RECARGO_AEROLINEA = 0.15;
    public AerolineaLanchita() throws PorcentajeIncorrectoException {
        super(RECARGO_AEROLINEA);
    }

    public AerolineaLanchita(LinkedList<Vuelo> vuelosDisponibles,double recargoAerolinea) throws PorcentajeIncorrectoException {
        super(vuelosDisponibles,recargoAerolinea);
    }
    
    @Override
    public List<AsientoGeneralVuelo> asientosDisponibles(Busqueda parametrosBusqueda) {
        LinkedList<AsientoGeneralVuelo> asientosDisponibles = obtenerAsientosVuelos();
        List<AsientoGeneralVuelo> asientosCumplenSolicitud = parametrosBusqueda.asientosCumplenRequisitoBusqueda(asientosDisponibles);
        return asientosCumplenSolicitud;
    }
    
    
    public AsientoGeneralVuelo obtenerAsiento(String codigoAsiento) throws CodigoAsientoException{
        LinkedList<AsientoGeneralVuelo> asientosVuelos = obtenerAsientosVuelos();
        CodigoAsiento codigoBuscado = new CodigoAsiento(codigoAsiento);
        return asientosVuelos.stream().filter(asiento -> codigoBuscado.asientoVueloCumpleParametro(asiento))
                .collect(Collectors.toList()).get(0);
    }
    
    //public void eliminarAsientoComprado()
    
    @Override
    public void comprar(String codigoAsiento,Usuario comprador) {
        try {
            AsientoGeneralVuelo asientoBuscado = obtenerAsiento(codigoAsiento);
            if(!asientoBuscado.getDatosAsiento().getEstado().asientoVendido()){
                marcarComoVendido(asientoBuscado);
                comprador.marcarComoComprado(asientoBuscado);
                comprador.efectuarCompra(precioTotal(asientoBuscado, comprador));
            }
            else{
                throw new AsientoVendidoException("El asiento asociado al codigo ingresado ya fue vendido");
            }
            
        } catch (CodigoAsientoException ex) {
            throw new CodigoAsientoNoEncontradoException("El codigo de asiento ingresado no pudo ser reconocido");
        }
    }

    
}
