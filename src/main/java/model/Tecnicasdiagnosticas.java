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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Idaf
 */
@Entity
@Table(name = "laboratorioraiva.tecnicasdiagnosticas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tecnicasdiagnosticas.findAll", query = "SELECT t FROM Tecnicasdiagnosticas t")
    , @NamedQuery(name = "Tecnicasdiagnosticas.findById", query = "SELECT t FROM Tecnicasdiagnosticas t WHERE t.id = :id")})
public class Tecnicasdiagnosticas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Lob
    @Column(name = "tecnica", columnDefinition = "citext")
    private String tecnica;

    public Tecnicasdiagnosticas() {
    }

    public Tecnicasdiagnosticas(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTecnica() {
        return tecnica;
    }

    public void setTecnica(String tecnica) {
        this.tecnica = tecnica;
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
        if (!(object instanceof Tecnicasdiagnosticas)) {
            return false;
        }
        Tecnicasdiagnosticas other = (Tecnicasdiagnosticas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tecnicasdiagnosticas[ id=" + id + " ]";
    }
    
}
