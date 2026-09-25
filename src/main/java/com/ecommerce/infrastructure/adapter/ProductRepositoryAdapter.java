package com.ecommerce.infrastructure.adapter;

import com.ecommerce.domain.model.Product;
import com.ecommerce.domain.port.ProductRepository;
import com.ecommerce.infrastructure.repository.ProductJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class ProductRepositoryAdapter implements ProductRepository {

    private final ProductJpaRepository productJpaRepository;

    @Autowired
    public ProductRepositoryAdapter(ProductJpaRepository productJpaRepository) {
        this.productJpaRepository = productJpaRepository;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productJpaRepository.findById(id).map(productEntity -> new Product(
                productEntity.getId(),
                productEntity.getName(),
                productEntity.getDescription(),
                productEntity.getPrice(),
                productEntity.getStock()
        ));
    }

    @Override
    public List<Product> findAll() {
        return productJpaRepository.findAll().stream().map(productEntity -> new Product(
                productEntity.getId(),
                productEntity.getName(),
                productEntity.getDescription(),
                productEntity.getPrice(),
                productEntity.getStock()
        )).toList();
    }

    @Override
    public Product save(Product product) {
        var productEntity = new com.ecommerce.infrastructure.repository.ProductEntity(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStock()
        );
        var savedEntity = productJpaRepository.save(productEntity);
        return new Product(
                savedEntity.getId(),
                savedEntity.getName(),
                savedEntity.getDescription(),
                savedEntity.getPrice(),
                savedEntity.getStock()
        );
    }

    @Override
    public void deleteById(Long id) {
        productJpaRepository.deleteById(id);
    }
}