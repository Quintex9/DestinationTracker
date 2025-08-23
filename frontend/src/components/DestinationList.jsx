import { Link } from "react-router-dom";

const DestinationList = ({ destinations = [] }) => {
  return (
    <div className="row">
      {destinations.map((destination) => (
        <div className="col-lg-4 col-md-6 col-sm-12 mb-4" key={destination.id}>
          <Link
            to={`/destination/${destination.id}`}
            className="text-decoration-none"
          >
            <div className="card h-100 text-primary-emphasis bg-primary-subtle border border-primary-subtle rounded-3">
              <img
                src={destination.imageURL || "https://placehold.co/600x400"}
                className="card-img-top fixed-image"
                alt={destination.name}
              />
              <div className="card-body">
                <h5 className="card-title">{destination.name}</h5>
                <p className="card-text">{destination.description}</p>
                {destination.price > 0.0 ? (
                  <p class="card-text">{destination.price}€</p>
                ) : undefined}
              </div>
            </div>
          </Link>
        </div>
      ))}
    </div>
  );
};

export default DestinationList;
