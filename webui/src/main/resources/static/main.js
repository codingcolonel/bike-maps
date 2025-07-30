const map = L.map("map").setView([49.25, -123.11], 13);
L.tileLayer("https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png", {
  attribution: "© OpenStreetMap contributors",
}).addTo(map);

let num = 5;

const url = `/api/number?num=${num}`;

fetch(url)
  .then((response) => response.text())
  .then((data) => console.log(data))
  .catch((err) => console.error(err));
