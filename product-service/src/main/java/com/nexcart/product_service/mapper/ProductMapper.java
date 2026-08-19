package com.nexcart.product_service.mapper;

import com.nexcart.product_service.dto.CreateProductRequest;
import com.nexcart.product_service.dto.ProductResponse;
import com.nexcart.product_service.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toEntity(CreateProductRequest request){
        Product product=new Product();

        product.setProductPrice(request.productPrice());
        product.setProductDescription(request.productDescription());
        product.setProductName(request.productName());

        return product;
    }

    public ProductResponse toResponse(Product savedProduct){
        return new ProductResponse(savedProduct.getProductId(),savedProduct.getProductName(),savedProduct.getProductPrice(),savedProduct.getProductDescription());


    }
}
