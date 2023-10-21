package com.se331.zomsantech.controller;

import com.se331.zomsantech.util.CloudStorageHelper;
import jakarta.servlet.ServletException;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class BucketController {
    final CloudStorageHelper cloudStorageHelper;

    @PostMapping("/uploadFile")
    public ResponseEntity<?> uploadFile(@RequestPart(value = "file")MultipartFile file)
            throws ServletException, IOException {
        return ResponseEntity.ok(this.cloudStorageHelper.getFileUrl(file,"se-lab-331-imageuplaod.appspot.com"));
    }

    @PostMapping("/uploadImage")
    public ResponseEntity<?> uploadFileComponent(@RequestPart(value = "image") MultipartFile file)
            throws IOException, ServletException {
        return ResponseEntity.ok(this.cloudStorageHelper.getImageUrl(file, "se-lab-331-imageuplaod.appspot.com"));
    }
}
