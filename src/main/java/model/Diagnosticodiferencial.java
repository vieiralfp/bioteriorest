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
@Table(name = "laboratorioraiva.diagnosticodiferencial")
@XmlRootElement
public class Diagnosticodiferencial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "dataenvio")
    @Temporal(TemporalType.DATE)
    private Date dataenvio;
    @Column(name = "resultado")
    private String resultado;
    @Column(name = "datarecebimento")
    @Temporal(TemporalType.DATE)
    private Date datarecebimento;
    @Column (name="laboratorio")
    private String laboratorio;
    @Column (name="dataresultado")
    @Temporal(TemporalType.DATE)
    private Date dataresultado;
    @Column (name="tecnica")
    private String tecnica;
    @Column (name = "naoenvio")
    private boolean naoenvio;
    @Size(max = 2147483647)
    @Column (name = "justificativa")
    private String justiticativa;
    @ManyToOne
    @JoinColumn(name = "id_principal", referencedColumnName = "registro")    
    private Principal idprincipal;
    @ManyToOne
    @JoinColumn(name = "diferencial", referencedColumnName = "id")
    private Diferencial diferencial;

    public Diagnosticodiferencial() {
    }

    public Diagnosticodiferencial(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataenvio() {
        return dataenvio;
    }

    public void setDataenvio(Date dataenvio) {
        this.dataenvio = dataenvio;
    }

    public Date getDatarecebimento() {
        return datarecebimento;
    }

    public void setDatarecebimento(Date datarecebimento) {
        this.datarecebimento = datarecebimento;
    }

    public Date getDataresultado() {
        return dataresultado;
    }

    public void setDataresultado(Date dataresultado) {
        this.dataresultado = dataresultado;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public Boolean getNaoenvio() {
        return naoenvio;
    }

    public void setNaoenvio(Boolean naoenvio) {
        this.naoenvio = naoenvio;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getTecnica() {
        return tecnica;
    }

    public void setTecnica(String tecnica) {
        this.tecnica = tecnica;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Diferencial getDiferencial() {
        return diferencial;
    }

    public void setDiferencial(Diferencial diferencial) {
        this.diferencial = diferencial;
    }

    public boolean isNaoenvio() {
        return naoenvio;
    }

    public void setNaoenvio(boolean naoenvio) {
        this.naoenvio = naoenvio;
    }

    public String getJustiticativa() {
        return justiticativa;
    }

    public void setJustiticativa(String justiticativa) {
        this.justiticativa = justiticativa;
    }

    public Principal getIdprincipal() {
        return idprincipal;
    }

    public void setIdprincipal(Principal idprincipal) {
        this.idprincipal = idprincipal;
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
        if (!(object instanceof Diagnosticodiferencial)) {
            return false;
        }
        Diagnosticodiferencial other = (Diagnosticodiferencial) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Diagnosticodiferencial[ id=" + id + " ]";
    }
    
}
