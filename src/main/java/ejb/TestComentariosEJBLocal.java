/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Local;
import model.Comentario;

/**
 *
 * @author Aracelly
 */
@Local
public interface TestComentariosEJBLocal {
    
    public void editar(Comentario comentario);
    
    public Comentario encontrarId(int id);
    
    public List<Comentario> encontrarTodos();
    
    public int cantidad();
    
    public void crear(Comentario comentario);
    
    public void crear(String descripcion, int idUsuarioComenta, int idImagen);
}
