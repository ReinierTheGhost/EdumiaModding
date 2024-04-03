package com.legends.edumia.utils.resources;

import com.legends.edumia.world.chunkgen.map.ImageUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FileUtils {
    private static FileUtils single_instance = null;

    public static synchronized FileUtils getInstance()
    {
        if (single_instance == null)
            single_instance = new FileUtils(ClassLoader.getSystemClassLoader());

        return single_instance;
    }

    private ClassLoader classLoader;

    public FileUtils(ClassLoader classLoader){
        this.classLoader = classLoader;
    }

    public BufferedImage getResourceImage(String path) {
        try{
            return ImageUtils.fetchResourceImage(getClass().getClassLoader(), path);
        } catch (IOException e) {
            return null;
        }
    }

    public BufferedImage getRunImage(String path) {
        try{
            File f = new File(path);
            if(!f.exists())
                return null;
            return ImageIO.read(f);
        } catch (IOException e) {
            return null;
        }
    }
}
