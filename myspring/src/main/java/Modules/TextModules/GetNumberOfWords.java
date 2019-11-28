package Modules.TextModules;

import Modules.AbstractModule;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class GetNumberOfWords extends AbstractModule {

    public GetNumberOfWords(String supportedFormats) {
        super(supportedFormats);
    }

    @Override
    public String Discription() {
        return "Получение количества слов в файле";
    }

    @Override
    public void Function(File file) throws IOException {
        Scanner scanner = new Scanner(file);
        int words = 0;

        while (scanner.hasNextLine()) {
            String[] array = scanner.nextLine().split(" ");
            words = words + array.length;
        }
        System.out.println("Слов в файле: " + words);
    }
}
