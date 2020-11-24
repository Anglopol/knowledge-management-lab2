package com.ivan.face.developer.impl;

import java.awt.image.BufferedImage;
import java.io.IOException;

public interface FinalImageSavingService {
    void save(BufferedImage image) throws IOException;
}
