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
@Table(name = "laboratorioraiva.login")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Login.findAll", query = "SELECT l FROM Login l")
    , @NamedQuery(name = "Login.findById", query = "SELECT l FROM Login l WHERE l.id = :id")
    , @NamedQuery(name = "Login.findByAtivo", query = "SELECT l FROM Login l WHERE l.ativo = :ativo")
    , @NamedQuery(name = "Login.findByCrmv", query = "SELECT l FROM Login l WHERE l.crmv = :crmv")
    , @NamedQuery(name = "Login.findByNomearquivo", query = "SELECT l FROM Login l WHERE l.nomearquivo = :nomearquivo")
    , @NamedQuery(name = "Login.findBySenha", query = "SELECT l FROM Login l WHERE l.senha = :senha")})
public class Login implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Lob
    @Column(name = "assinatura")
    private byte[] assinatura;
    @Column(name = "ativo")
    private Boolean ativo;
    @Size(max = 255)
    @Column(name = "crmv")
    private String crmv;
    @Lob
    @Column(name = "login", columnDefinition = "citext")
    private String login;
    @Lob
    @Column(name = "nome", columnDefinition = "citext")
    private String nome;
    @Size(max = 255)
    @Column(name = "nomearquivo")
    private String nomearquivo;
    @Size(max = 255)
    @Column(name = "senha")
    private String senha;
    @Lob
    @Column(name = "tipousuario", columnDefinition = "citext")
    private String tipousuario;
    @OneToMany(mappedBy = "responsavelenvio")
    private List<Liberacaoderelatoriodeensaio> liberacaoderelatoriodeensaioCollection;
    @OneToMany(mappedBy = "recebeuid")
    private List<Principal> principalCollection;
    @OneToMany(mappedBy = "ultimousuario")
    private List<Principal> principalCollection1;
    @OneToMany(mappedBy = "veterinarioresponsavel1")
    private List<Principal> principalCollection2;
    @OneToMany(mappedBy = "veterinarioresponsavel2")
    private List<Principal> principalCollection3;
    @OneToMany(mappedBy = "login")
    private List<Emailsaida> emailsaidaCollection;
    @OneToMany(mappedBy = "assinoulaudoId")
    private List<Relatorioensaio> relatorioensaioCollection;
    @OneToMany(mappedBy = "responsavelenvio")
    private List<Liberacaoderesultados> liberacaoderesultadosCollection;

    public Login() {
    }

    public Login(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getAssinatura() {
        return assinatura;
    }

    public void setAssinatura(byte[] assinatura) {
        this.assinatura = assinatura;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getCrmv() {
        return crmv;
    }

    public void setCrmv(String crmv) {
        this.crmv = crmv;
    }



    public String getNomearquivo() {
        return nomearquivo;
    }

    public void setNomearquivo(String nomearquivo) {
        this.nomearquivo = nomearquivo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(String tipousuario) {
        this.tipousuario = tipousuario;
    }


    @XmlTransient    
    @JsonIgnore
    public List<Liberacaoderelatoriodeensaio> getLiberacaoderelatoriodeensaioCollection() {
        return liberacaoderelatoriodeensaioCollection;
    }

    public void setLiberacaoderelatoriodeensaioCollection(List<Liberacaoderelatoriodeensaio> liberacaoderelatoriodeensaioCollection) {
        this.liberacaoderelatoriodeensaioCollection = liberacaoderelatoriodeensaioCollection;
    }

    @XmlTransient    @JsonIgnore
    public List<Principal> getPrincipalCollection() {
        return principalCollection;
    }

    public void setPrincipalCollection(List<Principal> principalCollection) {
        this.principalCollection = principalCollection;
    }

    @XmlTransient    @JsonIgnore
    public List<Principal> getPrincipalCollection1() {
        return principalCollection1;
    }

    public void setPrincipalCollection1(List<Principal> principalCollection1) {
        this.principalCollection1 = principalCollection1;
    }

    @XmlTransient    @JsonIgnore
    public List<Principal> getPrincipalCollection2() {
        return principalCollection2;
    }

    public void setPrincipalCollection2(List<Principal> principalCollection2) {
        this.principalCollection2 = principalCollection2;
    }

    @XmlTransient    @JsonIgnore
    public List<Principal> getPrincipalCollection3() {
        return principalCollection3;
    }

    public void setPrincipalCollection3(List<Principal> principalCollection3) {
        this.principalCollection3 = principalCollection3;
    }

    @XmlTransient    @JsonIgnore
    public List<Emailsaida> getEmailsaidaCollection() {
        return emailsaidaCollection;
    }

    public void setEmailsaidaCollection(List<Emailsaida> emailsaidaCollection) {
        this.emailsaidaCollection = emailsaidaCollection;
    }

    @XmlTransient    @JsonIgnore
    public List<Relatorioensaio> getRelatorioensaioCollection() {
        return relatorioensaioCollection;
    }

    public void setRelatorioensaioCollection(List<Relatorioensaio> relatorioensaioCollection) {
        this.relatorioensaioCollection = relatorioensaioCollection;
    }

    @XmlTransient    @JsonIgnore
    public List<Liberacaoderesultados> getLiberacaoderesultadosCollection() {
        return liberacaoderesultadosCollection;
    }

    public void setLiberacaoderesultadosCollection(List<Liberacaoderesultados> liberacaoderesultadosCollection) {
        this.liberacaoderesultadosCollection = liberacaoderesultadosCollection;
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
        if (!(object instanceof Login)) {
            return false;
        }
        Login other = (Login) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Login[ id=" + id + " ]";
    }
    
}
