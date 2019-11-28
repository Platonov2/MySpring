import Modules.AbstractModule;
import Modules.TextModules.GetNumberOfStrings;
import org.h2.tools.Console;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Main {

    private String filePath;

    private List<AbstractModule> modules;
    private List<AbstractModule> relevantModules;
    private int counter = 0;

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext(
                "Modules.xml");

        Main main = (Main) ctx.getBean("Main");
        //GetNumberOfStrings getNumberOfStrings = (GetNumberOfStrings) ctx.getBean("GetNumberOfStrings");
        //String a = getNumberOfStrings.supportedFormats;

        main.offerModules(main.filePath);

        Scanner in = new Scanner(System.in);
        while (true){
            System.out.println("Введите номер модуля");
            int index = in.nextInt();
            main.executeModule(index - 1);
            System.out.println();
        }

    }

    public void offerModules(String filePath){
        String format = getFormat(filePath);
        relevantModules = new ArrayList<AbstractModule>();

        for (AbstractModule module : modules) {
            if (module.CheckFormat(format)){
                relevantModules.add(module);
                counter += 1;
                System.out.println(counter + ". " + module.Discription());
            }
        }
    }

    public void executeModule(int index){
        File file = new File(filePath);

        try {
            relevantModules.get(index).Function(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getFormat(String filePath){
        if(filePath.lastIndexOf(".") != -1 && filePath.lastIndexOf(".") != 0)
            return filePath.substring(filePath.lastIndexOf(".")+1);
        else return "dir";
    }

    public Main(String filePath, List<AbstractModule> modules){
        this.filePath = filePath;
        this.modules = modules;
    }
}
