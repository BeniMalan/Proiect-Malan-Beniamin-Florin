package org.fastrackit.PhotoApp.Service;

import org.fastrackit.PhotoApp.Model.Image;
import org.fastrackit.PhotoApp.Repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@Service
public class ImageService {
    private final ImageRepository imageRepository;
    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }
    public Image getImageById(Long id) {
        return imageRepository.findById(id).orElseThrow(() -> new RuntimeException("Image not found"));
    }

    public Image uploadImage(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getOriginalFilename());
        image.setPicByte(file.getBytes());
        return imageRepository.save(image);
    }
    public void deleteImage(Long id) {
        imageRepository.deleteById(id);
    }

}
