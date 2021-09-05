package ru.netology.manager;

import lombok.Data;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

@Data
public class FileOpenManager {
    Map<String, String> map;

    public FileOpenManager() {
        this.map = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    }

    public void catalogue(String extension, String name) {
        if (extension == null) {
            extension = ".txt(default)";
        }
        map.put(extension, name);
    }

    public String getNameByExtension(String extension) {
        return map.get(extension);
    }

    public void delete(String extension) {
        map.remove(extension);
    }

    public Set<String> getSetExtensions() {
        return map.keySet();
    }

    public Set<String> getSetNames() {
        return new HashSet<>(map.values());
    }


}

