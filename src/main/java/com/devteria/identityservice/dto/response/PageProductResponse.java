package com.devteria.identityservice.dto.response;

import com.devteria.identityservice.entity.Product;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PageProductResponse {

    List<Product> products;
    int pageNumber;
    int pageSize;
    int pageElement;
    int totalPages;
    boolean empty;

    public PageProductResponse(Page<Product> productPage,int pageNumber,int pageSize ){
        this.products=productPage.getContent();
        this.pageNumber=pageNumber;
        this.pageNumber=productPage.getTotalPages();
        this.pageSize=pageSize;
        this.pageElement=productPage.getNumberOfElements();
        this.totalPages=productPage.getTotalPages();
        this.empty=productPage.getContent().isEmpty();

    }


}
