/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Idaf
 */
@Entity
@Table(name = "laboratorioraiva.observacaocamundongo")
public class ObservacaoCamundongo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int saudaveis;
    private int doentes;
    private int mortos;
    private int eutanasias;
    private int perdidos;    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataObservacao;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Inoculacao inoculacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSaudaveis() {
        return saudaveis;
    }

    public void setSaudaveis(int saudaveis) {
        this.saudaveis = saudaveis;
    }

    public int getDoentes() {
        return doentes;
    }

    public void setDoentes(int doentes) {
        this.doentes = doentes;
    }

    public int getMortos() {
        return mortos;
    }

    public void setMortos(int mortos) {
        this.mortos = mortos;
    }

    public int getEutanasias() {
        return eutanasias;
    }

    public void setEutanasias(int eutanasias) {
        this.eutanasias = eutanasias;
    }

    public int getPerdidos() {
        return perdidos;
    }

    public void setPerdidos(int perdidos) {
        this.perdidos = perdidos;
    }

    public Date getDataObservacao() {
        return dataObservacao;
    }

    public void setDataObservacao(Date dataObservacao) {
        this.dataObservacao = dataObservacao;
    }

    public Inoculacao getInoculacao() {
        return inoculacao;
    }

    public void setInoculacao(Inoculacao inoculacao) {
        this.inoculacao = inoculacao;
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
        if (!(object instanceof ObservacaoCamundongo)) {
            return false;
        }
        ObservacaoCamundongo other = (ObservacaoCamundongo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ObservacaoCamundongo[ id=" + id + " ]";
    }
    
}
