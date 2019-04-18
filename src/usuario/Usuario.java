package usuario;

import static java.lang.Integer.compare;

public class Usuario implements Comparable<Usuario>{
    PerfilUsuario perfil;
    String nombre;
    String apellido;
    int dni;

    public Usuario(String nombre, String apellido, int dni) throws DniInvalidoException {
        if(dni <= 0){
            throw new DniInvalidoException("El dni no puede ser negativo");
        }
        
        perfil = new PerfilUsuario();
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;//Al dni lo asumimos como valido si no es negativo
    }
    
    @Override
    public int compareTo(Usuario otroUsuario) {
        return Integer.compare(this.dni,otroUsuario.dni);
    }
    
    
}
