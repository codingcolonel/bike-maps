package engine.parsing;

import engine.map.Track;

public abstract class Reader {
    String path;

    // EFFECTS: initializes reader to read from source file at given path
    public Reader(String path) {
        this.path = path;
    }

    // Sets path for file to be read
    public void setPath(String path) {
        this.path = path;
    }

    public abstract Track read();
}
