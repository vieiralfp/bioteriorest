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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Idaf
 */
@Entity
@Table(name = "laboratorioraiva.municipios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Municipios.findAll", query = "SELECT m FROM Municipios m")
    , @NamedQuery(name = "Municipios.findById", query = "SELECT m FROM Municipios m WHERE m.id = :id")
    , @NamedQuery(name = "Municipios.findByCentrocoord", query = "SELECT m FROM Municipios m WHERE m.centrocoord = :centrocoord")
    , @NamedQuery(name = "Municipios.findByCoordenadas", query = "SELECT m FROM Municipios m WHERE m.coordenadas = :coordenadas")
    , @NamedQuery(name = "Municipios.findByEstado", query = "SELECT m FROM Municipios m WHERE m.estado = :estado")})
public class Municipios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "centrocoord")
    private String centrocoord;
    @Size(max = 2147483647)
    @Column(name = "coordenadas")
    private String coordenadas;
    @Size(max = 2)
    @Column(name = "estado")
    private String estado;
    @Lob
    @Column(name = "municipio", columnDefinition = "citext")
    private String municipio;
    @Lob
    @Column(name = "regional")
    private String regional;
    @OneToMany(mappedBy = "cidadeid")
    private List<Remetente> remetenteCollection;
    @OneToMany(mappedBy = "municipioid")
    private List<Principal> principalCollection;

    public Municipios() {
    }

    public Municipios(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCentrocoord() {
        return centrocoord;
    }

    public void setCentrocoord(String centrocoord) {
        this.centrocoord = centrocoord;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getRegional() {
        return regional;
    }

    public void setRegional(String regional) {
        this.regional = regional;
    }



    @XmlTransient    @JsonIgnore
    public List<Remetente> getRemetenteCollection() {
        return remetenteCollection;
    }

    public void setRemetenteCollection(List<Remetente> remetenteCollection) {
        this.remetenteCollection = remetenteCollection;
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
        if (!(object instanceof Municipios)) {
            return false;
        }
        Municipios other = (Municipios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Municipios[ id=" + id + " ]";
    }
    
}
