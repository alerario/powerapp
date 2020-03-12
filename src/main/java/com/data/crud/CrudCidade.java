/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data.crud;

import com.data.entity.Cidade;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author evee
 */
public class CrudCidade extends AbstractCrud<Cidade> {

    private EntityManager em;

    private static final String PU = EMNames.EMN1;

    public CrudCidade() {
        super(Cidade.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        if (em == null) {
            em = Persistence.createEntityManagerFactory(EMNames.EMN1, EMNames.getEM1Props()).createEntityManager();
        }
        return em;
    }

}
