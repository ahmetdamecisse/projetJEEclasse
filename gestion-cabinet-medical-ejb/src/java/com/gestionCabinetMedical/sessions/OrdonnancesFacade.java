/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gestionCabinetMedical.sessions;

import com.gestionCabinetMedical.entites.Ordonnances;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ahmet Dame CISSE
 */
@Stateless
public class OrdonnancesFacade extends AbstractFacade<Ordonnances> {
    @PersistenceContext(unitName = "gestion-cabinet-medical-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdonnancesFacade() {
        super(Ordonnances.class);
    }
    
}
