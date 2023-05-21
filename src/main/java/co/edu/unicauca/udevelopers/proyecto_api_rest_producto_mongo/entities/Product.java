package co.edu.unicauca.udevelopers.proyecto_api_rest_producto_mongo.entities;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import co.edu.unicauca.udevelopers.proyecto_api_rest_producto_mongo.dtos.ProductDTO;

@Document(value = "product")
@JsonPropertyOrder({"id", "name", "description", "brand", "reference", "material", "price"})
public class Product {    

    @Id
    @NotNull 
    private Long id;
    private String name;
    private String description;
    private String brand;
    private String reference;
    private String material;
    private String price; 
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getReference() {
        return reference;
    }
    public void setReference(String reference) {
        this.reference = reference;
    }
    public String getMaterial() {
        return material;
    }
    public void setMaterial(String material) {
        this.material = material;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public Product() {
        
    }

    public void convertDTOToProduct(ProductDTO objProductDTO) {
        this.id = objProductDTO.getId();
        this.name = objProductDTO.getName();
        this.description = objProductDTO.getDescription();
        this.brand = objProductDTO.getBrand();
        this.reference = objProductDTO.getReference();
        this.material = objProductDTO.getMaterial();
        this.price = objProductDTO.getPrice();
    }
}
