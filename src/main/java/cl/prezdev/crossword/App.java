package cl.prezdev.crossword;

import cl.prezdev.crossword.model.Word;
import cl.prezdev.crossword.service.config.ReadConfigFile;
import cl.prezdev.crossword.service.config.impl.JsonReadConfigFileImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        ReadConfigFile readConfigFile = new JsonReadConfigFileImpl();

        List<Word> words = readConfigFile.loadWords(new File("config.json"));
        words.forEach(word -> System.out.println(word));
    }
}
