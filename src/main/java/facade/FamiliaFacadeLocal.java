/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.util.List;
import javax.ejb.Local;
import model.Familia;

/**
 *
 * @author Aracelly
 */
@Local
public interface FamiliaFacadeLocal {

    void create(Familia familia);

    void edit(Familia familia);

    void remove(Familia familia);

    Familia find(Object id);

    List<Familia> findAll();

    List<Familia> findRange(int[] range);

    int count();
    
}
