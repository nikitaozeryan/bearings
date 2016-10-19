/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.so.bearingsstore.domain;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Никита
 */
public class UsersDaoImpl implements UsersDao{

    @Override
    public List<Users> getList() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Users> user = session.createCriteria(Users.class).list();
        session.close();
        return user;
    }

    @Override
    public Users getById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Users user = (Users) session.createCriteria(Users.class).
                add(Restrictions.eq("id", id)).uniqueResult();
        session.close();
        return user;
    }

    @Override
    public Users getbyLogin(String login) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Users user = (Users) session.createCriteria(Users.class)
                .add(Restrictions.eq("login", login)).uniqueResult();
        session.close();
        return user;
    }

//    @Override
//    public int checkLogin(String login) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        int numberUsers;
//        try{
//            numberUsers = session.createSQLQuery("SELECT * from users WHERE login=:login")
//                    .setParameter("login", login).executeUpdate();
//            
//        }catch(Exception ex){
//            numberUsers = 0;
//        }
//        return numberUsers;
//    }
    

    @Override
    public int save(Object o) {
        int result;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        tx.begin();
        try{
            result = (Integer)session.save(o);
            tx.commit();
        }
        catch(Exception ex){
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
    public int deleteUser(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        int numberUsers;
        try{
            numberUsers = session.createSQLQuery("delete from users where id=:id")
                    .setParameter("id", id).executeUpdate();
            session.getTransaction().commit();
        }catch(Exception ex){
            session.getTransaction().rollback();
            numberUsers = 0;
        }
        return numberUsers;
    }
    
}
