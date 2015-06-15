/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Local;
import model.Imagen;

/**
 *
 * @author Aracelly
 */
@Local
public interface TestImagenesEJBLocal {
    
    public void editar(Imagen imagen);
    
    public Imagen encontrarId(int id);
    
    public List<Imagen> encontrarTodos();
    
    public int cantidad();
    
    public void crear(Imagen imagen);
}
