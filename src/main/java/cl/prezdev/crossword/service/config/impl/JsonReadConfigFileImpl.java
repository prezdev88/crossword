package cl.prezdev.crossword.service.config.impl;

import cl.prezdev.crossword.model.ConfigFile;
import cl.prezdev.crossword.model.Word;
import cl.prezdev.crossword.service.config.ConfigFileMapper;
import cl.prezdev.crossword.service.config.ReadConfigFile;
import com.google.gson.Gson;

import java.io.*;
import java.util.List;

public class JsonReadConfigFileImpl implements ReadConfigFile {
    @Override
    public List<Word> loadWords(File file) throws FileNotFoundException {
        try (FileInputStream inputStream = createFileInputStream(file);
             InputStreamReader reader = new InputStreamReader(inputStream)) {
            ConfigFile configFile = new Gson().fromJson(reader, ConfigFile.class);
            return new ConfigFileMapper().map(configFile);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read config file", e);
        }
    }

    protected FileInputStream createFileInputStream(File file) throws FileNotFoundException {
        return new FileInputStream(file);
    }
}
