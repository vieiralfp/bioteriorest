/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Idaf
 */
@Entity
@Table(name = "laboratorioraiva.relatorioensaio")
@XmlRootElement
public class Relatorioensaio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Principal principalid;    
    private Integer numerolaudo;
    private Integer ano;
    private String registroamostra;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataentrada;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datacoleta;
    private String materialanalisado;
    private String materialanalisadopb;
    private String remetente;
    private String contatoremetente;
    private String proprietario;
    private String endreco;
    private String municipio;
    private String estado;
    private String especie;
    private String raca;
    private String sexo;
    private String idade;
    private String resultado1;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataresultado1;
    private String responsavel1;
    @Lob
    private String observacoes1;
    private String resultado2;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataresultado2;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date iniciopb;
    private String responsavel2;
    @Lob
    private String observacoes2;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataemissao;
    private boolean relatorioenviado;
    boolean correcao;
    private int versaocorrecao;
    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    private Login assinoulaudo;
    private String liberadopor;
    private String liberadoporcrmv;
    private boolean resultadofinal;
    @Transient
    private boolean enviaremail;

    public Relatorioensaio() {
    }

    public Relatorioensaio(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getContatoremetente() {
        return contatoremetente;
    }

    public void setContatoremetente(String contatoremetente) {
        this.contatoremetente = contatoremetente;
    }

    public Date getIniciopb() {
        return iniciopb;
    }

    public void setIniciopb(Date iniciopb) {
        this.iniciopb = iniciopb;
    }

    public Login getAssinoulaudo() {
        return assinoulaudo;
    }

    public void setAssinoulaudo(Login assinoulaudo) {
        this.assinoulaudo = assinoulaudo;
    }

    @JsonIgnore
    public boolean isEnviaremail() {
        return enviaremail;
    }

    public void setEnviaremail(boolean enviaremail) {
        this.enviaremail = enviaremail;
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
