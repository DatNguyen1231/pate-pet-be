package com.devteria.identityservice.service;

import com.devteria.identityservice.Cloudinary.CloudinaryCustom;
import com.devteria.identityservice.dto.request.ProductRequest;
import com.devteria.identityservice.dto.response.PageProductResponse;
import com.devteria.identityservice.entity.Image;
import com.devteria.identityservice.entity.Product;
import com.devteria.identityservice.mapper.ProductMapper;
import com.devteria.identityservice.repository.ProductRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductService {
    ProductRepository productRepository;
    CloudinaryCustom cloudinaryCustom;
    ProductMapper productMapper;
    public String saveProduct(ProductRequest productRequest){

        System.out.println(productRequest);

        return "true";
    }

    public PageProductResponse getAllProduct(int pageNumber,int pageSize ){

        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Product> productsPage = productRepository.findAll(pageable);

        PageProductResponse pageProductResponse= new PageProductResponse(productsPage,pageNumber, pageSize);
        return pageProductResponse;
    }

    public Product saveProduct(String name, double price, List<MultipartFile> images, Date time) {

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setTime(LocalDate.now());

        List<Image> imageList = cloudinaryCustom.listImg(images);

        product.setImages(imageList);


        productRepository.save(product);


        return product;
    }
}
