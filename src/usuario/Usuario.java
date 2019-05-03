package usuario;

import aerolinea.AerolineaGeneral;
import aerolinea.datosAsiento.excepcionesAsiento.CodigoAsientoException;
import aerolinea.excepcionesAerolinea.AsientoReservadoException;
import aerolinea.excepcionesAerolinea.UsuarioNoEncontradoException;
import aerolinea.vuelo.AsientoGeneralVuelo;
import static java.lang.Integer.compare;
import java.util.LinkedList;

public class Usuario implements Comparable<Usuario>{
    private PerfilUsuario perfil;
    private LinkedList<AsientoGeneralVuelo> asientosComprados;
    private LinkedList<AsientoGeneralVuelo> asientosReservados;
    private LinkedList<AsientoGeneralVuelo> asientosSobreReservados;
    private String nombre;
    private String apellido;
    private Integer dni;

    public Usuario(String nombre, String apellido, Integer dni) throws DniInvalidoException {
        if(dni <= 0){
            throw new DniInvalidoException("El dni no puede ser negativo");
        }
        
        perfil = new PerfilUsuario();
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;//Al dni lo asumimos como valido si no es negativo
        asientosComprados = new LinkedList<>();
        asientosReservados = new LinkedList<>();
    }

    public PerfilUsuario getPerfil() {
        return perfil;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Integer getDni() {
        return dni;
    }
    
    public void agregarAsientoReservado(AsientoGeneralVuelo asiento){
        asientosReservados.add(asiento);
    }
    
    public void marcarComoComprado(AsientoGeneralVuelo asiento){
        asientosComprados.add(asiento);
    }
    
    public void efectuarCompra(double costoCompra){
        perfil.incrementarDineroGastado(costoCompra);
    }
    
    public void reservarAsiento(String codigoAsiento, AerolineaGeneral aerolinea) throws AsientoReservadoException, CodigoAsientoException, UsuarioNoEncontradoException{
        aerolinea.reservar(codigoAsiento, dni);
    }
    
     public void agregarAsientoSobrereservado(AsientoGeneralVuelo asiento){
        asientosReservados.add(asiento);
    }
        
    public void comprarAsiento(String codigoAsiento, AerolineaGeneral aerolinea) throws CodigoAsientoException{
        aerolinea.comprar(codigoAsiento, this);
    }
    
    @Override
    public int compareTo(Usuario otroUsuario) {
        return Integer.compare(this.dni,otroUsuario.dni);
    }

    public void quitarASientoReservado(AsientoGeneralVuelo asiento) {
        asientosReservados.remove(asiento);
    }
    
    
}
