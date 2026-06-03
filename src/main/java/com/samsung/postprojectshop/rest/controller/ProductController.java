package com.samsung.postprojectshop.rest.controller;

import com.samsung.postprojectshop.dto.ProductCreateRequest;
import com.samsung.postprojectshop.dto.ProductDtoShort;
import com.samsung.postprojectshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("product/{id}")
    public ProductDtoShort getById(@PathVariable long id) {
        return productService.getById(id);
    }

    @PostMapping("product")
    public ProductDtoShort create(@RequestBody ProductCreateRequest request) {
        ProductDtoShort dto = ProductDtoShort.builder()
                .name(request.name())
                .cost(request.cost())
                .build();
        return productService.create(dto);
    }
}
