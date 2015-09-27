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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Aracelly
 */
@Entity
@Table(name = "etiqueta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Etiqueta.findAll", query = "SELECT e FROM Etiqueta e"),
    @NamedQuery(name = "Etiqueta.findByIdEtiqueta", query = "SELECT e FROM Etiqueta e WHERE e.idEtiqueta = :idEtiqueta"),
    @NamedQuery(name = "Etiqueta.findByFechaEtiqueta", query = "SELECT e FROM Etiqueta e WHERE e.fechaEtiqueta = :fechaEtiqueta"),
    @NamedQuery(name = "Etiqueta.findByPosicionXetiqueta", query = "SELECT e FROM Etiqueta e WHERE e.posicionXetiqueta = :posicionXetiqueta"),
    @NamedQuery(name = "Etiqueta.findByPosicoinYetiqueta", query = "SELECT e FROM Etiqueta e WHERE e.posicoinYetiqueta = :posicoinYetiqueta")})
public class Etiqueta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_etiqueta")
    private Integer idEtiqueta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_etiqueta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEtiqueta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "posicionX_etiqueta")
    private int posicionXetiqueta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "posicoinY_etiqueta")
    private int posicoinYetiqueta;
    @JoinColumn(name = "Usuario_id_usuario1", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario usuarioidusuario1;
    @JoinColumn(name = "Usuario_id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario usuarioidusuario;
    @JoinColumn(name = "Imagen_id_imagen", referencedColumnName = "id_imagen")
    @ManyToOne(optional = false)
    private Imagen imagenidimagen;

    public Etiqueta() {
    }

    public Etiqueta(Integer idEtiqueta) {
        this.idEtiqueta = idEtiqueta;
    }

    public Etiqueta(Integer idEtiqueta, Date fechaEtiqueta, int posicionXetiqueta, int posicoinYetiqueta) {
        this.idEtiqueta = idEtiqueta;
        this.fechaEtiqueta = fechaEtiqueta;
        this.posicionXetiqueta = posicionXetiqueta;
        this.posicoinYetiqueta = posicoinYetiqueta;
    }

    public Integer getIdEtiqueta() {
        return idEtiqueta;
    }

    public void setIdEtiqueta(Integer idEtiqueta) {
        this.idEtiqueta = idEtiqueta;
    }

    public Date getFechaEtiqueta() {
        return fechaEtiqueta;
    }

    public void setFechaEtiqueta(Date fechaEtiqueta) {
        this.fechaEtiqueta = fechaEtiqueta;
    }

    public int getPosicionXetiqueta() {
        return posicionXetiqueta;
    }

    public void setPosicionXetiqueta(int posicionXetiqueta) {
        this.posicionXetiqueta = posicionXetiqueta;
    }

    public int getPosicoinYetiqueta() {
        return posicoinYetiqueta;
    }

    public void setPosicoinYetiqueta(int posicoinYetiqueta) {
        this.posicoinYetiqueta = posicoinYetiqueta;
    }

    public Usuario getUsuarioidusuario1() {
        return usuarioidusuario1;
    }

    public void setUsuarioidusuario1(Usuario usuarioidusuario1) {
        this.usuarioidusuario1 = usuarioidusuario1;
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
        hash += (idEtiqueta != null ? idEtiqueta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etiqueta)) {
            return false;
        }
        Etiqueta other = (Etiqueta) object;
        if ((this.idEtiqueta == null && other.idEtiqueta != null) || (this.idEtiqueta != null && !this.idEtiqueta.equals(other.idEtiqueta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Etiqueta[ idEtiqueta=" + idEtiqueta + " ]";
    }
    
}
