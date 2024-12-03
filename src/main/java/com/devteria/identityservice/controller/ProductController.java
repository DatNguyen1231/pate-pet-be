    package com.devteria.identityservice.controller;

    import com.devteria.identityservice.dto.request.ProductRequest;
    import com.devteria.identityservice.entity.Product;
    import com.devteria.identityservice.service.ProductService;
    import lombok.AccessLevel;
    import lombok.RequiredArgsConstructor;
    import lombok.experimental.FieldDefaults;
    import org.springframework.http.ResponseEntity;
    import org.springframework.stereotype.Controller;
    import org.springframework.web.bind.annotation.*;
    import org.springframework.web.multipart.MultipartFile;

    import java.util.Date;
    import java.util.List;

    @Controller
    @RequiredArgsConstructor
    @RequestMapping("/product")
    @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
    public class ProductController {
        ProductService productService;


        @PostMapping("/save-product")
        public ResponseEntity saveProduct(@RequestParam String name,
                                          @RequestParam double price,
                                          @RequestParam List<MultipartFile> images,
                                          @RequestParam Date time){

            return ResponseEntity.ok(productService.saveProduct(name,price,images,time));
        }


        @PostMapping("/get-product/{pageNumber}/{pageSize}")
        public ResponseEntity getProduct(@PathVariable int pageNumber, @PathVariable int pageSize){


            return ResponseEntity.ok(productService.getAllProduct(pageNumber,pageSize));
        }
    }

