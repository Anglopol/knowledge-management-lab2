package com.ivan.face.developer.impl;

import java.awt.image.BufferedImage;

public interface NormalizingImageService {
    BufferedImage normalizeContrast(BufferedImage input);
}
