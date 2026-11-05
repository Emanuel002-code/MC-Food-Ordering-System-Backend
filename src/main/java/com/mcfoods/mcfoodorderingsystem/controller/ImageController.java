package com.mcfoods.mcfoodorderingsystem.controller;

import com.mcfoods.mcfoodorderingsystem.service.ImageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api/images")
@CrossOrigin(origins = "http://localhost:5173")
public class ImageController {


    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadImage(
            @RequestParam("image") MultipartFile image) {

        try {
            String imageName = imageService.uploadImage(image);

            return ResponseEntity.ok(
                    Map.of(
                            "message", "Image uploaded successfully",
                            "imageName", imageName
                    )
            );

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(
                    Map.of("error", e.getMessage())
            );

        } catch (IOException e) {
            return ResponseEntity.internalServerError().body(
                    Map.of("error", "Failed to upload image")
            );
        }
    }
}
