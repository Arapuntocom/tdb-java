package ejb;

import javax.ejb.Local;
import model.Usuario;
import model.UsuarioRegistroPost;

@Local
public interface RegistroUsuarioEJBLocal {
		
    public Usuario agregarUsuario(UsuarioRegistroPost usuarioPost);
    
}
