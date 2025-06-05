package cl.prezdev.crossword.service.config;

import cl.prezdev.crossword.model.Word;
import cl.prezdev.crossword.service.config.impl.JsonReadConfigFileImpl;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.List;

public class JsonReadConfigFileIntegrationTest {

    @Test
    public void loadWords_readsConfigFile() throws Exception {
        File config = new File("config.json");
        JsonReadConfigFileImpl reader = new JsonReadConfigFileImpl();
        List<Word> words = reader.loadWords(config);

        Assert.assertEquals(3, words.size());
        Assert.assertEquals("asd", words.get(0).getValue());
        Assert.assertEquals("asd2", words.get(1).getValue());
        Assert.assertEquals("asdasd", words.get(2).getValue());
    }
}
