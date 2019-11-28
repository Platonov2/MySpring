package Modules.DirectoryModules;

import Modules.AbstractModule;

import java.io.File;
import java.io.IOException;

public class GetNumberOfFiles extends AbstractModule {

    public GetNumberOfFiles(String supportedFormats) {
        super(supportedFormats);
    }

    @Override
    public String Discription() {
        return "Получение количества файлов в папке";
    }

    @Override
    public void Function(File file) throws IOException {
        File[] arrFiles = file.listFiles();

        System.out.println(arrFiles.length);
    }
}
