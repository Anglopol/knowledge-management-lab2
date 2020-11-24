package com.ivan.face.developer.controller;

import com.ivan.face.developer.service.FaceDeveloperServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RestController
public class TheMostImportantController {
    private final FaceDeveloperServiceImpl faceDeveloperService;

    public TheMostImportantController(FaceDeveloperServiceImpl faceDeveloperService) {
        this.faceDeveloperService = faceDeveloperService;
    }

    @PutMapping(value = "", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody
    byte[] improveBrightness(MultipartFile file) throws IOException {
        BufferedImage bufferedImage = faceDeveloperService.performNotAllRequiredSteps(file);
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "jpg", bao);

        return bao.toByteArray();
    }
}
