package Modules.ImageModules;

import Modules.AbstractModule;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GetNumberOfPixels extends AbstractModule {

    public GetNumberOfPixels(String supportedFormats) {
        super(supportedFormats);
    }

    @Override
    public String Discription() {
        return "Получение количества пикселей изображения";
    }

    @Override
    public void Function(File file) throws IOException {
        BufferedImage bimg = ImageIO.read(file);
        int pixels = bimg.getWidth() * bimg.getHeight();

        System.out.println("Количество пикселей:" + pixels);
    }
}
