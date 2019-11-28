package Modules.ImageModules;

import Modules.AbstractModule;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GetImageSize extends AbstractModule {

    public GetImageSize(String supportedFormats) {
        super(supportedFormats);
    }

    @Override
    public String Discription() {
        return "Вывод размера изображения";
    }

    @Override
    public void Function(File file) throws IOException {
        BufferedImage bimg = ImageIO.read(file);
        int width = bimg.getWidth();
        int height  = bimg.getHeight();

        System.out.println("Размер изображения: " + width + " x " + height);
    }
}
