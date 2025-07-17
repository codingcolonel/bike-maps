TO-DO

- Set up gradle multi project - done
- Basic map using leaflet - done
- Make GPX parser and integrate it with map
- Create graph representation of road segements using intersections as seperators
  - Assign cycling data to segments to be used in A-star later

Using Canada cycling data

- Find fastest routes with A-Star alogrithm
- Report certain routes
- Assess comfort levels using a points system
  - Must be above a certain threshold and include no major routes
  - Finds best route considering distance, elevation, safety, dedicated routes using weighing system
    - Finds best overall, safest, fastest routes
    - USe STRM elevation raster for elevation
- Recommended destinations/routes
- Time estimate based on distance and elevation
- Crosswalk/stairs/other hazards
- Best time of day

Design feature

- Route draws itself
- Biking fact/statistics of cities
- Elevation map layer

Classes
Route
start coords
end coords
point value

Network
