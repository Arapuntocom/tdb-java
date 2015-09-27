/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Aracelly
 */
@Entity
@Table(name = "camara")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Camara.findAll", query = "SELECT c FROM Camara c"),
    @NamedQuery(name = "Camara.findByIdCamara", query = "SELECT c FROM Camara c WHERE c.idCamara = :idCamara"),
    @NamedQuery(name = "Camara.findByMarcaCamara", query = "SELECT c FROM Camara c WHERE c.marcaCamara = :marcaCamara"),
    @NamedQuery(name = "Camara.findByModeloCamara", query = "SELECT c FROM Camara c WHERE c.modeloCamara = :modeloCamara")})
public class Camara implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_camara")
    private Integer idCamara;
    @Size(max = 45)
    @Column(name = "marca_camara")
    private String marcaCamara;
    @Size(max = 45)
    @Column(name = "modelo_camara")
    private String modeloCamara;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "camaraidcamara", fetch = FetchType.EAGER)
    private List<Imagen> imagenList;

    public Camara() {
    }

    public Camara(Integer idCamara) {
        this.idCamara = idCamara;
    }

    public Integer getIdCamara() {
        return idCamara;
    }

    public void setIdCamara(Integer idCamara) {
        this.idCamara = idCamara;
    }

    public String getMarcaCamara() {
        return marcaCamara;
    }

    public void setMarcaCamara(String marcaCamara) {
        this.marcaCamara = marcaCamara;
    }

    public String getModeloCamara() {
        return modeloCamara;
    }

    public void setModeloCamara(String modeloCamara) {
        this.modeloCamara = modeloCamara;
    }

    @XmlTransient
    public List<Imagen> getImagenList() {
        return imagenList;
    }

    public void setImagenList(List<Imagen> imagenList) {
        this.imagenList = imagenList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCamara != null ? idCamara.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Camara)) {
            return false;
        }
        Camara other = (Camara) object;
        if ((this.idCamara == null && other.idCamara != null) || (this.idCamara != null && !this.idCamara.equals(other.idCamara))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Camara[ idCamara=" + idCamara + " ]";
    }
    
}
