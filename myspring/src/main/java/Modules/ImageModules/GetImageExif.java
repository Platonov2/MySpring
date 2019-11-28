package Modules.ImageModules;

import Modules.AbstractModule;
import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GetImageExif extends AbstractModule {

    public GetImageExif(String supportedFormats) {
        super(supportedFormats);
    }

    @Override
    public String Discription() {
        return null;
    }

    @Override
    public void Function(File file) throws IOException {
        StringBuilder answer = new StringBuilder("Информация exif \n" );

        /*ArrayList<Directory> directories = (ArrayList<Directory>) metadata.getDirectories();
        for (Tag tag : directories.get(2).getTags()){
            answer.append(tag.getTagName() + " : " + tag.getDescription() + "\n");
        }*/

    }
}
