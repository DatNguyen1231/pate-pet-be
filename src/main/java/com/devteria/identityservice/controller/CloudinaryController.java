package com.devteria.identityservice.controller;

import com.devteria.identityservice.Cloudinary.CloudinaryCustom;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/api/cloudinary")
public class CloudinaryController {

    private final CloudinaryCustom cloudinary;

    public CloudinaryController(CloudinaryCustom cloudinary) {
        this.cloudinary = cloudinary;
    }

//    @PostMapping("/upload")
//    public Map<String, Object> uploadImage(@RequestParam("file") MultipartFile file) {
//        return cloudinary.uploadImage(file);
//    }

    @DeleteMapping("/delete")
    public ResponseEntity<Map<String, Object>> deleteImage(@RequestParam("public_id") String publicId) {
       return null;
    }
}

