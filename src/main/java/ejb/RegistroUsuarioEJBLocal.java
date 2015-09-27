package ejb;

import javax.ejb.Local;
import model.UsuarioRegistroPost;

@Local
public interface RegistroUsuarioEJBLocal {
	
	
    public void agregarUsuario(UsuarioRegistroPost usuarioPost);

    public void agregarUsuario(String email, Integer pass, Integer pass2, String nombre, Integer dia, Integer mes, Integer year, String fono, String sexo, Integer id);

}
