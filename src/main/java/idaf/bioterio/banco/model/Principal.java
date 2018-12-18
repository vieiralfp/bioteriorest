/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaf.bioterio.banco.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import java.io.Serializable;
import java.math.BigInteger;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;


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
    private Integer id;
    @Size(max = 255)
    @Column(name = "alimentacao")
    private String alimentacao;
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
    @Column(name = "diferencial")
    private String diferencial;
    @Column(name = "eeb")
    private Boolean eeb;
    @Size(max = 255)
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "fecharresultado1")
    private Boolean fecharresultado1;
    @Column(name = "fecharresultado2")
    private Boolean fecharresultado2;
    @Column(name = "formin")
    private BigInteger formin;
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Size(max = 255)
    @Column(name = "idade")
    private String idade;
    @Column(name = "namostra")
    private Integer namostra;
    @Size(max = 2147483647)
    @Column(name = "natamostra")
    private String natamostra;
    @Size(max = 255)
    @Column(name = "obs")
    private String obs;
    @Size(max = 2147483647)
    @Column(name = "observacoes")
    private String observacoes;
    @Size(max = 255)
    @Column(name = "pelagem")
    private String pelagem;
    @Column(name = "proprietario", columnDefinition = "citext")
    private String proprietario;
    @Size(max = 255)
    @Column(name = "registro")
    private String registro;
    @Size(max = 255)
    @Column(name = "remetente")
    private String remetente;
    @Size(max = 255)
    @Column(name = "resultado1")
    private String resultado1;
    @Size(max = 255)
    @Column(name = "resultado2")
    private String resultado2;
    @Size(max = 255)
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "sivcont")
    private Boolean sivcont;
    @Column(name = "ultimaatualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimaatualizacao;
    @Size(max = 255)
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "agressao")
    private Boolean agressao;
    @Column(name = "contato")
    private Boolean contato;
    @Column(name = "datacolheita")
    @Temporal(TemporalType.DATE)
    private Date datacolheita;
    @Column(name = "contatoagressao")
    private Boolean contatoagressao;
    @Size(max = 255)
    @Column(name = "materialanalisadoifd")
    private String materialanalisadoifd;
    @Size(max = 255)
    @Column(name = "materialanalisadopb")
    private String materialanalisadopb;
    @Size(max = 2147483647)
    @Column(name = "observacoespb")
    private String observacoespb;
    @JoinColumn(name = "especieid", referencedColumnName = "id")
    @ManyToOne
    private Especie especieid;
    @JoinColumn(name = "especiemorcegoid", referencedColumnName = "id")
    @ManyToOne
    private Especiemorcego especiemorcegoid;
    @JoinColumn(name = "recebeuid", referencedColumnName = "id")
    @ManyToOne
    private Login recebeuid;
    @JoinColumn(name = "ultimousuario", referencedColumnName = "id")
    @ManyToOne
    @JsonView()
    private Login ultimousuario;
    @JoinColumn(name = "veterinarioresponsavel1", referencedColumnName = "id")
    @ManyToOne
    private Login veterinarioresponsavel1;
    @JoinColumn(name = "veterinarioresponsavel2", referencedColumnName = "id")
    @ManyToOne
    private Login veterinarioresponsavel2;
    @JoinColumn(name = "municipioid", referencedColumnName = "id")
    @ManyToOne
    private Municipios municipioid;
    @JoinColumn(name = "racaid", referencedColumnName = "id")
    @ManyToOne
    private Racas racaid;
    @JoinColumn(name = "remetenteid", referencedColumnName = "id")
    @ManyToOne
    private Remetente remetenteid;
    @OneToMany(mappedBy = "idPrincipal")
    private List<Diagnosticodiferencial> diagnosticodiferencialCollection;
    @OneToMany(mappedBy = "principalidId")
    private List<Relatorioensaio> relatorioensaioCollection;
    @OneToMany(mappedBy = "principal")
    private List<Liberacaoderesultados> liberacaoderesultadosCollection;

    public Principal() {
    }

    public Principal(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getDiferencial() {
        return diferencial;
    }

    public void setDiferencial(String diferencial) {
        this.diferencial = diferencial;
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

    public BigInteger getFormin() {
        return formin;
    }

    public void setFormin(BigInteger formin) {
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

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getPelagem() {
        return pelagem;
    }

    public void setPelagem(String pelagem) {
        this.pelagem = pelagem;
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

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Boolean getAgressao() {
        return agressao;
    }

    public void setAgressao(Boolean agressao) {
        this.agressao = agressao;
    }

    public Boolean getContato() {
        return contato;
    }

    public void setContato(Boolean contato) {
        this.contato = contato;
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
    public List<Diagnosticodiferencial> getDiagnosticodiferencialCollection() {
        return diagnosticodiferencialCollection;
    }

    public void setDiagnosticodiferencialCollection(List<Diagnosticodiferencial> diagnosticodiferencialCollection) {
        this.diagnosticodiferencialCollection = diagnosticodiferencialCollection;
    }

    @JsonIgnore
    public List<Relatorioensaio> getRelatorioensaioCollection() {
        return relatorioensaioCollection;
    }

    public void setRelatorioensaioCollection(List<Relatorioensaio> relatorioensaioCollection) {
        this.relatorioensaioCollection = relatorioensaioCollection;
    }

    @JsonIgnore
    public List<Liberacaoderesultados> getLiberacaoderesultadosCollection() {
        return liberacaoderesultadosCollection;
    }

    public void setLiberacaoderesultadosCollection(List<Liberacaoderesultados> liberacaoderesultadosCollection) {
        this.liberacaoderesultadosCollection = liberacaoderesultadosCollection;
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
        return "idaf.bioterio.banco.model.Principal[ id=" + id + " ]";
    }
    
}
