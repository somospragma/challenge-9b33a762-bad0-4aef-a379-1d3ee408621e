package com.ecommerce.application.usecase;

import com.ecommerce.domain.model.Product;
import com.ecommerce.domain.port.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductUseCase {

    private final ProductRepository productRepository;

    public ProductUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}