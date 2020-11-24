package com.ivan.face.developer.service;

import com.ivan.face.developer.impl.NormalizingImageService;
import com.ivan.face.developer.impl.SmoothBrightEnhancementBasicService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Service
public class FaceDeveloperServiceImpl {
    private final NormalizingImageService normalizingImageService;
    private final SmoothBrightEnhancementBasicService smoothBrightEnhancementBasicService;


    public FaceDeveloperServiceImpl(NormalizingImageService normalizingImageService,
                                    SmoothBrightEnhancementBasicService smoothBrightEnhancementBasicService) {
        this.normalizingImageService = normalizingImageService;
        this.smoothBrightEnhancementBasicService = smoothBrightEnhancementBasicService;
    }

    public BufferedImage performNotAllRequiredSteps(MultipartFile file) throws IOException {
        return normalizingImageService.normalizeContrast(
                smoothBrightEnhancementBasicService.increaseBright(
                        ImageIO.read(file.getInputStream())
                )
        );


    }
}
