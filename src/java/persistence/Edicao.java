/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jorge
 */
@Entity
@Table(name = "edicao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Edicao.findAll", query = "SELECT e FROM Edicao e")
    , @NamedQuery(name = "Edicao.findByNomeEvento", query = "SELECT e FROM Edicao e WHERE e.edicaoPK.nomeEvento = :nomeEvento")
    , @NamedQuery(name = "Edicao.findByNumero", query = "SELECT e FROM Edicao e WHERE e.edicaoPK.numero = :numero")
    , @NamedQuery(name = "Edicao.findByAno", query = "SELECT e FROM Edicao e WHERE e.ano = :ano")
    , @NamedQuery(name = "Edicao.findByDataInicio", query = "SELECT e FROM Edicao e WHERE e.dataInicio = :dataInicio")
    , @NamedQuery(name = "Edicao.findByDataFim", query = "SELECT e FROM Edicao e WHERE e.dataFim = :dataFim")})
public class Edicao implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EdicaoPK edicaoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ano")
    @Temporal(TemporalType.DATE)
    private Date ano;
    @Column(name = "data_inicio")
    @Temporal(TemporalType.DATE)
    private Date dataInicio;
    @Column(name = "data_fim")
    @Temporal(TemporalType.DATE)
    private Date dataFim;
    @JoinColumn(name = "nome_evento", referencedColumnName = "nome", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Evento evento;
    @JoinColumn(name = "organizadora_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Instituicao organizadoraId;
    @JoinColumn(name = "cidade", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cidade cidade;

    public Edicao() {
    }

    public Edicao(EdicaoPK edicaoPK) {
        this.edicaoPK = edicaoPK;
    }

    public Edicao(EdicaoPK edicaoPK, Date ano) {
        this.edicaoPK = edicaoPK;
        this.ano = ano;
    }

    public Edicao(String nomeEvento, int numero) {
        this.edicaoPK = new EdicaoPK(nomeEvento, numero);
    }

    public EdicaoPK getEdicaoPK() {
        return edicaoPK;
    }

    public void setEdicaoPK(EdicaoPK edicaoPK) {
        this.edicaoPK = edicaoPK;
    }

    public Date getAno() {
        return ano;
    }

    public void setAno(Date ano) {
        this.ano = ano;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Instituicao getOrganizadoraId() {
        return organizadoraId;
    }

    public void setOrganizadoraId(Instituicao organizadoraId) {
        this.organizadoraId = organizadoraId;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (edicaoPK != null ? edicaoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Edicao)) {
            return false;
        }
        Edicao other = (Edicao) object;
        if ((this.edicaoPK == null && other.edicaoPK != null) || (this.edicaoPK != null && !this.edicaoPK.equals(other.edicaoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistencia.Edicao[ edicaoPK=" + edicaoPK + " ]";
    }
    
}
