package com.samsung.postprojectshop.dto;

import com.samsung.postprojectshop.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDtoShort {

    private long id;
    private String name;
    private int cost;

    public static ProductDtoShort toDto(Product product) {
        return ProductDtoShort.builder()
                .id(product.getId())
                .name(product.getName())
                .cost(product.getCost())
                .build();
    }

    public static Product toEntity(ProductDtoShort dto) {
        Product.ProductBuilder builder = Product.builder()
                .name(dto.getName())
                .cost(dto.getCost())
                .description("empty");
        if (dto.getId() != 0) {
            builder.id(dto.getId());
        }
        return builder.build();
    }
}
