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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Idaf
 */
@Entity
@Table(name = "laboratorioraiva.emailsaida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Emailsaida.findAll", query = "SELECT e FROM Emailsaida e")
    , @NamedQuery(name = "Emailsaida.findById", query = "SELECT e FROM Emailsaida e WHERE e.id = :id")
    , @NamedQuery(name = "Emailsaida.findByAssinatura", query = "SELECT e FROM Emailsaida e WHERE e.assinatura = :assinatura")
    , @NamedQuery(name = "Emailsaida.findByNome", query = "SELECT e FROM Emailsaida e WHERE e.nome = :nome")
    , @NamedQuery(name = "Emailsaida.findByPortasmtp", query = "SELECT e FROM Emailsaida e WHERE e.portasmtp = :portasmtp")
    , @NamedQuery(name = "Emailsaida.findBySenha", query = "SELECT e FROM Emailsaida e WHERE e.senha = :senha")
    , @NamedQuery(name = "Emailsaida.findBySmtphost", query = "SELECT e FROM Emailsaida e WHERE e.smtphost = :smtphost")
    , @NamedQuery(name = "Emailsaida.findByTipoconexao", query = "SELECT e FROM Emailsaida e WHERE e.tipoconexao = :tipoconexao")
    , @NamedQuery(name = "Emailsaida.findByUsername", query = "SELECT e FROM Emailsaida e WHERE e.username = :username")
    , @NamedQuery(name = "Emailsaida.findByPalavrachave", query = "SELECT e FROM Emailsaida e WHERE e.palavrachave = :palavrachave")
    , @NamedQuery(name = "Emailsaida.findByImaphost", query = "SELECT e FROM Emailsaida e WHERE e.imaphost = :imaphost")
    , @NamedQuery(name = "Emailsaida.findByPortimap", query = "SELECT e FROM Emailsaida e WHERE e.portimap = :portimap")
    , @NamedQuery(name = "Emailsaida.findBySalvarenviado", query = "SELECT e FROM Emailsaida e WHERE e.salvarenviado = :salvarenviado")
    , @NamedQuery(name = "Emailsaida.findByTipoconexaoimap", query = "SELECT e FROM Emailsaida e WHERE e.tipoconexaoimap = :tipoconexaoimap")})
public class Emailsaida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "assinatura")
    private String assinatura;
    @Size(max = 255)
    @Column(name = "nome")
    private String nome;
    @Size(max = 255)
    @Column(name = "portasmtp")
    private String portasmtp;
    @Size(max = 255)
    @Column(name = "senha")
    private String senha;
    @Size(max = 255)
    @Column(name = "smtphost")
    private String smtphost;
    @Size(max = 255)
    @Column(name = "tipoconexao")
    private String tipoconexao;
    @Size(max = 255)
    @Column(name = "username")
    private String username;
    @Size(max = 2147483647)
    @Column(name = "palavrachave")
    private String palavrachave;
    @Size(max = 255)
    @Column(name = "imaphost")
    private String imaphost;
    @Size(max = 255)
    @Column(name = "portimap")
    private String portimap;
    @Column(name = "salvarenviado")
    private Boolean salvarenviado;
    @Size(max = 255)
    @Column(name = "tipoconexaoimap")
    private String tipoconexaoimap;
    @JoinColumn(name = "login", referencedColumnName = "id")
    @ManyToOne
    private Login login;

    public Emailsaida() {
    }

    public Emailsaida(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAssinatura() {
        return assinatura;
    }

    public void setAssinatura(String assinatura) {
        this.assinatura = assinatura;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPortasmtp() {
        return portasmtp;
    }

    public void setPortasmtp(String portasmtp) {
        this.portasmtp = portasmtp;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSmtphost() {
        return smtphost;
    }

    public void setSmtphost(String smtphost) {
        this.smtphost = smtphost;
    }

    public String getTipoconexao() {
        return tipoconexao;
    }

    public void setTipoconexao(String tipoconexao) {
        this.tipoconexao = tipoconexao;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPalavrachave() {
        return palavrachave;
    }

    public void setPalavrachave(String palavrachave) {
        this.palavrachave = palavrachave;
    }

    public String getImaphost() {
        return imaphost;
    }

    public void setImaphost(String imaphost) {
        this.imaphost = imaphost;
    }

    public String getPortimap() {
        return portimap;
    }

    public void setPortimap(String portimap) {
        this.portimap = portimap;
    }

    public Boolean getSalvarenviado() {
        return salvarenviado;
    }

    public void setSalvarenviado(Boolean salvarenviado) {
        this.salvarenviado = salvarenviado;
    }

    public String getTipoconexaoimap() {
        return tipoconexaoimap;
    }

    public void setTipoconexaoimap(String tipoconexaoimap) {
        this.tipoconexaoimap = tipoconexaoimap;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
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
        if (!(object instanceof Emailsaida)) {
            return false;
        }
        Emailsaida other = (Emailsaida) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Emailsaida[ id=" + id + " ]";
    }
    
}
