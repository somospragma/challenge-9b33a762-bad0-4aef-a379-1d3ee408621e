package com.ecommerce.infrastructure.controller;

import com.ecommerce.application.usecase.PaymentUseCase;
import com.ecommerce.domain.exception.PaymentFailedException;
import com.ecommerce.domain.model.Payment;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentUseCase paymentUseCase;

    @Autowired
    public PaymentController(PaymentUseCase paymentUseCase) {
        this.paymentUseCase = paymentUseCase;
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<Payment> processPayment(@Valid @RequestBody Payment payment) {
        try {
            Payment processedPayment = paymentUseCase.processPayment(payment);
            return new ResponseEntity<>(processedPayment, HttpStatus.CREATED);
        } catch (PaymentFailedException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}