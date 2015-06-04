/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.util.List;
import javax.ejb.Local;
import model.Etiqueta;

/**
 *
 * @author Aracelly
 */
@Local
public interface EtiquetaFacadeLocal {

    void create(Etiqueta etiqueta);

    void edit(Etiqueta etiqueta);

    void remove(Etiqueta etiqueta);

    Etiqueta find(Object id);

    List<Etiqueta> findAll();

    List<Etiqueta> findRange(int[] range);

    int count();
    
}
