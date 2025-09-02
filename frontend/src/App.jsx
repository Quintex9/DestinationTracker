import { useEffect, useState } from "react";
import "./App.css";
import DestinationList from "./components/DestinationList";
import CategoryFilter from "./components/CategoryFilter";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import DestinationPage from "./components/DestinationPage";
import Navbar from "./components/Navbar";
import Map from "./components/Map.jsx";
import Contact from "./components/Contact";
import { api } from "./api.js";

function App() {
  const [destinations, setDestinations] = useState([]);
  const [categories, setCategories] = useState([]);

  const [selectedCategory, setSelectedCategory] = useState(null);
  const [searchTerm, setSearchTerm] = useState("");

  const [loading, setLoading] = useState(true);
  const [err, setErr] = useState("");

  useEffect(() => {
    (async () => {
      try {
        const [d, c] = await Promise.all([
          api.getDestinations(),
          api.getCategories(),
        ]);
        setDestinations(d);
        setCategories(c);
      } catch (e) {
        setErr("Prebúdzam server… Skús to o chvíľku znovu.");
        console.error(e);
      } finally {
        setLoading(false);
      }
    })();
  }, []);

  if (loading)
    return (
      <div>
        <h1>Prebúdzam databázu</h1>
        <h2>Po načítaní databázy sa automaticky stránka refreshne</h2>
        <p>Toto je bezplatná stránka, ktorá používa Vercel, Render a Neon...</p>
      </div>
    );
  if (err) return <p>{err}</p>;

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
      <Navbar />
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
          <Route
            path="/destination/:id"
            element={<DestinationPage destinations={destinations} />}
          />
          <Route path="/mapa" element={<Map destinations={destinations} />} />
          <Route path="/contact" element={<Contact />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
