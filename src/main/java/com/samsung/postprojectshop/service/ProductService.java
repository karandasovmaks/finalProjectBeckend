package com.samsung.postprojectshop.service;

import com.samsung.postprojectshop.dto.ProductDtoShort;

import java.util.List;

public interface ProductService {
    ProductDtoShort getById(long id);
    ProductDtoShort create(ProductDtoShort dto);
    List<ProductDtoShort> getByCostLessThan(int cost);
}
