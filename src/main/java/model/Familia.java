/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Aracelly
 */
@Entity
@Table(name = "familia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Familia.findAll", query = "SELECT f FROM Familia f"),
    @NamedQuery(name = "Familia.findByIdFamilia", query = "SELECT f FROM Familia f WHERE f.idFamilia = :idFamilia"),
    @NamedQuery(name = "Familia.findByUsuarioidusuario", query = "SELECT f FROM Familia f WHERE f.familiaPK.usuarioidusuario = :usuarioidusuario"),
    @NamedQuery(name = "Familia.findByUsuarioidusuario1", query = "SELECT f FROM Familia f WHERE f.familiaPK.usuarioidusuario1 = :usuarioidusuario1")})
public class Familia implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FamiliaPK familiaPK;
    @Size(max = 45)
    @Column(name = "id_familia")
    private String idFamilia;
    @JoinColumn(name = "Usuario_id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario usuario;
    @JoinColumn(name = "Usuario_id_usuario1", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario usuario1;

    public Familia() {
    }

    public Familia(FamiliaPK familiaPK) {
        this.familiaPK = familiaPK;
    }

    public Familia(int usuarioidusuario, int usuarioidusuario1) {
        this.familiaPK = new FamiliaPK(usuarioidusuario, usuarioidusuario1);
    }

    public FamiliaPK getFamiliaPK() {
        return familiaPK;
    }

    public void setFamiliaPK(FamiliaPK familiaPK) {
        this.familiaPK = familiaPK;
    }

    public String getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(String idFamilia) {
        this.idFamilia = idFamilia;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario1() {
        return usuario1;
    }

    public void setUsuario1(Usuario usuario1) {
        this.usuario1 = usuario1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (familiaPK != null ? familiaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Familia)) {
            return false;
        }
        Familia other = (Familia) object;
        if ((this.familiaPK == null && other.familiaPK != null) || (this.familiaPK != null && !this.familiaPK.equals(other.familiaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Familia[ familiaPK=" + familiaPK + " ]";
    }
    
}
