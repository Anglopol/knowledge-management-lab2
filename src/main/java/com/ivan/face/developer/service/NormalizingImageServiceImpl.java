package com.ivan.face.developer.service;

import com.ivan.face.developer.impl.NormalizingImageService;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.image.BufferedImage;

@Service
public class NormalizingImageServiceImpl implements NormalizingImageService {
    /**
     * Функция, проводящая нормализацию изображения
     *
     * @param input входное изображение
     * @return нормализованное изображение
     */
    public BufferedImage normalizeContrast(BufferedImage input) {
        int width = input.getWidth();
        int height = input.getHeight();

        BufferedImage normalizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        int maxR = -300, minR = 300;
        int maxG = -300, minG = 300;
        int maxB = -300, minB = 300;

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Color currentColor = new Color(input.getRGB(i, j));
                int red = currentColor.getRed();
                int green = currentColor.getGreen();
                int blue = currentColor.getBlue();
                maxR = Math.max(maxR, red);
                minR = Math.min(minR, red);
                maxG = Math.max(maxG, green);
                minG = Math.min(minG, green);
                maxB = Math.max(maxB, blue);
                minB = Math.min(minB, blue);
            }
        }

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Color currentColor = new Color(input.getRGB(i, j));
                int r = (int) (currentColor.getRed() * (currentColor.getRed() - minR + 0.) / (maxR - minR + 0.));
                int g = (int) (currentColor.getGreen() * (currentColor.getGreen() - minG + 0.) / (maxG - minG + 0.));
                int b = (int) (currentColor.getBlue() * (currentColor.getBlue() - minB + 0.) / (maxB - minB + 0.));

                normalizedImage.setRGB(i, j, new Color(r, g, b).getRGB());
            }
        }

        return normalizedImage;
    }
}
