package engine.gpx;

import java.util.ArrayList;

/*
 * A track representing a bike route on a map; contains a set of coordinates creating many segments
 */
public class Track {
    ArrayList<Coordinate> coordinates;

    public Track() {
        coordinates = new ArrayList<>();
    }

    public void addCoordinate(Coordinate coordinate) {
        coordinates.add(coordinate);
    }
}
