package com.ivan.face.developer.service;

import com.ivan.face.developer.impl.FinalImageSavingService;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Service
public class FinalImageJpgSavingService implements FinalImageSavingService {

    public void save(BufferedImage image) throws IOException {
        File outputFile = new File("contrastedFace3.jpg");
        ImageIO.write(image, "jpg", outputFile);
    }
}
