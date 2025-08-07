package gui;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import engine.map.Coordinate;
import engine.map.MarkerManager;
import engine.map.Track;
import engine.parsing.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
public class GUIManager {
    GPXReader gpxReader;
    MarkerManager markerManager;

    public GUIManager() {
        gpxReader = new GPXReader();
        markerManager = new MarkerManager();
    }

    // Test function
    @GetMapping("/number")
    public String getNumber(@RequestParam Integer num) {
        return "I love the number " + num;
    }

    // REQUIRES: File exists within data/gpx-routes folder
    // EFFECTS: Returns Track object of given file
    @GetMapping("/track")
    public Track getTrack(@RequestParam String file) {
        String path = "../data/gpx-routes/" + file;
        gpxReader.setPath(path);
        return gpxReader.read();
    }

    // EFFECTS: Gets marker coordinates
    @GetMapping("/markers/get")
    public List<Coordinate> getMarkers() {
        return markerManager.getMarkers();
    }

    // EFFECTS: Adds coordinates to the end of markers list
    @PostMapping("/markers/add")
    public void addMarker(@RequestParam double lat, @RequestParam double lon) {
        Coordinate newCoordinate = new Coordinate(lat, lon);
        markerManager.addMarker(newCoordinate, -1);
    }
}
