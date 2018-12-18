/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaf.bioterio.banco.model;

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
import javax.persistence.ManyToOne;
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
@Table(name = "laboratorioraiva.remetente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Remetente.findAll", query = "SELECT r FROM Remetente r")
    , @NamedQuery(name = "Remetente.findById", query = "SELECT r FROM Remetente r WHERE r.id = :id")
    , @NamedQuery(name = "Remetente.findByApenasdestinatario", query = "SELECT r FROM Remetente r WHERE r.apenasdestinatario = :apenasdestinatario")
    , @NamedQuery(name = "Remetente.findByBairro", query = "SELECT r FROM Remetente r WHERE r.bairro = :bairro")
    , @NamedQuery(name = "Remetente.findByCep", query = "SELECT r FROM Remetente r WHERE r.cep = :cep")
    , @NamedQuery(name = "Remetente.findByEmail1", query = "SELECT r FROM Remetente r WHERE r.email1 = :email1")
    , @NamedQuery(name = "Remetente.findByEmail2", query = "SELECT r FROM Remetente r WHERE r.email2 = :email2")
    , @NamedQuery(name = "Remetente.findByEndereco", query = "SELECT r FROM Remetente r WHERE r.endereco = :endereco")
    , @NamedQuery(name = "Remetente.findByObsservacoes", query = "SELECT r FROM Remetente r WHERE r.obsservacoes = :obsservacoes")
    , @NamedQuery(name = "Remetente.findByTelefone1", query = "SELECT r FROM Remetente r WHERE r.telefone1 = :telefone1")
    , @NamedQuery(name = "Remetente.findByTelefone2", query = "SELECT r FROM Remetente r WHERE r.telefone2 = :telefone2")})
public class Remetente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "apenasdestinatario")
    private Boolean apenasdestinatario;
    @Size(max = 255)
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "cep")
    private Integer cep;
    @Size(max = 255)
    @Column(name = "email1")
    private String email1;
    @Size(max = 255)
    @Column(name = "email2")
    private String email2;
    @Size(max = 255)
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "nome", columnDefinition = "citext")
    private String nome;
    @Size(max = 255)
    @Column(name = "obsservacoes")
    private String obsservacoes;
    @Size(max = 255)
    @Column(name = "telefone1")
    private String telefone1;
    @Size(max = 255)
    @Column(name = "telefone2")
    private String telefone2;
    @JoinColumn(name = "cidadeid", referencedColumnName = "id")
    @ManyToOne
    private Municipios cidadeid;
    @OneToMany(mappedBy = "remetente")
    private List<Emails> emailsCollection;
    @OneToMany(mappedBy = "remetenteid")
    private List<Principal> principalCollection;

    public Remetente() {
    }

    public Remetente(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getApenasdestinatario() {
        return apenasdestinatario;
    }

    public void setApenasdestinatario(Boolean apenasdestinatario) {
        this.apenasdestinatario = apenasdestinatario;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getObsservacoes() {
        return obsservacoes;
    }

    public void setObsservacoes(String obsservacoes) {
        this.obsservacoes = obsservacoes;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public Municipios getCidadeid() {
        return cidadeid;
    }

    public void setCidadeid(Municipios cidadeid) {
        this.cidadeid = cidadeid;
    }

    @XmlTransient    @JsonIgnore
    public List<Emails> getEmailsCollection() {
        return emailsCollection;
    }

    public void setEmailsCollection(List<Emails> emailsCollection) {
        this.emailsCollection = emailsCollection;
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
        if (!(object instanceof Remetente)) {
            return false;
        }
        Remetente other = (Remetente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "idaf.bioterio.banco.model.Remetente[ id=" + id + " ]";
    }
    
}
