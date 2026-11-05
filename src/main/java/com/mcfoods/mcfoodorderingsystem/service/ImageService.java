package com.mcfoods.mcfoodorderingsystem.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
public class ImageService {

    @Value("${app.upload.dir}")
    private String uploadDir;

    public String uploadImage(MultipartFile file)
            throws IOException {

        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException(
                    "Please select an image"
            );
        }

        String contentType = file.getContentType();

        if (!List.of("image/jpeg", "image/png",
                "image/webp").contains(contentType)) {
            throw new IllegalArgumentException(
                    "Only JPG, PNG and WebP are allowed"
            );
        }

        assert contentType != null;
        String extension = switch (contentType) {
            case "image/jpeg" -> ".jpg";
            case "image/png" -> ".png";
            case "image/webp" -> ".webp";
            default -> throw new IllegalArgumentException(
                    "Unsupported image format"
            );
        };

        String fileName = UUID.randomUUID() + extension;

        Path directory = Paths.get(uploadDir)
                .toAbsolutePath().normalize();

        Files.createDirectories(directory);

        Path destination = directory.resolve(fileName);

        Files.copy(file.getInputStream(), destination);

        return fileName;
    }
}
