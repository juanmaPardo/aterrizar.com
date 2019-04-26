package usuario;

import aerolinea.vuelo.AsientoGeneralVuelo;
import static java.lang.Integer.compare;
import java.util.LinkedList;

public class Usuario implements Comparable<Usuario>{
    private PerfilUsuario perfil;
    private LinkedList<AsientoGeneralVuelo> asientosComprados;
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
    
    
    public void marcarComoComprado(AsientoGeneralVuelo asiento){
        asientosComprados.add(asiento);
    }
    
    public void efectuarCompra(double costoCompra){
        perfil.incrementarDineroGastado(costoCompra);
    }
    
    @Override
    public int compareTo(Usuario otroUsuario) {
        return Integer.compare(this.dni,otroUsuario.dni);
    }
    
    
}
