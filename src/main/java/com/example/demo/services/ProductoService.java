/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.services;

import com.example.demo.dto.Producto;
import java.util.Optional;
import java.util.List;

/**
 *
 * @author Raquel
 */
public interface ProductoService {
    List<Producto> GetAllProductos();
    Optional<Producto> getProductoById(Long id);
    Optional<Producto> CreateProducto(Producto producto);
    Producto updateProducto(Long id, Producto producto);
    void deleteProductoById(Long id);
}
