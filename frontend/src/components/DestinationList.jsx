import { Link } from "react-router-dom";

const DestinationList = ({ destinations = [], role }) => {
  return (
    <div className="row">
      {destinations.map((destination) => (
        <div className="col-lg-4 col-md-6 col-sm-12 mb-4" key={destination.id}>
          <Link
            onClick={(e) => {
              if (role !== "Admin") {
                e.preventDefault(); // zabráni navigácii
              }
            }}
            to={`/destination/${destination.id}`}
            className="text-decoration-none"
          >
            {/*Lenke sa páči farba $green-700 , $yellow-600 , $orange-700 , $pink-200 , $teal-200 , $indigo-300 ,  text-primary-emphasis bg-primary-subtle border border-primary-subtle rounded-3*/}
            <div className={`card h-100 ${destination.farba}`}>
              <img
                src={destination.imageURL || "https://placehold.co/600x400"}
                className="card-img-top fixed-image"
                alt={destination.name}
              />
              <div className="card-body">
                <h5 className="card-title">{destination.name}</h5>
                <p className="card-text">
                  Spoločné hodnotenie:{" "}
                  {(
                    (destination.ratingMichal + destination.ratingLenka) /
                    2
                  ).toFixed(2)}
                  ⭐
                </p>
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
