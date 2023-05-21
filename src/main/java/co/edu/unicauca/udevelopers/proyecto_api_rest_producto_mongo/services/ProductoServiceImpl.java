package co.edu.unicauca.udevelopers.proyecto_api_rest_producto_mongo.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.unicauca.udevelopers.proyecto_api_rest_producto_mongo.entities.Producto;
import co.edu.unicauca.udevelopers.proyecto_api_rest_producto_mongo.repositories.ProductoRepository;

@Service
public class ProductoServiceImpl implements IProductoService{

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Producto save(Producto objProducto) {
       
        return this.productoRepository.save(objProducto);
    }

    @Override
    public Optional<Producto> findById(Long idProducto) {
        return this.productoRepository.findById(idProducto);
    }

    @Override
    public List<Producto> findAll() {
        return this.productoRepository.findAll();
    }

    @Override
    public Producto update(Long idProducto, Producto objProducto) {
        if(this.productoRepository.existsById(idProducto))
        {
            objProducto.setId(idProducto);
            return this.productoRepository.save(objProducto);
        }
        else return null;   
    }

    @Override
    public boolean delete(Long idProducto) {
        Optional <Producto> optCliente = this.productoRepository.findById(idProducto);
        if(optCliente.isPresent())
        {   this.productoRepository.deleteById(idProducto);
            return true; 
        }
        return false;
    }

    
}
