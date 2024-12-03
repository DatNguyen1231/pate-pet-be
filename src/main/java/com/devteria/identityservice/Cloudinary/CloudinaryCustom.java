package com.devteria.identityservice.Cloudinary;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.devteria.identityservice.entity.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
@Component
public class CloudinaryCustom {

    private final Cloudinary cloudinary;

    public CloudinaryCustom(
            @Value("${cloudinary.cloud_name}") String cloudName,
            @Value("${cloudinary.api_key}") String apiKey,
            @Value("${cloudinary.api_secret}") String apiSecret) {
        this.cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", cloudName,
                "api_key", apiKey,
                "api_secret", apiSecret
        ));
    }

    public Image uploadImage(MultipartFile file) {

        // Kiểm tra Content-Type của file (chỉ cho phép ảnh)
        String contentType = file.getContentType();
        if (contentType == null || !contentType.startsWith("image/")) {
            throw new IllegalArgumentException("Only image files are allowed.");
        }

        // Kiểm tra kích thước của file (giới hạn dưới 1MB)
        long maxSize =1* 1024 * 1024; // 1MB
        if (file.getSize() > maxSize) {
            throw new IllegalArgumentException("File size must be under 1MB.");
        }
        // Lấy tên gốc của file và loại bỏ phần mở rộng
        String originalFilename = file.getOriginalFilename();
        String fileNameWithoutExtension = originalFilename != null
                ? originalFilename.substring(0, originalFilename.lastIndexOf('.'))
                : "default_name";

        Image img= new Image();

        try {
            // Tạo bản đồ tùy chọn với `public_id`
            Map<String, Object> options = ObjectUtils.asMap(
                    "display_name", fileNameWithoutExtension
            );
            Map<String, Object> uploadResult = cloudinary.uploader().upload(file.getBytes(), options);
            img.setUrl(uploadResult.get("url").toString());
            img.setPublic_id(uploadResult.get("public_id").toString());
            img.setCreated_at(LocalDate.now());
            img.setDisplay_name(uploadResult.get("display_name").toString());

        }catch (Exception e) {
            // Xử lý lỗi nếu có
            e.printStackTrace();
            throw new RuntimeException("Error uploading image: " + e.getMessage());
        }

        return img ;


    }

    public List<Image> listImg(List<MultipartFile> files){

        List<Image> images = new ArrayList<>();
        for (MultipartFile file:files){
            images.add(uploadImage(file))    ;
        }
        return images;
    }

    public Map<String, Object> deleteImage(String publicId) {
        try {
            // Xóa ảnh khỏi Cloudinary bằng public_id
            Map<String, Object> result = cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());

            return result ;
        } catch (Exception e) {
            return null;
        }
    }


}
