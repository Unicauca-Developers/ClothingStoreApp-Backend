package co.edu.unicauca.udevelopers.proyecto_api_rest_producto_mongo.entities;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import co.edu.unicauca.udevelopers.proyecto_api_rest_producto_mongo.dtos.ProductoDTO;

@Document(value = "producto")
@JsonPropertyOrder({"id", "nombre","descripcion", ",marca","referencia", "material","precio"})
public class Producto {    

    @Id
    @NotNull 
    private Long id;
    private String nombre;
    private String descripcion;
    private String marca;
    private String referencia;
    private String material;
    private String precio; 
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getReferencia() {
        return referencia;
    }
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
    public String getMaterial() {
        return material;
    }
    public void setMaterial(String material) {
        this.material = material;
    }
    public String getPrecio() {
        return precio;
    }
    public void setPrecio(String precio) {
        this.precio = precio;
    }
    public Producto() {
        
    }

    public void convertirDTO_a_Producto (ProductoDTO objProductoDTO)
    {
        this.id = objProductoDTO.getId();
        this.nombre = objProductoDTO.getNombre();
        this.descripcion = objProductoDTO.getDescripcion();
        this.marca = objProductoDTO.getMarca();
        this.referencia = objProductoDTO.getReferencia();
        this.material = objProductoDTO.getMaterial();
        this.precio = objProductoDTO.getPrecio();
    }


}
