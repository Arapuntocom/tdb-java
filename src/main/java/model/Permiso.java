/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Aracelly
 */
@Entity
@Table(name = "permiso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permiso.findAll", query = "SELECT p FROM Permiso p"),
    @NamedQuery(name = "Permiso.findByUsuarioidusuario", query = "SELECT p FROM Permiso p WHERE p.permisoPK.usuarioidusuario = :usuarioidusuario"),
    @NamedQuery(name = "Permiso.findByFotoidimagen", query = "SELECT p FROM Permiso p WHERE p.permisoPK.fotoidimagen = :fotoidimagen"),
    @NamedQuery(name = "Permiso.findByPermisoImagen", query = "SELECT p FROM Permiso p WHERE p.permisoImagen = :permisoImagen")})
public class Permiso implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PermisoPK permisoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "permiso_imagen")
    private String permisoImagen;
    @JoinColumn(name = "Usuario_id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "Foto_id_imagen", referencedColumnName = "id_imagen", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Imagen imagen;

    public Permiso() {
    }

    public Permiso(PermisoPK permisoPK) {
        this.permisoPK = permisoPK;
    }

    public Permiso(PermisoPK permisoPK, String permisoImagen) {
        this.permisoPK = permisoPK;
        this.permisoImagen = permisoImagen;
    }

    public Permiso(int usuarioidusuario, int fotoidimagen) {
        this.permisoPK = new PermisoPK(usuarioidusuario, fotoidimagen);
    }

    public PermisoPK getPermisoPK() {
        return permisoPK;
    }

    public void setPermisoPK(PermisoPK permisoPK) {
        this.permisoPK = permisoPK;
    }

    public String getPermisoImagen() {
        return permisoImagen;
    }

    public void setPermisoImagen(String permisoImagen) {
        this.permisoImagen = permisoImagen;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Imagen getImagen() {
        return imagen;
    }

    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (permisoPK != null ? permisoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permiso)) {
            return false;
        }
        Permiso other = (Permiso) object;
        if ((this.permisoPK == null && other.permisoPK != null) || (this.permisoPK != null && !this.permisoPK.equals(other.permisoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Permiso[ permisoPK=" + permisoPK + " ]";
    }
    
}
