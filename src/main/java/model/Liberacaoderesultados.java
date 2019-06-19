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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Idaf
 */
@Entity
@Table(name = "laboratorioraiva.liberacaoderesultados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Liberacaoderesultados.findAll", query = "SELECT l FROM Liberacaoderesultados l")
    , @NamedQuery(name = "Liberacaoderesultados.findById", query = "SELECT l FROM Liberacaoderesultados l WHERE l.id = :id")
    , @NamedQuery(name = "Liberacaoderesultados.findByDatalibrecao", query = "SELECT l FROM Liberacaoderesultados l WHERE l.datalibrecao = :datalibrecao")
    , @NamedQuery(name = "Liberacaoderesultados.findByEmails", query = "SELECT l FROM Liberacaoderesultados l WHERE l.emails = :emails")
    , @NamedQuery(name = "Liberacaoderesultados.findByFormalibercao", query = "SELECT l FROM Liberacaoderesultados l WHERE l.formalibercao = :formalibercao")
    , @NamedQuery(name = "Liberacaoderesultados.findByRecebedores", query = "SELECT l FROM Liberacaoderesultados l WHERE l.recebedores = :recebedores")
    , @NamedQuery(name = "Liberacaoderesultados.findByRecebido", query = "SELECT l FROM Liberacaoderesultados l WHERE l.recebido = :recebido")
    , @NamedQuery(name = "Liberacaoderesultados.findByTiporesultado", query = "SELECT l FROM Liberacaoderesultados l WHERE l.tiporesultado = :tiporesultado")})
public class Liberacaoderesultados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "datalibrecao")
    @Temporal(TemporalType.DATE)
    private Date datalibrecao;
    @Size(max = 2147483647)
    @Column(name = "emails")
    private String emails;
    @Size(max = 255)
    @Column(name = "formalibercao")
    private String formalibercao;
    @Size(max = 2147483647)
    @Column(name = "recebedores")
    private String recebedores;
    @Column(name = "recebido")
    private Boolean recebido;
    @Size(max = 255)
    @Column(name = "tiporesultado")
    private String tiporesultado;
    @JoinColumn(name = "responsavelenvio", referencedColumnName = "id")
    @ManyToOne
    private Login responsavelenvio;
    @JoinColumn(name = "principal", referencedColumnName = "id")
    @ManyToOne
    private Principal principal;

    public Liberacaoderesultados() {
    }

    public Liberacaoderesultados(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatalibrecao() {
        return datalibrecao;
    }

    public void setDatalibrecao(Date datalibrecao) {
        this.datalibrecao = datalibrecao;
    }

    public String getEmails() {
        return emails;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

    public String getFormalibercao() {
        return formalibercao;
    }

    public void setFormalibercao(String formalibercao) {
        this.formalibercao = formalibercao;
    }

    public String getRecebedores() {
        return recebedores;
    }

    public void setRecebedores(String recebedores) {
        this.recebedores = recebedores;
    }

    public Boolean getRecebido() {
        return recebido;
    }

    public void setRecebido(Boolean recebido) {
        this.recebido = recebido;
    }

    public String getTiporesultado() {
        return tiporesultado;
    }

    public void setTiporesultado(String tiporesultado) {
        this.tiporesultado = tiporesultado;
    }

    public Login getResponsavelenvio() {
        return responsavelenvio;
    }

    public void setResponsavelenvio(Login responsavelenvio) {
        this.responsavelenvio = responsavelenvio;
    }

    public Principal getPrincipal() {
        return principal;
    }

    public void setPrincipal(Principal principal) {
        this.principal = principal;
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
        if (!(object instanceof Liberacaoderesultados)) {
            return false;
        }
        Liberacaoderesultados other = (Liberacaoderesultados) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Liberacaoderesultados[ id=" + id + " ]";
    }
    
}
