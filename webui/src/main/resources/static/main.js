const map = L.map("map").setView([49.25, -123.11], 13);
L.tileLayer("https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png", {
  attribution: "© OpenStreetMap contributors",
}).addTo(map);

// Fetch coordinate data from a track in the data folder
let file = "13746599585.gpx";

const url = `/api/track?file=${file}`;

fetch(url)
  .then((response) => response.text())
  .then((data) => console.log(data))
  .catch((err) => console.error(err));
