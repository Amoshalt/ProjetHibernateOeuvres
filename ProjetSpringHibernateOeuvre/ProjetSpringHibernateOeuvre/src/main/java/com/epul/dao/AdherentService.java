package com.epul.dao;

import com.epul.hibernate.ServiceHibernate;
import com.epul.metier.AdherentEntity;
import org.hibernate.Session;

import java.util.ArrayList;

/**
 * Created by tardy on 24/03/2018.
 */
public class AdherentService extends Service {
    public void insertAdherent(AdherentEntity adherentEntity) {
        Session session = ServiceHibernate.currentSession();
        session.persist(adherentEntity);
    }

    public ArrayList<AdherentEntity> listerAdherent() {
        ArrayList<AdherentEntity> adherentEntities = new ArrayList<>();
            //TODO session. get all adherent , look at how it's done in Service but don't use any SQL
        return adherentEntities;
    }
}
