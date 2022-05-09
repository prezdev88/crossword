package cl.prezdev.crossword.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Word {

    private String value;
    private Direction direction;
    private int length;

    public Word(String word) {
        this.value = word;
        this.length = word.length();
    }
}
