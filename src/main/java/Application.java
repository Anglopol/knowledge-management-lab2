//import com.sun.org.apache.bcel.internal.util.ClassLoader;
//
//import javax.imageio.ImageIO;
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import java.net.URISyntaxException;
//import java.net.URL;
//
///**
// * Версия без спринга
// */
//public class Application {
//    /**
//     * Коэффициент повышения яркости
//     */
//    private static final int BRIGHT_COEFFICIENT = 50;
//
//    /**
//     * Считывание и запись файлов.
//     */
//    public static void main(String[] args) throws IOException, URISyntaxException {
//        URL systemResource = ClassLoader.getSystemResource("3.jpg");
//        File inputFile = new File(systemResource.toURI());
//        File outputFile = new File("contrastedFace3.jpg");
//        BufferedImage inputImage = ImageIO.read(inputFile);
//        BufferedImage brightImage = increaseBright(inputImage);
//        ImageIO.write(normalizeContrast(brightImage), "jpg", outputFile);
//    }
//
//    /**
//     * Функция, повышаюшая яркость яркость изображения
//     *
//     * @param input входное изображение
//     * @return изображение с повышенной яркостью
//     */
//    private static BufferedImage increaseBright(BufferedImage input) {
//        int width = input.getWidth();
//        int height = input.getHeight();
//        BufferedImage brightImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//
//        for (int i = 0; i < width; i++) {
//            for (int j = 0; j < height; j++) {
//                Color currentColor = new Color(input.getRGB(i, j));
//
//                int r = Math.min(currentColor.getRed() + BRIGHT_COEFFICIENT, 255);
//                int b = Math.min(currentColor.getBlue() + BRIGHT_COEFFICIENT, 255);
//                int g = Math.min(currentColor.getGreen() + BRIGHT_COEFFICIENT, 255);
//
//                brightImage.setRGB(i, j, new Color(r, g, b).getRGB());
//            }
//        }
//
//        return brightImage;
//    }
//
//    /**
//     * Функция, проводящая нормализацию изображения
//     *
//     * @param input входное изображение
//     * @return нормализованное изображение
//     */
//    private static BufferedImage normalizeContrast(BufferedImage input) {
//        int width = input.getWidth();
//        int height = input.getHeight();
//
//        BufferedImage normalizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//
//        int maxR = -300, minR = 300;
//        int maxG = -300, minG = 300;
//        int maxB = -300, minB = 300;
//
//        for (int i = 0; i < width; i++) {
//            for (int j = 0; j < height; j++) {
//                Color currentColor = new Color(input.getRGB(i, j));
//                int red = currentColor.getRed();
//                int green = currentColor.getGreen();
//                int blue = currentColor.getBlue();
//                maxR = Math.max(maxR, red);
//                minR = Math.min(minR, red);
//                maxG = Math.max(maxG, green);
//                minG = Math.min(minG, green);
//                maxB = Math.max(maxB, blue);
//                minB = Math.min(minB, blue);
//            }
//        }
//
//        for (int i = 0; i < width; i++) {
//            for (int j = 0; j < height; j++) {
//                Color currentColor = new Color(input.getRGB(i, j));
//                int r = (int) (currentColor.getRed() * (currentColor.getRed() - minR + 0.) / (maxR - minR + 0.));
//                int g = (int) (currentColor.getGreen() * (currentColor.getGreen() - minG + 0.) / (maxG - minG + 0.));
//                int b = (int) (currentColor.getBlue() * (currentColor.getBlue() - minB + 0.) / (maxB - minB + 0.));
//
//                normalizedImage.setRGB(i, j, new Color(r, g, b).getRGB());
//            }
//        }
//
//        return normalizedImage;
//    }
//}
