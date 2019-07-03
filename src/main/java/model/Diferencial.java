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
@Table(name = "laboratorioraiva.diferencial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diferencial.findAll", query = "SELECT d FROM Diferencial d")
    , @NamedQuery(name = "Diferencial.findById", query = "SELECT d FROM Diferencial d WHERE d.id = :id")})
public class Diferencial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "doenca", columnDefinition = "citext", unique = true)
    private String doenca;
    @OneToMany(mappedBy = "diferencial")
    private List<Diagnosticodiferencial> listDiagnosticodiferencial;

    public Diferencial() {
    }

    public Diferencial(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDoenca() {
        return doenca;
    }

    public void setDoenca(String doenca) {
        this.doenca = doenca;
    }

    @XmlTransient    @JsonIgnore
    public List<Diagnosticodiferencial> getListDiagnosticodiferencial() {
        return listDiagnosticodiferencial;
    }

    public void setListDiagnosticodiferencial(List<Diagnosticodiferencial> listDiagnosticodiferencial) {
        this.listDiagnosticodiferencial = listDiagnosticodiferencial;
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
        if (!(object instanceof Diferencial)) {
            return false;
        }
        Diferencial other = (Diferencial) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Diferencial[ id=" + id + " ]";
    }
    
}
