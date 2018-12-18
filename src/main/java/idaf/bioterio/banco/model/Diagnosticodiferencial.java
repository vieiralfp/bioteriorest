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
@Table(name = "laboratorioraiva.diagnosticodiferencial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diagnosticodiferencial.findAll", query = "SELECT d FROM Diagnosticodiferencial d")
    , @NamedQuery(name = "Diagnosticodiferencial.findById", query = "SELECT d FROM Diagnosticodiferencial d WHERE d.id = :id")
    , @NamedQuery(name = "Diagnosticodiferencial.findByDataenvio", query = "SELECT d FROM Diagnosticodiferencial d WHERE d.dataenvio = :dataenvio")
    , @NamedQuery(name = "Diagnosticodiferencial.findByDatarecebimento", query = "SELECT d FROM Diagnosticodiferencial d WHERE d.datarecebimento = :datarecebimento")
    , @NamedQuery(name = "Diagnosticodiferencial.findByDataresultado", query = "SELECT d FROM Diagnosticodiferencial d WHERE d.dataresultado = :dataresultado")
    , @NamedQuery(name = "Diagnosticodiferencial.findByJustificativa", query = "SELECT d FROM Diagnosticodiferencial d WHERE d.justificativa = :justificativa")
    , @NamedQuery(name = "Diagnosticodiferencial.findByLaboratorio", query = "SELECT d FROM Diagnosticodiferencial d WHERE d.laboratorio = :laboratorio")
    , @NamedQuery(name = "Diagnosticodiferencial.findByNaoenvio", query = "SELECT d FROM Diagnosticodiferencial d WHERE d.naoenvio = :naoenvio")
    , @NamedQuery(name = "Diagnosticodiferencial.findByResultado", query = "SELECT d FROM Diagnosticodiferencial d WHERE d.resultado = :resultado")
    , @NamedQuery(name = "Diagnosticodiferencial.findByTecnica", query = "SELECT d FROM Diagnosticodiferencial d WHERE d.tecnica = :tecnica")
    , @NamedQuery(name = "Diagnosticodiferencial.findByTipo", query = "SELECT d FROM Diagnosticodiferencial d WHERE d.tipo = :tipo")})
public class Diagnosticodiferencial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "dataenvio")
    @Temporal(TemporalType.DATE)
    private Date dataenvio;
    @Column(name = "datarecebimento")
    @Temporal(TemporalType.DATE)
    private Date datarecebimento;
    @Column(name = "dataresultado")
    @Temporal(TemporalType.DATE)
    private Date dataresultado;
    @Size(max = 2147483647)
    @Column(name = "justificativa")
    private String justificativa;
    @Size(max = 255)
    @Column(name = "laboratorio")
    private String laboratorio;
    @Column(name = "naoenvio")
    private Boolean naoenvio;
    @Size(max = 255)
    @Column(name = "resultado")
    private String resultado;
    @Size(max = 255)
    @Column(name = "tecnica")
    private String tecnica;
    @Size(max = 255)
    @Column(name = "tipo")
    private String tipo;
    @JoinColumn(name = "diferencial", referencedColumnName = "id")
    @ManyToOne
    private Diferencial diferencial;
    @JoinColumn(name = "id_principal", referencedColumnName = "registro")
    @ManyToOne
    private Principal idPrincipal;

    public Diagnosticodiferencial() {
    }

    public Diagnosticodiferencial(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
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

    public Principal getIdPrincipal() {
        return idPrincipal;
    }

    public void setIdPrincipal(Principal idPrincipal) {
        this.idPrincipal = idPrincipal;
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
        return "idaf.bioterio.banco.model.Diagnosticodiferencial[ id=" + id + " ]";
    }
    
}
