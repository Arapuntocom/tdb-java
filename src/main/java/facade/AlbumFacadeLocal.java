/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import model.Album;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Aracelly
 */
@Local
public interface AlbumFacadeLocal {

    void create(Album album);

    void edit(Album album);

    void remove(Album album);

    Album find(Object id);

    List<Album> findAll();

    List<Album> findRange(int[] range);

    int count();
    
}
