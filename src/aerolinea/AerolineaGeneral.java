package aerolinea;

import aerolinea.busqueda.Busqueda;
import aerolinea.datosAsiento.CodigoAsiento;
import aerolinea.datosAsiento.excepcionesAsiento.AsientoVendidoException;
import aerolinea.datosAsiento.excepcionesAsiento.CodigoAsientoException;
import aerolinea.excepcionesAerolinea.CodigoAsientoNoEncontradoException;
import aerolinea.excepcionesAerolinea.PorcentajeIncorrectoException;
import aerolinea.vuelo.AsientoGeneralVuelo;
import aerolinea.vuelo.Vuelo;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.stream.Collectors;
import javax.naming.InsufficientResourcesException;
import usuario.Usuario;
import aerolinea.excepcionesAerolinea.AsientoReservadoException;
import aerolinea.excepcionesAerolinea.UsuarioNoEncontradoException;
import java.util.List;
import java.util.Objects;

public class AerolineaGeneral{
    protected LinkedList<Vuelo> vuelosDisponibles;
    protected LinkedList<AsientoGeneralVuelo> asientosVendidos;
    protected LinkedList<AsientoGeneralVuelo> asientosReservados;
    protected TreeMap<Integer,Usuario> usuariosSuscriptos;
    protected double recargoAerolinea;
    protected final double RECARGO_NO_INSCRIPTOS = 20;
    protected int diasParaQueExpireReserva;
    
    public AerolineaGeneral(LinkedList<Vuelo> vuelosDisponibles,double recargoAerolinea, int diasParaQueExpireReserva) throws PorcentajeIncorrectoException {
        if(recargoAerolinea > 1 || recargoAerolinea <= 0){
            throw new PorcentajeIncorrectoException("El recargo tiene que ser representado porcentualmente entre entre 0 y 1");
        }
        this.vuelosDisponibles = new LinkedList<>();
        this.asientosVendidos = new LinkedList<>();
        this.usuariosSuscriptos = new TreeMap<>();
        this.vuelosDisponibles.addAll(vuelosDisponibles);
        this.recargoAerolinea = recargoAerolinea;
        this.diasParaQueExpireReserva = diasParaQueExpireReserva;
        this.asientosReservados = new LinkedList <>();
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

    public AsientoGeneralVuelo obtenerAsiento(String codigoAsiento) throws CodigoAsientoException {
        LinkedList<AsientoGeneralVuelo> asientosVuelos = obtenerAsientosVuelos();
        CodigoAsiento codigoBuscado = new CodigoAsiento(codigoAsiento);
        return asientosVuelos.stream().filter(asiento -> codigoBuscado.asientoVueloCumpleParametro(asiento))
                .collect(Collectors.toList()).get(0);
    }
    
    public void reservar(String codigoAsiento, Integer dni) throws AsientoReservadoException, CodigoAsientoException, UsuarioNoEncontradoException{
        AsientoGeneralVuelo asientoBuscado = obtenerAsiento(codigoAsiento);
        if (asientoBuscado.getDatosAsiento().getEstado().estaReservado()) {
            throw new AsientoReservadoException("El asiento asociado al codigo ingresado ya fue reservado");
        }
        reservarAsiento(asientoBuscado);
        asientosReservados.add(asientoBuscado);
        Usuario usuarioAsociado = obtenerUsurioAsociado(dni);
        usuarioAsociado.agregarAsientoReservado(asientoBuscado);
    }
    
    private Usuario obtenerUsurioAsociado(Integer dni) throws UsuarioNoEncontradoException{
        if(usuariosSuscriptos.containsKey(dni)){
            return usuariosSuscriptos.get(dni);
        }
        else{
            throw new UsuarioNoEncontradoException("No existe un usuario con ese dni inscripto en aterrizar.com");
        }
 
    }
    
    public void expiroReserva(AsientoGeneralVuelo asiento, Usuario usuario){
        if(!asiento.getDatosAsiento().getEstado().estaSobrereservado()) {
            asiento.getDatosAsiento().getEstado().asientoDisponible();
            asientosReservados.remove(asiento);
            usuario.quitarASientoReservado(asiento);
        }
        else{
            //tengo que reservarle al otro usuario el asiento
        }
        
    }
    
    private void reservarAsiento(AsientoGeneralVuelo asientoBuscado) {
        asientoBuscado.getDatosAsiento().getEstado().reservarAsiento();
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

    public void comprar(String codigoAsiento,Usuario comprador) throws CodigoAsientoException{
        AsientoGeneralVuelo asientoBuscado = obtenerAsiento(codigoAsiento);
        if(asientoBuscado.getDatosAsiento().getEstado().asientoVendido()){
            throw new AsientoVendidoException("El asiento asociado al codigo ingresado ya fue vendido");  
        }
        marcarComoVendido(asientoBuscado);
        comprador.marcarComoComprado(asientoBuscado);
        comprador.efectuarCompra(precioTotal(asientoBuscado, comprador));
    }


    public List<AsientoGeneralVuelo> asientosDisponibles(Busqueda parametrosBusqueda) {
        LinkedList<AsientoGeneralVuelo> asientosDisponibles = obtenerAsientosVuelos();
        List<AsientoGeneralVuelo> asientosCumplenSolicitud = parametrosBusqueda.asientosCumplenRequisitoBusqueda(asientosDisponibles);
        return asientosCumplenSolicitud;
    }

}
