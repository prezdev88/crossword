package cl.prezdev.crossword.service.config.impl;

import cl.prezdev.crossword.service.config.impl.JsonReadConfigFileImpl;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class JsonReadConfigFileImplTest {
    private static class TrackingFileInputStream extends FileInputStream {
        private boolean closed = false;
        TrackingFileInputStream(File file) throws FileNotFoundException { super(file); }
        @Override
        public void close() throws IOException {
            closed = true;
            super.close();
        }
        boolean isClosed() { return closed; }
    }

    private static class TrackingJsonReadConfigFileImpl extends JsonReadConfigFileImpl {
        private TrackingFileInputStream stream;
        @Override
        protected FileInputStream createFileInputStream(File file) throws FileNotFoundException {
            stream = new TrackingFileInputStream(file);
            return stream;
        }
        boolean isStreamClosed() { return stream != null && stream.isClosed(); }
    }

    @Test
    public void loadWords_closesStreams() throws Exception {
        File temp = File.createTempFile("config", ".json");
        Files.write(temp.toPath(), "{\"words\":[\"hello\"]}".getBytes(StandardCharsets.UTF_8));

        TrackingJsonReadConfigFileImpl reader = new TrackingJsonReadConfigFileImpl();
        reader.loadWords(temp);

        Assert.assertTrue("Input stream should be closed after reading", reader.isStreamClosed());
    }
}
