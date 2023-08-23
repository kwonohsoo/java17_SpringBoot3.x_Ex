package com.example.javaRecordCRUD.dto;

import com.example.javaRecordCRUD.entity.Product;

//@ApiModel(value = "상품 CRUD 응답 정보")
public record ProductDTO() {

//    @ApiModel(description = "ProductRequest")
    public record ProductRequest(
//            @ApiModelProperty(value = "상품 이름")
            String name,
//            @ApiModelProperty(value = "상품 가격")
            int price
    ) {
        public Product toEntity() {
            return Product.builder()
                    .name(name)
                    .price(price)
                    .build();
        }
    }

//    @ApiModel(description = "ProductResponse")
    public record ProductResponse(
//            @ApiModelProperty(value = "상품 ID")
            Long id,
//            @ApiModelProperty(value = "상품 이름")
            String name,
//            @ApiModelProperty(value = "상품 가격")
            int price
    ) {
        public ProductResponse(Product product) {
            this(product.getId(), product.getName(), product.getPrice());
        }
    }
}
