package Modules.TextModules;

import Modules.AbstractModule;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class GetSymbolsFrequency extends AbstractModule {

    public GetSymbolsFrequency(String supportedFormats) {
        super(supportedFormats);
    }

    public String Discription() {
        return "Вывод частотности символов в файле";
    }

    public void Function(File file) throws IOException {
        Map<String, Integer> map = new HashMap<>();

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;

        while ((line = br.readLine()) != null) {
            line = line.trim();
            String charI;
            for (int i = 0; i < line.length(); i++) {
                charI = line.substring(i, i + 1).toLowerCase();
                if (charI.matches("[a-z]")) {
                    map.put(charI, map.getOrDefault(charI, 0) + 1);
                }
            }
        }
        br.close();

        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }
    }
}
