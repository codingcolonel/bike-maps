package engine.map;

import java.util.ArrayList;
import java.util.List;

/*
 * A class that handles all the markers on the map, their order on the current route, and coordinate data 
 */
public class MarkerManager {
    List<Coordinate> markers;

    // Initializes markers with an empty list
    public MarkerManager() {
        markers = new ArrayList<>();
    }

    public List<Coordinate> getMarkers() {
        return markers;
    }

    // REQUIRES: -1 <= position < markers.length()
    // EFFECTS: Adds marker at given position; -1 for last position
    public void addMarker(Coordinate coordinate, int position) {
        if (position == -1) {
            markers.add(coordinate);
            return;
        }
        markers.add(position, coordinate);
    }

    // REQUIRES: -1 <= position < markers.length()
    // EFFECTS: Get coordinate of the marker in specified position; -1 for last
    // position
    public Coordinate getCoordinate(int position) {
        return new Coordinate(position, position); // stub
    }

    // EFFECTS: Inserts marker at correct position given the origin start location
    // on the path and it's new end location
    public void insertMarker(Coordinate start, Coordinate end) {

    }

    // EFFECTS: Checks if given coordinate is the first in the list
    public boolean isStart(Coordinate coordinate) {
        return false; // stub
    }

    // EFFECTS: Checks if given coordinate is the last in the list
    public boolean isEnd(Coordinate coordinate) {
        return false; // stub
    }

}