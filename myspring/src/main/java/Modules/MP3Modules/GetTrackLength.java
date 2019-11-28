package Modules.MP3Modules;

import Modules.AbstractModule;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.TagException;

import java.io.File;
import java.io.IOException;

public class GetTrackLength extends AbstractModule {

    public GetTrackLength(String supportedFormats) {
        super(supportedFormats);
    }

    @Override
    public String Discription() {
        return "Вывод длительности в секундах";
    }

    @Override
    public void Function(File file) throws IOException {

        AudioFile audioFile = null;
        try {
            audioFile = AudioFileIO.read(file);
        } catch (CannotReadException e) {
            e.printStackTrace();
        } catch (TagException e) {
            e.printStackTrace();
        } catch (ReadOnlyFileException e) {
            e.printStackTrace();
        } catch (InvalidAudioFrameException e) {
            e.printStackTrace();
        }
        int duration= audioFile.getAudioHeader().getTrackLength();
        System.out.println("Длительность: " + duration + " секунд");

    }
}
