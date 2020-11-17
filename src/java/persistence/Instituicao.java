/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jorge
 */
@Entity
@Table(name = "instituicao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Instituicao.findAll", query = "SELECT i FROM Instituicao i")
    , @NamedQuery(name = "Instituicao.findById", query = "SELECT i FROM Instituicao i WHERE i.id = :id")
    , @NamedQuery(name = "Instituicao.findByNome", query = "SELECT i FROM Instituicao i WHERE i.nome = :nome")})
public class Instituicao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 600)
    @Column(name = "nome")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "organizadoraId")
    private Collection<Evento> eventoCollection;
    @JoinColumn(name = "cidade_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cidade cidadeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "organizadoraId")
    private Collection<Edicao> edicaoCollection;

    public Instituicao() {
    }

    public Instituicao(Integer id) {
        this.id = id;
    }

    public Instituicao(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public Collection<Evento> getEventoCollection() {
        return eventoCollection;
    }

    public void setEventoCollection(Collection<Evento> eventoCollection) {
        this.eventoCollection = eventoCollection;
    }

    public Cidade getCidadeId() {
        return cidadeId;
    }

    public void setCidadeId(Cidade cidadeId) {
        this.cidadeId = cidadeId;
    }

    @XmlTransient
    public Collection<Edicao> getEdicaoCollection() {
        return edicaoCollection;
    }

    public void setEdicaoCollection(Collection<Edicao> edicaoCollection) {
        this.edicaoCollection = edicaoCollection;
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
        if (!(object instanceof Instituicao)) {
            return false;
        }
        Instituicao other = (Instituicao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistencia.Instituicao[ id=" + id + " ]";
    }
    
}
