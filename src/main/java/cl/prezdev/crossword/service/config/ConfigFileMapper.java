package cl.prezdev.crossword.service.config;

import cl.prezdev.crossword.model.ConfigFile;
import cl.prezdev.crossword.model.Word;

import java.util.ArrayList;
import java.util.List;

public class ConfigFileMapper {
    public List<Word> map(ConfigFile configFile) {
        List<Word> words = new ArrayList<>();

        for(String word : configFile.getWords()){
             words.add(new Word(word));
        }

        return words;
    }
}
