/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.services;

import com.example.demo.dto.Producto;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.ProductoRepository;

/**
 *
 * @author Raquel
 */
@Service
public class ProductoServiceImpl implements ProductoService {
    
    @Autowired
    public ProductoRepository productoRepository;
    
    org.slf4j.Logger logger = LoggerFactory.getLogger(ProductoServiceImpl.class);
    
    @Override
    public List<Producto> GetAllProductos(){
        List<Producto> Producto= productoRepository.findAll();
        return Producto;
    }
    
    @Override
    public Optional<Producto> getProductoById(Long id){
        Optional<Producto> searchProducto= productoRepository.findById(id);
        if(searchProducto.isPresent()){
            logger.error("Producto encontrado!!");
            return searchProducto;
        } else {
            logger.error("No se encontro el producto" + id + "buscado");
            throw new NoSuchElementException("No se encontro el producto" + id + "buscado");
        }
    }
    
    @Override
    public Optional<Producto> CreateProducto(Producto producto){
        Optional<Producto> optProducto = Optional.of(producto);
        if(optProducto.isPresent()){
            Producto newProducto = new Producto();
            newProducto.setNombre(producto.getNombre());
            newProducto.setPrecio(producto.getPrecio());
            newProducto.setExistencia(producto.getExistencia());
            newProducto.setDescripcion(producto.getDescripcion());
            productoRepository.save(newProducto);
            logger.info("Se ha creado el producto correctamente");
            Optional<Producto> rturnOptProduct = Optional .of(newProducto);
            return rturnOptProduct;
        } else {
            logger.error("No se ha recibido un producto para crear");
            throw new NoSuchElementException("No se ha recibido un producto para crear");
        }
    }
    
    @Override
    public Producto updateProducto(Long id, Producto producto){
        Optional<Producto> optProducto = productoRepository.findById(id);
        if(optProducto.isPresent()){
            Producto productoUpdate = optProducto.get();
            productoUpdate.setNombre(producto.getNombre());
            productoUpdate.setPrecio(producto.getPrecio());
            productoUpdate.setExistencia(producto.getExistencia());
            productoUpdate.setDescripcion(producto.getDescripcion());
            productoUpdate.setNombreProv(producto.getNombreProv());
            productoRepository.save(productoUpdate);
            logger.error("Producto con id" + id + "actualizado correctamente");
            return productoUpdate;
        } else {
            logger.error("No se ha recibido un producto para crear");
            throw new NoSuchElementException("No se ha recibido un producto para crear");
        }
    }

    @Override
    public void deleteProductoById(Long id) {
        Optional<Producto> optProducto = productoRepository.findById(id);
        if(optProducto.isPresent()){
            Producto productoTrust = optProducto.get();
            productoRepository.deleteById(productoTrust.getId());
            logger.error("Producto con id" + id + "de forma efectiva");
        } else {
            logger.error("El producto ha eliminar no existe");
        }
    }
}