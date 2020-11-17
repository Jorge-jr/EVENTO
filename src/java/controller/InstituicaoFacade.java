/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import persistence.Instituicao;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jorge
 */
@Stateless
public class InstituicaoFacade extends AbstractFacade<Instituicao> {

    @PersistenceContext(unitName = "EVENTOSPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InstituicaoFacade() {
        super(Instituicao.class);
    }
    
}
