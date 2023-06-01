package co.edu.unicauca.udevelopers.proyecto_api_rest_producto_mongo.dtos;

import java.io.Serializable;
import co.edu.unicauca.udevelopers.proyecto_api_rest_producto_mongo.entities.Product;

public class ProductDTO implements Serializable {
    
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

    public ProductDTO() {
    } 

    public void convertProductToDTO(Product objProduct) {
        this.id = objProduct.getId();
        this.name = objProduct.getName();
        this.description = objProduct.getDescription();
        this.brand = objProduct.getBrand();
        this.reference = objProduct.getReference();
        this.material = objProduct.getMaterial();
        this.price = objProduct.getPrice();
    }
}