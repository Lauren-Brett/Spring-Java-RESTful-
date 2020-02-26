package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;


import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import net.bytebuddy.asm.Advice;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class WhiskyRepositoryImpl implements WhiskyRepositoryCustom {


    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Whisky> getAllWhiskyFromRegion(String region){
        List<Whisky> result = null;
        Session session = entityManager.unwrap(Session.class);

        try {

            Criteria criteria = session.createCriteria(Whisky.class);

//            criteria.add(Restrictions.eq("name", ));

            criteria.createAlias("distillery", "distilleriesAlias");
            criteria.add(Restrictions.eq("distilleriesAlias.region", region));

            result = criteria.list();

        }

        catch (HibernateException ex) {
            ex.printStackTrace();
        }

        return result;


    }

}
