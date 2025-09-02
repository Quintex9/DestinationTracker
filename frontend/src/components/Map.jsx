import { MapContainer, TileLayer, Marker, Popup } from "react-leaflet";
import L from "leaflet";
import { useNavigate } from "react-router-dom";

// vlastná ikonka bodky (Leaflet default má veľký pin)
const markerIcon = new L.Icon({
  iconUrl: "https://unpkg.com/leaflet@1.9.4/dist/images/marker-icon.png",
  iconSize: [25, 41],
  iconAnchor: [12, 41],
  popupAnchor: [1, -34],
  shadowUrl: "https://unpkg.com/leaflet@1.9.4/dist/images/marker-shadow.png",
});

function Map({ destinations }) {
    const navigate = useNavigate();

  return (
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
          position={[dest.lat, dest.lng]} // musíš mať v databáze súradnice
          icon={markerIcon}
        >
          <Popup>
            {dest.name}
            <button className="btn btn-sm btn-primary mt-2"onClick={() => navigate(`/destination/${dest.id}`)}></button>
            </Popup>
        </Marker>
      ))}
    </MapContainer>
  );
}

export default Map;
