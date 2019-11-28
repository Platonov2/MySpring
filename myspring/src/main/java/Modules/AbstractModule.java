package Modules;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public abstract class AbstractModule {

    public String supportedFormats;

    public AbstractModule(String supportedFormats){
        this.supportedFormats = supportedFormats;
    }

    public boolean CheckFormat(String format){
        return supportedFormats.contains(format);
    }

    public abstract String Discription();

    public abstract void Function(File file) throws IOException;
}
