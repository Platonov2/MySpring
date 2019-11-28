package Modules.DirectoryModules;

import Modules.AbstractModule;

import java.io.File;
import java.util.List;

public class GetFilesFromDirectory extends AbstractModule {

    public GetFilesFromDirectory(String supportedFormats) {
        super(supportedFormats);
    }

    public String Discription() {
        return "Вывести список файлов из папки";
    }

    public void Function(File file) {
        File[] arrFiles = file.listFiles();

        for (File fileFromDir : arrFiles) {
            System.out.println(fileFromDir.getName());
        }
    }
}
