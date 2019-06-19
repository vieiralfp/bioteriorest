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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "laboratorioraiva.racas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Racas.findAll", query = "SELECT r FROM Racas r")
    , @NamedQuery(name = "Racas.findById", query = "SELECT r FROM Racas r WHERE r.id = :id")})
public class Racas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Lob
    @Column(name = "raca", columnDefinition = "citext")
    private String raca;
    @OneToMany(mappedBy = "racaid")
    private List<Principal> principalCollection;
    @JoinColumn(name = "especie", referencedColumnName = "especie")
    @ManyToOne
    private Especie especie;
    @JoinColumn(name = "especieid", referencedColumnName = "id")
    @ManyToOne
    private Especie especieid;

    public Racas() {
    }

    public Racas(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    @XmlTransient    @JsonIgnore
    public List<Principal> getPrincipalCollection() {
        return principalCollection;
    }

    public void setPrincipalCollection(List<Principal> principalCollection) {
        this.principalCollection = principalCollection;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public Especie getEspecieid() {
        return especieid;
    }

    public void setEspecieid(Especie especieid) {
        this.especieid = especieid;
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
        if (!(object instanceof Racas)) {
            return false;
        }
        Racas other = (Racas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Racas[ id=" + id + " ]";
    }
    
}
