package com.example.test.models.products.services.impl;

import com.example.test.exceptions.PageEndException;
import com.example.test.models.brands.dtos.BrandDto;
import com.example.test.models.product_categories.dtos.ProductCategoryDto;
import com.example.test.models.products.dtos.ProductDto;
import com.example.test.models.products.entities.ProductEntity;
import com.example.test.models.products.repo.ProductRepository;
import com.example.test.models.products.services.ProductService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    private ModelMapper modelMapper = new ModelMapper();
    protected ProductDto entityToDto(ProductEntity productEntity) {
        ProductDto productDto = new ProductDto();
        productDto = modelMapper.map(productEntity, ProductDto.class);
        ProductCategoryDto productCategoryDto = modelMapper.map(productEntity.getProductCategoryEntity(), ProductCategoryDto.class);
        BrandDto brandDto = modelMapper.map(productEntity.getBrandEntity(), BrandDto.class);
        productDto.setProductCategoryDto(productCategoryDto);
        productDto.setBrandDto(brandDto);
        return productDto;
    }
    protected List<ProductDto> entities2Dtos(List<ProductEntity> productEntities){
        List<ProductDto> productDtos = productEntities.stream().map(en -> entityToDto(en)).collect(Collectors.toList());
        return  productDtos;
    }
    @Override
    public List<ProductDto> getAllProducts(Integer pageNo, Integer pageSize){
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<ProductEntity> productEntities = productRepository.findAll(pageable);
        Page<ProductDto> productDtos = productEntities.map(new Function<ProductEntity, ProductDto>() {
            @Override
            public ProductDto apply(ProductEntity productEntity) {
                return modelMapper.map(productEntity, ProductDto.class);
            }
        });
        List<ProductDto> productDtoList = productDtos.getContent();
        if(productDtoList.isEmpty()){
            throw new PageEndException("Đã hết trang!");
        } else {
            return productDtoList;
        }
    }
    @Override
    public ProductDto findByProductId(Long productId){
        Optional<ProductEntity> productEntity = productRepository.findByProductId(productId);
        ProductDto productDto = new ProductDto();
        if(productEntity.isPresent()){
           productDto = entityToDto(productEntity.get());
        }
        else{
            throw new EntityNotFoundException("Không tìm thấy sản phẩm!");
        }
        return productDto;
    }
}
