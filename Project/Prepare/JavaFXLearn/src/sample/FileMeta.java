package sample;

import javafx.stage.Window;

import java.io.File;

public class FileMeta {
private final File file;
    FileMeta(File file) {
        this.file = file;
    }

    public String getDirectory() {
        if (this.file.isDirectory()) {
            return "目录";
        }else{
            return "普通文件";
        }
    }

    public String getPath() {
        return file.getAbsolutePath();
    }

    @Override
    public String toString() {
        return "FileMeta{" +
                "file=" + file +
                '}';
    }
}
