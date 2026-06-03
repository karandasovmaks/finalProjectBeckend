package com.samsung.postprojectshop.service;

import com.samsung.postprojectshop.domain.Product;
import com.samsung.postprojectshop.dto.ProductDtoShort;
import com.samsung.postprojectshop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    @Override
    public ProductDtoShort getById(long id) {
        Product product = repository.findById(id).orElseThrow(() ->
                new RuntimeException("product with id " + id + " was not found")
        );
        return ProductDtoShort.toDto(product);
    }

    @Override
    public ProductDtoShort create(ProductDtoShort dto) {
        Product saved = repository.save(ProductDtoShort.toEntity(dto));
        return ProductDtoShort.toDto(saved);
    }

    @Override
    public List<ProductDtoShort> getByCostLessThan(int cost) {
        return repository.findByCostLessThan(cost).stream()
                .map(ProductDtoShort::toDto)
                .toList();
    }
}
