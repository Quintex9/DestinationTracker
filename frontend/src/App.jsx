import { useEffect, useState } from "react";
import "./App.css";
import DestinationList from "./components/DestinationList";
import CategoryFilter from "./components/CategoryFilter";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import DestinationPage from "./components/DestinationPage";
import Navbar from "./components/Navbar";

function App() {
  const [destinations, setDestinations] = useState([]);
  const [categories, setCategories] = useState([]);

  const [selectedCategory, setSelectedCategory] = useState(null);
  const [searchTerm, setSearchTerm] = useState("");

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

  const handleCategorySelect = (categoryId) => {
    setSelectedCategory(categoryId ? Number(categoryId) : null);
  };

  const filteredDestinations = (
    selectedCategory
      ? categories.find((c) => c.id === selectedCategory)?.destinations || []
      : destinations
  ).filter((destination) =>
    destination.name.toLowerCase().includes(searchTerm.toLowerCase())
  );

  return (
    <Router>
      <Navbar/>
      <div className="container">
        <Routes>
          <Route
            path="/"
            element={
              <>
                <h1 className="my-4">Naše spoločné výlety</h1>
                <div className="row allign-items-center mb-4">
                  <div className="col-md-3 col-sm-12 mb-12">
                    <CategoryFilter
                      categories={categories}
                      onSelect={handleCategorySelect}
                    />
                  </div>
                  <div className="col-md-5 col-sm 12 mb-12">
                    <input
                      type="text"
                      className="form-control"
                      placeholder="Search for destinations"
                      onChange={handleSearchChange}
                    ></input>
                  </div>
                </div>
                {filteredDestinations.length ? (
                  <DestinationList destinations={filteredDestinations} />
                ) : (
                  <p>No products found</p>
                )}
              </>
            }
          />
          <Route path="/destination/:id" element={<DestinationPage destinations={destinations}/>}/>
        </Routes>
      </div>
    </Router>
  );
}

export default App;
