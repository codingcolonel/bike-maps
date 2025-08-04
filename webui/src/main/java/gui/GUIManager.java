package gui;

import org.springframework.web.bind.annotation.*;

import engine.gpx.*;
import engine.map.Track;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api")
public class GUIManager {
    GPXReader gpxReader;

    public GUIManager() {
        gpxReader = new GPXReader();
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
    
}
