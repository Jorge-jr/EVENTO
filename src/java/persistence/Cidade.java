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
@Table(name = "cidade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cidade.findAll", query = "SELECT c FROM Cidade c")
    , @NamedQuery(name = "Cidade.findById", query = "SELECT c FROM Cidade c WHERE c.id = :id")
    , @NamedQuery(name = "Cidade.findByNome", query = "SELECT c FROM Cidade c WHERE c.nome = :nome")})
public class Cidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @JoinColumn(name = "pais_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pais paisId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cidadeId")
    private Collection<Instituicao> instituicaoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cidade")
    private Collection<Edicao> edicaoCollection;

    public Cidade() {
    }

    public Cidade(Integer id) {
        this.id = id;
    }

    public Cidade(Integer id, String nome) {
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

    public Pais getPaisId() {
        return paisId;
    }

    public void setPaisId(Pais paisId) {
        this.paisId = paisId;
    }

    @XmlTransient
    public Collection<Instituicao> getInstituicaoCollection() {
        return instituicaoCollection;
    }

    public void setInstituicaoCollection(Collection<Instituicao> instituicaoCollection) {
        this.instituicaoCollection = instituicaoCollection;
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
        if (!(object instanceof Cidade)) {
            return false;
        }
        Cidade other = (Cidade) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistencia.Cidade[ id=" + id + " ]";
    }
    
}
