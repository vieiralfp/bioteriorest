/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import org.eclipse.persistence.annotations.Index;


/**
 *
 * @author Idaf
 */
@Entity
@Table(name = "laboratorioraiva.principal")

public class Principal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Index
    @Column(name = "registro", unique = true)
    private String registro;
    @Basic(optional = false)
    @Column(name = "namostra")
    private Integer namostra;
    @Index
    @Column(name = "dataentrada")
    @Temporal(TemporalType.DATE)
    private Date dataentrada;
    @Column (name= "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Column(name = "datacolheita")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datacolheita;
    @Column(name = "proprietario", columnDefinition = "citext")
    private String proprietario;
    @Column(name = "endereco")
    private String endereco;
    @ManyToOne
    @JoinColumn(name = "remetenteid", referencedColumnName = "id")
    private Remetente remetenteid; 
    @Column(name="contatoremetente")
    private String contatoremetente;
    @ManyToOne
    @JoinColumn(name = "municipioid", referencedColumnName = "id")
    private Municipios municipioid;
    @ManyToOne
    @JoinColumn(name = "especieid", referencedColumnName = "id")
    private Especie especieid;
    @ManyToOne
    @JoinColumn(name = "racaid", referencedColumnName = "id")
    private Racas racaid;
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "idade")
    private String idade;
    @Column(name = "formin")
    private Long formin;
    
    @Size(max = 2147483647)
    @Column(name = "natamostra")
    private String natamostra;
    
    /**
     * Informações de Resultados
     */
    @Column(name = "resultado1")
    private String resultado1;
    @Column(name = "dataresultado1")
    @Temporal(TemporalType.DATE)
    private Date dataresultado1;    
    
    @Column(name = "resultado2")
    private String resultado2;
    @Column(name = "iniciopb")
    @Temporal(TemporalType.DATE)
    private Date iniciopb;
    @Column(name = "dataresultado2")
    @Temporal(TemporalType.DATE)
    private Date dataresultado2;
    
    @Column (name="fecharresultado1")
    private boolean fecharresultado1;
    @Column (name="fecharresultado2")
    private boolean fecharresultado2;
    
    @JoinColumn(name = "veterinarioresponsavel1", referencedColumnName = "id")
    @ManyToOne
    private Login veterinarioresponsavel1;
    @JoinColumn(name = "veterinarioresponsavel2", referencedColumnName = "id")
    @ManyToOne
    private Login veterinarioresponsavel2;
    
    @Lob
    @Column(name = "observacoes")
    private String observacoes;
    @Lob
    @Column(name = "observacoesPB")
    private String observacoespb;
    
     private String materialanalisadoifd;
    private String materialanalisadopb;
    
    
    /**
     * Outras informações
     */
    
    @ManyToOne
    @JoinColumn(name = "recebeuid", referencedColumnName = "id")
    private Login recebeuid;
    
    @Column(name="sivcont")
    private boolean sivcont;
    @Column(name="eeb")
    private boolean eeb;
        
    @OneToMany(mappedBy = "idprincipal")
    private List<Diagnosticodiferencial> diagnosticodiferenciallist;
    
    
    @ManyToOne
    @JoinColumn(name = "especiemorcegoid", referencedColumnName = "id")
    private Especiemorcego especiemorcegoid;
    @Column(name = "alimentacao")
    private String alimentacao;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "principal")
    private List<Liberacaoderesultados> libercaoDeResultados;
    private transient boolean enviarIFD;
    private transient boolean enviarPB;
    private Boolean contatoagressao;
   
   
    @Column(name = "ultimaatualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimaatualizacao;
    @ManyToOne
    @JoinColumn(name = "ultimousuario", referencedColumnName = "id")
    private Login ultimousuario;

    public Principal() {
    }

    public Principal(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlimentacao() {
        return alimentacao;
    }

    public void setAlimentacao(String alimentacao) {
        this.alimentacao = alimentacao;
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

    public Boolean getEeb() {
        return eeb;
    }

    public void setEeb(Boolean eeb) {
        this.eeb = eeb;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Boolean getFecharresultado1() {
        return fecharresultado1;
    }

    public void setFecharresultado1(Boolean fecharresultado1) {
        this.fecharresultado1 = fecharresultado1;
    }

    public Boolean getFecharresultado2() {
        return fecharresultado2;
    }

    public void setFecharresultado2(Boolean fecharresultado2) {
        this.fecharresultado2 = fecharresultado2;
    }

    public Long getFormin() {
        return formin;
    }

    public void setFormin(Long formin) {
        this.formin = formin;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public Integer getNamostra() {
        return namostra;
    }

    public void setNamostra(Integer namostra) {
        this.namostra = namostra;
    }

    public String getNatamostra() {
        return natamostra;
    }

    public void setNatamostra(String natamostra) {
        this.natamostra = natamostra;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Boolean getSivcont() {
        return sivcont;
    }

    public void setSivcont(Boolean sivcont) {
        this.sivcont = sivcont;
    }

    public Date getUltimaatualizacao() {
        return ultimaatualizacao;
    }

    public void setUltimaatualizacao(Date ultimaatualizacao) {
        this.ultimaatualizacao = ultimaatualizacao;
    }

    public Date getDatacolheita() {
        return datacolheita;
    }

    public void setDatacolheita(Date datacolheita) {
        this.datacolheita = datacolheita;
    }

    public Boolean getContatoagressao() {
        return contatoagressao;
    }

    public void setContatoagressao(Boolean contatoagressao) {
        this.contatoagressao = contatoagressao;
    }

    public String getMaterialanalisadoifd() {
        return materialanalisadoifd;
    }

    public void setMaterialanalisadoifd(String materialanalisadoifd) {
        this.materialanalisadoifd = materialanalisadoifd;
    }

    public String getMaterialanalisadopb() {
        return materialanalisadopb;
    }

    public void setMaterialanalisadopb(String materialanalisadopb) {
        this.materialanalisadopb = materialanalisadopb;
    }

    public String getObservacoespb() {
        return observacoespb;
    }

    public void setObservacoespb(String observacoespb) {
        this.observacoespb = observacoespb;
    }

    public Especie getEspecieid() {
        return especieid;
    }

    public void setEspecieid(Especie especieid) {
        this.especieid = especieid;
    }

    public Especiemorcego getEspeciemorcegoid() {
        return especiemorcegoid;
    }

    public void setEspeciemorcegoid(Especiemorcego especiemorcegoid) {
        this.especiemorcegoid = especiemorcegoid;
    }

    public Login getRecebeuid() {
        return recebeuid;
    }

    public void setRecebeuid(Login recebeuid) {
        this.recebeuid = recebeuid;
    }

    public Login getUltimousuario() {
        return ultimousuario;
    }

    public void setUltimousuario(Login ultimousuario) {
        this.ultimousuario = ultimousuario;
    }

    public Login getVeterinarioresponsavel1() {
        return veterinarioresponsavel1;
    }

    public void setVeterinarioresponsavel1(Login veterinarioresponsavel1) {
        this.veterinarioresponsavel1 = veterinarioresponsavel1;
    }

    public Login getVeterinarioresponsavel2() {
        return veterinarioresponsavel2;
    }

    public void setVeterinarioresponsavel2(Login veterinarioresponsavel2) {
        this.veterinarioresponsavel2 = veterinarioresponsavel2;
    }

    public Municipios getMunicipioid() {
        return municipioid;
    }

    public void setMunicipioid(Municipios municipioid) {
        this.municipioid = municipioid;
    }

    public Racas getRacaid() {
        return racaid;
    }

    public void setRacaid(Racas racaid) {
        this.racaid = racaid;
    }

    public Remetente getRemetenteid() {
        return remetenteid;
    }

    public void setRemetenteid(Remetente remetenteid) {
        this.remetenteid = remetenteid;
    }

    @JsonIgnore
    public List<Diagnosticodiferencial> getDiagnosticodiferenciallist() {
        return diagnosticodiferenciallist;
    }

    public void setDiagnosticodiferenciallist(List<Diagnosticodiferencial> diagnosticodiferenciallist) {
        this.diagnosticodiferenciallist = diagnosticodiferenciallist;
    }
    
    @JsonIgnore
    public List<Liberacaoderesultados> getLibercaoDeResultados() {
        return libercaoDeResultados;
    }

    public void setLibercaoDeResultados(List<Liberacaoderesultados> libercaoDeResultados) {
        this.libercaoDeResultados = libercaoDeResultados;
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

    public boolean isFecharresultado1() {
        return fecharresultado1;
    }

    public void setFecharresultado1(boolean fecharresultado1) {
        this.fecharresultado1 = fecharresultado1;
    }

    public boolean isFecharresultado2() {
        return fecharresultado2;
    }

    public void setFecharresultado2(boolean fecharresultado2) {
        this.fecharresultado2 = fecharresultado2;
    }

    public boolean isSivcont() {
        return sivcont;
    }

    public void setSivcont(boolean sivcont) {
        this.sivcont = sivcont;
    }

    public boolean isEeb() {
        return eeb;
    }

    public void setEeb(boolean eeb) {
        this.eeb = eeb;
    }

    public boolean isEnviarIFD() {
        return enviarIFD;
    }

    public void setEnviarIFD(boolean enviarIFD) {
        this.enviarIFD = enviarIFD;
    }

    public boolean isEnviarPB() {
        return enviarPB;
    }

    public void setEnviarPB(boolean enviarPB) {
        this.enviarPB = enviarPB;
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
        if (!(object instanceof Principal)) {
            return false;
        }
        Principal other = (Principal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Principal[ id=" + id + " ]";
    }
    
}
