/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Local;
import model.Comentario;
import model.Imagen;
import model.Usuario;

/**
 *
 * @author Aracelly
 */
@Local
public interface BusquedaEJBLocal {
    
    public List<Comentario> busquedaComentarios(String texto);
    
    public List<Usuario> busquedaPersonas(String username);
    
    public List<Imagen> busquedaImagenByPais(String pais);
    
}
