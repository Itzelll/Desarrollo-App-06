/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.programa06;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Itzel
 */
@Entity
@Table(name = "venta")
public class Venta {
    
    @Id
    @Column(name = "clave")
    private long clave;
    
    @Column(name = "fecha")
    private String fecha;
    
    @Column(name = "monto")
    private double monto;
    
    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    private List<DetalleVenta> dVenta = new ArrayList<>();

    public List<DetalleVenta> getDetalleVenta() {
        return dVenta;
    }

    public void setDetalleVenta(List<DetalleVenta> dVenta) {
        this.dVenta = dVenta;
    }
    

    public long getClave() {
        return clave;
    }

    public void setClave(long clave) {
        this.clave = clave;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(long monto) {
        this.monto = monto;
    }
    
}
