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

public class AerolineaLanchita extends AerolineaGeneral{
    final static double RECARGO_AEROLINEA = 0.15;
    public AerolineaLanchita() throws PorcentajeIncorrectoException {
        super(RECARGO_AEROLINEA);
    }

    public AerolineaLanchita(LinkedList<Vuelo> vuelosDisponibles,double recargoAerolinea, int diasParaQueExpireReserva) throws PorcentajeIncorrectoException {
        super(vuelosDisponibles,recargoAerolinea, diasParaQueExpireReserva);
    }
    
       
    //public void eliminarAsientoComprado()
    

    
}
