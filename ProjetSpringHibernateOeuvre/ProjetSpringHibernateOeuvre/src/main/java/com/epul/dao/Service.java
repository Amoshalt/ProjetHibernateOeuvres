package com.epul.dao;


import java.util.*;

import com.epul.metier.AdherentEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import com.epul.hibernate.*;
import com.epul.gestiondeserreurs.*;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;


public class Service {


	//TODO drag , drop and update all mapping related to adherent into adherentService


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

	/* Consultation d'une adherent par son numéro
	*/
	public AdherentEntity adherentById(int numero) throws MonException {
		List<AdherentEntity> mesAdherents = null;
		AdherentEntity unAdherent = new AdherentEntity();
		String marequete ="SELECT a FROM AdherentEntity a WHERE a.idAndherent="+numero;
		try {
			Session session = ServiceHibernate.currentSession();

			TypedQuery query =   session.createQuery(marequete);
			mesAdherents =  query.getResultList();
			unAdherent = mesAdherents.get(0);
			session.close();
		}
		catch (HibernateException ex) {
			throw new MonException("Impossible d'accèder à la SessionFactory: ",  ex.getMessage());
		}

		return unAdherent;
	}

}
