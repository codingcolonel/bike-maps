// Set up map
const map = L.map("map").setView([49.25, -123.11], 13);
L.tileLayer("https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png", {
  attribution: "© OpenStreetMap contributors",
}).addTo(map);

// Event listeners
map.on("click", setMarker);

// Fetch coordinate data from a track in the data folder
// let file = "13746599585.gpx";

// const url = `/api/track?file=${file}`;

// fetch(url)
//   .then((response) => response.text())
//   .then((data) => processJsonResponse(JSON.parse(data)))
//   .catch((err) => console.error(err));

// EFFECTS: Takes GPX json data and draws a line on the map
function processJsonResponse(jsonData) {
  let listOfCoordinates = jsonData.coordinates;
  let polylineArray = [];

  for (let i = 0; i < listOfCoordinates.length; i++) {
    polylineArray.push(listOfCoordinates[i]);
  }

  let line = L.polyline(polylineArray, {
    color: "red",
    weight: 5,
  }).addTo(map);

  line.on("click", setMarker);
}

// EFFECTS: If no markers set, sets a start marker, otherwise sets end marker
function setMarker(e) {
  console.log(e);
  let latlng = e.latlng;
  L.marker(latlng).addTo(map);

  fetch(`/api/markers/add?lat=${latlng.lat}&lon=${latlng.lng}`, {
    method: "POST",
  }).then(drawLine());
}

// Fetchs markers then draws polyline
function drawLine() {
  fetch(`/api/markers/get`)
    .then((response) => response.text())
    .then((data) => {
      let coordinateArray = JSON.parse(data);
      L.polyline(coordinateArray, {
        color: "red",
        weight: 5,
      }).addTo(map);
    });
}
