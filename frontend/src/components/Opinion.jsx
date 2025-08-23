const Opinion = ({ imageURl, text }) => {
  return (
    <div className="row">
      <div className="col">
        <img src={imageURl} alt="Obrazok" className="opinion-image rounded-circle"></img>
      </div>
      <div className="col">
        <p>{text}</p>
      </div>
    </div>
  );
};

export default Opinion;
