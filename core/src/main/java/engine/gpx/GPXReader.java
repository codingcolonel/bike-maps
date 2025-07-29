package engine.gpx;

import java.io.File;
import javax.xml.parsers.*;
import org.w3c.dom.*;

/*
 * Manages the reading of data from GPX files; contains the File object of the source GPX file
 */
public class GPXReader {
    private File file;

    // EFFECTS: initializes reader to read from source file
    public GPXReader(String path) {
        this.file = new File(path);
    }

    // EFFECTS: parses GPX file and then creates a new Track
    public Track read() {
        
    }

    // EFFECTS: parses track points into Coordinate objects for Track
    public Track readTrackPoints(Document doc) {

    }
}
