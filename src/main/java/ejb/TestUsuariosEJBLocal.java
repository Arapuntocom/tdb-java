/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Local;
import model.Usuario;
import model.UsuarioRegistroPost;

/**
 *
 * @author Aracelly
 */
@Local
public interface TestUsuariosEJBLocal {
    
    
    public void editar(UsuarioRegistroPost usuario);
    
    public Usuario encontrarId(int id);
    
    public List<Usuario> encontrarTodos();
    
    public int cantidad();
   
}
