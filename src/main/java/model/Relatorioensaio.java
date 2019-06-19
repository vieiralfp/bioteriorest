/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Idaf
 */
@Entity
@Table(name = "laboratorioraiva.relatorioensaio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Relatorioensaio.findAll", query = "SELECT r FROM Relatorioensaio r")
    , @NamedQuery(name = "Relatorioensaio.findById", query = "SELECT r FROM Relatorioensaio r WHERE r.id = :id")
    , @NamedQuery(name = "Relatorioensaio.findByAno", query = "SELECT r FROM Relatorioensaio r WHERE r.ano = :ano")
    , @NamedQuery(name = "Relatorioensaio.findByCorrecao", query = "SELECT r FROM Relatorioensaio r WHERE r.correcao = :correcao")
    , @NamedQuery(name = "Relatorioensaio.findByDatacoleta", query = "SELECT r FROM Relatorioensaio r WHERE r.datacoleta = :datacoleta")
    , @NamedQuery(name = "Relatorioensaio.findByDataemissao", query = "SELECT r FROM Relatorioensaio r WHERE r.dataemissao = :dataemissao")
    , @NamedQuery(name = "Relatorioensaio.findByDataentrada", query = "SELECT r FROM Relatorioensaio r WHERE r.dataentrada = :dataentrada")
    , @NamedQuery(name = "Relatorioensaio.findByDataresultado1", query = "SELECT r FROM Relatorioensaio r WHERE r.dataresultado1 = :dataresultado1")
    , @NamedQuery(name = "Relatorioensaio.findByDataresultado2", query = "SELECT r FROM Relatorioensaio r WHERE r.dataresultado2 = :dataresultado2")
    , @NamedQuery(name = "Relatorioensaio.findByEndreco", query = "SELECT r FROM Relatorioensaio r WHERE r.endreco = :endreco")
    , @NamedQuery(name = "Relatorioensaio.findByEspecie", query = "SELECT r FROM Relatorioensaio r WHERE r.especie = :especie")
    , @NamedQuery(name = "Relatorioensaio.findByEstado", query = "SELECT r FROM Relatorioensaio r WHERE r.estado = :estado")
    , @NamedQuery(name = "Relatorioensaio.findByIdade", query = "SELECT r FROM Relatorioensaio r WHERE r.idade = :idade")
    , @NamedQuery(name = "Relatorioensaio.findByLiberadopor", query = "SELECT r FROM Relatorioensaio r WHERE r.liberadopor = :liberadopor")
    , @NamedQuery(name = "Relatorioensaio.findByLiberadoporcrmv", query = "SELECT r FROM Relatorioensaio r WHERE r.liberadoporcrmv = :liberadoporcrmv")
    , @NamedQuery(name = "Relatorioensaio.findByMaterialanalisado", query = "SELECT r FROM Relatorioensaio r WHERE r.materialanalisado = :materialanalisado")
    , @NamedQuery(name = "Relatorioensaio.findByMaterialanalisadopb", query = "SELECT r FROM Relatorioensaio r WHERE r.materialanalisadopb = :materialanalisadopb")
    , @NamedQuery(name = "Relatorioensaio.findByMunicipio", query = "SELECT r FROM Relatorioensaio r WHERE r.municipio = :municipio")
    , @NamedQuery(name = "Relatorioensaio.findByNumerolaudo", query = "SELECT r FROM Relatorioensaio r WHERE r.numerolaudo = :numerolaudo")
    , @NamedQuery(name = "Relatorioensaio.findByObservacoes1", query = "SELECT r FROM Relatorioensaio r WHERE r.observacoes1 = :observacoes1")
    , @NamedQuery(name = "Relatorioensaio.findByObservacoes2", query = "SELECT r FROM Relatorioensaio r WHERE r.observacoes2 = :observacoes2")
    , @NamedQuery(name = "Relatorioensaio.findByProprietario", query = "SELECT r FROM Relatorioensaio r WHERE r.proprietario = :proprietario")
    , @NamedQuery(name = "Relatorioensaio.findByRaca", query = "SELECT r FROM Relatorioensaio r WHERE r.raca = :raca")
    , @NamedQuery(name = "Relatorioensaio.findByRegistroamostra", query = "SELECT r FROM Relatorioensaio r WHERE r.registroamostra = :registroamostra")
    , @NamedQuery(name = "Relatorioensaio.findByRelatorioenviado", query = "SELECT r FROM Relatorioensaio r WHERE r.relatorioenviado = :relatorioenviado")
    , @NamedQuery(name = "Relatorioensaio.findByRemetente", query = "SELECT r FROM Relatorioensaio r WHERE r.remetente = :remetente")
    , @NamedQuery(name = "Relatorioensaio.findByResponsavel1", query = "SELECT r FROM Relatorioensaio r WHERE r.responsavel1 = :responsavel1")
    , @NamedQuery(name = "Relatorioensaio.findByResponsavel2", query = "SELECT r FROM Relatorioensaio r WHERE r.responsavel2 = :responsavel2")
    , @NamedQuery(name = "Relatorioensaio.findByResultado1", query = "SELECT r FROM Relatorioensaio r WHERE r.resultado1 = :resultado1")
    , @NamedQuery(name = "Relatorioensaio.findByResultado2", query = "SELECT r FROM Relatorioensaio r WHERE r.resultado2 = :resultado2")
    , @NamedQuery(name = "Relatorioensaio.findByResultadofinal", query = "SELECT r FROM Relatorioensaio r WHERE r.resultadofinal = :resultadofinal")
    , @NamedQuery(name = "Relatorioensaio.findBySexo", query = "SELECT r FROM Relatorioensaio r WHERE r.sexo = :sexo")
    , @NamedQuery(name = "Relatorioensaio.findByVersaocorrecao", query = "SELECT r FROM Relatorioensaio r WHERE r.versaocorrecao = :versaocorrecao")})
