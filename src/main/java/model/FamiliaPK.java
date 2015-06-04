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
public class FamiliaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "Usuario_id_usuario")
    private int usuarioidusuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Usuario_id_usuario1")
    private int usuarioidusuario1;

    public FamiliaPK() {
    }

    public FamiliaPK(int usuarioidusuario, int usuarioidusuario1) {
        this.usuarioidusuario = usuarioidusuario;
        this.usuarioidusuario1 = usuarioidusuario1;
    }

    public int getUsuarioidusuario() {
        return usuarioidusuario;
    }

    public void setUsuarioidusuario(int usuarioidusuario) {
        this.usuarioidusuario = usuarioidusuario;
    }

    public int getUsuarioidusuario1() {
        return usuarioidusuario1;
    }

    public void setUsuarioidusuario1(int usuarioidusuario1) {
        this.usuarioidusuario1 = usuarioidusuario1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) usuarioidusuario;
        hash += (int) usuarioidusuario1;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FamiliaPK)) {
            return false;
        }
        FamiliaPK other = (FamiliaPK) object;
        if (this.usuarioidusuario != other.usuarioidusuario) {
            return false;
        }
        if (this.usuarioidusuario1 != other.usuarioidusuario1) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.FamiliaPK[ usuarioidusuario=" + usuarioidusuario + ", usuarioidusuario1=" + usuarioidusuario1 + " ]";
    }
    
}
