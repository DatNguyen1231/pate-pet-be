package com.devteria.identityservice.dto.request;

import com.devteria.identityservice.entity.Image;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductRequest {

    String name;
    double price;
    List<MultipartFile> images;
    Date time;

    public ProductRequest(String name, double price, List<MultipartFile>images,Date time){
        this.name=name;
        this.price=price;
        this.images=images;
        this.time=time;
    }
}
