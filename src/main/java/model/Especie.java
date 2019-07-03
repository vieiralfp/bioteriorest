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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.eclipse.persistence.annotations.Index;

/**
 *
 * @author Idaf
 */
@Entity
@Table(name = "laboratorioraiva.especie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Especie.findAll", query = "SELECT e FROM Especie e")
    , @NamedQuery(name = "Especie.findById", query = "SELECT e FROM Especie e WHERE e.id = :id")
    , @NamedQuery(name = "Especie.findBySivcont", query = "SELECT e FROM Especie e WHERE e.sivcont = :sivcont")})
public class Especie implements Serializable {

    private static final long serialVersionUID = 1L;
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Index
    @Column(name = "especie", columnDefinition = "citext", unique = true)
    private String especie;
    @Column (name = "sivcont")
    private boolean sivcont;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,  mappedBy = "especieid")
    @OrderBy("raca")
    private List<Racas> racaslist;

    public Especie() {
    }

    public Especie(Integer id) {
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

    public Boolean getSivcont() {
        return sivcont;
    }

    public void setSivcont(Boolean sivcont) {
        this.sivcont = sivcont;
    }

    public boolean isSivcont() {
        return sivcont;
    }

    public void setSivcont(boolean sivcont) {
        this.sivcont = sivcont;
    }

    @JsonIgnore
    public List<Racas> getRacaslist() {
        return racaslist;
    }

    public void setRacaslist(List<Racas> racaslist) {
        this.racaslist = racaslist;
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
        if (!(object instanceof Especie)) {
            return false;
        }
        Especie other = (Especie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Especie[ id=" + id + " ]";
    }
    
}
