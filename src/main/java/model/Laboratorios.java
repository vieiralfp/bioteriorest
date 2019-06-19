/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Idaf
 */
@Entity
@Table(name = "laboratorioraiva.laboratorios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Laboratorios.findAll", query = "SELECT l FROM Laboratorios l")
    , @NamedQuery(name = "Laboratorios.findById", query = "SELECT l FROM Laboratorios l WHERE l.id = :id")
    , @NamedQuery(name = "Laboratorios.findByEstado", query = "SELECT l FROM Laboratorios l WHERE l.estado = :estado")})
public class Laboratorios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "estado")
    private String estado;
    @Lob
    @Column(name = "nomelaboratorio", columnDefinition = "citext")
    private String nomelaboratorio;

    public Laboratorios() {
    }

    public Laboratorios(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNomelaboratorio() {
        return nomelaboratorio;
    }

    public void setNomelaboratorio(String nomelaboratorio) {
        this.nomelaboratorio = nomelaboratorio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Laboratorios)) {
            return false;
        }
        Laboratorios other = (Laboratorios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Laboratorios[ id=" + id + " ]";
    }
    
}
