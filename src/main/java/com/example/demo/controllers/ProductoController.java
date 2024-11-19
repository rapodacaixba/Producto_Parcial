/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controllers;

import com.example.demo.dto.Producto;
import com.example.demo.services.ProductoServiceImpl;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Raquel
 */
@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    public ProductoServiceImpl productoServiceImpl;
    
    @GetMapping("/all")
    public List<Producto> getAllProductos(){
            return productoServiceImpl.GetAllProductos();
    }
    
    @GetMapping("/{id}")
    public Producto getProductoById(@PathVariable(name="id") Long id){
        Optional<Producto> producto = productoServiceImpl.getProductoById(id);
        if(producto.isPresent()){
            return producto.get();
        } else {
            throw new NoSuchElementException();
        }
    }
    
    @PostMapping("/create")
    public Optional<Producto> createProducto(@RequestBody Producto producto){
        Optional<Producto> newProducto = productoServiceImpl.CreateProducto(producto);
        if(newProducto.isPresent()){
            return newProducto;
        } else {
            throw new NoSuchElementException();
        }
    }
    
    @PutMapping("/update/{id}")
    public Producto updateProducto(@PathVariable(name="id") Long id, @RequestBody Producto producto){
        Producto updateProducto = productoServiceImpl.updateProducto(id, producto);
        return updateProducto;
    }
    
    @DeleteMapping("/delete/{id}")
    public void deleteProducto(@PathVariable(name="id") Long id){
        productoServiceImpl.deleteProductoById(id);
    }
}
