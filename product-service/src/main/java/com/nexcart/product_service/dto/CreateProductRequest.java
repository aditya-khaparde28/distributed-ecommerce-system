package com.nexcart.product_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


import java.math.BigDecimal;

public record CreateProductRequest(
        @NotBlank(message="Product Name is Required")
        String productName,
        @NotNull(message="Product Price is required")
        @Positive(message="Product Price must be greater than zero")
        BigDecimal productPrice,
        @NotBlank(message = "Product Description Is required")
        String productDescription) {



}
