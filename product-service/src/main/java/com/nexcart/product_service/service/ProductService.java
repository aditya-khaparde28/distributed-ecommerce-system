package com.nexcart.product_service.service;

import com.nexcart.product_service.dto.CreateProductRequest;
import com.nexcart.product_service.dto.ProductResponse;
import com.nexcart.product_service.entity.Product;
import com.nexcart.product_service.exception.ProductNotFoundException;
import com.nexcart.product_service.mapper.ProductMapper;
import com.nexcart.product_service.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository,ProductMapper productMapper){
        this.productRepository=productRepository;
        this.productMapper=productMapper;
    }
//Changing the createProduct method to use the DTO
//    public Product createProduct(Product product){
//        return productRepository.save(product);
//    }

    public ProductResponse createProduct(CreateProductRequest request){

       // System.out.println("Request Recived at service is "+request);
        Product product=new Product();
//        product.setProductName(request.productName());
//        product.setProductPrice(request.productPrice());
//        product.setProductDescription(request.productDescription());

        product=productMapper.toEntity(request);


        Product savedProduct=productRepository.save(product);
        //System.out.println("Saved Product is: "+savedProduct);
        //ProductResponse productResponse=new ProductResponse();
        ProductResponse productResponse=productMapper.toResponse(savedProduct);
//        return new ProductResponse(
//                savedProduct.getProductId(),
//                savedProduct.getProductName(),
//                savedProduct.getProductPrice(),
//                savedProduct.getProductDescription()
//        );

        return productResponse;





    }



    public List<ProductResponse> getAllProducts(){
        //Commenting and writing new below that
        //return productRepository.findAll();
        return productRepository.findAll().stream().map(productMapper::toResponse).toList();
    }

    public ProductResponse getProductById(Integer productId){
        Product product= productRepository.findById(productId).orElseThrow(()-> new ProductNotFoundException("Product Not Found with product id"+productId)
        );
        return new productMapper.toResponse(product);
    }

    public void deleteProduct(Integer productId){
        productRepository.deleteById(productId);
    }





}
