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
@Table(name = "auditoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Auditoria.findAll", query = "SELECT a FROM Auditoria a"),
    @NamedQuery(name = "Auditoria.findByIdAuditoria", query = "SELECT a FROM Auditoria a WHERE a.idAuditoria = :idAuditoria"),
    @NamedQuery(name = "Auditoria.findByIdUsuario", query = "SELECT a FROM Auditoria a WHERE a.idUsuario = :idUsuario"),
    @NamedQuery(name = "Auditoria.findByIdUsuarioDB", query = "SELECT a FROM Auditoria a WHERE a.idUsuarioDB = :idUsuarioDB"),
    @NamedQuery(name = "Auditoria.findByTabla", query = "SELECT a FROM Auditoria a WHERE a.tabla = :tabla"),
    @NamedQuery(name = "Auditoria.findByFila", query = "SELECT a FROM Auditoria a WHERE a.fila = :fila"),
    @NamedQuery(name = "Auditoria.findByCampo", query = "SELECT a FROM Auditoria a WHERE a.campo = :campo"),
    @NamedQuery(name = "Auditoria.findByAccion", query = "SELECT a FROM Auditoria a WHERE a.accion = :accion"),
    @NamedQuery(name = "Auditoria.findByOldValue", query = "SELECT a FROM Auditoria a WHERE a.oldValue = :oldValue"),
    @NamedQuery(name = "Auditoria.findByNewValue", query = "SELECT a FROM Auditoria a WHERE a.newValue = :newValue"),
    @NamedQuery(name = "Auditoria.findByTimestampAudi", query = "SELECT a FROM Auditoria a WHERE a.timestampAudi = :timestampAudi")})
public class Auditoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAuditoria")
    private Integer idAuditoria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idUsuario")
    private int idUsuario;
    @Size(max = 30)
    @Column(name = "idUsuario_DB")
    private String idUsuarioDB;
    @Size(max = 30)
    @Column(name = "tabla")
    private String tabla;
    @Column(name = "fila")
    private Integer fila;
    @Size(max = 30)
    @Column(name = "campo")
    private String campo;
    @Size(max = 10)
    @Column(name = "accion")
    private String accion;
    @Size(max = 120)
    @Column(name = "old_value")
    private String oldValue;
    @Size(max = 120)
    @Column(name = "new_value")
    private String newValue;
    @Column(name = "timestamp_audi")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestampAudi;

    public Auditoria() {
    }

    public Auditoria(Integer idAuditoria) {
        this.idAuditoria = idAuditoria;
    }

    public Auditoria(Integer idAuditoria, int idUsuario) {
        this.idAuditoria = idAuditoria;
        this.idUsuario = idUsuario;
    }

    public Integer getIdAuditoria() {
        return idAuditoria;
    }

    public void setIdAuditoria(Integer idAuditoria) {
        this.idAuditoria = idAuditoria;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdUsuarioDB() {
        return idUsuarioDB;
    }

    public void setIdUsuarioDB(String idUsuarioDB) {
        this.idUsuarioDB = idUsuarioDB;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public Integer getFila() {
        return fila;
    }

    public void setFila(Integer fila) {
        this.fila = fila;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    public Date getTimestampAudi() {
        return timestampAudi;
    }

    public void setTimestampAudi(Date timestampAudi) {
        this.timestampAudi = timestampAudi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAuditoria != null ? idAuditoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auditoria)) {
            return false;
        }
        Auditoria other = (Auditoria) object;
        if ((this.idAuditoria == null && other.idAuditoria != null) || (this.idAuditoria != null && !this.idAuditoria.equals(other.idAuditoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Auditoria[ idAuditoria=" + idAuditoria + " ]";
    }
    
}
