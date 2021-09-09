package ru.netology.manager;

import lombok.Data;

import java.util.*;

@Data
public class FileOpenManager {
    Map<String, String> map;

    public FileOpenManager() {
        this.map = new HashMap<>();
    }

    public void catalogue(String extension, String name) {
        if (extension == null) {
            extension = ".txt(default)";
        }
        if (name == null) {
            name = "NotePad(default)";
        }
        extension = extension.toLowerCase();
        name = name.toLowerCase();
        map.put(extension, name);
    }

    public String getNameByExtension(String extension) {
        extension = extension.toLowerCase();
        return map.get(extension);
    }

    public void delete(String extension) {
        extension = extension.toLowerCase();
        map.remove(extension);
    }

    public Set<String> getSetExtensions() {
        return map.keySet();
    }

    public Set<String> getSetNames() {
        return new HashSet<>(map.values());
    }


}

