package co.edu.unicauca.udevelopers.proyecto_api_rest_producto_mongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import co.edu.unicauca.udevelopers.proyecto_api_rest_producto_mongo.entities.Producto;

public interface ProductoRepository extends MongoRepository<Producto, Long>{

}
