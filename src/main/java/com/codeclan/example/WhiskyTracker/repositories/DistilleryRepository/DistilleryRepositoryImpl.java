package com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;


import com.codeclan.example.WhiskyTracker.models.Distillery;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.script.ScriptEngine;
import javax.transaction.Transactional;
import java.util.List;

public class DistilleryRepositoryImpl implements DistilleryRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Distillery> getAllDistilleriesForRegion(String region){
        List<Distillery> result = null;
        Session session = entityManager.unwrap(Session.class);

        try {
        Criteria criteria = session.createCriteria(Distillery.class);
//        criteria.createAlias("distilleries", "distilleriesAlias");
        criteria.add(Restrictions.eq("region", region));

            result = criteria.list();
      }
      catch (HibernateException ex) {
          ex.printStackTrace();
      }

        return result;
    }

    @Transactional
    public List<Distillery> getAllWhiskiesForYear(int year){
        List<Distillery> result = null;
        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria criteria = session.createCriteria(Distillery.class);
        criteria.createAlias("whiskies", "whiskiesAlias");
            criteria.add(Restrictions.eq("whiskiesAlias.year", year));

            result = criteria.list();
        }
        catch (HibernateException ex) {
            ex.printStackTrace();
        }

        return result;
    }

    @Transactional
    public List<Distillery> getAllWhiskiesForDistilleryForYear(String name, int age){
        List<Distillery> result = null;
        Session session = entityManager.unwrap(Session.class);

        try{
            Criteria criteria = session.createCriteria(Distillery.class);
            criteria.add(Restrictions.eq("name", name));

            criteria.createAlias("whiskies", "whiskiesAlias");
            criteria.add(Restrictions.eq("whiskiesAlias.age", age));

            result = criteria.list();
        }
        catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return result;
    }



}
