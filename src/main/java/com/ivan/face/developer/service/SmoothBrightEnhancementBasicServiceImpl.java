package com.ivan.face.developer.service;

import com.ivan.face.developer.impl.SmoothBrightEnhancementBasicService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.image.BufferedImage;

@Service
public class SmoothBrightEnhancementBasicServiceImpl implements SmoothBrightEnhancementBasicService {
    @Value("${com.ivan.bright.coefficient}")
    private int brightCoefficient;

    /**
     * Функция, повышаюшая яркость яркость изображения
     *
     * @param input входное изображение
     * @return изображение с повышенной яркостью
     */
    public BufferedImage increaseBright(BufferedImage input) {
        int width = input.getWidth();
        int height = input.getHeight();
        BufferedImage brightImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Color currentColor = new Color(input.getRGB(i, j));

                int r = Math.min(currentColor.getRed() + brightCoefficient, 255);
                int b = Math.min(currentColor.getBlue() + brightCoefficient, 255);
                int g = Math.min(currentColor.getGreen() + brightCoefficient, 255);

                brightImage.setRGB(i, j, new Color(r, g, b).getRGB());
            }
        }

        return brightImage;
    }

}
