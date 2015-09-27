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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Aracelly
 */
@Entity
@Table(name = "comentario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comentario.findAll", query = "SELECT c FROM Comentario c"),
    @NamedQuery(name = "Comentario.findByIdComentario", query = "SELECT c FROM Comentario c WHERE c.idComentario = :idComentario"),
    @NamedQuery(name = "Comentario.findByTextoComentario", query = "SELECT c FROM Comentario c WHERE c.textoComentario = :textoComentario"),
    @NamedQuery(name = "Comentario.findByFechaComentario", query = "SELECT c FROM Comentario c WHERE c.fechaComentario = :fechaComentario"),
    @NamedQuery(name = "Comentario.findByClasificacionComentario", query = "SELECT c FROM Comentario c WHERE c.clasificacionComentario = :clasificacionComentario")})
public class Comentario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_comentario")
    private Integer idComentario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "texto_comentario")
    private String textoComentario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_comentario")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaComentario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "clasificacion_comentario")
    private int clasificacionComentario;
    @JoinColumn(name = "Usuario_id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario usuarioidusuario;
    @JoinColumn(name = "Imagen_id_imagen", referencedColumnName = "id_imagen")
    @ManyToOne(optional = false)
    private Imagen imagenidimagen;

    public Comentario() {
    }

    public Comentario(Integer idComentario) {
        this.idComentario = idComentario;
    }

    public Comentario(Integer idComentario, String textoComentario, Date fechaComentario, int clasificacionComentario) {
        this.idComentario = idComentario;
        this.textoComentario = textoComentario;
        this.fechaComentario = fechaComentario;
        this.clasificacionComentario = clasificacionComentario;
    }

    public Integer getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(Integer idComentario) {
        this.idComentario = idComentario;
    }

    public String getTextoComentario() {
        return textoComentario;
    }

    public void setTextoComentario(String textoComentario) {
        this.textoComentario = textoComentario;
    }

    public Date getFechaComentario() {
        return fechaComentario;
    }

    public void setFechaComentario(Date fechaComentario) {
        this.fechaComentario = fechaComentario;
    }

    public int getClasificacionComentario() {
        return clasificacionComentario;
    }

    public void setClasificacionComentario(int clasificacionComentario) {
        this.clasificacionComentario = clasificacionComentario;
    }

    public Usuario getUsuarioidusuario() {
        return usuarioidusuario;
    }

    public void setUsuarioidusuario(Usuario usuarioidusuario) {
        this.usuarioidusuario = usuarioidusuario;
    }

    public Imagen getImagenidimagen() {
        return imagenidimagen;
    }

    public void setImagenidimagen(Imagen imagenidimagen) {
        this.imagenidimagen = imagenidimagen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComentario != null ? idComentario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comentario)) {
            return false;
        }
        Comentario other = (Comentario) object;
        if ((this.idComentario == null && other.idComentario != null) || (this.idComentario != null && !this.idComentario.equals(other.idComentario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Comentario[ idComentario=" + idComentario + " ]";
    }
    
}
