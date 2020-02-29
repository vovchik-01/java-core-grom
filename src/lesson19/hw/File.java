package lesson19.hw;

import java.util.Scanner;

public class File {
    private long id;
    private String name;
    private String format;
    private long size;

    public File(long id, String name, String format, long size) throws Exception {
        if (name.length() > 10) {
            throw new Exception("Error");
        } else {
            this.name = name;
            this.id = id;
            this.format = format;
            this.size = size;
        }

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFormat() {
        return format;
    }

    public long getSize() {
        return size;
    }


}
