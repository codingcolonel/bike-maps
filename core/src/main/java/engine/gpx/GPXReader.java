package engine.gpx;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import engine.map.Coordinate;
import engine.map.Track;

/*
 * Manages the reading of data from GPX files; contains the File object of the source GPX file
 */
public class GPXReader {
    private File file;

    // EFFECTS: initializes reader to read from source file at given path
    public GPXReader(String path) {
        this.file = new File(path);
    }

    // EFFECTS: initializes reader without a path
    public GPXReader() {
    }

    // Sets path for file to be read
    public void setPath(String path) {
        this.file = new File(path);
    }

    // REQUIRES: file is set and valid
    // EFFECTS: parses GPX file and then creates a new Track
    public Track read() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);
            return readTrackPoints(doc);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    // EFFECTS: parses track points into Coordinate objects for Track
    public Track readTrackPoints(Document doc) {
        NodeList nodeList = doc.getElementsByTagName("trkpt");
        Track track = new Track();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Element trkpt = (Element) nodeList.item(i);
            double lat = Double.parseDouble(trkpt.getAttribute("lat"));
            double lon = Double.parseDouble(trkpt.getAttribute("lon"));
            Coordinate coordinate = new Coordinate(lat, lon);
            track.addCoordinate(coordinate);
        }

        return track;
    }
}
