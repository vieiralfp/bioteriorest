/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaf.bioterio.banco.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Idaf
 */
@Entity
@Table(name = "laboratorioraiva.inoculacao")
@XmlRootElement
public class Inoculacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataInoculacao;
    @ManyToOne
    private Principal principal;
    private int qtdInoculados;
    private String idadeCamundongo;
    private String statusReinoculacao;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Login responsavelInoculacao;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataFinalizacao;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Login responsavelFinalizacao;
    @Lob
    private String observacoes;
    
    
    //Relacionamento com ObservacaoCamundongo
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataInoculacao() {
        return dataInoculacao;
    }

    public void setDataInoculacao(Date dataInoculacao) {
        this.dataInoculacao = dataInoculacao;
    }

    public Principal getPrincipal() {
        return principal;
    }

    public void setPrincipal(Principal principal) {
        this.principal = principal;
    }

    public int getQtdInoculados() {
        return qtdInoculados;
    }

    public void setQtdInoculados(int qtdInoculados) {
        this.qtdInoculados = qtdInoculados;
    }

    public String getIdadeCamundongo() {
        return idadeCamundongo;
    }

    public void setIdadeCamundongo(String idadeCamundongo) {
        this.idadeCamundongo = idadeCamundongo;
    }

    public String getStatusReinoculacao() {
        return statusReinoculacao;
    }

    public void setStatusReinoculacao(String statusReinoculacao) {
        this.statusReinoculacao = statusReinoculacao;
    }

    public Login getResponsavelInoculacao() {
        return responsavelInoculacao;
    }

    public void setResponsavelInoculacao(Login responsavelInoculacao) {
        this.responsavelInoculacao = responsavelInoculacao;
    }

    public Date getDataFinalizacao() {
        return dataFinalizacao;
    }

    public void setDataFinalizacao(Date dataFinalizacao) {
        this.dataFinalizacao = dataFinalizacao;
    }

    public Login getResponsavelFinalizacao() {
        return responsavelFinalizacao;
    }

    public void setResponsavelFinalizacao(Login responsavelFinalizacao) {
        this.responsavelFinalizacao = responsavelFinalizacao;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
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
        if (!(object instanceof Inoculacao)) {
            return false;
        }
        Inoculacao other = (Inoculacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "idaf.bioterio.banco.model.Inoculacao[ id=" + id + " ]";
    }
    
}
