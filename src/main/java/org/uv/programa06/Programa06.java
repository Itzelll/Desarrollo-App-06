/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package org.uv.programa06;

import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Itzel
 */
public class Programa06 {

    public static void main(String[] args) {
        
//        Session session = HibernateUtil.getSession();

        DAODetalleVenta daov = new DAODetalleVenta();
        
        DetalleVenta dv = new DetalleVenta();
        dv.setClaveproducto(1);
        dv.setCantidad(2);
        dv.setPrecio(200);
        dv.setSubtotal(400);
        
        daov.create(dv);
        
        
        DAOVenta dao = new DAOVenta();
        Venta v = new Venta();
        v.setClave(1);
        v.setFecha("01/03/2023");
        v.setMonto(200);
        
        v.setDetalleVenta((List<DetalleVenta>) dv);
        dao.create(v);
        
    }
}
