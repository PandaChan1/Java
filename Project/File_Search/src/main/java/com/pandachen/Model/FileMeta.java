package com.pandachen.Model;

import java.io.File;

public class FileMeta {
    private final Integer id;
    private final String name;
    private final String path;
    private final boolean directory;
    private final Long size;
    private final Long lastModifiedTimestamp;

    // 提供给扫描后使用
    public FileMeta(File file) {
        this.id = null;
        this.name = file.getName();
        this.path = file.getAbsolutePath();
        this.directory = file.isDirectory();
        this.size = file.length();
        this.lastModifiedTimestamp = file.lastModified();
    }

    // 提供给DB查询后使用
    public FileMeta(Integer id, String name, String path, boolean directory, Long size, Long lastModifiedTimestamp) {
        this.id = id;
        this.name = name;
        this.path = path;
        this.directory = directory;
        this.size = size;
        this.lastModifiedTimestamp = lastModifiedTimestamp;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public boolean isDirectory() {
        return directory;
    }

    public String getSize() {
        return String.valueOf(size);
    }

    public String getLastModified() {
        return String.valueOf(lastModifiedTimestamp);
    }
}
