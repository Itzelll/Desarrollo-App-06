/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.programa06;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Itzel
 */
public class DAOVenta implements IDAOGeneral<Venta, Long>{

    @Override
    public Venta create(Venta p) {
        Session session = HibernateUtil.getSession(); 
        Transaction t = session.beginTransaction();
        
        session.save(p);
        Logger.getLogger(DAOVenta.class.getName()).log(Level.INFO, "Se creó ...");
        
        t.commit(); 
        session.close();
        return p;
    }

    @Override
    public boolean delete(Long id) {
        Session session = HibernateUtil.getSession();
        Transaction t = session.beginTransaction();
        boolean res = false;
        
        Venta v = findById(id); 
        if (v == null){
            res = false; //para validar que primero exista 
        } else {
            session.delete(v);
            Logger.getLogger(DAOVenta.class.getName()).log(Level.INFO, "Se borró...");
            res = true;
        }
        
        t.commit();
        session.close();
        return res;
    }

    @Override
    public Venta update(Venta p, Long id) {
        Session session = HibernateUtil.getSession();
        Transaction t = session.beginTransaction();
        
        Venta v = findById(id); 
        if (v != null){
            session.update(v);
            Logger.getLogger(DAOVenta.class.getName()).log(Level.INFO, "Se modificó...");
        }
        
        t.commit();
        session.close();
        return v;
    }

    @Override
    public List<Venta> findAll() {
        Session session = HibernateUtil.getSession(); 
        Transaction t = session.beginTransaction();
        
        List<Venta> lista = null;
        lista = session.createQuery("from venta").list(); 
        
        t.commit();
        session.close();
        return lista;   
    }

    @Override
    public Venta findById(Long id) {
        Session session = HibernateUtil.getSession();
        Transaction t = session.beginTransaction();
        
        Venta v = null;
        v = session.get(Venta.class, id); 
        
        t.commit();
        session.close();
        return v;
    }
    
    
}
