package com.nexcart.product_service.controller;

import com.nexcart.product_service.dto.CreateProductRequest;
import com.nexcart.product_service.dto.ProductResponse;
import com.nexcart.product_service.entity.Product;
import com.nexcart.product_service.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService=productService;
    }

    @GetMapping
    public List<ProductResponse> getAllProducts(){
        return productService.getAllProducts();
    }

//Chnaging the createproduct method to Use the DTO
//    @PostMapping
//    public Product createProduct(@RequestBody Product product){
//        return productService.createProduct(product);
//    }


    @PostMapping
    public ProductResponse createProduct(@Valid  @RequestBody CreateProductRequest request){
        //System.out.println("@@@@request from frontend is "+request);
        return productService.createProduct(request);
    }


    @GetMapping("/{productId}")
    public ProductResponse getProductById(@PathVariable Integer productId){
        return productService.getProductById(productId);
    }




}
