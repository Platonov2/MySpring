package Modules.MP3Modules;

import Modules.AbstractModule;

import java.io.File;
import java.io.IOException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GetTrackName extends AbstractModule {

    public GetTrackName(String supportedFormats) {
        super(supportedFormats);
    }

    @Override
    public String Discription() {
        return "Вывод названия трека из тегов";
    }

    @Override
    public void Function(File file) throws IOException {
        InputStream input = new FileInputStream(file);
        ContentHandler handler = new DefaultHandler();
        Metadata metadata = new Metadata();
        Parser parser = new Mp3Parser();
        ParseContext parseCtx = new ParseContext();
        try {
            parser.parse(input, handler, metadata, parseCtx);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (TikaException e) {
            e.printStackTrace();
        }
        input.close();

        System.out.println("Название: " + metadata.get("title"));
    }
}
