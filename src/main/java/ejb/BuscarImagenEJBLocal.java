/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import model.Imagen;
import model.Tag;

/**
 *
 * @author Aracelly
 */
public interface BuscarImagenEJBLocal {
    
    public List<Imagen> buscarImagenByTags(List<Tag> tags);
}
