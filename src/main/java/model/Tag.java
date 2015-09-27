/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Aracelly
 */
@Entity
@Table(name = "tag")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tag.findAll", query = "SELECT t FROM Tag t"),
    @NamedQuery(name = "Tag.findByIdTag", query = "SELECT t FROM Tag t WHERE t.idTag = :idTag"),
    @NamedQuery(name = "Tag.findByTextoTag", query = "SELECT t FROM Tag t WHERE t.textoTag = :textoTag"),
    @NamedQuery(name = "Tag.findByOcurrenciaTag", query = "SELECT t FROM Tag t WHERE t.ocurrenciaTag = :ocurrenciaTag")})
public class Tag implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tag")
    private Integer idTag;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "texto_tag")
    private String textoTag;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ocurrencia_tag")
    private int ocurrenciaTag;
    @ManyToMany(mappedBy = "tagList", fetch = FetchType.EAGER)
    private List<Imagen> imagenList;

    public Tag() {
    }

    public Tag(Integer idTag) {
        this.idTag = idTag;
    }

    public Tag(Integer idTag, String textoTag, int ocurrenciaTag) {
        this.idTag = idTag;
        this.textoTag = textoTag;
        this.ocurrenciaTag = ocurrenciaTag;
    }

    public Integer getIdTag() {
        return idTag;
    }

    public void setIdTag(Integer idTag) {
        this.idTag = idTag;
    }

    public String getTextoTag() {
        return textoTag;
    }

    public void setTextoTag(String textoTag) {
        this.textoTag = textoTag;
    }

    public int getOcurrenciaTag() {
        return ocurrenciaTag;
    }

    public void setOcurrenciaTag(int ocurrenciaTag) {
        this.ocurrenciaTag = ocurrenciaTag;
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
        hash += (idTag != null ? idTag.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tag)) {
            return false;
        }
        Tag other = (Tag) object;
        if ((this.idTag == null && other.idTag != null) || (this.idTag != null && !this.idTag.equals(other.idTag))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tag[ idTag=" + idTag + " ]";
    }
    
}
