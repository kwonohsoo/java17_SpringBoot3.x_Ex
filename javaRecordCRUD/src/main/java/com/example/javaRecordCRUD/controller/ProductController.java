package com.example.javaRecordCRUD.controller;

import com.example.javaRecordCRUD.dto.ProductDTO;
import com.example.javaRecordCRUD.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
//@Api(tag = "상품 관리")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

//    SwaggerURL : http://localhost:8080/swagger-ui/index.html

    private final ProductService productService;

//    @ApiOperation(value = "상품 생성 API", notes = "상품 생성")
    @PostMapping("/create")
    public ResponseEntity<ProductDTO.ProductResponse> createProduct(@RequestBody ProductDTO.ProductRequest request) {
        ProductDTO.ProductResponse response = productService.createProduct(request);
        return ResponseEntity.ok(response);
    }

//    @ApiOperation(value = "상품 조회 API", notes = "상품 조회")
    @GetMapping("/search")
    public ResponseEntity<List<ProductDTO.ProductResponse>> getAllProducts() {
        List<ProductDTO.ProductResponse> responses = productService.getAllProducts();
        return ResponseEntity.ok(responses);
    }

//    @ApiOperation(value = "상품 수정 API", notes = "상품 수정")
    @PutMapping("/update/{id}")
    public ResponseEntity<ProductDTO.ProductResponse> updateProduct(
            @PathVariable Long id,
            @RequestBody ProductDTO.ProductRequest request
    ) {
        ProductDTO.ProductResponse response = productService.updateProduct(id, request);
        return ResponseEntity.ok(response);
    }

//    @ApiOperation(value = "상품 삭제 API", notes = "상품 삭제")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
