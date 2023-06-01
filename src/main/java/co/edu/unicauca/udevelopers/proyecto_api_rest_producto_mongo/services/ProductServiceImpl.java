package co.edu.unicauca.udevelopers.proyecto_api_rest_producto_mongo.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.unicauca.udevelopers.proyecto_api_rest_producto_mongo.entities.Product;
import co.edu.unicauca.udevelopers.proyecto_api_rest_producto_mongo.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements IProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product save(Product objProduct) {
       
        return this.productRepository.save(objProduct);
    }

    @Override
    public Optional<Product> findById(Long idProduct) {
        return this.productRepository.findById(idProduct);
    }

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Product update(Long idProduct, Product objProduct) {
        if(this.productRepository.existsById(idProduct))
        {
            objProduct.setId(idProduct);
            return this.productRepository.save(objProduct);
        }
        else return null;   
    }

    @Override
    public boolean delete(Long idProduct) {
        Optional <Product> optCliente = this.productRepository.findById(idProduct);
        if(optCliente.isPresent())
        {   this.productRepository.deleteById(idProduct);
            return true; 
        }
        return false;
    }

    
}
