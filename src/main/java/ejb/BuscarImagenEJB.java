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
public class BuscarImagenEJB implements BuscarImagenEJBLocal{
    
    @Override
    public List<Imagen> buscarImagenByTags(List<Tag> tags){
        return null;    
    }
    
}
