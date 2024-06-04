package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import model.Product;
import service.ProductService;

@Tag(name = "Product", description = "Controle de criação e manutenção de produto")
@RestController
@RequestMapping("/api/Product")
public class ProductController {
  
  @Autowired
  private ProductService productService;

  @GetMapping()
  public List<Product> findAll(){
    return this.productService.findAll();
  }

  @GetMapping("/{id}")
  public Product findById(@PathVariable("id") Long id){
    return this.productService.findById(id);
  }

  @PostMapping
    public Product save(@RequestBody Product product){
        return this.productService.save(product);
    }

    @PutMapping
    public Product update(@RequestBody Product product){
        return this.productService.save(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        this.productService.delete(id);
    }




}
