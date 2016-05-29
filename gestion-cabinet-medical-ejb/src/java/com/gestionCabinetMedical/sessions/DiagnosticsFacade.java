/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gestionCabinetMedical.sessions;

import com.gestionCabinetMedical.entites.Diagnostics;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ahmet Dame CISSE
 */
@Stateless
public class DiagnosticsFacade extends AbstractFacade<Diagnostics> {
    @PersistenceContext(unitName = "gestion-cabinet-medical-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DiagnosticsFacade() {
        super(Diagnostics.class);
    }
    
}
