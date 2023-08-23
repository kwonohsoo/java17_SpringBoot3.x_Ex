package com.example.javaRecordCRUD.service;

import com.example.javaRecordCRUD.dto.ProductDTO;
import com.example.javaRecordCRUD.entity.Product;
import com.example.javaRecordCRUD.reposity.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public ProductDTO.ProductResponse createProduct(ProductDTO.ProductRequest request) {
        Product product = request.toEntity();
        productRepository.save(product);
        return new ProductDTO.ProductResponse(product);
    }

    public List<ProductDTO.ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(ProductDTO.ProductResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public ProductDTO.ProductResponse updateProduct(Long id, ProductDTO.ProductRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("상품을 찾을 수 없습니다."));

        product.setName(request.name());
        product.setPrice(request.price());

        return new ProductDTO.ProductResponse(product);
    }

    @Transactional
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("상품을 찾을 수 없습니다."));
        productRepository.delete(product);
    }

}
