package co.edu.unicauca.udevelopers.proyecto_api_rest_producto_mongo.controllers;

import java.util.*;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.edu.unicauca.udevelopers.proyecto_api_rest_producto_mongo.dtos.ProductDTO;
import co.edu.unicauca.udevelopers.proyecto_api_rest_producto_mongo.entities.Product;
import co.edu.unicauca.udevelopers.proyecto_api_rest_producto_mongo.services.IProductService;

@RestController
@CrossOrigin(origins={"http://localhost:4400","http://localhost:4200"})
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private IProductService productService;

	@PostMapping("/save")
    public ResponseEntity<?> save(@Valid @RequestBody ProductDTO objProductDTO){
        Map<String, Object> response = new HashMap<>();
        Product objProduct = new Product();
    	Product product = new Product();
        ProductDTO productDTO = new ProductDTO();
        
    
        try {
            objProduct.convertDTOToProduct(objProductDTO);
            product = this.productService.save(objProduct);
            productDTO.convertProductToDTO(product);
                            
        } catch (DataAccessException e){
            response.put("Mensaje", "Error al realizar la inserción en la base de datos");
            response.put("Error", e.getMessage() + " " + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<ProductDTO>(productDTO, HttpStatus.OK);
    }


	@GetMapping("/{id}")
    public ResponseEntity<?> searchForId(@PathVariable("id") Long idProduct){
        Map<String, Object> response = new HashMap<>();
            Product product = new Product();
            ProductDTO productDTO = new ProductDTO();
        try {
            Optional<Product> optProduct = this.productService.findById(idProduct);
            if (optProduct.isPresent()) {
                product = optProduct.get();
                productDTO.convertProductToDTO(product);
                                       
                return new ResponseEntity<ProductDTO>(productDTO, HttpStatus.OK);
            } else {
                response.put("Mensaje", "No se encontró el producto");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }
        } catch (DataAccessException e){
            response.put("Mensaje", "Error al realizar la busqueda en la base de datos");
            response.put("Error", e.getMessage() + " " + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/tolist")
	public ResponseEntity<?> toList(){
		ResponseEntity<?> response = new ResponseEntity<>("No hay ningun producto registrado", 
				HttpStatus.NOT_FOUND);

        List <ProductDTO> ArrayProductsDTO = new ArrayList<>();            
		List <Product> products = this.productService.findAll();
		if (!products.isEmpty()) {
            for(Product product: products)
            {
                ProductDTO productDTO = new ProductDTO();
                productDTO.convertProductToDTO(product);
                ArrayProductsDTO.add(productDTO);
            }
         
			response = new ResponseEntity<List <ProductDTO>>(ArrayProductsDTO, HttpStatus.OK);
		}
		return response;
	} 

	@PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long idProduct, @Valid @RequestBody ProductDTO objProductDTO){
        Map<String, Object> response = new HashMap<>();
        Product objProduct = new Product();
        Product product = new Product();
        ProductDTO productDTO = new ProductDTO();

        try {
            objProduct.convertDTOToProduct(objProductDTO);
            product = this.productService.update(idProduct, objProduct);
            productDTO.convertProductToDTO(product);
          
        } catch (DataAccessException e){
            response.put("mensaje", "Error al actualizar en la base de datos");
            response.put("Error", e.getMessage() + " " + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<ProductDTO>(productDTO, HttpStatus.OK);
    }

	@DeleteMapping("/delete/{id}")
    public ResponseEntity<?> eliminarPorId(@PathVariable("id") Long idProduct){
        Map<String, Object> response = new HashMap<>();
        
        try {
            if(productService.delete(idProduct))
            {   response.put("Exito","Se elimino correctamente");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
            }
            else
            {   response.put("Mensaje","el producto no existe");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }
        } catch (DataAccessException e){
            response.put("Mensaje", "Error al realizar la eliminacion en la base de datos");
            response.put("Error", e.getMessage() + " " + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
