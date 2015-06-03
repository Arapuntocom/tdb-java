/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Aracelly
 */
@Entity
@Table(name = "favorito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Favorito.findAll", query = "SELECT f FROM Favorito f"),
    @NamedQuery(name = "Favorito.findByIdFavorito", query = "SELECT f FROM Favorito f WHERE f.idFavorito = :idFavorito"),
    @NamedQuery(name = "Favorito.findByFechaFavorito", query = "SELECT f FROM Favorito f WHERE f.fechaFavorito = :fechaFavorito")})
public class Favorito implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_favorito")
    private Integer idFavorito;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_favorito")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFavorito;
    @JoinColumn(name = "Imagen_id_imagen", referencedColumnName = "id_imagen")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Imagen imagenidimagen;
    @JoinColumn(name = "Usuario_id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario usuarioidusuario;

    public Favorito() {
    }

    public Favorito(Integer idFavorito) {
        this.idFavorito = idFavorito;
    }

    public Favorito(Integer idFavorito, Date fechaFavorito) {
        this.idFavorito = idFavorito;
        this.fechaFavorito = fechaFavorito;
    }

    public Integer getIdFavorito() {
        return idFavorito;
    }

    public void setIdFavorito(Integer idFavorito) {
        this.idFavorito = idFavorito;
    }

    public Date getFechaFavorito() {
        return fechaFavorito;
    }

    public void setFechaFavorito(Date fechaFavorito) {
        this.fechaFavorito = fechaFavorito;
    }

    public Imagen getImagenidimagen() {
        return imagenidimagen;
    }

    public void setImagenidimagen(Imagen imagenidimagen) {
        this.imagenidimagen = imagenidimagen;
    }

    public Usuario getUsuarioidusuario() {
        return usuarioidusuario;
    }

    public void setUsuarioidusuario(Usuario usuarioidusuario) {
        this.usuarioidusuario = usuarioidusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFavorito != null ? idFavorito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Favorito)) {
            return false;
        }
        Favorito other = (Favorito) object;
        if ((this.idFavorito == null && other.idFavorito != null) || (this.idFavorito != null && !this.idFavorito.equals(other.idFavorito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Favorito[ idFavorito=" + idFavorito + " ]";
    }
    
}
