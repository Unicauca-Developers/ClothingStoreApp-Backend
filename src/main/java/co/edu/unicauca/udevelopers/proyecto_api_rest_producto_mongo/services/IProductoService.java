package co.edu.unicauca.udevelopers.proyecto_api_rest_producto_mongo.services;

import java.util.List;
import java.util.Optional;

import co.edu.unicauca.udevelopers.proyecto_api_rest_producto_mongo.entities.Producto;

public interface IProductoService {
    public Producto save(Producto objProducto);
    public Optional<Producto> findById(Long idProducto);
    public List <Producto> findAll();
    public Producto update(Long idProducto, Producto objProducto);
    public boolean delete(Long idProducto);
}
