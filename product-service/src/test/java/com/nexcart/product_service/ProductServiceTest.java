package com.nexcart.product_service;

import com.nexcart.product_service.dto.ProductResponse;
import com.nexcart.product_service.entity.Product;
import com.nexcart.product_service.exception.ProductNotFoundException;
import com.nexcart.product_service.mapper.ProductMapper;
import com.nexcart.product_service.repository.ProductRepository;
import com.nexcart.product_service.service.ProductService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    private final ProductRepository productRepository =
            mock(ProductRepository.class);

    private final ProductMapper productMapper =
            mock(ProductMapper.class);

    private final ProductService productService =
            new ProductService(productRepository, productMapper);

    @Test
    void shouldReturnProductWhenProductExists() {

        Product product = new Product(
                "iPhone",
                new BigDecimal("999.99"),
                "Apple smartphone"
        );

        ProductResponse response = new ProductResponse(
                1,
                "iPhone",
                new BigDecimal("999.99"),
                "Apple smartphone"
        );

        when(productRepository.findById(1))
                .thenReturn(Optional.of(product));

        when(productMapper.toResponse(product))
                .thenReturn(response);

        ProductResponse result = productService.getProductById(1);

        assertEquals(response, result);

        verify(productRepository).findById(1);
        verify(productMapper).toResponse(product);
    }

    @Test
    void shouldThrowExceptionWhenProductDoesNotExist() {

        when(productRepository.findById(99))
                .thenReturn(Optional.empty());

        assertThrows(
                ProductNotFoundException.class,
                () -> productService.getProductById(99)
        );

        verify(productRepository).findById(99);
        verify(productMapper, never()).toResponse(any());
    }
}