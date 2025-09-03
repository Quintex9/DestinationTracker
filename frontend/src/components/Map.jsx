import { MapContainer, TileLayer, Marker, Popup } from "react-leaflet";
import L from "leaflet";
import Footer from "./Footer";

// vlastná ikonka bodky (Leaflet default má veľký pin)
const markerIcon = new L.Icon({
  iconUrl: "https://unpkg.com/leaflet@1.9.4/dist/images/marker-icon.png",
  iconSize: [25, 41],
  iconAnchor: [12, 41],
  popupAnchor: [1, -34],
  shadowUrl: "https://unpkg.com/leaflet@1.9.4/dist/images/marker-shadow.png",
});

const icons = {
  Hiking: new L.divIcon({
    html: "<div class='custom-marker hiking'>🥾</div>",
    className: "", // zruší defaultné Leaflet className
  }),
  Castles: new L.divIcon({
    html: "<div class='custom-marker castles'>🏰</div>",
    className: "",
  }),
  Zoo: new L.divIcon({
    html: "<div class='custom-marker zoo'>🐒</div>",
    className: "",
  }),
  Spa: new L.divIcon({
    html: "<div class='custom-marker spa'>💧</div>",
    className: "",
  }),
};



function Map({ destinations }) {

  return (
    <>
    <MapContainer
      center={[48.669, 19.699]} // stred Slovenska
      zoom={7}
      style={{ height: "500px", width: "100%" }}
    >
      {/* Podkladová mapa */}
      <TileLayer
        url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
        attribution='&copy; <a href="http://osm.org/copyright">OpenStreetMap</a>'
      />

      {/* Vykreslenie destinácií */}
      {destinations.map((dest) => (
        <Marker
          key={dest.id}
          position={[dest.lat, dest.lng]}
          icon={icons[dest.category.name]}
        >
          <Popup>
            <div>
              <img src={dest.imageURL} className="popup-img"></img>
              {localStorage.getItem("role") === "Admin" ? (<a
                href={`/destination/${dest.id}`}
                style={{
                  textDecoration: "none",
                  color: "#007bff",
                  fontWeight: "bold",
                }}
              >
                {dest.name}
              </a>) : <a>{dest.name}</a>}

            </div>
          </Popup>
        </Marker>
      ))}
    </MapContainer>
    </>
  );
  
}

export default Map;
