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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "imagen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Imagen.findAll", query = "SELECT i FROM Imagen i"),
    @NamedQuery(name = "Imagen.findByIdImagen", query = "SELECT i FROM Imagen i WHERE i.idImagen = :idImagen"),
    @NamedQuery(name = "Imagen.findByAnchoImagen", query = "SELECT i FROM Imagen i WHERE i.anchoImagen = :anchoImagen"),
    @NamedQuery(name = "Imagen.findByLargoImagen", query = "SELECT i FROM Imagen i WHERE i.largoImagen = :largoImagen"),
    @NamedQuery(name = "Imagen.findByDescripcionImagen", query = "SELECT i FROM Imagen i WHERE i.descripcionImagen = :descripcionImagen"),
    @NamedQuery(name = "Imagen.findByPathImagen", query = "SELECT i FROM Imagen i WHERE i.pathImagen = :pathImagen"),
    @NamedQuery(name = "Imagen.findByPathMetadatosimagen", query = "SELECT i FROM Imagen i WHERE i.pathMetadatosimagen = :pathMetadatosimagen"),
    @NamedQuery(name = "Imagen.findByFechaImagen", query = "SELECT i FROM Imagen i WHERE i.fechaImagen = :fechaImagen"),
    @NamedQuery(name = "Imagen.findByLicenciaImagen", query = "SELECT i FROM Imagen i WHERE i.licenciaImagen = :licenciaImagen")})
public class Imagen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_imagen")
    private Integer idImagen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ancho_imagen")
    private int anchoImagen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "largo_imagen")
    private int largoImagen;
    @Size(max = 45)
    @Column(name = "descripcion_imagen")
    private String descripcionImagen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "path_imagen")
    private String pathImagen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "pathMetadatos_imagen")
    private String pathMetadatosimagen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_imagen")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaImagen;
    @Lob
    @Column(name = "geo_imagen")
    private String geoImagen;
    @Size(max = 45)
    @Column(name = "licencia_imagen")
    private String licenciaImagen;
    @JoinTable(name = "imagen_has_tag", joinColumns = {
        @JoinColumn(name = "Imagen_id_imagen", referencedColumnName = "id_imagen")}, inverseJoinColumns = {
        @JoinColumn(name = "Tag_id_tag", referencedColumnName = "id_tag")})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Tag> tagList;
    @ManyToMany(mappedBy = "imagenList", fetch = FetchType.EAGER)
    private List<Album> albumList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "imagenidimagen", fetch = FetchType.EAGER)
    private List<Etiqueta> etiquetaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "imagenidimagen", fetch = FetchType.EAGER)
    private List<Favorito> favoritoList;
    @JoinColumn(name = "Camara_id_camara", referencedColumnName = "id_camara")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Camara camaraidcamara;
    @JoinColumn(name = "Usuario_id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario usuarioidusuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "imagen", fetch = FetchType.EAGER)
    private List<Permiso> permisoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "imagenidimagen", fetch = FetchType.EAGER)
    private List<Comentario> comentarioList;

    public Imagen() {
    }

    public Imagen(Integer idImagen) {
        this.idImagen = idImagen;
    }

    public Imagen(Integer idImagen, int anchoImagen, int largoImagen, String pathImagen, String pathMetadatosimagen, Date fechaImagen) {
        this.idImagen = idImagen;
        this.anchoImagen = anchoImagen;
        this.largoImagen = largoImagen;
        this.pathImagen = pathImagen;
        this.pathMetadatosimagen = pathMetadatosimagen;
        this.fechaImagen = fechaImagen;
    }

    public Integer getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(Integer idImagen) {
        this.idImagen = idImagen;
    }

    public int getAnchoImagen() {
        return anchoImagen;
    }

    public void setAnchoImagen(int anchoImagen) {
        this.anchoImagen = anchoImagen;
    }

    public int getLargoImagen() {
        return largoImagen;
    }

    public void setLargoImagen(int largoImagen) {
        this.largoImagen = largoImagen;
    }

    public String getDescripcionImagen() {
        return descripcionImagen;
    }

    public void setDescripcionImagen(String descripcionImagen) {
        this.descripcionImagen = descripcionImagen;
    }

    public String getPathImagen() {
        return pathImagen;
    }

    public void setPathImagen(String pathImagen) {
        this.pathImagen = pathImagen;
    }

    public String getPathMetadatosimagen() {
        return pathMetadatosimagen;
    }

    public void setPathMetadatosimagen(String pathMetadatosimagen) {
        this.pathMetadatosimagen = pathMetadatosimagen;
    }

    public Date getFechaImagen() {
        return fechaImagen;
    }

    public void setFechaImagen(Date fechaImagen) {
        this.fechaImagen = fechaImagen;
    }

    public String getGeoImagen() {
        return geoImagen;
    }

    public void setGeoImagen(String geoImagen) {
        this.geoImagen = geoImagen;
    }

    public String getLicenciaImagen() {
        return licenciaImagen;
    }

    public void setLicenciaImagen(String licenciaImagen) {
        this.licenciaImagen = licenciaImagen;
    }

    @XmlTransient
    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    @XmlTransient
    public List<Album> getAlbumList() {
        return albumList;
    }

    public void setAlbumList(List<Album> albumList) {
        this.albumList = albumList;
    }

    @XmlTransient
    public List<Etiqueta> getEtiquetaList() {
        return etiquetaList;
    }

    public void setEtiquetaList(List<Etiqueta> etiquetaList) {
        this.etiquetaList = etiquetaList;
    }

    @XmlTransient
    public List<Favorito> getFavoritoList() {
        return favoritoList;
    }

    public void setFavoritoList(List<Favorito> favoritoList) {
        this.favoritoList = favoritoList;
    }

    public Camara getCamaraidcamara() {
        return camaraidcamara;
    }

    public void setCamaraidcamara(Camara camaraidcamara) {
        this.camaraidcamara = camaraidcamara;
    }

    public Usuario getUsuarioidusuario() {
        return usuarioidusuario;
    }

    public void setUsuarioidusuario(Usuario usuarioidusuario) {
        this.usuarioidusuario = usuarioidusuario;
    }

    @XmlTransient
    public List<Permiso> getPermisoList() {
        return permisoList;
    }

    public void setPermisoList(List<Permiso> permisoList) {
        this.permisoList = permisoList;
    }

    @XmlTransient
    public List<Comentario> getComentarioList() {
        return comentarioList;
    }

    public void setComentarioList(List<Comentario> comentarioList) {
        this.comentarioList = comentarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idImagen != null ? idImagen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Imagen)) {
            return false;
        }
        Imagen other = (Imagen) object;
        if ((this.idImagen == null && other.idImagen != null) || (this.idImagen != null && !this.idImagen.equals(other.idImagen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Imagen[ idImagen=" + idImagen + " ]";
    }
    
}
