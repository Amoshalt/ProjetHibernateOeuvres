package com.epul.dao;

import com.epul.gestiondeserreurs.MonException;
import com.epul.hibernate.ServiceHibernate;
import com.epul.metier.AdherentEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tardy on 24/03/2018.
 */
public class AdherentService extends Service {


    //  ***************************************
    //  On ajoute un adhérent à  la base
    //  ***************************************
    public void insertAdherent(AdherentEntity unAdh) throws MonException
    {
        Transaction tx = null;
        try {
            Session   session = ServiceHibernate.currentSession();
            tx = session.beginTransaction();
            // on transfère le nouvel adhérent à la base
            session.save(unAdh);
            tx.commit();
            session.close();
        }
        catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
        }
        catch (Exception e) {
            throw new MonException("Impossible d'accèder à la SessionFactory: ",  e.getMessage());
        }
    }

    /* Lister les adherents
	 * */
    public List<AdherentEntity> consulterListeAdherents() throws MonException {
        List<AdherentEntity> mesAdherents = null;
        String marequete = "SELECT a FROM AdherentEntity a ORDER BY a.nomAdherent";
        try {

            Session session = ServiceHibernate.currentSession();
            TypedQuery<AdherentEntity> query = session.createQuery(marequete);
            mesAdherents = query.getResultList();
            session.close();

        } catch (HibernateException ex) {
            throw new MonException("Impossible d'accèder à la SessionFactory: ",  ex.getMessage());
        }
        return mesAdherents;

    }


    /* Consultation d'une adherent par son numéro
	*/
    public AdherentEntity adherentById(int numero) throws MonException {
        List mesAdherents = null;
        AdherentEntity unAdherent;

        //TODO replace SQL by function of session
        String marequete = "SELECT a FROM AdherentEntity a WHERE a.idAdherent=" + numero;
        try {
            Session session = ServiceHibernate.currentSession();

            TypedQuery query =   session.createQuery(marequete);
            mesAdherents =  query.getResultList();
            unAdherent = (AdherentEntity) mesAdherents.get(0);
            session.close();
        }
        catch (HibernateException ex) {
            throw new MonException("Impossible d'accèder à la SessionFactory: ",  ex.getMessage());
        }

        return unAdherent;
    }
}
