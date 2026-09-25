package com.ecommerce.domain.exception;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Excepción lanzada cuando falla el procesamiento de un pago.
 * Contiene detalles sobre el intento de pago para facilitar el seguimiento y la recuperación.
 */
public class PaymentFailedException extends RuntimeException {

    private final UUID paymentId;
    private final BigDecimal amount;
    private final String reason;

    /**
     * Constructor con detalles del pago fallido.
     * @param paymentId El ID del intento de pago.
     * @param amount El monto del pago.
     * @param reason La razón del fallo.
     */
    public PaymentFailedException(UUID paymentId, BigDecimal amount, String reason) {
        super("Pago con ID " + paymentId + " falló: " + reason + ". Monto: " + amount);
        this.paymentId = paymentId;
        this.amount = amount;
        this.reason = reason;
    }

    /**
     * Obtiene el ID del intento de pago.
     * @return El ID del pago.
     */
    public UUID getPaymentId() {
        return paymentId;
    }

    /**
     * Obtiene el monto del pago.
     * @return El monto.
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Obtiene la razón del fallo.
     * @return La razón del fallo.
     */
    public String getReason() {
        return reason;
    }
}