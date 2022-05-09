package cl.prezdev.crossword.service.config;

import cl.prezdev.crossword.model.Word;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public interface ReadConfigFile {
    List<Word> loadWords(File file) throws FileNotFoundException;
}
