/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Jorge
 */
@Embeddable
public class EdicaoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nome_evento")
    private String nomeEvento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero")
    private int numero;

    public EdicaoPK() {
    }

    public EdicaoPK(String nomeEvento, int numero) {
        this.nomeEvento = nomeEvento;
        this.numero = numero;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nomeEvento != null ? nomeEvento.hashCode() : 0);
        hash += (int) numero;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EdicaoPK)) {
            return false;
        }
        EdicaoPK other = (EdicaoPK) object;
        if ((this.nomeEvento == null && other.nomeEvento != null) || (this.nomeEvento != null && !this.nomeEvento.equals(other.nomeEvento))) {
            return false;
        }
        if (this.numero != other.numero) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistencia.EdicaoPK[ nomeEvento=" + nomeEvento + ", numero=" + numero + " ]";
    }
    
}
