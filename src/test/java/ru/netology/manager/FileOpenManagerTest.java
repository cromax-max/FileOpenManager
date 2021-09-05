package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class FileOpenManagerTest {
    FileOpenManager manager = new FileOpenManager();

    @BeforeEach
    void setUp() {
        manager.catalogue(".mp3", "Player");
        manager.catalogue(".mp4", null);
        manager.catalogue(".html", "Browser");
        manager.catalogue(".JpEg", "Foto");
        manager.catalogue(".Doc", "wordApp");
        manager.catalogue(".xls", "wordApp");
        manager.catalogue(".PDF", "redactor");
        manager.catalogue(null, "Browser"); // ".txt(default)" instead of the null
    }

    @ParameterizedTest
    @CsvSource({".PdF", ".pdf", ".PDF"})
    void shouldGetNameByExtension(String e) {
        assertThat(manager.getNameByExtension(e), equalTo("redactor"));
    }

    @Test
    void shouldNotGetNameByExtension() {
        assertThat(manager.getNameByExtension(".xPdF"), equalTo(null));
    }

    @Test
    void shouldGetSetExtensions() {
        Set<String> expected = new HashSet<>(Set.of(".Doc", ".html", ".JpEg", ".mp4", ".txt(default)"));
        manager.delete(".MP3");
        manager.delete(".Xls");
        manager.delete(".pdf");
        assertThat(manager.getSetExtensions(), equalTo(expected));
    }

    @Test
    void getSetNames() {
        Set<String> expected = new HashSet<>();
        expected.add("redactor");
        expected.add(null);
        expected.add("Player");
        expected.add("wordApp");
        expected.add("Foto");
        expected.add("Browser");
        assertThat(manager.getSetNames(), equalTo(expected));
    }
}