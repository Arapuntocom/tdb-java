/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.util.List;
import javax.ejb.Local;
import model.Camara;

/**
 *
 * @author Aracelly
 */
@Local
public interface CamaraFacadeLocal {

    void create(Camara camara);

    void edit(Camara camara);

    void remove(Camara camara);

    Camara find(Object id);

    List<Camara> findAll();

    List<Camara> findRange(int[] range);

    int count();
    
}
