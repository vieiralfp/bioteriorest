/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Idaf
 */
@Entity
@Table(name = "laboratorioraiva.especiemorcego")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Especiemorcego.findAll", query = "SELECT e FROM Especiemorcego e")
    , @NamedQuery(name = "Especiemorcego.findById", query = "SELECT e FROM Especiemorcego e WHERE e.id = :id")})
public class Especiemorcego implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Lob
    @Column(name = "especie", columnDefinition = "citext")
    private String especie;
    @OneToMany(mappedBy = "especiemorcegoid")
    private List<Principal> principalCollection;

    public Especiemorcego() {
    }

    public Especiemorcego(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }


    @XmlTransient    @JsonIgnore
    public List<Principal> getPrincipalCollection() {
        return principalCollection;
    }

    public void setPrincipalCollection(List<Principal> principalCollection) {
        this.principalCollection = principalCollection;
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
        if (!(object instanceof Especiemorcego)) {
            return false;
        }
        Especiemorcego other = (Especiemorcego) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Especiemorcego[ id=" + id + " ]";
    }
    
}
