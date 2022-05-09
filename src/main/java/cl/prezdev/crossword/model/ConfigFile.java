package cl.prezdev.crossword.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ConfigFile {
    private List<String> words;
}
