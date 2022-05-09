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
        InputStreamReader inputStreamReader = getInputStreamReader(file);
        ConfigFile configFile = new Gson().fromJson(inputStreamReader, ConfigFile.class);

        return new ConfigFileMapper().map(configFile);
    }

    private InputStreamReader getInputStreamReader(File file) throws FileNotFoundException {
        InputStream inputStream = new FileInputStream(file);
        return new InputStreamReader(inputStream);
    }
}
