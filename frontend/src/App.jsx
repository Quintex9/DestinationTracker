import { useEffect, useState } from "react";
import "./App.css";
import DestinationList from "./assets/DestinationList";

function App() {
  const [destinations, setDestinations] = useState([]);
  const [categories, setCategories] = useState([]);

  const [selectedCategory, setSelectedCategory] = useState(null);
  const [searchTerm, setSearchTerm] = useState("");
  const [sortOrder, setSortOrder] = useState("asc");

  useEffect(() => {
    fetch("http://localhost:8080/api/destinations")
      .then((response) => response.json())
      .then((data) => setDestinations(data));

    fetch("http://localhost:8080/api/categories")
      .then((response) => response.json())
      .then((data) => setCategories(data));
  }, []);

  const handleSearchChange = (event) => {
    setSearchTerm(event.target.value);
  };

  const handleSortChange = (event) => {
    setSortOrder(event.target.value);
  };

  return (
    <div className="container">
      <div>
        <h1 className="my-4">Naše spoločné výlety</h1>
        <div className="row allign-items-center mb-4">
          <div className="col-md-3 col-sm-12 mb-12">
            <p>Category filter</p>
          </div>
          <div className="col-md-5 col-sm 12 mb-12">
            <input
              type="text"
              className="form-control"
              placeholder="Search for destinations"
              onChange={handleSearchChange}
            ></input>
          </div>
          <div className="col-md-4 col-sm-12 mb-2">
            <select className="form-control" onChange={handleSortChange}>
              <option value="asc">Sort by Price: Low to High</option>
              <option value="desc">Sort by Price: High to Low</option>
            </select>
          </div>
        </div>
        {destinations.length ? (
          <DestinationList destinations={destinations} />
        ) : (
          <p>No products found</p>
        )}
      </div>
    </div>
  );
}

export default App;
