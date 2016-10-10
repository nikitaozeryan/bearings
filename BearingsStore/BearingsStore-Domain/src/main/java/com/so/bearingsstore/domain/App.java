/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.so.bearingsstore.domain;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Никита
 */

public class App {
    static Session session;
    
    //load static session for all methods
    static{
        session = HibernateUtil.getSessionFactory().openSession();
    }
    public static void main(String[] args) {
        BearingDao bdao = new BearingDaoImpl();
        List<Bearing> blist = bdao.getList();
        for(Bearing u:blist){
            System.out.println(u);
        }
        closeConnection();
    }
     static void closeConnection(){
        session.close();
        HibernateUtil.getSessionFactory().close();
    }
}
