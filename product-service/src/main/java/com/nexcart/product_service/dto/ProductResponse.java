package com.nexcart.product_service.dto;

import java.math.BigDecimal;

public record ProductResponse(Integer productId,
                              String productName,
                              BigDecimal productPrice,
                              String productDescription) {

}
