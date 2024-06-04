package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Product;
import repository.ProductRepository;

@Service
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  public List<Product> findAll() {
    return this.productRepository.findAll();
  }

  public Product findById(Long id) {
    return this.productRepository.findById(id).orElseThrow(() -> new RuntimeException("produto nao encontrado"));
  }

  public Product save(Product item) {
    return this.productRepository.save(item);
  }

  public void delete(Long id) {
    this.productRepository.deleteById(id);
  }

}
