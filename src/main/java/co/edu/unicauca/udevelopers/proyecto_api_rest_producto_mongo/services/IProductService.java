package co.edu.unicauca.udevelopers.proyecto_api_rest_producto_mongo.services;

import java.util.List;
import java.util.Optional;

import co.edu.unicauca.udevelopers.proyecto_api_rest_producto_mongo.entities.Product;

public interface IProductService {
    public Product save(Product objProduct);
    public Optional<Product> findById(Long idProduct);
    public List <Product> findAll();
    public Product update(Long idProduct, Product objProduct);
    public boolean delete(Long idProduct);
}
