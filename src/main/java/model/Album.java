/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Aracelly
 */
@Entity
@Table(name = "album")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Album.findAll", query = "SELECT a FROM Album a"),
    @NamedQuery(name = "Album.findByIdAlbum", query = "SELECT a FROM Album a WHERE a.idAlbum = :idAlbum"),
    @NamedQuery(name = "Album.findByNombreAlbum", query = "SELECT a FROM Album a WHERE a.nombreAlbum = :nombreAlbum"),
    @NamedQuery(name = "Album.findByFechaCreacionalbum", query = "SELECT a FROM Album a WHERE a.fechaCreacionalbum = :fechaCreacionalbum"),
    @NamedQuery(name = "Album.findByDescripcionAlbum", query = "SELECT a FROM Album a WHERE a.descripcionAlbum = :descripcionAlbum"),
    @NamedQuery(name = "Album.findByPrivacidadAlbum", query = "SELECT a FROM Album a WHERE a.privacidadAlbum = :privacidadAlbum")})
public class Album implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_album")
    private Integer idAlbum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_album")
    private String nombreAlbum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaCreacion_album")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacionalbum;
    @Size(max = 45)
    @Column(name = "descripcion_album")
    private String descripcionAlbum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "privacidad_album")
    private String privacidadAlbum;
    @JoinTable(name = "album_has_imagen", joinColumns = {
        @JoinColumn(name = "id_album", referencedColumnName = "id_album")}, inverseJoinColumns = {
        @JoinColumn(name = "id_imagen", referencedColumnName = "id_imagen")})
    @ManyToMany
    private List<Imagen> imagenList;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public Album() {
    }

    public Album(Integer idAlbum) {
        this.idAlbum = idAlbum;
    }

    public Album(Integer idAlbum, String nombreAlbum, Date fechaCreacionalbum, String privacidadAlbum) {
        this.idAlbum = idAlbum;
        this.nombreAlbum = nombreAlbum;
        this.fechaCreacionalbum = fechaCreacionalbum;
        this.privacidadAlbum = privacidadAlbum;
    }

    public Integer getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(Integer idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getNombreAlbum() {
        return nombreAlbum;
    }

    public void setNombreAlbum(String nombreAlbum) {
        this.nombreAlbum = nombreAlbum;
    }

    public Date getFechaCreacionalbum() {
        return fechaCreacionalbum;
    }

    public void setFechaCreacionalbum(Date fechaCreacionalbum) {
        this.fechaCreacionalbum = fechaCreacionalbum;
    }

    public String getDescripcionAlbum() {
        return descripcionAlbum;
    }

    public void setDescripcionAlbum(String descripcionAlbum) {
        this.descripcionAlbum = descripcionAlbum;
    }

    public String getPrivacidadAlbum() {
        return privacidadAlbum;
    }

    public void setPrivacidadAlbum(String privacidadAlbum) {
        this.privacidadAlbum = privacidadAlbum;
    }

    @XmlTransient
    public List<Imagen> getImagenList() {
        return imagenList;
    }

    public void setImagenList(List<Imagen> imagenList) {
        this.imagenList = imagenList;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlbum != null ? idAlbum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Album)) {
            return false;
        }
        Album other = (Album) object;
        if ((this.idAlbum == null && other.idAlbum != null) || (this.idAlbum != null && !this.idAlbum.equals(other.idAlbum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Album[ idAlbum=" + idAlbum + " ]";
    }
    
}