public class Relatorioensaio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "ano")
    private Integer ano;
    @Column(name = "correcao")
    private Boolean correcao;
    @Column(name = "datacoleta")
    @Temporal(TemporalType.DATE)
    private Date datacoleta;
    @Column(name = "dataemissao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataemissao;
    @Column(name = "dataentrada")
    @Temporal(TemporalType.DATE)
    private Date dataentrada;
    @Column(name = "dataresultado1")
    @Temporal(TemporalType.DATE)
    private Date dataresultado1;
    @Column(name = "dataresultado2")
    @Temporal(TemporalType.DATE)
    private Date dataresultado2;
    @Size(max = 255)
    @Column(name = "endreco")
    private String endreco;
    @Size(max = 255)
    @Column(name = "especie")
    private String especie;
    @Size(max = 255)
    @Column(name = "estado")
    private String estado;
    @Size(max = 255)
    @Column(name = "idade")
    private String idade;
    @Size(max = 255)
    @Column(name = "liberadopor")
    private String liberadopor;
    @Size(max = 255)
    @Column(name = "liberadoporcrmv")
    private String liberadoporcrmv;
    @Size(max = 255)
    @Column(name = "materialanalisado")
    private String materialanalisado;
    @Size(max = 255)
    @Column(name = "materialanalisadopb")
    private String materialanalisadopb;
    @Size(max = 255)
    @Column(name = "municipio")
    private String municipio;
    @Column(name = "numerolaudo")
    private Integer numerolaudo;
    @Size(max = 2147483647)
    @Column(name = "observacoes1")
    private String observacoes1;
    @Size(max = 2147483647)
    @Column(name = "observacoes2")
    private String observacoes2;
    @Size(max = 255)
    @Column(name = "proprietario")
    private String proprietario;
    @Size(max = 255)
    @Column(name = "raca")
    private String raca;
    @Size(max = 255)
    @Column(name = "registroamostra")
    private String registroamostra;
    @Column(name = "relatorioenviado")
    private Boolean relatorioenviado;
    @Size(max = 255)
    @Column(name = "remetente")
    private String remetente;
    @Size(max = 255)
    @Column(name = "responsavel1")
    private String responsavel1;
    @Size(max = 255)
    @Column(name = "responsavel2")
    private String responsavel2;
    @Size(max = 255)
    @Column(name = "resultado1")
    private String resultado1;
    @Size(max = 255)
    @Column(name = "resultado2")
    private String resultado2;
    @Column(name = "resultadofinal")
    private Boolean resultadofinal;
    @Size(max = 255)
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "versaocorrecao")
    private Integer versaocorrecao;
    @OneToMany(mappedBy = "relatorioensaioId")
    private List<Liberacaoderelatoriodeensaio> liberacaoderelatoriodeensaioCollection;
    @JoinColumn(name = "assinoulaudo_id", referencedColumnName = "id")
    @ManyToOne
    private Login assinoulaudoId;
    @JoinColumn(name = "principalid_id", referencedColumnName = "id")
    @ManyToOne
    private Principal principalidId;

    public Relatorioensaio() {
    }

    public Relatorioensaio(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Boolean getCorrecao() {
        return correcao;
    }

    public void setCorrecao(Boolean correcao) {
        this.correcao = correcao;
    }

    public Date getDatacoleta() {
        return datacoleta;
    }

    public void setDatacoleta(Date datacoleta) {
        this.datacoleta = datacoleta;
    }

    public Date getDataemissao() {
        return dataemissao;
    }

    public void setDataemissao(Date dataemissao) {
        this.dataemissao = dataemissao;
    }

    public Date getDataentrada() {
        return dataentrada;
    }

    public void setDataentrada(Date dataentrada) {
        this.dataentrada = dataentrada;
    }

    public Date getDataresultado1() {
        return dataresultado1;
    }

    public void setDataresultado1(Date dataresultado1) {
        this.dataresultado1 = dataresultado1;
    }

    public Date getDataresultado2() {
        return dataresultado2;
    }

    public void setDataresultado2(Date dataresultado2) {
        this.dataresultado2 = dataresultado2;
    }

    public String getEndreco() {
        return endreco;
    }

    public void setEndreco(String endreco) {
        this.endreco = endreco;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getLiberadopor() {
        return liberadopor;
    }

    public void setLiberadopor(String liberadopor) {
        this.liberadopor = liberadopor;
    }

    public String getLiberadoporcrmv() {
        return liberadoporcrmv;
    }

    public void setLiberadoporcrmv(String liberadoporcrmv) {
        this.liberadoporcrmv = liberadoporcrmv;
    }

    public String getMaterialanalisado() {
        return materialanalisado;
    }

    public void setMaterialanalisado(String materialanalisado) {
        this.materialanalisado = materialanalisado;
    }

    public String getMaterialanalisadopb() {
        return materialanalisadopb;
    }

    public void setMaterialanalisadopb(String materialanalisadopb) {
        this.materialanalisadopb = materialanalisadopb;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public Integer getNumerolaudo() {
        return numerolaudo;
    }

    public void setNumerolaudo(Integer numerolaudo) {
        this.numerolaudo = numerolaudo;
    }

    public String getObservacoes1() {
        return observacoes1;
    }

    public void setObservacoes1(String observacoes1) {
        this.observacoes1 = observacoes1;
    }

    public String getObservacoes2() {
        return observacoes2;
    }

    public void setObservacoes2(String observacoes2) {
        this.observacoes2 = observacoes2;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getRegistroamostra() {
        return registroamostra;
    }

    public void setRegistroamostra(String registroamostra) {
        this.registroamostra = registroamostra;
    }

    public Boolean getRelatorioenviado() {
        return relatorioenviado;
    }

    public void setRelatorioenviado(Boolean relatorioenviado) {
        this.relatorioenviado = relatorioenviado;
    }

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public String getResponsavel1() {
        return responsavel1;
    }

    public void setResponsavel1(String responsavel1) {
        this.responsavel1 = responsavel1;
    }

    public String getResponsavel2() {
        return responsavel2;
    }

    public void setResponsavel2(String responsavel2) {
        this.responsavel2 = responsavel2;
    }

    public String getResultado1() {
        return resultado1;
    }

    public void setResultado1(String resultado1) {
        this.resultado1 = resultado1;
    }

    public String getResultado2() {
        return resultado2;
    }

    public void setResultado2(String resultado2) {
        this.resultado2 = resultado2;
    }

    public Boolean getResultadofinal() {
        return resultadofinal;
    }

    public void setResultadofinal(Boolean resultadofinal) {
        this.resultadofinal = resultadofinal;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getVersaocorrecao() {
        return versaocorrecao;
    }

    public void setVersaocorrecao(Integer versaocorrecao) {
        this.versaocorrecao = versaocorrecao;
    }

    @XmlTransient    @JsonIgnore
    public List<Liberacaoderelatoriodeensaio> getLiberacaoderelatoriodeensaioCollection() {
        return liberacaoderelatoriodeensaioCollection;
    }

    public void setLiberacaoderelatoriodeensaioCollection(List<Liberacaoderelatoriodeensaio> liberacaoderelatoriodeensaioCollection) {
        this.liberacaoderelatoriodeensaioCollection = liberacaoderelatoriodeensaioCollection;
    }

    public Login getAssinoulaudoId() {
        return assinoulaudoId;
    }

    public void setAssinoulaudoId(Login assinoulaudoId) {
        this.assinoulaudoId = assinoulaudoId;
    }

    public Principal getPrincipalidId() {
        return principalidId;
    }

    public void setPrincipalidId(Principal principalidId) {
        this.principalidId = principalidId;
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
        if (!(object instanceof Relatorioensaio)) {
            return false;
        }
        Relatorioensaio other = (Relatorioensaio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Relatorioensaio[ id=" + id + " ]";
    }
    
}
