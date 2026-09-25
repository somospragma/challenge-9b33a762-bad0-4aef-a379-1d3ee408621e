package com.ecommerce.infrastructure.adapter;

import com.ecommerce.domain.model.Product;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ProductValidator implements ConstraintValidator<ValidProduct, Product> {

    @Override
    public boolean isValid(Product product, ConstraintValidatorContext context) {
        if (product == null) {
            return false;
        }
        if (product.getName() == null || product.getName().isEmpty()) {
            return false;
        }
        if (product.getPrice() == null || product.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            return false;
        }
        return true;
    }
}