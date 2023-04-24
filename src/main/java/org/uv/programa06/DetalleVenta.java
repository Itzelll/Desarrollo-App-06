/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.programa06;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Itzel
 */
@Entity
@Table(name = "detalle_venta")
public class DetalleVenta {
    
    @Id
    @Column(name = "claveproducto")
    private long claveproducto;
    
    @Column(name = "cantidad")
    private long cantidad;
    
    @Column(name = "precio")
    private double precio;
    
    @Column(name = "subtotal")
    private double subtotal;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idventa")
    private Venta venta;

    public long getClaveproducto() {
        return claveproducto;
    }

    public void setClaveproducto(long claveproducto) {
        this.claveproducto = claveproducto;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(long subtotal) {
        this.subtotal = subtotal;
    }    
    
}
