/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaf.bioterio.banco.model;

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
@Table(name = "laboratorioraiva.liberacaoderelatoriodeensaio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Liberacaoderelatoriodeensaio.findAll", query = "SELECT l FROM Liberacaoderelatoriodeensaio l")
    , @NamedQuery(name = "Liberacaoderelatoriodeensaio.findById", query = "SELECT l FROM Liberacaoderelatoriodeensaio l WHERE l.id = :id")
    , @NamedQuery(name = "Liberacaoderelatoriodeensaio.findByDatalibrecao", query = "SELECT l FROM Liberacaoderelatoriodeensaio l WHERE l.datalibrecao = :datalibrecao")
    , @NamedQuery(name = "Liberacaoderelatoriodeensaio.findByEmails", query = "SELECT l FROM Liberacaoderelatoriodeensaio l WHERE l.emails = :emails")
    , @NamedQuery(name = "Liberacaoderelatoriodeensaio.findByFormalibercao", query = "SELECT l FROM Liberacaoderelatoriodeensaio l WHERE l.formalibercao = :formalibercao")
    , @NamedQuery(name = "Liberacaoderelatoriodeensaio.findByRecebedores", query = "SELECT l FROM Liberacaoderelatoriodeensaio l WHERE l.recebedores = :recebedores")
    , @NamedQuery(name = "Liberacaoderelatoriodeensaio.findByRecebido", query = "SELECT l FROM Liberacaoderelatoriodeensaio l WHERE l.recebido = :recebido")})
public class Liberacaoderelatoriodeensaio implements Serializable {

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
    @JoinColumn(name = "responsavelenvio", referencedColumnName = "id")
    @ManyToOne
    private Login responsavelenvio;
    @JoinColumn(name = "relatorioensaio_id", referencedColumnName = "id")
    @ManyToOne
    private Relatorioensaio relatorioensaioId;

    public Liberacaoderelatoriodeensaio() {
    }

    public Liberacaoderelatoriodeensaio(Integer id) {
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

    public Login getResponsavelenvio() {
        return responsavelenvio;
    }

    public void setResponsavelenvio(Login responsavelenvio) {
        this.responsavelenvio = responsavelenvio;
    }

    public Relatorioensaio getRelatorioensaioId() {
        return relatorioensaioId;
    }

    public void setRelatorioensaioId(Relatorioensaio relatorioensaioId) {
        this.relatorioensaioId = relatorioensaioId;
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
        if (!(object instanceof Liberacaoderelatoriodeensaio)) {
            return false;
        }
        Liberacaoderelatoriodeensaio other = (Liberacaoderelatoriodeensaio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "idaf.bioterio.banco.model.Liberacaoderelatoriodeensaio[ id=" + id + " ]";
    }
    
}
