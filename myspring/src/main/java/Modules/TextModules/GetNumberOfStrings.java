package Modules.TextModules;

import Modules.AbstractModule;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class GetNumberOfStrings extends AbstractModule {

    public GetNumberOfStrings(String supportedFormats) {
        super(supportedFormats);
    }

    public String Discription() {
        return "Получение количества строк в файле";
    }

    public void Function(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        int lines = 0;

        while (scanner.hasNextLine()) {
            scanner.nextLine();
            lines++;
        }
        System.out.println("Строк в файле: " + lines);
    }
}
