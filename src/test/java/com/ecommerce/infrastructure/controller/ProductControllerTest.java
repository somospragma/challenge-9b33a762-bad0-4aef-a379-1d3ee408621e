package com.ecommerce.infrastructure.controller;

import com.ecommerce.domain.model.Product;
import com.ecommerce.domain.port.ProductRepository;
import com.ecommerce.infrastructure.controller.ProductController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductController productController;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void testGetProductById() throws Exception {
        Product product = new Product(UUID.randomUUID(), "Test Product", 100.0);
        when(productRepository.findById(any(UUID.class))).thenReturn(java.util.Optional.of(product));

        mockMvc.perform(get("/products/{id}", product.getId())
                       .contentType(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk());
    }
}