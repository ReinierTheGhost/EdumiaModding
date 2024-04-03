package com.legends.edumia.world.chunkgen.map;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.DataBufferByte;
import java.awt.image.Kernel;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

public class ImageUtils {
    private static byte[] SEED = generateSeed(50);
    private static int SEED_INDEX = 0;
    public static int BRUSH_SIZE = 16;
    public static float RATIO = 1.0f / (BRUSH_SIZE * BRUSH_SIZE);

    public static BufferedImage fetchResourceImage(ClassLoader classLoader, String path) throws IOException {
        URL resource = classLoader.getResource(path);
        BufferedImage img = ImageIO.read(resource);
        return img;
    }

    public static BufferedImage fetchRunImage(String path) throws Exception {
        File f = new File(path);
        //System.out.println(f.getAbsolutePath());
        if(!f.exists()) return null;

        BufferedImage img = ImageIO.read(f);
        return img;
    }

    public static void saveImage(BufferedImage bufferedImage, String path, String fileName) throws Exception {
        new File(path).mkdirs();
        File f = new File(path + fileName);
        ImageIO.write(bufferedImage, "png", f);
    }
    public static BufferedImage blur(BufferedImage image) {
        float[] blurKernel = new float[BRUSH_SIZE * BRUSH_SIZE];
        Arrays.fill(blurKernel, RATIO);
        Kernel kernel = new Kernel(BRUSH_SIZE, BRUSH_SIZE, blurKernel);
        ConvolveOp op = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);

        return op.filter(image, null);
    }

    public static int[][] convertTo2D(BufferedImage image) {

        final byte[] pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        final int width = image.getWidth();
        final int height = image.getHeight();
        final boolean hasAlphaChannel = image.getAlphaRaster() != null;

        int[][] result = new int[height][width];
        final int pixelLength = (hasAlphaChannel) ? 4 : 3;

        if (hasAlphaChannel) {
            for (int pixel = 0, row = 0, col = 0; pixel + 3 < pixels.length; pixel += pixelLength) {
                int argb = 0;
                argb += (((int) pixels[pixel] & 0xff) << 24); // alpha
                argb += ((int) pixels[pixel + 1] & 0xff); // blue
                argb += (((int) pixels[pixel + 2] & 0xff) << 8); // green
                argb += (((int) pixels[pixel + 3] & 0xff) << 16); // red
                result[row][col] = argb;
                col++;
                if (col == width) {
                    col = 0;
                    row++;
                }
            }
        } else {
            for (int pixel = 0, row = 0, col = 0; pixel + 2 < pixels.length; pixel += pixelLength) {
                int argb = 0;
                argb += -16777216; // 255 alpha
                argb += ((int) pixels[pixel] & 0xff); // blue
                argb += (((int) pixels[pixel + 1] & 0xff) << 8); // green
                argb += (((int) pixels[pixel + 2] & 0xff) << 16); // red
                result[row][col] = argb;
                col++;
                if (col == width) {
                    col = 0;
                    row++;
                }
            }
        }
        return result;
    }

    public static byte[] generateSeed(int bound){
        String piString = "31415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679";

        byte[] piBytes = new byte[piString.length()];
        for (int i = 0; i < piString.length(); i++) {
            piBytes[i] = Byte.parseByte(String.valueOf(piString.charAt(i)));
        }

        SEED = piBytes;
        SEED_INDEX = bound % piBytes.length;

        return SEED;
    }

    public static byte getNextSeed(){
        SEED_INDEX ++;
        if(SEED_INDEX >= SEED.length){
            SEED_INDEX = 0;
        }
        return SEED[SEED_INDEX];
    }
}
