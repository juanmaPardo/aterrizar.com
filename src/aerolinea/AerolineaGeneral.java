package aerolinea;

import aerolinea.excepcionesAerolinea.PorcentajeIncorrectoException;
import aerolinea.vuelo.AsientoGeneralVuelo;
import aerolinea.vuelo.Vuelo;
import java.util.LinkedList;
import java.util.TreeMap;
import javax.naming.InsufficientResourcesException;
import usuario.Usuario;

public class AerolineaGeneral {
    protected LinkedList<Vuelo> vuelosDisponibles;
    protected LinkedList<AsientoGeneralVuelo> asientosVendidos;
    protected TreeMap<Integer,Usuario> usuariosSuscriptos;
    protected double recargoAerolinea;
    protected final double RECARGO_NO_INSCRIPTOS = 20;
    
    public AerolineaGeneral(LinkedList<Vuelo> vuelosDisponibles,double recargoAerolinea) throws PorcentajeIncorrectoException {
        if(recargoAerolinea > 1 || recargoAerolinea <= 0){
            throw new PorcentajeIncorrectoException("El recargo tiene que ser representado porcentualmente entre entre 0 y 1");
        }
        this.vuelosDisponibles = new LinkedList<>();
        this.asientosVendidos = new LinkedList<>();
        this.usuariosSuscriptos = new TreeMap<>();
        this.vuelosDisponibles.addAll(vuelosDisponibles);
        this.recargoAerolinea = recargoAerolinea;
    }

    public AerolineaGeneral(double recargoAerolinea) throws PorcentajeIncorrectoException {
        if(recargoAerolinea > 1 || recargoAerolinea <= 0){
            throw new PorcentajeIncorrectoException("El recargo tiene que ser representado porcentualmente entre entre 0 y 1");
        }
        this.vuelosDisponibles = new LinkedList<>();
        this.asientosVendidos = new LinkedList<>();
        this.usuariosSuscriptos = new TreeMap<>();
        this.recargoAerolinea = recargoAerolinea;
    }
     
    public void agregarVuelo(Vuelo vuelo){
        vuelosDisponibles.add(vuelo);
    }
    
    protected void marcarComoVendido(AsientoGeneralVuelo asiento){
        asiento.getDatosAsiento().getEstado().venderAsiento();
        agregarAVendidos(asiento);
    }
    
    protected void agregarAVendidos(AsientoGeneralVuelo asiento){
        asientosVendidos.add(asiento);
    }
    
    protected LinkedList<AsientoGeneralVuelo> obtenerAsientosVuelos(){
        LinkedList<AsientoGeneralVuelo> asientosVuelos = new LinkedList<>();
        vuelosDisponibles.forEach(vuelo ->{
            asientosVuelos.addAll(vuelo.getDatosAsientoVuelo());
        });
        return asientosVuelos;
    }
    
    public void agregarUsuario(Usuario usuario){
        usuariosSuscriptos.put(usuario.getDni(), usuario);
    }
    
    private boolean usuarioEstaSuscripto(Usuario usuario){
        return usuariosSuscriptos.containsKey(usuario.getDni());
    }
    
    public double precioTotal(AsientoGeneralVuelo asiento,Usuario usuario){
        double precioBase = asiento.getDatosAsiento().getPrecio().getPrecioAsiento();
        double precioConRecargo = precioBase+=precioBase*recargoAerolinea;
        return (usuarioEstaSuscripto(usuario)) ? precioConRecargo : precioConRecargo + RECARGO_NO_INSCRIPTOS;
    }
    
    /*public boolean esSuperOferta(AsientoGeneralVuelo asiento){
        
    }*/
}
