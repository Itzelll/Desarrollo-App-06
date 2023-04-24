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
public class DAODetalleVenta implements IDAOGeneral<DetalleVenta, Long>{

    @Override
    public DetalleVenta create(DetalleVenta p) {
        Session session = HibernateUtil.getSession();
        Transaction t = session.beginTransaction();
        
        session.save(p);
        Logger.getLogger(DAODetalleVenta.class.getName()).log(Level.INFO, "Se creó Venta...");
        
        t.commit(); 
        session.close();
        return p;
    }

    @Override
    public boolean delete(Long id) {
        Session session = HibernateUtil.getSession();
        Transaction t = session.beginTransaction();
        boolean res = false;
        
        DetalleVenta dv = findById(id); 
        if (dv == null){
            res = false; //para validar que primero exista 
        } else {
            session.delete(dv);
            Logger.getLogger(DAODetalleVenta.class.getName()).log(Level.INFO, "Se borró...");
            res = true;
        }
        
        t.commit();
        session.close();
        return res;
    }

    @Override
    public DetalleVenta update(DetalleVenta p, Long id) {
        Session session = HibernateUtil.getSession();
        Transaction t = session.beginTransaction();
        
        DetalleVenta dv = findById(id); 
        if (dv != null){
            session.update(dv);
            Logger.getLogger(DAODetalleVenta.class.getName()).log(Level.INFO, "Se modificó...");
        }
        
        t.commit();
        session.close();
        return dv;
    }

    @Override
    public List<DetalleVenta> findAll() {
        Session session = HibernateUtil.getSession();
        Transaction t = session.beginTransaction();
        
        List<DetalleVenta> lista = null;
        lista = session.createQuery("from detalle_venta").list(); 
        
        t.commit();
        session.close();
        return lista;  
    }

    @Override
    public DetalleVenta findById(Long id) {
        Session session = HibernateUtil.getSession();
        Transaction t = session.beginTransaction();
        
        DetalleVenta dv = null;
        dv = session.get(DetalleVenta.class, id); 
        
        t.commit();
        session.close();
        return dv;
    }
    
    
}
