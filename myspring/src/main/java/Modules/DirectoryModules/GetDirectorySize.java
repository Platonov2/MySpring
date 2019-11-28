package Modules.DirectoryModules;

import Modules.AbstractModule;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class GetDirectorySize extends AbstractModule {

    public GetDirectorySize(String supportedFormats) {
        super(supportedFormats);
    }

    @Override
    public String Discription() {
        return "Получение размера папки в байтах";
    }

    @Override
    public void Function(File file) throws IOException {
        List<File> arrFiles = Files.walk(file.toPath())
                .filter(Files::isRegularFile)
                .map(Path::toFile)
                .collect(Collectors.toList());
        int size = 0;

        for (File fileFromDir : arrFiles) {
            size += fileFromDir.length();
        }

        System.out.println(size);
    }
}
