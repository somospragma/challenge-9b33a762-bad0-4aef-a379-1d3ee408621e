package com.ecommerce.domain.exception;

/**
 * Excepción lanzada cuando falla la autenticación de un usuario.
 * Superficie de práctica para que el participante implemente el manejo adecuado.
 */
public class AuthenticationException extends RuntimeException {

    /**
     * Constructor con mensaje descriptivo.
     * @param message Mensaje que describe el error de autenticación.
     */
    public AuthenticationException(String message) {
        super(message);
    }

    /**
     * Constructor con mensaje y causa raíz.
     * @param message Mensaje que describe el error.
     * @param cause Causa raíz del error.
     */
    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}