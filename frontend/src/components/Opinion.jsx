const Opinion = ({ imageURl, text }) => {
  return (
    <div className="row g">
      <div className="col-auto">
        <img src={imageURl} alt="Obrazok" className="opinion-image rounded-circle"></img>
      </div>
      <div className="col m-4">
        <p>{text}</p>
      </div>
    </div>
  );
};

export default Opinion;
