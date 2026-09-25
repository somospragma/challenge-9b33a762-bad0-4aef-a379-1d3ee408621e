package com.ecommerce.domain.exception;

import java.util.UUID;

/**
 * Excepción lanzada cuando un producto no se encuentra en el sistema.
 * Se utiliza para indicar que la operación no puede completarse debido a la ausencia del recurso.
 */
public class ProductNotFoundException extends RuntimeException {

    private final UUID productId;

    /**
     * Constructor con el ID del producto que no se encontró.
     * @param productId El ID del producto que no existe.
     */
    public ProductNotFoundException(UUID productId) {
        super("Producto con ID " + productId + " no encontrado.");
        this.productId = productId;
    }

    /**
     * Constructor con mensaje personalizado y el ID del producto.
     * @param message Mensaje descriptivo del error.
     * @param productId El ID del producto que no existe.
     */
    public ProductNotFoundException(String message, UUID productId) {
        super(message);
        this.productId = productId;
    }

    /**
     * Obtiene el ID del producto que no se encontró.
     * @return El ID del producto.
     */
    public UUID getProductId() {
        return productId;
    }
}