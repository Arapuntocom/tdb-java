/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Aracelly
 */
@Embeddable
public class PermisoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "Usuario_id_usuario")
    private int usuarioidusuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Foto_id_imagen")
    private int fotoidimagen;

    public PermisoPK() {
    }

    public PermisoPK(int usuarioidusuario, int fotoidimagen) {
        this.usuarioidusuario = usuarioidusuario;
        this.fotoidimagen = fotoidimagen;
    }

    public int getUsuarioidusuario() {
        return usuarioidusuario;
    }

    public void setUsuarioidusuario(int usuarioidusuario) {
        this.usuarioidusuario = usuarioidusuario;
    }

    public int getFotoidimagen() {
        return fotoidimagen;
    }

    public void setFotoidimagen(int fotoidimagen) {
        this.fotoidimagen = fotoidimagen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) usuarioidusuario;
        hash += (int) fotoidimagen;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PermisoPK)) {
            return false;
        }
        PermisoPK other = (PermisoPK) object;
        if (this.usuarioidusuario != other.usuarioidusuario) {
            return false;
        }
        if (this.fotoidimagen != other.fotoidimagen) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PermisoPK[ usuarioidusuario=" + usuarioidusuario + ", fotoidimagen=" + fotoidimagen + " ]";
    }
    
}
