import { useParams, Link } from "react-router-dom";
import Opinion from "./Opinion";

export default function DestinationPage({ destinations }) {
  const { id } = useParams();
  const destination = destinations.find((d) => d.id === Number(id));

  if (!destination) {
    return <p className="mt-4">Destination not found</p>;
  }

  return (
    <div className="container mt-4">
      <div className="text-center mb-4">
        <img
          src={destination.imageURL || "https://placehold.co/1200x500"}
          alt={destination.name}
          className="img-fluid rounded-pill"
          style={{ maxHeight: "500px", objectFit: "cover", width: "100%" }}
        />
      </div>

      <div className="text-center">
        <h1 className="mb-3">{destination.name}</h1>
        <h2>Celkové trvanie atrakcie: {destination.duration} {destination.duration === 1 ? "hodina." : "hodiny."}</h2>
        <p className="lead">{destination.description}</p>
        {destination.price > 0 && (
          <h4 className="mt-3 text-primary">Cena atrakcie: {destination.price} €</h4>
        )}
        <Opinion imageURl={destination.michalURL} text={destination.nazorMichal}/>
        <Opinion imageURl={destination.lenkaURL} text={destination.nazorLenka}/>
        <h2>Hodnotenie</h2>
        <div>
              <p>Michal hodnotí: {destination.ratingMichal}⭐️</p>
              <p>Lenka hodnotí: {destination.ratingLenka}⭐️</p>
              <p>Priemer hodnotenia: {((destination.ratingMichal+destination.ratingLenka)/2).toFixed(2)}⭐️</p>
        </div>
        <Link to="/" className="btn btn-secondary mt-4">
          ← Späť na zoznam
        </Link>
      </div>
    </div>
  );
}
