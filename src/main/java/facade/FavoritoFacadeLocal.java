/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.util.List;
import javax.ejb.Local;
import model.Favorito;

/**
 *
 * @author Aracelly
 */
@Local
public interface FavoritoFacadeLocal {

    void create(Favorito favorito);

    void edit(Favorito favorito);

    void remove(Favorito favorito);

    Favorito find(Object id);

    List<Favorito> findAll();

    List<Favorito> findRange(int[] range);

    int count();
    
}