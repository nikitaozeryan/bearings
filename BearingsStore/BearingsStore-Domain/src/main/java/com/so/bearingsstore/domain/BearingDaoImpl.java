/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.so.bearingsstore.domain;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Никита
 */
public class BearingDaoImpl implements BearingDao{

    @Override
    public List<Bearing> getList() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Bearing> bearing = session.createCriteria(Bearing.class).list();
        session.close();
        return bearing;
        
    }
   

    @Override
    public Bearing getById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Bearing bearing = (Bearing) session.createCriteria(Bearing.class)
                .add(Restrictions.eq("id", id)).uniqueResult();
        session.close();
        return bearing;
    }
    
    @Override
    public int save(Object o) {
       int result;
       Session session = HibernateUtil.getSessionFactory().openSession();
       Transaction tx = session.getTransaction();
       tx.begin();
       try{
           result = (Integer) session.save(o);
           tx.commit();
       }
       catch(Exception e)
       {
           result = 0;
           tx.rollback();
       }
       finally{
           session.close();
       }
       return result;
    }

    @Override
    public void update(Object o) {
       Session session = HibernateUtil.getSessionFactory().openSession();
       Transaction tx = session.getTransaction();
       tx.begin();
       try{
           session.update(o);
           tx.commit();
       }
       catch(Exception e)
       {
           tx.rollback();
       }
       finally{
           session.close();
       }
    }

    @Override
    public void delete(Object o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        try{
            session.delete(o);
            tx.commit();
        }
        catch(Exception e)
        {
            tx.rollback();
        }
        finally{
            session.close();
        }
    }

    @Override
    public void remove(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        try{
            session.createSQLQuery("delete from users where id=:id ")
                    .setParameter("id", id).executeUpdate();
            tx.commit();
            
        }
        catch(Exception e)
        {
            tx.rollback();
        }
        finally{
            session.close();
       }
    }

    
    
    
}
