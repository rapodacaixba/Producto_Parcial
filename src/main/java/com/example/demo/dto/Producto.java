/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author Raquel
 */
@Entity
@Table(name="product")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="Nombre")
    private String nombre;
    
    @Column(name="Precio")
    private Double precio;
    
    @Column(name="Existencia")
    private int existencia;
    
    @Column(name="Descripcion")
    private String descripcion;
    
     @Column(name="NombreProv")
    private String nombreProv;
    
    public Producto(){}
    
    public Producto(Long id, String nombre, Double precio, int existencia, String descripcion, String nombreProv){
        this.id=id;
        this.nombre=nombre;
        this.precio=precio;
        this.existencia=existencia;
        this.descripcion=descripcion;
        this.nombreProv=nombreProv;
    }
    
    public Long getId(){
        return id;
    }
    
    public void setId(Long id){
        this.id = id;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public Double getPrecio(){
        return precio;
    }
    
    public void setPrecio(Double precio){
        this.precio = precio;
    }
    
    public int getExistencia(){
        return existencia;
    }
    
    public void setExistencia(int existencia){
        this.existencia = existencia;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    
    public String getNombreProv(){
        return nombreProv;
    }
    
    public void setNombreProv(String nombreProv){
        this.nombreProv = nombreProv;
    }
    
    @Override
    public String toString(){
        return "Producto [id=" + id + ", nombre=" + nombre + ", Precio=" + precio + ", Existencia=" + existencia + ", Descripcion=" + descripcion + ", NombreProv="+ nombreProv + "]";
    }
}
