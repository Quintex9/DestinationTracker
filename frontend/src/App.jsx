import { useEffect, useState } from "react";
import "./App.css";
import DestinationList from "./assets/DestinationList";

function App() {
  const [destinations, setDestinations] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/api/destinations")
    .then((response) =>response.json())
    .then(data => setDestinations(data));
  }, []);

  return(
    <div className="container">
      <div>
        {destinations.length ? (
          <DestinationList destinations={destinations}/>
        ) : (
          <p>No products found</p>
        )}
      </div>
    </div>
  )
}

export default App;
